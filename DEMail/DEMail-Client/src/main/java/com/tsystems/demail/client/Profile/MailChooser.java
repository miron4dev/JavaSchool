package com.tsystems.demail.client.Profile;

import com.tsystems.demail.client.App;
import com.tsystems.demail.client.Client;
import com.tsystems.demail.client.Mail;
import com.tsystems.demail.common.ProtocolCommands;
import com.tsystems.demail.common.ProtocolParameters;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class MailChooser extends javax.swing.JFrame {

    private static String mobile_phone, password, first_name, last_name;
    private static String[] mails;
    private static final String[] arg = {};
    private ProtocolCommands pc;
    private ProtocolParameters pp;
    
    public static String getMobile_phone() {
        return mobile_phone;
    }
    
    public MailChooser(String mobile_phone, String password, String first_name, String last_name) {
        pc = new ProtocolCommands();
        pp = new ProtocolParameters();
        MailChooser.mobile_phone = mobile_phone;
        getMailList(mobile_phone);
        MailChooser.password = password;
        MailChooser.first_name = first_name;
        MailChooser.last_name = last_name;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelWelcome = new javax.swing.JLabel();
        boxList = new javax.swing.JComboBox();
        buttonCreate = new javax.swing.JButton();
        buttonLogin = new javax.swing.JButton();
        buttonExit = new javax.swing.JButton();
        buttonDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Choose the action");
        setResizable(false);

        labelWelcome.setText("Welcome back, " + first_name + " " + last_name);

        boxList.setModel(new javax.swing.DefaultComboBoxModel(MailChooser.mails));

        buttonCreate.setText("Create new user");
        buttonCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCreateActionPerformed(evt);
            }
        });

        buttonLogin.setText("Login");
        buttonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLoginActionPerformed(evt);
            }
        });

        buttonExit.setText("Exit to main menu");
        buttonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExitActionPerformed(evt);
            }
        });

        buttonDelete.setText("Delete ");
        buttonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(buttonCreate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonExit)
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(boxList, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labelWelcome))
                .addGap(115, 115, 115))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(labelWelcome)
                .addGap(18, 18, 18)
                .addComponent(boxList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCreate)
                    .addComponent(buttonLogin)
                    .addComponent(buttonExit)
                    .addComponent(buttonDelete))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExitActionPerformed
        setVisible(false);
        App.main(arg);
    }//GEN-LAST:event_buttonExitActionPerformed

    private void buttonCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCreateActionPerformed
        setVisible(false);
        RegistrationMail.setPhone(mobile_phone);
        RegistrationMail.setReal_pass(password);
        RegistrationMail.main(arg);
    }//GEN-LAST:event_buttonCreateActionPerformed

    private void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteActionPerformed
        setVisible(false);
        String username = boxList.getSelectedItem().toString();
        ConfirmDelete.setUsername(username);
        ConfirmDelete.main(arg);
    }//GEN-LAST:event_buttonDeleteActionPerformed

    private void buttonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLoginActionPerformed
 
            Properties p1 = new Properties();
            p1.setProperty(pp.KEY, pc.GET_FOLDERS);
            p1.setProperty(pp.USERNAME, boxList.getSelectedItem().toString());
            List folders = Client.getList(p1);
            Mail m = new Mail();
            Object[][] forTable = m.getForTableList(boxList.getSelectedItem().toString(), pp.INBOX);
            Object[][] arrayOfMessages = m.getMessagesList(boxList.getSelectedItem().toString(), pp.INBOX);
            setVisible(false);
            Mail client = new Mail(boxList.getSelectedItem().toString(), folders.subList(6, folders.size()), forTable, arrayOfMessages);
            client.setVisible(true);
    }//GEN-LAST:event_buttonLoginActionPerformed

    public void getMailList(String phone){
            Properties p = new Properties();
            p.setProperty(pp.KEY, pc.GET_MAILS);
            p.setProperty(pp.PHONE, phone);
            List list = Client.getList(p);
            MailChooser.mails = new String[list.size()];
            for(int i = 0; i < list.size(); i++)
            MailChooser.mails[i] = list.get(i).toString();
    }
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(MailChooser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MailChooser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MailChooser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MailChooser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MailChooser(getMobile_phone(), password, first_name, last_name).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox boxList;
    private javax.swing.JButton buttonCreate;
    private javax.swing.JButton buttonDelete;
    private javax.swing.JButton buttonExit;
    private javax.swing.JButton buttonLogin;
    private javax.swing.JLabel labelWelcome;
    // End of variables declaration//GEN-END:variables
}
