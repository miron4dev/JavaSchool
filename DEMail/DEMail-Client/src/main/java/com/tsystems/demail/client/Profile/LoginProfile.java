package com.tsystems.demail.client.Profile;

import com.tsystems.demail.client.App;
import com.tsystems.demail.client.Client;
import com.tsystems.demail.client.Validator;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import javax.swing.JOptionPane;

public class LoginProfile extends javax.swing.JFrame {

    public LoginProfile() {
        initComponents();
    }
    private final String[] arg = {};

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fieldPass = new javax.swing.JPasswordField();
        fieldMPhone = new javax.swing.JTextField();
        buttonLgn = new javax.swing.JButton();
        buttonCncl = new javax.swing.JButton();
        labelMPhone = new javax.swing.JLabel();
        labalPass = new javax.swing.JLabel();
        field7 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Login to service");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        buttonLgn.setText("Login");
        buttonLgn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLgnActionPerformed(evt);
            }
        });

        buttonCncl.setText("Cancel");
        buttonCncl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCnclActionPerformed(evt);
            }
        });

        labelMPhone.setText("Mobile Phone:");

        labalPass.setText("Password:");

        field7.setEditable(false);
        field7.setText("+7");
        field7.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(buttonLgn, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(buttonCncl, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelMPhone, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labalPass, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(fieldPass, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(field7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(fieldMPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(23, 23, 23))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldMPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMPhone)
                    .addComponent(field7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labalPass))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonLgn)
                    .addComponent(buttonCncl))
                .addGap(5, 5, 5))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCnclActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCnclActionPerformed
        setVisible(false);
        App.main(arg);
    }//GEN-LAST:event_buttonCnclActionPerformed

    private void buttonLgnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLgnActionPerformed
        String phone = "+7" + fieldMPhone.getText();
        String password = fieldPass.getText();
        String phoneAlert = "", passAlert = "";
        boolean check = true;
        if (Validator.phoneChecking(phone) == false) {
            phoneAlert = "Mobile phone is invalid.\n";
            check = false;
        }
        if (password.length() <= 6) {
            passAlert = "Password is too short.\n";
            check = false;
        }
        if (check == false) {
            JOptionPane.showMessageDialog(rootPane, phoneAlert + passAlert);
            return;
        }
        Properties data = new Properties();
        data.setProperty("KEY", "LOG_PROFILE");
        data.setProperty("PHONE", phone);
        data.setProperty("PASSWORD", password);
        try {
            List list = Client.getList(data);
            if (list.get(0).toString().equals("false") == false) {
                setVisible(false);
                Object[] obj1 = (Object[]) list.get(0);
                MailChooser choose = new MailChooser(obj1[0].toString() , obj1[1].toString(), obj1[2].toString(), obj1[3].toString());
                choose.setVisible(true);
            }
            else
            {
                JOptionPane.showMessageDialog(rootPane, "Incorrect mobile phone or password.");
                return;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_buttonLgnActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        setVisible(false);
        App.main(arg);
    }//GEN-LAST:event_formWindowClosing

    public static void main(String args[]) {

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginProfile().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCncl;
    private javax.swing.JButton buttonLgn;
    private javax.swing.JTextField field7;
    private javax.swing.JTextField fieldMPhone;
    private javax.swing.JPasswordField fieldPass;
    private javax.swing.JLabel labalPass;
    private javax.swing.JLabel labelMPhone;
    // End of variables declaration//GEN-END:variables
}
