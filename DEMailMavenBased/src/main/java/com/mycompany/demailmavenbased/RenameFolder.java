package com.mycompany.demailmavenbased;

import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;

public class RenameFolder extends javax.swing.JFrame {

    public RenameFolder() {
        initComponents();
    }

    private static MutableTreeNode folderName = null;
    public static void setActionFields(MutableTreeNode folderName)
    {
        RenameFolder.folderName = folderName;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonRename = new javax.swing.JButton();
        fieldName = new javax.swing.JTextField();
        labelName = new javax.swing.JLabel();
        buttonCancel = new javax.swing.JButton();

        setTitle("Rename Folder");
        setPreferredSize(new java.awt.Dimension(230, 118));
        setResizable(false);

        buttonRename.setText("Rename");
        buttonRename.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRenameActionPerformed(evt);
            }
        });

        labelName.setText("New Folder Name:");

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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(fieldName)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonRename, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                        .addComponent(buttonCancel)
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
                    .addComponent(buttonRename)
                    .addComponent(buttonCancel))
                .addGap(5, 5, 5))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonRenameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRenameActionPerformed
        String name = fieldName.getText();
        DefaultTreeModel model = (DefaultTreeModel)Mail.folders.getModel();
        DefaultMutableTreeNode root = (DefaultMutableTreeNode)model.getRoot();
        DefaultMutableTreeNode folder = (DefaultMutableTreeNode)model.getChild(root, root.getChildCount()-1);
        if(Validator.folderExistenceChecking(folder, name) == true)
        {
            JOptionPane.showMessageDialog(rootPane, "That folder is already exists.");
            return;
        }
        if(Validator.permitActionChecking(name) == false || Validator.systemFolderChecking(name))
        {
            JOptionPane.showMessageDialog(rootPane, "You cannot rename folders to system folder names.");
            return;
        }
        if(name.length() > 0)
        {
            folderName.setUserObject(new DefaultMutableTreeNode(name));
            model.reload(root);
            for(int i=0;i<Mail.folders.getRowCount();i++)  
            {  
                Mail.folders.expandRow(i);  
            }
        }
        else JOptionPane.showMessageDialog(rootPane, "Folder name cannot be null.");  
        setVisible(false);
    }//GEN-LAST:event_buttonRenameActionPerformed

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
            java.util.logging.Logger.getLogger(RenameFolder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RenameFolder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RenameFolder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RenameFolder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RenameFolder().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonRename;
    private javax.swing.JTextField fieldName;
    private javax.swing.JLabel labelName;
    // End of variables declaration//GEN-END:variables
}
