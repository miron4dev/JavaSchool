package com.mycompany.demailmavenbased;

import javax.swing.JOptionPane;
import javax.swing.JTable;

public class Mail extends javax.swing.JFrame {

    public Mail() {
        initComponents();
    }
    
    private final String[] arg = {};
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupTable = new javax.swing.JPopupMenu();
        menuOpenMsg = new javax.swing.JMenuItem();
        menuReply = new javax.swing.JMenuItem();
        menuSendTo = new javax.swing.JMenu();
        movetoSpam = new javax.swing.JMenuItem();
        menuDelete = new javax.swing.JMenuItem();
        popupFolders = new javax.swing.JPopupMenu();
        menuOpenFldr = new javax.swing.JMenuItem();
        menuNewFldr = new javax.swing.JMenuItem();
        menuDelFldr = new javax.swing.JMenuItem();
        scrollFolders = new javax.swing.JScrollPane();
        folders = new javax.swing.JTree();
        buttonMsg = new javax.swing.JButton();
        buttonCheck = new javax.swing.JButton();
        scrollTable = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        buttonLgt = new javax.swing.JButton();
        menuCommon = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        menuNew = new javax.swing.JMenu();
        menuNewMessage = new javax.swing.JMenuItem();
        menuNewFolder = new javax.swing.JMenuItem();
        menuCheck = new javax.swing.JMenuItem();
        menuLogout = new javax.swing.JMenuItem();
        menuQuit = new javax.swing.JMenuItem();
        menuHelp = new javax.swing.JMenu();
        menuAbout = new javax.swing.JMenuItem();

        menuOpenMsg.setText("Open message");
        popupTable.add(menuOpenMsg);

        menuReply.setText("Reply");
        popupTable.add(menuReply);

        menuSendTo.setText("Send to...");

        movetoSpam.setText("Spam");
        menuSendTo.add(movetoSpam);

        popupTable.add(menuSendTo);

        menuDelete.setText("Delete");
        popupTable.add(menuDelete);

        menuOpenFldr.setText("Open");
        popupFolders.add(menuOpenFldr);

