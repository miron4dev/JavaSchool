package com.tsystems.demail.client.Profile;

import com.tsystems.demail.client.Client;
import com.tsystems.demail.client.Validator;
import java.io.IOException;
import java.util.Properties;
import javax.swing.JOptionPane;

public class RegistrationMail extends javax.swing.JFrame {

    private static final String[] arg = {};
    private static String phone, real_pass;

    public static void setPhone(String aPhone) {
        phone = aPhone;
    }

    public static void setReal_pass(String aReal_pass) {
        real_pass = aReal_pass;
    }
    
    public RegistrationMail() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelUName = new javax.swing.JLabel();
        labelProfile = new javax.swing.JLabel();
        fieldUName = new javax.swing.JTextField();
        fieldDEMail = new javax.swing.JTextField();
        fieldPass = new javax.swing.JPasswordField();
        buttonReg = new javax.swing.JButton();
        buttonCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Create new e-mail");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        labelUName.setText("Username:");

        labelProfile.setText("Profile password");

        fieldDEMail.setEditable(false);
        fieldDEMail.setText("@demail.com");
        fieldDEMail.setEnabled(false);

        buttonReg.setText("Registration");
        buttonReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRegActionPerformed(evt);
            }
        });

        buttonCancel.setText("Cancel");
        buttonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelUName, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelProfile, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(fieldPass)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(fieldUName, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(fieldDEMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(5, 5, 5))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(buttonReg)
                        .addGap(80, 80, 80)
                        .addComponent(buttonCancel)
                        .addGap(56, 56, 56))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelUName)
                    .addComponent(fieldUName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldDEMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelProfile)
                    .addComponent(fieldPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonReg)
                    .addComponent(buttonCancel))
                .addGap(5, 5, 5))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        setVisible(false);
        MailChooser.main(arg);
    }//GEN-LAST:event_formWindowClosing

    private void buttonRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRegActionPerformed
        String username = fieldUName.getText();
        String password = fieldPass.getText();
        String userAlert = "";
        String passAlert = "";
        String real_passAlert = "";
        boolean passCheck = false, userCheck = false, real_passCheck = false;
        if(Validator.userNameChecking(username) == true)
            userCheck = true;
        else userAlert = "Username must be between 6 and 30 characters and contain only letters (a-z) and numbers.\n";
        
        if(password.length() > 6)
            passCheck = true;
        else passAlert = "Password must be at least 6 characters.\n";
        
        if(password.equals(real_pass) == true)
            real_passCheck = true;
        else real_passAlert = "Password is wrong.";
        if(userCheck && passCheck && real_passCheck == true)
        {
            Properties data = new Properties();
            data.setProperty("KEY", "REG_MAIL");
            data.setProperty("USERNAME", username + "@demail.com");
            data.setProperty("PASSWORD", password);
            data.setProperty("PHONE", phone);
            try {
                if(Client.getAnswer(data) == true){
                    JOptionPane.showMessageDialog(rootPane, username + "@demail.com was successfuly registered. Now you can log in.\n");
                    setVisible(false);
                    MailChooser.main(arg);
                }
                else{
                    JOptionPane.showMessageDialog(rootPane, "Mail with that name is already registered.");
                }                    
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        else{
            JOptionPane.showMessageDialog(rootPane, userAlert + passAlert + real_passAlert);
        }
    }//GEN-LAST:event_buttonRegActionPerformed

    private void buttonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelActionPerformed
        setVisible(false);
    }//GEN-LAST:event_buttonCancelActionPerformed

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
            java.util.logging.Logger.getLogger(RegistrationMail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrationMail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrationMail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrationMail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrationMail().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonReg;
    private javax.swing.JTextField fieldDEMail;
    private javax.swing.JPasswordField fieldPass;
    private javax.swing.JTextField fieldUName;
    private javax.swing.JLabel labelProfile;
    private javax.swing.JLabel labelUName;
    // End of variables declaration//GEN-END:variables
}
