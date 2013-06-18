package com.tsystems.demail.client;

import com.tsystems.demail.common.ProtocolCommands;
import com.tsystems.demail.common.ProtocolParameters;
import java.util.Properties;
import javax.swing.JOptionPane;

public class NewMessage extends javax.swing.JFrame {

    private static String username;
    private static String to, subject;
    private ProtocolCommands pc;
    private ProtocolParameters pp;

    
    public NewMessage(String username, String to, String subject) {
        pc = new ProtocolCommands();
        pp = new ProtocolParameters();
        NewMessage.username = username;
        NewMessage.to = to;
        NewMessage.subject = subject;
        initComponents();
        fieldTo.setText(to);
        fieldSubject.setText(subject);
    }

    private final String[] arg = {};
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelTo = new javax.swing.JLabel();
        labelSubject = new javax.swing.JLabel();
        fieldTo = new javax.swing.JTextField();
        fieldSubject = new javax.swing.JTextField();
        scrollMessage = new javax.swing.JScrollPane();
        areaMessage = new javax.swing.JTextArea();
        buttonSend = new javax.swing.JButton();
        buttonCncl = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        setTitle("New message");
        setResizable(false);

        labelTo.setText("To:");

        labelSubject.setText("Subject:");

        areaMessage.setColumns(20);
        areaMessage.setLineWrap(true);
        areaMessage.setRows(5);
        scrollMessage.setViewportView(areaMessage);

        buttonSend.setText("Send");
        buttonSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSendActionPerformed(evt);
            }
        });

        buttonCncl.setText("Cancel");
        buttonCncl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCnclActionPerformed(evt);
            }
        });

        jTextField1.setEditable(false);
        jTextField1.setText("@demail.com");
        jTextField1.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollMessage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelSubject)
                    .addComponent(labelTo, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fieldSubject)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(fieldTo)
                        .addGap(1, 1, 1)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(buttonSend, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(buttonCncl, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTo)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldSubject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelSubject))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonSend)
                    .addComponent(buttonCncl))
                .addGap(5, 5, 5))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCnclActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCnclActionPerformed
        setVisible(false);
    }//GEN-LAST:event_buttonCnclActionPerformed

    private void buttonSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSendActionPerformed
        String to1 = fieldTo.getText();
        String subject1 = fieldSubject.getText();
        String text = areaMessage.getText();
        boolean toCheck = false, textCheck = false, selfCheck = false;
        String toAlert = "";
        String textAlert = "";
        String selfAlert = "";
        if(Validator.userNameChecking(to1) == true)
            toCheck = true;
        else toAlert = "To field must be between 6 and 30 characters and contain only letters (a-z) and numbers.\n";
        if(text.length() > 0)
            textCheck = true;
        else textAlert = "Text field cannot be null.\n";
        if((to1+"@demail.com").equals(username) == false)
            selfCheck = true;
        else selfAlert = "You cannot send messages to yourself.\n";
        if(toCheck && textCheck && selfCheck == true)
        {
                Properties p = new Properties();
                p.setProperty(pp.KEY, pc.SEND_MESSAGE);
                p.setProperty(pp.FROM, username);
                p.setProperty(pp.TO, to1 + "@demail.com");
                p.setProperty(pp.SUBJECT, subject1);
                p.setProperty(pp.TEXT, text);
                if(Client.getAnswer(p) == true){
                    JOptionPane.showMessageDialog(rootPane, "Message sent.");
                    setVisible(false);
                }
                else JOptionPane.showMessageDialog(rootPane, "User with that mail is not registered.");
            
            
        }
        else JOptionPane.showMessageDialog(rootPane, toAlert + textAlert + selfAlert);
    }//GEN-LAST:event_buttonSendActionPerformed

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
            java.util.logging.Logger.getLogger(NewMessage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewMessage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewMessage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewMessage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewMessage(username, to, subject).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaMessage;
    private javax.swing.JButton buttonCncl;
    private javax.swing.JButton buttonSend;
    private javax.swing.JTextField fieldSubject;
    private javax.swing.JTextField fieldTo;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel labelSubject;
    private javax.swing.JLabel labelTo;
    private javax.swing.JScrollPane scrollMessage;
    // End of variables declaration//GEN-END:variables
}