        menuNewFldr.setText("New folder...");
        menuNewFldr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNewFldrActionPerformed(evt);
            }
        });
        popupFolders.add(menuNewFldr);

        menuDelFldr.setText("Delete");
        popupFolders.add(menuDelFldr);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("DE-Mail Client");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("UserMail");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("DE-Mail");
        javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Inbox");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Sent");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Drafts");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Spam");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Trash");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Folders");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Priority");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        folders.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        folders.setShowsRootHandles(false);
        folders.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                foldersMouseClicked(evt);
            }
        });
        scrollFolders.setViewportView(folders);
        for(int i=0;i<folders.getRowCount();i++)
        {
            folders.expandRow(i);
        }

        buttonMsg.setText("New message");
        buttonMsg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMsgActionPerformed(evt);
            }
        });

        buttonCheck.setText("Check mail");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Test message. Hello world!", "rustock@demail.com", "1994-10-18 23:59:06"}
            },
            new String [] {
                "Subject", "From", "Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        scrollTable.setViewportView(table);

        buttonLgt.setText("Logout");
        buttonLgt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLgtActionPerformed(evt);
            }
        });

        menuFile.setText("File");

        menuNew.setText("New");

        menuNewMessage.setText("Message...");
        menuNewMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNewMessageActionPerformed(evt);
            }
        });
        menuNew.add(menuNewMessage);

        menuNewFolder.setText("Folder...");
        menuNewFolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNewFolderActionPerformed(evt);
            }
        });
        menuNew.add(menuNewFolder);

        menuFile.add(menuNew);

        menuCheck.setText("Check mail");
        menuFile.add(menuCheck);

        menuLogout.setText("Logout");
        menuLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLogoutActionPerformed(evt);
            }
        });
        menuFile.add(menuLogout);

        menuQuit.setText("Quit");
        menuQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuQuitActionPerformed(evt);
            }
        });
        menuFile.add(menuQuit);

        menuCommon.add(menuFile);

        menuHelp.setText("Help");

        menuAbout.setText("About");
        menuAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAboutActionPerformed(evt);
            }
        });
        menuHelp.add(menuAbout);

        menuCommon.add(menuHelp);

        setJMenuBar(menuCommon);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(scrollFolders, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(scrollTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(buttonLgt, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonMsg)
                    .addComponent(buttonCheck)
                    .addComponent(buttonLgt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scrollFolders)
                    .addComponent(scrollTable, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonLgtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLgtActionPerformed
        setVisible(false);
        App.main(arg);
    }//GEN-LAST:event_buttonLgtActionPerformed

    private void buttonMsgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMsgActionPerformed
        NewMessage.main(arg);
    }//GEN-LAST:event_buttonMsgActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        if(evt.getButton() == java.awt.event.MouseEvent.BUTTON3)
        {
            JTable source = (JTable)evt.getSource();
            int row = source.rowAtPoint(evt.getPoint());
            int column = source.columnAtPoint( evt.getPoint() );
            if (!source.isRowSelected(row))
                source.changeSelection(row, column, false, false);

            popupTable.show(evt.getComponent(), evt.getX(), evt.getY());
        }
        if(evt.getClickCount() == 2)
        {
            JTable target = (JTable)evt.getSource();
            int row = target.getSelectedRow();
            JOptionPane.showMessageDialog(rootPane, "Double-click!");
        }
            
    }//GEN-LAST:event_tableMouseClicked

    private void foldersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_foldersMouseClicked
        if(evt.getButton() == java.awt.event.MouseEvent.BUTTON3)
        {
            int row = folders.getClosestRowForLocation(evt.getX(), evt.getY());
            folders.setSelectionRow(row);
            popupFolders.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_foldersMouseClicked

    private void menuAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAboutActionPerformed
        About.main(arg);
    }//GEN-LAST:event_menuAboutActionPerformed

    private void menuNewMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNewMessageActionPerformed
        NewMessage.main(arg);
    }//GEN-LAST:event_menuNewMessageActionPerformed

    private void menuLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLogoutActionPerformed
        setVisible(false);
        App.main(arg);
    }//GEN-LAST:event_menuLogoutActionPerformed

    private void menuQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuQuitActionPerformed
        DBConf.closeCon();
    }//GEN-LAST:event_menuQuitActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        DBConf.closeCon();
    }//GEN-LAST:event_formWindowClosing

    private void menuNewFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNewFolderActionPerformed
        NewFolder.main(arg);
    }//GEN-LAST:event_menuNewFolderActionPerformed

    private void menuNewFldrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNewFldrActionPerformed
        NewFolder.main(arg);
    }//GEN-LAST:event_menuNewFldrActionPerformed

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
            java.util.logging.Logger.getLogger(Mail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mail().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCheck;
    private javax.swing.JButton buttonLgt;
    private javax.swing.JButton buttonMsg;
    public static javax.swing.JTree folders;
    private javax.swing.JMenuItem menuAbout;
    private javax.swing.JMenuItem menuCheck;
    private javax.swing.JMenuBar menuCommon;
    private javax.swing.JMenuItem menuDelFldr;
    private javax.swing.JMenuItem menuDelete;
    private javax.swing.JMenu menuFile;
    private javax.swing.JMenu menuHelp;
    private javax.swing.JMenuItem menuLogout;
    private javax.swing.JMenu menuNew;
    private javax.swing.JMenuItem menuNewFldr;
    private javax.swing.JMenuItem menuNewFolder;
    private javax.swing.JMenuItem menuNewMessage;
    private javax.swing.JMenuItem menuOpenFldr;
    private javax.swing.JMenuItem menuOpenMsg;
    private javax.swing.JMenuItem menuQuit;
    private javax.swing.JMenuItem menuReply;
    private javax.swing.JMenu menuSendTo;
    private javax.swing.JMenuItem movetoSpam;
    private javax.swing.JPopupMenu popupFolders;
    private javax.swing.JPopupMenu popupTable;
    private javax.swing.JScrollPane scrollFolders;
    private javax.swing.JScrollPane scrollTable;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
