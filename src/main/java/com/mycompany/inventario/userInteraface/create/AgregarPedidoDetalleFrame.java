package com.mycompany.inventario.userInteraface.create;

import com.mycompany.inventario.Entity.DetallePedido;
import com.mycompany.inventario.Entity.Pago;
import com.mycompany.inventario.Entity.Pedido;
import com.mycompany.inventario.Entity.Product;
import com.mycompany.inventario.Entity.Proveedor;
import com.mycompany.inventario.dao.PagoRepository;
import com.mycompany.inventario.dao.ProductRepository;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author wuser
 */
public class AgregarPedidoDetalleFrame extends javax.swing.JInternalFrame {

    private ProductRepository productRepository = new ProductRepository();

    private DetallePedido pedido;
    private PagoRepository pagoRepository = new PagoRepository();

    public AgregarPedidoDetalleFrame() {
        initComponents();
        loadData();
        this.setVisible(true);
        productComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Product p = (Product) productComboBox.getSelectedItem();
                DefaultComboBoxModel<Proveedor> comboBoxModelProveedor = new DefaultComboBoxModel<>();
                for (Proveedor proveedor : p.getProveedores()) {
                    comboBoxModelProveedor.addElement(proveedor);
                }
                proveedorComboBox.setModel(comboBoxModelProveedor);
                calculaTotal();
            }
        });
        proveedorComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculaTotal();
            }
        });
        unityPriceTxt.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                calculaTotal();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                calculaTotal();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                calculaTotal();
            }
        });
        quantityTxt.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                calculaTotal();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                calculaTotal();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                calculaTotal();
            }
        });
        discountTxt.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                calculaTotal();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                calculaTotal();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                calculaTotal();
            }
        });
        impuestosCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImpuestosSpinner.setEnabled(impuestosCheckBox.isSelected());
                calculaTotal();
            }
        });
        ImpuestosSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                calculaTotal();
            }
        });
    }

    private void calculaTotal() {
        try {
            Float precioUnitario =Float.parseFloat(unityPriceTxt.getValue().toString());
            Float cantidad = Float.parseFloat(quantityTxt.getValue().toString());
            Float discount = Float.parseFloat(discountTxt.getValue().toString());
            Float impuesto = (Float) ImpuestosSpinner.getValue();
            Float total = precioUnitario * cantidad - discount;
            total += total * impuesto;
            totalTxt.setText(total.toString());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void loadData() {
        DefaultComboBoxModel<Product> comboBoxModelProduct = new DefaultComboBoxModel<>();
        for (Product p : productRepository.findAll()) {
            comboBoxModelProduct.addElement(p);
        }
        productComboBox.setModel(comboBoxModelProduct);
        DefaultComboBoxModel<Pago> comboBoxModelPago = new DefaultComboBoxModel<>();
        for(Pago p: pagoRepository.findAll()){
            comboBoxModelPago.addElement(p);
        }
        pagoBox.setModel(comboBoxModelPago);
    }

    public DetallePedido getPedido() {
        return pedido;
    }

    public void setPedido(DetallePedido pedido) {
        this.pedido = pedido;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        productComboBox = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        proveedorComboBox = new javax.swing.JComboBox<>();
        jPanel31 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        jPanel28 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        unityPriceTxt = new javax.swing.JFormattedTextField();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        sizeTxt = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        quantityTxt = new javax.swing.JFormattedTextField();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanel32 = new javax.swing.JPanel();
        jPanel38 = new javax.swing.JPanel();
        jPanel39 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel40 = new javax.swing.JPanel();
        discountTxt = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel35 = new javax.swing.JPanel();
        jPanel33 = new javax.swing.JPanel();
        jPanel34 = new javax.swing.JPanel();
        impuestosCheckBox = new javax.swing.JCheckBox();
        ImpuestosSpinner = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        pagoBox = new javax.swing.JComboBox<>();
        jPanel36 = new javax.swing.JPanel();
        jPanel41 = new javax.swing.JPanel();
        jPanel42 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanel43 = new javax.swing.JPanel();
        totalTxt = new javax.swing.JTextField();
        jPanel44 = new javax.swing.JPanel();
        jPanel45 = new javax.swing.JPanel();
        cancelarBtn2 = new javax.swing.JButton();
        jPanel46 = new javax.swing.JPanel();
        jPanel37 = new javax.swing.JPanel();
        aceptarBtn2 = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        setClosable(true);
        setTitle("Agregar un pedido");
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel19.setPreferredSize(new java.awt.Dimension(100, 37));
        jPanel19.setLayout(new java.awt.BorderLayout());

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("<html>Producto</html>");
        jPanel19.add(jLabel9, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel19, java.awt.BorderLayout.WEST);

        jPanel20.setLayout(new java.awt.GridLayout(1, 0));

        jPanel20.add(productComboBox);

        jPanel3.add(jPanel20, java.awt.BorderLayout.CENTER);
        jPanel3.add(jPanel5, java.awt.BorderLayout.PAGE_START);
        jPanel3.add(jPanel6, java.awt.BorderLayout.PAGE_END);
        jPanel3.add(jPanel16, java.awt.BorderLayout.LINE_END);

        getContentPane().add(jPanel3);

        jPanel30.setMinimumSize(new java.awt.Dimension(159, 52));
        jPanel30.setPreferredSize(new java.awt.Dimension(202, 57));
        jPanel30.setLayout(new java.awt.BorderLayout());

        jPanel1.setName(""); // NOI18N
        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.add(proveedorComboBox);

        jPanel30.add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel31.setPreferredSize(new java.awt.Dimension(100, 10));
        jPanel31.setLayout(new java.awt.BorderLayout());

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("<html>Proveedor</html>");
        jPanel31.add(jLabel13, java.awt.BorderLayout.CENTER);

        jPanel30.add(jPanel31, java.awt.BorderLayout.WEST);
        jPanel30.add(jPanel8, java.awt.BorderLayout.PAGE_START);
        jPanel30.add(jPanel7, java.awt.BorderLayout.PAGE_END);
        jPanel30.add(jPanel15, java.awt.BorderLayout.LINE_END);

        getContentPane().add(jPanel30);

        jPanel27.setMinimumSize(new java.awt.Dimension(159, 52));
        jPanel27.setLayout(new java.awt.BorderLayout());

        jPanel28.setPreferredSize(new java.awt.Dimension(100, 55));
        jPanel28.setLayout(new java.awt.BorderLayout());

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("<html>Precio unidad </html>");
        jPanel28.add(jLabel12, java.awt.BorderLayout.CENTER);

        jPanel27.add(jPanel28, java.awt.BorderLayout.WEST);

        jPanel29.setLayout(new java.awt.BorderLayout());

        unityPriceTxt.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        jPanel29.add(unityPriceTxt, java.awt.BorderLayout.CENTER);

        jPanel27.add(jPanel29, java.awt.BorderLayout.CENTER);
        jPanel27.add(jPanel9, java.awt.BorderLayout.PAGE_START);
        jPanel27.add(jPanel10, java.awt.BorderLayout.PAGE_END);
        jPanel27.add(jPanel17, java.awt.BorderLayout.LINE_END);

        getContentPane().add(jPanel27);

        jPanel24.setMinimumSize(new java.awt.Dimension(159, 52));
        jPanel24.setLayout(new java.awt.BorderLayout());

        jPanel25.setPreferredSize(new java.awt.Dimension(100, 100));
        jPanel25.setLayout(new java.awt.BorderLayout());

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("<html>Tamaño</html>");
        jPanel25.add(jLabel11, java.awt.BorderLayout.CENTER);

        jPanel24.add(jPanel25, java.awt.BorderLayout.WEST);

        jPanel26.setLayout(new java.awt.BorderLayout());

        sizeTxt.setMinimumSize(new java.awt.Dimension(22, 16));
        sizeTxt.setPreferredSize(new java.awt.Dimension(22, 16));
        sizeTxt.setRequestFocusEnabled(false);
        jPanel26.add(sizeTxt, java.awt.BorderLayout.CENTER);

        jPanel24.add(jPanel26, java.awt.BorderLayout.CENTER);
        jPanel24.add(jPanel11, java.awt.BorderLayout.PAGE_START);
        jPanel24.add(jPanel12, java.awt.BorderLayout.PAGE_END);
        jPanel24.add(jPanel18, java.awt.BorderLayout.LINE_END);

        getContentPane().add(jPanel24);

        jPanel21.setMinimumSize(new java.awt.Dimension(159, 52));
        jPanel21.setLayout(new java.awt.BorderLayout());

        jPanel22.setPreferredSize(new java.awt.Dimension(100, 34));
        jPanel22.setLayout(new java.awt.BorderLayout());

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("<html>Cantidad</html>");
        jPanel22.add(jLabel10, java.awt.BorderLayout.CENTER);

        jPanel21.add(jPanel22, java.awt.BorderLayout.WEST);

        jPanel23.setLayout(new java.awt.BorderLayout());

        quantityTxt.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        jPanel23.add(quantityTxt, java.awt.BorderLayout.CENTER);

        jPanel21.add(jPanel23, java.awt.BorderLayout.CENTER);
        jPanel21.add(jPanel13, java.awt.BorderLayout.PAGE_START);
        jPanel21.add(jPanel14, java.awt.BorderLayout.PAGE_END);
        jPanel21.add(jPanel32, java.awt.BorderLayout.LINE_END);

        getContentPane().add(jPanel21);

        jPanel38.setMinimumSize(new java.awt.Dimension(159, 52));
        jPanel38.setLayout(new java.awt.BorderLayout());

        jPanel39.setPreferredSize(new java.awt.Dimension(100, 34));
        jPanel39.setLayout(new java.awt.BorderLayout());

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("<html>Descuento</html>");
        jPanel39.add(jLabel15, java.awt.BorderLayout.CENTER);

        jPanel38.add(jPanel39, java.awt.BorderLayout.WEST);

        jPanel40.setLayout(new java.awt.BorderLayout());

        discountTxt.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        jPanel40.add(discountTxt, java.awt.BorderLayout.CENTER);

        jPanel38.add(jPanel40, java.awt.BorderLayout.CENTER);
        jPanel38.add(jPanel2, java.awt.BorderLayout.PAGE_START);
        jPanel38.add(jPanel4, java.awt.BorderLayout.PAGE_END);
        jPanel38.add(jPanel35, java.awt.BorderLayout.LINE_END);

        getContentPane().add(jPanel38);

        jPanel33.setLayout(new java.awt.BorderLayout(100, 0));

        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 50, 5);
        flowLayout1.setAlignOnBaseline(true);
        jPanel34.setLayout(flowLayout1);

        impuestosCheckBox.setSelected(true);
        impuestosCheckBox.setText("Impuestos");
        jPanel34.add(impuestosCheckBox);

        ImpuestosSpinner.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(100.0f), Float.valueOf(0.1f)));
        ImpuestosSpinner.setEnabled(impuestosCheckBox.isSelected());
        jPanel34.add(ImpuestosSpinner);

        jLabel1.setText("Tipo de pago");
        jPanel34.add(jLabel1);

        jPanel34.add(pagoBox);

        jPanel33.add(jPanel34, java.awt.BorderLayout.CENTER);
        jPanel33.add(jPanel36, java.awt.BorderLayout.LINE_END);

        getContentPane().add(jPanel33);

        jPanel41.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 200, 5));

        jPanel42.setPreferredSize(new java.awt.Dimension(100, 34));
        jPanel42.setLayout(new java.awt.BorderLayout());

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("<html>Total</html>");
        jPanel42.add(jLabel16, java.awt.BorderLayout.CENTER);

        jPanel41.add(jPanel42);

        jPanel43.setMinimumSize(new java.awt.Dimension(100, 32));
        jPanel43.setPreferredSize(new java.awt.Dimension(100, 32));
        jPanel43.setVerifyInputWhenFocusTarget(false);
        jPanel43.setLayout(new java.awt.BorderLayout());

        totalTxt.setEditable(false);
        jPanel43.add(totalTxt, java.awt.BorderLayout.CENTER);

        jPanel41.add(jPanel43);

        getContentPane().add(jPanel41);

        jPanel44.setMinimumSize(new java.awt.Dimension(159, 52));
        jPanel44.setLayout(new java.awt.BorderLayout(100, 0));

        jPanel45.setLayout(new java.awt.GridLayout(1, 4));

        cancelarBtn2.setText("Cancelar");
        jPanel45.add(cancelarBtn2);
        jPanel45.add(jPanel46);
        jPanel45.add(jPanel37);

        aceptarBtn2.setText("Aceptar");
        aceptarBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarBtn2ActionPerformed(evt);
            }
        });
        jPanel45.add(aceptarBtn2);

        jPanel44.add(jPanel45, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel44);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aceptarBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarBtn2ActionPerformed

        try {
            DetallePedido detallePedido = new DetallePedido();
            detallePedido.setProveedor((Proveedor) proveedorComboBox.getSelectedItem());
            detallePedido.setProducto((Product) productComboBox.getSelectedItem());
            detallePedido.setDescuento(
                    Double.parseDouble(discountTxt.getText())
            );
            detallePedido.setCantidad(Double.parseDouble(quantityTxt.getText()));
            detallePedido.setPrecioUnidad(Double.parseDouble(unityPriceTxt.getText()));
            detallePedido.setSize(sizeTxt.getText());
            detallePedido.setTotal(Double.parseDouble(totalTxt.getText()));
            detallePedido.setPago((Pago)pagoBox.getSelectedItem());
            JOptionPane.showMessageDialog(rootPane, "Guardado");
            this.setPedido(detallePedido);
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(rootPane, "Error al guardar, por favor verifique los datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_aceptarBtn2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner ImpuestosSpinner;
    private javax.swing.JButton aceptarBtn2;
    private javax.swing.JButton cancelarBtn2;
    private javax.swing.JFormattedTextField discountTxt;
    private javax.swing.JCheckBox impuestosCheckBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JComboBox<Pago> pagoBox;
    private javax.swing.JComboBox<Product> productComboBox;
    private javax.swing.JComboBox<Proveedor> proveedorComboBox;
    private javax.swing.JFormattedTextField quantityTxt;
    private javax.swing.JTextField sizeTxt;
    private javax.swing.JTextField totalTxt;
    private javax.swing.JFormattedTextField unityPriceTxt;
    // End of variables declaration//GEN-END:variables
}
