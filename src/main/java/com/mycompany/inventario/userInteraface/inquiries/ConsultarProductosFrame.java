package com.mycompany.inventario.userInteraface.inquiries;

import com.mycompany.inventario.Entity.Product;
import com.mycompany.inventario.dao.ProductRepository;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author wuser
 */
public class ConsultarProductosFrame extends javax.swing.JInternalFrame {

    private ProductRepository repositorio = new ProductRepository();

    public ConsultarProductosFrame() {
        initComponents();
        loadData();
    }

    private void loadData() {
        DefaultTableModel model = (DefaultTableModel) this.jTable1.getModel();

        List<Product> productos = this.repositorio.findAll();
        for (Product producto : productos) {
            System.out.println(producto);
            System.out.println(producto.getProveedores().size());
            for (int i = 0; i < producto.getProveedores().size(); i++){
                System.out.println(producto.getProveedores().size());
                Vector row = new Vector();
                row.add(producto.getNombre());
                row.add(producto.getCategoria().getNombre());
                row.add(producto.getProveedores().get(i).getNombre());
                row.add(producto.getUnit());
                model.addRow(row);
            }
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
        setMaximizable(true);
        setTitle("Consultar Productos");
        setVerifyInputWhenFocusTarget(false);
        setVisible(false);

        jPanel1.setMinimumSize(new java.awt.Dimension(100, 20));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel3.setPreferredSize(new java.awt.Dimension(394, 30));
        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.X_AXIS));

        jLabel1.setText("Buscar");
        jPanel3.add(jLabel1);

        jTextField1.setText("Mis productos...");
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
                "Nombre", "Categoria", "Proveedor", "Cantidad"
            }
        ));
        jTable1.setMinimumSize(new java.awt.Dimension(75, 0));
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
