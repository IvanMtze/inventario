package com.mycompany.inventario.userInteraface.inquiries;

import com.mycompany.inventario.Entity.DetallePedido;
import com.mycompany.inventario.Entity.Item;
import com.mycompany.inventario.Entity.Stock;
import com.mycompany.inventario.dao.DetallePedidoRepository;
import com.mycompany.inventario.dao.PedidoRepository;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class ConsultarPedidosFrame extends javax.swing.JInternalFrame {

    DetallePedidoRepository pedidos = new DetallePedidoRepository();

    public ConsultarPedidosFrame() {
        initComponents();
        loadData();
                jTable1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    final JPopupMenu menu = new JPopupMenu("Menu");
                    JMenuItem menuItemEliminar = new JMenuItem("Eliminar");
                    menuItemEliminar.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            deleteSelectedItem();
                        }
                    });
                    menu.add(menuItemEliminar);
                    menu.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });
    }

    private void deleteSelectedItem() {
        Long id = (Long) jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 0);
        pedidos.deleteById(id);
        loadData();
    }

    
    private void loadData() {
        List<DetallePedido> pedidos = this.pedidos.findAll();
        
        DefaultTableModel model = (DefaultTableModel) this.jTable1.getModel();
        for (int i = 0; i < model.getRowCount();) {
            model.removeRow(i);
        }
        for (DetallePedido pedido : pedidos) {
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
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        setClosable(true);
        setTitle("Consultar Pedidos");

        jPanel1.setMinimumSize(new java.awt.Dimension(100, 20));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel3.setPreferredSize(new java.awt.Dimension(394, 30));
        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.X_AXIS));

        jLabel1.setText("Buscar");
        jPanel3.add(jLabel1);

        jTextField1.setText("Mis pedidos...");
        jTextField1.setToolTipText("");
        jPanel3.add(jTextField1);

        jButton1.setText("Buscar");
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
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
