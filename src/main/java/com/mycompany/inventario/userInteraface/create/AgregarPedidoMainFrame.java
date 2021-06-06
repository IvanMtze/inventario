package com.mycompany.inventario.userInteraface.create;

import com.mycompany.inventario.Entity.DetallePedido;
import com.mycompany.inventario.Entity.Pedido;
import com.mycompany.inventario.dao.DetallePedidoRepository;
import com.mycompany.inventario.dao.PedidoRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.table.DefaultTableModel;

public class AgregarPedidoMainFrame extends javax.swing.JInternalFrame {

    DetallePedidoRepository pedidosDetailsReposity = new DetallePedidoRepository();
    PedidoRepository pedidosRepository = new PedidoRepository();
    
    Pedido pedido = new Pedido();

    public AgregarPedidoMainFrame() {
        initComponents();
        pedido.setDetallesPedido(new ArrayList<DetallePedido>());
    }

    
    private void loadData() {
        DefaultTableModel model = (DefaultTableModel) this.jTable1.getModel();
        for (int i = 0; i < model.getRowCount();) {
            model.removeRow(i);
        }
        for (DetallePedido pedidoDetails : pedido.getDetallesPedido()) {
            Vector row = new Vector();
            row.add(pedidoDetails.getProducto().getNombre());
            row.add(pedidoDetails.getCantidad());
            row.add(pedidoDetails.getProveedor().getNombre());
            row.add(pedidoDetails.getPago().getTipoDePago());
            row.add(pedidoDetails.getTotal());
            row.add(pedidoDetails.getPedido().getFechaDeRealizacion());
            model.addRow(row);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        setClosable(true);
        setTitle("Consultar Pedidos");

        jPanel1.setMinimumSize(new java.awt.Dimension(100, 20));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel3.setPreferredSize(new java.awt.Dimension(394, 30));
        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.X_AXIS));

        jLabel1.setText("Tipo de pago");
        jPanel3.add(jLabel1);

        jButton1.setText("Nuevo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);

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

        jButton3.setText("Guardar y salir");
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        AgregarPedidoDetalleFrame detailFrame = new AgregarPedidoDetalleFrame();
        this.getParent().add(detailFrame);
        detailFrame.addInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameClosed(InternalFrameEvent e) {
                if (detailFrame.getPedido() != null) {
                    detailFrame.getPedido().setPedido(pedido);
                    pedido.getDetallesPedido().add(detailFrame.getPedido());
                }
                loadData();
                toFront();
                setEnabled(true);
                setVisible(true);
                //detailFrame.dispose();
            }
        });
        this.toBack();
        this.setVisible(false);
        this.setEnabled(false);
        detailFrame.toFront();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        pedido.setFechaDeRealizacion(new Date());
        pedidosRepository.create(pedido);
        JOptionPane.showMessageDialog(rootPane, "Guardado", "Información", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
