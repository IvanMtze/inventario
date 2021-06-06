package com.mycompany.inventario.userInteraface;

import com.mycompany.inventario.Entity.User;
import com.mycompany.inventario.dao.UserRepository;
import java.awt.Frame;
import javax.swing.JOptionPane;

/**
 *
 * @author wuser
 */
public class AddUserForm extends javax.swing.JDialog {

    UserRepository repository;

    public AddUserForm(Frame owner, String title, Boolean modal) {
        super(owner, title, modal);
        initComponents();
        repository = new UserRepository();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        usernameTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        nameTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lastNameTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        addressTxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        phoneTxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        emailTxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        passwordTxt = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();


        setVisible(true);

        jPanel1.setLayout(new java.awt.GridLayout(7, 2, 10, 10));

        jLabel7.setText("Nombre de usuario");
        jPanel1.add(jLabel7);
        jPanel1.add(usernameTxt);

        jLabel2.setText("Nombre(s)");
        jPanel1.add(jLabel2);
        jPanel1.add(nameTxt);

        jLabel3.setText("Apellidos");
        jPanel1.add(jLabel3);
        jPanel1.add(lastNameTxt);

        jLabel4.setText("Dirección");
        jPanel1.add(jLabel4);
        jPanel1.add(addressTxt);

        jLabel5.setText("Telefono");
        jPanel1.add(jLabel5);
        jPanel1.add(phoneTxt);

        jLabel6.setText("Email");
        jPanel1.add(jLabel6);
        jPanel1.add(emailTxt);

        jLabel8.setText("Contraseña");
        jPanel1.add(jLabel8);
        jPanel1.add(passwordTxt);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 100, 5);
        flowLayout1.setAlignOnBaseline(true);
        jPanel2.setLayout(flowLayout1);

        jButton1.setText("Cancelar");
        jPanel2.add(jButton1);

        jButton2.setText("Aceptar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);

        getContentPane().add(jPanel2, java.awt.BorderLayout.SOUTH);

        jPanel5.setLayout(new java.awt.BorderLayout(20, 0));

        jLabel1.setText("<html>Recuerda elegir una contraseña segura. y facil de recordar para ti. Por ahora, no tendras forma de recuperarla y en caso de olvidarla, deberás crear otro usuario.</html>");
        jPanel5.add(jLabel1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel5, java.awt.BorderLayout.NORTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        User user = new User();
        user.setFirstName(nameTxt.getText());
        user.setAddress(addressTxt.getText());
        user.setEmail(emailTxt.getText());
        user.setLastName(lastNameTxt.getText());
        user.setPhone(phoneTxt.getText());
        user.setPassword(passwordTxt.getText());
        user.setUsername(usernameTxt.getText());
        if (repository.create(user) != null) {
            JOptionPane.showMessageDialog(this, "Creado exitosamente");
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Error al guardar, intente nuevamente por favor o contacte al administrador del sistema.");
        }

    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addressTxt;
    private javax.swing.JTextField emailTxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField lastNameTxt;
    private javax.swing.JTextField nameTxt;
    private javax.swing.JTextField passwordTxt;
    private javax.swing.JTextField phoneTxt;
    private javax.swing.JTextField usernameTxt;
    // End of variables declaration//GEN-END:variables
}
