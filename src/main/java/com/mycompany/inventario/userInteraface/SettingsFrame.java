package com.mycompany.inventario.userInteraface;

import com.mycompany.inventario.Entity.Pago;
import com.mycompany.inventario.Entity.Stock;
import com.mycompany.inventario.Entity.User;
import com.mycompany.inventario.dao.PagoRepository;
import com.mycompany.inventario.dao.UserRepository;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author wuser
 */
public class SettingsFrame extends javax.swing.JInternalFrame {

    UserRepository repositorio = new UserRepository();

    public SettingsFrame() {
        initComponents();
        loadData();

        usersTable.addMouseListener(new MouseAdapter() {
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

        this.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                loadData();
            }
        });
        jListPago.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    final JPopupMenu menu = new JPopupMenu("Menu");
                    JMenuItem menuItemEliminar = new JMenuItem("Eliminar");
                    menuItemEliminar.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            deleteSelectedPagoItem();
                        }
                    });
                    JMenuItem menuItemEditar = new JMenuItem("Editar");
                    menuItemEditar.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            editarSelectedPagoItem();
                        }
                    });
                    menu.add(menuItemEditar);
                    menu.add(menuItemEliminar);
                    menu.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });
    }

    private void editarSelectedPagoItem(){
        
    }
    
    private void deleteSelectedPagoItem(){
        Long id = (Long) jListPago.getSelectedValue().getId();
        PagoRepository repository = new PagoRepository();
        repository.deleteById(id);
        loadData();
    }
    
    private void deleteSelectedItem() {
        Long id = (Long) usersTable.getModel().getValueAt(usersTable.getSelectedRow(), 0);
        repositorio.deleteById(id);
        loadData();
    }

    private void changeStatus(Boolean state) {
        this.setClosable(state);
    }

    private void changeFocus() {
        requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel12 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel10 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListPago = new javax.swing.JList<>();
        jPanel8 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        tipoPagoTxt = new javax.swing.JTextField();
        jPanel14 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        descripcionPagoTxt = new javax.swing.JTextArea();
        jPanel15 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        usersTable = new javax.swing.JTable();

        jPanel12.setPreferredSize(new java.awt.Dimension(0, 0));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 0);
        flowLayout1.setAlignOnBaseline(true);
        jPanel12.setLayout(flowLayout1);

        jButton2.setText("Editar");
        jPanel12.add(jButton2);

        jButton3.setText("Eliminar");
        jPanel12.add(jButton3);

        setClosable(true);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jTabbedPane2.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        jPanel10.setLayout(new java.awt.BorderLayout());

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Metodos de pago existentes"));
        jPanel9.setMinimumSize(new java.awt.Dimension(100, 100));
        jPanel9.setLayout(new javax.swing.BoxLayout(jPanel9, javax.swing.BoxLayout.Y_AXIS));

        jListPago.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(jListPago);

        jPanel9.add(jScrollPane2);

        jPanel10.add(jPanel9, java.awt.BorderLayout.EAST);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Registrar un metodo de pago"));
        jPanel8.setLayout(new java.awt.GridLayout(3, 2, 0, 20));

        jPanel13.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 40));

        jLabel2.setText("Nombre o tipo de pago");
        jLabel2.setPreferredSize(new java.awt.Dimension(210, 16));
        jPanel13.add(jLabel2);

        tipoPagoTxt.setMinimumSize(new java.awt.Dimension(150, 32));
        tipoPagoTxt.setPreferredSize(new java.awt.Dimension(150, 32));
        jPanel13.add(tipoPagoTxt);

        jPanel8.add(jPanel13);

        jPanel14.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 30));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Descripción");
        jLabel3.setMaximumSize(new java.awt.Dimension(210, 16));
        jLabel3.setMinimumSize(new java.awt.Dimension(210, 16));
        jLabel3.setPreferredSize(new java.awt.Dimension(210, 16));
        jPanel14.add(jLabel3);

        jScrollPane4.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        descripcionPagoTxt.setColumns(20);
        descripcionPagoTxt.setRows(5);
        jScrollPane4.setViewportView(descripcionPagoTxt);

        jPanel14.add(jScrollPane4);

        jPanel8.add(jPanel14);

        jPanel15.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 30));

        jButton6.setText("Aceptar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel15.add(jButton6);

        jButton7.setText("Cancelar");
        jPanel15.add(jButton7);

        jPanel8.add(jPanel15);

        jPanel10.add(jPanel8, java.awt.BorderLayout.CENTER);

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder("Descripción del metodo de pago"));
        jPanel11.setLayout(new javax.swing.BoxLayout(jPanel11, javax.swing.BoxLayout.LINE_AXIS));

        jScrollPane3.setFocusable(false);

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(javax.swing.UIManager.getDefaults().getColor("Desktop.background"));
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("dfd");
        jScrollPane3.setViewportView(jTextArea1);

        jPanel11.add(jScrollPane3);

        jPanel10.add(jPanel11, java.awt.BorderLayout.SOUTH);

        jTabbedPane2.addTab("Pagos", jPanel10);

        jPanel1.add(jTabbedPane2, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("General", jPanel1);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel4.setLayout(new java.awt.BorderLayout());

        jLabel1.setText("<html>Agrega usuarios al sistema, de esta forma podrán trabajar sin usar la cuenta de administrador.</html>");
        jLabel1.setToolTipText("");
        jPanel4.add(jLabel1, java.awt.BorderLayout.CENTER);

        jButton1.setText("Agregar usuario");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1, java.awt.BorderLayout.EAST);

        jPanel2.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        jPanel5.setLayout(new java.awt.BorderLayout());

        jPanel6.setLayout(new java.awt.GridLayout(1, 4, 10, 0));

        jButton4.setText("jButton4");
        jPanel6.add(jButton4);

        jButton5.setText("jButton5");
        jPanel6.add(jButton5);

        jPanel5.add(jPanel6, java.awt.BorderLayout.PAGE_END);

        jPanel7.setLayout(new java.awt.GridLayout(1, 0));

        usersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre(s)", "Apellidos", "Email", "Nombre de usuario", "Telefono", "Dirección"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        usersTable.setShowHorizontalLines(false);
        usersTable.setShowVerticalLines(false);
        jScrollPane1.setViewportView(usersTable);

        jPanel7.add(jScrollPane1);

        jPanel5.add(jPanel7, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel5, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Usuarios", jPanel2);

        getContentPane().add(jTabbedPane1, java.awt.BorderLayout.CENTER);
        jTabbedPane1.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        AddUserForm addUserForm = new AddUserForm(JOptionPane.getFrameForComponent(this), "Crear un usuario nuevo", false);
        addUserForm.setVisible(true);
        changeStatus(false);
        addUserForm.addWindowListener(new WindowAdapter() {
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
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        Pago nuevoPago = new Pago();
        nuevoPago.setDetalles(descripcionPagoTxt.getText());
        nuevoPago.setTipoDePago(tipoPagoTxt.getText());
        PagoRepository pagoRepository = new PagoRepository();
        if (pagoRepository.create(nuevoPago) != null) {
            JOptionPane.showMessageDialog(rootPane, "Guardado", "Información", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Error al guardar, por favor intente nuevamente.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        loadData();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void loadData() {
        DefaultTableModel model = (DefaultTableModel) usersTable.getModel();
        List<User> users = this.repositorio.findAll();
        for (int i = 0; i < model.getRowCount();) {
            model.removeRow(i);
        }
        for (User user : users) {
            Vector row = new Vector();
            row.add(user.getId());
            row.add(user.getFirstName());
            row.add(user.getLastName());
            row.add(user.getEmail());
            row.add(user.getUsername());
            row.add(user.getPhone());
            row.add(user.getAddress());
            model.addRow(row);
        }
        PagoRepository pagosRepository = new PagoRepository();
        DefaultListModel listModelPago = new DefaultListModel();
        List<Pago> pagos = pagosRepository.findAll();
        for (Pago pago : pagos) {
            listModelPago.addElement(pago);
        }
        jListPago.setModel(listModelPago);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea descripcionPagoTxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<Pago> jListPago;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField tipoPagoTxt;
    private javax.swing.JTable usersTable;
    // End of variables declaration//GEN-END:variables
}
