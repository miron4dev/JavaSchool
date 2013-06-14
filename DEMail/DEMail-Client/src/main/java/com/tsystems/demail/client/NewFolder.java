package com.tsystems.demail.client;

import java.util.List;
import java.util.Properties;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class NewFolder extends javax.swing.JFrame {

    private static String username;

    public static void setUsername(String aUsername) {
        username = aUsername;
    }
    
    public NewFolder() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelName = new javax.swing.JLabel();
        fieldName = new javax.swing.JTextField();
        buttonCrt = new javax.swing.JButton();
        buttonCncl = new javax.swing.JButton();

        setTitle("New Folder");
        setResizable(false);

        labelName.setText("Name:");

        buttonCrt.setText("Create folder");
        buttonCrt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCrtActionPerformed(evt);
            }
        });

        buttonCncl.setText("Cancel");
        buttonCncl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCnclActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(fieldName)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonCrt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                        .addComponent(buttonCncl)
                        .addGap(27, 27, 27))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelName)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCrt)
                    .addComponent(buttonCncl))
                .addGap(5, 5, 5))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCnclActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCnclActionPerformed
        setVisible(false);
    }//GEN-LAST:event_buttonCnclActionPerformed

    private void buttonCrtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCrtActionPerformed
        String name = fieldName.getText();
        if (name.length() > 0) {
            DefaultTreeModel model = (DefaultTreeModel) Mail.folders.getModel();
            DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
            DefaultMutableTreeNode folder = (DefaultMutableTreeNode) model.getChild(root, root.getChildCount() - 1);
            if (Validator.folderExistenceChecking(folder, name) == true) {
                JOptionPane.showMessageDialog(rootPane, "This folder is already exists.");
                return;
            }
            if (Validator.permitActionChecking(name) == false || Validator.systemFolderChecking(name)) {
                JOptionPane.showMessageDialog(rootPane, "You cannot create folders with system folder names.");
                return;
            }
            Properties p = new Properties();
            p.setProperty("KEY", "NEW_FOLDER");
            p.setProperty("USERNAME", username);
            p.setProperty("FOLDERNAME", name);
            Client.sendAction(p);
            List list = Mail.getList();
            list.add(name);
            Mail.setList(list);
            folder.add(new DefaultMutableTreeNode(name));
            model.reload(root);
            for (int i = 0; i < Mail.folders.getRowCount(); i++) {
                Mail.folders.expandRow(i);
            }
            setVisible(false);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Folder name cannot be null.");
        }
    }//GEN-LAST:event_buttonCrtActionPerformed

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
            java.util.logging.Logger.getLogger(NewFolder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewFolder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewFolder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewFolder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewFolder().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCncl;
    private javax.swing.JButton buttonCrt;
    private javax.swing.JTextField fieldName;
    private javax.swing.JLabel labelName;
    // End of variables declaration//GEN-END:variables
}
