/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.inventario.userInteraface.create;

import com.mycompany.inventario.Entity.Category;
import com.mycompany.inventario.Entity.DetallePedido;
import com.mycompany.inventario.Entity.Item;
import com.mycompany.inventario.Entity.Pago;
import com.mycompany.inventario.Entity.Pedido;
import com.mycompany.inventario.Entity.Product;
import com.mycompany.inventario.Entity.Proveedor;
import com.mycompany.inventario.Entity.Recepcion;
import com.mycompany.inventario.Entity.Stock;
import com.mycompany.inventario.dao.CategoryRepository;
import com.mycompany.inventario.dao.DetallePedidoRepository;
import com.mycompany.inventario.dao.ItemRepository;
import com.mycompany.inventario.dao.PedidoRepository;
import com.mycompany.inventario.dao.ProveedorRepository;
import com.mycompany.inventario.dao.RecepcionRepository;
import com.mycompany.inventario.dao.StockRepository;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Oswaldo
 */
public class AgregarRecepcion extends javax.swing.JInternalFrame {
    
    DetallePedidoRepository pedidosDetalles = new DetallePedidoRepository();
    PedidoRepository pedidos = new PedidoRepository();
    
    public AgregarRecepcion() {
        initComponents();
        loadData();
        pedidosComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                loadTableData();
            }
        });
    }
    
    private void loadData() {
        DefaultComboBoxModel<Pedido> comboBoxModelProduct = new DefaultComboBoxModel<>();
        for (Pedido p : pedidos.findAll()) {
            comboBoxModelProduct.addElement(p);
        }
        pedidosComboBox.setModel(comboBoxModelProduct);
    }
    
    private void loadTableData() {
        Pedido pedidos = (Pedido) pedidosComboBox.getSelectedItem();
        
        DefaultTableModel model = (DefaultTableModel) this.jTable1.getModel();
        for (int i = 0; i < model.getRowCount();) {
            model.removeRow(i);
        }
        for (DetallePedido pedido : pedidos.getDetallesPedido()) {
            Vector row = new Vector();
            row.add(pedido.getPedido().getId());
            row.add(pedido.getProducto().getNombre());
            row.add(pedido.getCantidad());
            row.add(pedido.getProveedor().getNombre());
            row.add(pedido.getPago().getTipoDePago());
            row.add(pedido.getTotal());
            row.add(pedido.getPedido().getFechaDeRealizacion());
            model.addRow(row);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pedidosComboBox = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        setClosable(true);
        setTitle("Agregar una entrega");

        jPanel1.setMinimumSize(new java.awt.Dimension(100, 20));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel3.setPreferredSize(new java.awt.Dimension(394, 30));
        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.X_AXIS));

        jLabel1.setText("Pedido");
        jPanel3.add(jLabel1);

        pedidosComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pedidosComboBoxActionPerformed(evt);
            }
        });
        jPanel3.add(pedidosComboBox);

        jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Producto", "Cantidad", "Proveedor", "Tipo de pago", "Total", "Fecha de realización"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jButton2.setText("Cancelar");
        jPanel4.add(jButton2);

        jButton3.setText("Marcar como recibido");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton3);

        jPanel2.add(jPanel4, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Pedido done = (Pedido) pedidosComboBox.getSelectedItem();
        done.setIsDone(true);
        RecepcionRepository recepcionRepository = new RecepcionRepository();
        Recepcion recepcion = new Recepcion();
        recepcion.setFechaRecepcion(new Date());
        recepcion.setPedido(done);
        recepcion.setComentarios(JOptionPane.showInputDialog(this, "Escriba algun comentario o observación sobre la entrega"));
        recepcionRepository.create(recepcion);
        pedidos.update(done);
        StockRepository stock = new StockRepository();
        Stock almacen = stock.findAll().get(0);
        //Check if exist 
        ItemRepository itemRepository = new ItemRepository();
        Boolean found = false;
        for (DetallePedido productoRecibido : recepcion.getPedido().getDetallesPedido()) {
            found = false;
            for (Item item : almacen.getItems()) {
                if (item.getProducto().getId().equals(productoRecibido.getId())) {
                    found = true;
                    item.setExistencias(item.getExistencias() + productoRecibido.getCantidad());
                    itemRepository.update(item);
                }
            }
            if (!found) {
                Item item = new Item();
                item.setProducto(productoRecibido.getProducto());
                item.setExistencias(productoRecibido.getCantidad());
                itemRepository.create(item);
                almacen.getItems().add(item);
                break;
            }
        }
        stock.update(almacen);
        JOptionPane.showMessageDialog(rootPane, "Guardado", "Información", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void pedidosComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pedidosComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pedidosComboBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<Pedido> pedidosComboBox;
    // End of variables declaration//GEN-END:variables
}
