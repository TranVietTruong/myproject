/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import vendor.DigitDocument;

/**
 *
 * @author Admin
 */
public class FrmInput extends javax.swing.JFrame {
    JFrame parent;
    /**
     * Creates new form FrmInput
     * @param frm
     */
    public FrmInput(JFrame frm) {
        initComponents();
        setLocationRelativeTo(null);
        txt_PriceInput.setDocument(new DigitDocument());
        txt_QuantityInput.setDocument(new DigitDocument());
        parent = frm;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txt_QuantityInput = new javax.swing.JTextField();
        txt_PriceInput = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btn_Input = new javax.swing.JButton();
        btn_Exit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_QuantityInput.setBackground(new java.awt.Color(0, 153, 153));
        txt_QuantityInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_QuantityInput.setForeground(new java.awt.Color(255, 255, 255));
        txt_QuantityInput.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.add(txt_QuantityInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 180, -1));

        txt_PriceInput.setBackground(new java.awt.Color(0, 153, 153));
        txt_PriceInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_PriceInput.setForeground(new java.awt.Color(255, 255, 255));
        txt_PriceInput.setToolTipText("");
        txt_PriceInput.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.add(txt_PriceInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 180, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Số Lượng Nhập : ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Đơn Giá Nhập : ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        btn_Input.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_checkmark_26px.png"))); // NOI18N
        btn_Input.setText("Nhập");
        btn_Input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_InputActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Input, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 100, 30));

        btn_Exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_cancel_25px.png"))); // NOI18N
        btn_Exit.setText("Hủy");
        btn_Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ExitActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, 100, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ExitActionPerformed
      
        this.dispose();
        parent.setEnabled(true);
    }//GEN-LAST:event_btn_ExitActionPerformed
   
    private void btn_InputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_InputActionPerformed
        if(txt_PriceInput.getText().length()>7 || txt_QuantityInput.getText().length() > 7)
        {
            JOptionPane.showMessageDialog(null,"Dữ liệu nhập không hợp lệ");
            return;
        }
       
        parent.setEnabled(true);
        dispose();
    }//GEN-LAST:event_btn_InputActionPerformed

    /**
     * @param args the command line arguments
     */
    /*
    public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmInput.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmInput.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmInput.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmInput.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmInput().setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Exit;
    private javax.swing.JButton btn_Input;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txt_PriceInput;
    private javax.swing.JTextField txt_QuantityInput;
    // End of variables declaration//GEN-END:variables
}
