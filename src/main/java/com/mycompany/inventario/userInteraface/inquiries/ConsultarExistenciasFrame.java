package com.mycompany.inventario.userInteraface.inquiries;

import com.mycompany.inventario.Entity.Item;
import com.mycompany.inventario.Entity.Stock;
import com.mycompany.inventario.dao.StockRepository;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author wuser
 */
public class ConsultarExistenciasFrame extends javax.swing.JInternalFrame {

    private StockRepository stock = new StockRepository();

    public ConsultarExistenciasFrame() {
        initComponents();
        loadData();
    }

    private void loadData() {
        List<Stock> existencias = this.stock.findAll();
        DefaultTableModel model = (DefaultTableModel) this.jTable1.getModel();
        for(Stock stock : existencias) {
            for(Item item : stock.getItems()) {
                for(int i = 0; i < item.getProducto().getProveedores().size();i++){
                    Vector row = new Vector();
                    row.add(item.getProducto().getNombre());
                    row.add(item.getProducto().getCategoria().getNombre());
                    row.add(item.getProducto().getProveedores().get(i));
                    row.add(item.getProducto().getUnit());
                    row.add(item.getExistencias());
                    model.addRow(row);
                }
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
        setTitle("Consultar Existencias");
        setVerifyInputWhenFocusTarget(false);
        setVisible(false);

        jPanel1.setMinimumSize(new java.awt.Dimension(100, 20));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel3.setPreferredSize(new java.awt.Dimension(394, 30));
        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.X_AXIS));

        jLabel1.setText("Buscar");
        jPanel3.add(jLabel1);

        jTextField1.setText("Mis existencias...");
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
                "Nombre", "Categoria", "Proveedor", "Cantidad", "Existencias"
            }
        ));
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
