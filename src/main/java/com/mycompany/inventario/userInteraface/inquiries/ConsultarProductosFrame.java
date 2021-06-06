package com.mycompany.inventario.userInteraface.inquiries;

import com.mycompany.inventario.Entity.Product;
import com.mycompany.inventario.Entity.Proveedor;
import com.mycompany.inventario.dao.ProductRepository;
import com.mycompany.inventario.userInteraface.edit.EditarProductoFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.Vector;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
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
                    JMenuItem menuItemEditar = new JMenuItem("Editar");
                    menuItemEditar.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            editSelectedItem();
                        }
                    });
                    menu.add(menuItemEditar);
                    menu.add(menuItemEliminar);
                    menu.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });
    }

    private void editSelectedItem() {
        Long id = (Long) jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 0);
        EditarProductoFrame frame = new EditarProductoFrame(repositorio.find(id), JOptionPane.getFrameForComponent(this), "Editar un producto", false
        );
        frame.setVisible(true);
        changeStatus(false);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                changeStatus(true);
                changeFocus();
            }

            @Override
            public void windowClosing(WindowEvent e) {
                changeStatus(true);
                changeFocus();
            }
        });
    }

    private void changeStatus(Boolean state) {
        this.setClosable(state);
    }

    private void changeFocus() {
        requestFocus();
        loadData();

    }

    private void openThisWIndow(Boolean state) {
        this.setVisible(state);
        if (state) {
            this.toFront();
        } else {
            this.toBack();
        }
    }

    private void deleteSelectedItem() {
        Long id = (Long) jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 0);
        repositorio.deleteById(id);
        loadData();
    }

    private void loadData() {
        DefaultTableModel model = (DefaultTableModel) this.jTable1.getModel();
        for (int i = 0; i < model.getRowCount();) {
            model.removeRow(i);
        }
        List<Product> productos = this.repositorio.findAll();
        for (Product producto : productos) {
            if (producto.getProveedores().size() <= 0) {
                Vector row = new Vector();
                row.add(producto.getId());
                row.add(producto.getNombre());
                row.add(producto.getCategoria().getNombre());
                row.add("No hay proveedores disponibles");
                row.add(producto.getUnit());
                model.addRow(row);
            } else {
                for (int i = 0; i < producto.getProveedores().size(); i++) {
                    Vector row = new Vector();
                    row.add(producto.getId());
                    row.add(producto.getNombre());
                    row.add(producto.getCategoria().getNombre());
                    row.add(producto.getProveedores().get(i).getNombre());
                    row.add(producto.getUnit());
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
        setResizable(true);
        setTitle("Consultar Productos Registrados");
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
                "Id", "Nombre", "Categoria", "Proveedor", "Cantidad", "Existencias"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

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
