package com.tsystems.demail.client;

import javax.swing.JOptionPane;

public class OpenMessage extends javax.swing.JFrame {

    private static String from, to, date, text, subject;
    private static int row;
    
    public OpenMessage(String from, String to, String date, String text, String subject, int row) {
        OpenMessage.from = from;
        OpenMessage.to = to;
        OpenMessage.date = date;
        OpenMessage.text = text;
        OpenMessage.subject = subject;
        OpenMessage.row = row;
        initComponents();
    }

    
    String[] arg = {};
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelFrom = new javax.swing.JLabel();
        labelSubject = new javax.swing.JLabel();
        labelDate = new javax.swing.JLabel();
        buttonDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaMsg = new javax.swing.JTextArea();
        buttonReply = new javax.swing.JButton();
        labelTo = new javax.swing.JLabel();
        labelFromGet = new javax.swing.JLabel();
        labelSubjectGet = new javax.swing.JLabel();
        labelToGet = new javax.swing.JLabel();
        labelDateGet = new javax.swing.JLabel();

        setTitle("Message");
        setResizable(false);

        labelFrom.setText("From");

        labelSubject.setText("Subject");

        labelDate.setText("Date");

        buttonDelete.setText("Delete");
        buttonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteActionPerformed(evt);
            }
        });

        areaMsg.setColumns(20);
        areaMsg.setRows(5);
        jScrollPane1.setViewportView(areaMsg);
        areaMsg.setText(text);

        buttonReply.setText("Reply");
        buttonReply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonReplyActionPerformed(evt);
            }
        });

        labelTo.setText("To");

        labelFromGet.setText(from);

        labelSubjectGet.setText(subject);

        labelToGet.setText(to);

        labelDateGet.setText(date);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelSubject)
                            .addComponent(labelFrom)
                            .addComponent(labelTo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelFromGet)
                                    .addComponent(labelToGet))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 174, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(labelDate)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(labelDateGet)
                                        .addGap(72, 72, 72))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(buttonReply, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(buttonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelSubjectGet)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelFrom)
                        .addComponent(labelFromGet))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonDelete)
                        .addComponent(buttonReply)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSubject)
                    .addComponent(labelSubjectGet))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTo)
                    .addComponent(labelDate)
                    .addComponent(labelToGet)
                    .addComponent(labelDateGet))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonReplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonReplyActionPerformed
        if(from.equals("DEMAIL") == true){
            JOptionPane.showMessageDialog(rootPane, "You cannot reply for that message.");
        }
        else{
            NewMessage newm = new NewMessage(to, from.substring(0, from.indexOf("@")), "Re: " + subject);
            newm.setVisible(true);
        }
    }//GEN-LAST:event_buttonReplyActionPerformed

    private void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteActionPerformed
        Mail m = new Mail();
        m.deleteMessage(row);
        setVisible(false);
    }//GEN-LAST:event_buttonDeleteActionPerformed

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
            java.util.logging.Logger.getLogger(OpenMessage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OpenMessage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OpenMessage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OpenMessage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OpenMessage(from, to, date, text, subject, row).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaMsg;
    private javax.swing.JButton buttonDelete;
    private javax.swing.JButton buttonReply;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelDate;
    private javax.swing.JLabel labelDateGet;
    private javax.swing.JLabel labelFrom;
    private javax.swing.JLabel labelFromGet;
    private javax.swing.JLabel labelSubject;
    private javax.swing.JLabel labelSubjectGet;
    private javax.swing.JLabel labelTo;
    private javax.swing.JLabel labelToGet;
    // End of variables declaration//GEN-END:variables
}
