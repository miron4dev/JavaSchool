package com.tsystems.demail.client;

import com.tsystems.demail.client.Profile.MailChooser;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;

public class Mail extends javax.swing.JFrame {

    private final String[] arg = {};
    private static String username;
    private static List list;
    private static Object[][] forTable;
    private static Object[][] messages;
    
    public Mail(String username, List list, Object[][] forTable, Object[][] messages) {
        Mail.username = username;
        Mail.list = list;
        Mail.forTable = forTable;
        Mail.messages = messages;
        initComponents();
    }

    public static void setList(List aList) {
        list = aList;
    }
    
    public static List getList() {
        return list;
    }
    
    public static void setMessages(Object[][] aMessages) {
        messages = aMessages;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupTable = new javax.swing.JPopupMenu();
        menuOpenMsg = new javax.swing.JMenuItem();
        menuMoveTo = new javax.swing.JMenuItem();
        menuDelete = new javax.swing.JMenuItem();
        popupFolders = new javax.swing.JPopupMenu();
        menuOpenFldr = new javax.swing.JMenuItem();
        menuNewFldr = new javax.swing.JMenuItem();
        menuRenFldr = new javax.swing.JMenuItem();
        menuDelFldr = new javax.swing.JMenuItem();
        scrollFolders = new javax.swing.JScrollPane();
        folders = new javax.swing.JTree();
        buttonMsg = new javax.swing.JButton();
        scroll = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        buttonLgt = new javax.swing.JButton();
        buttonQuit = new javax.swing.JButton();
        menuCommon = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        menuNew = new javax.swing.JMenu();
        menuNewMessage = new javax.swing.JMenuItem();
        menuNewFolder = new javax.swing.JMenuItem();
        menuLogout = new javax.swing.JMenuItem();
        menuQuit = new javax.swing.JMenuItem();
        menuHelp = new javax.swing.JMenu();
        menuAbout = new javax.swing.JMenuItem();

        menuOpenMsg.setText("Open message");
        menuOpenMsg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuOpenMsgActionPerformed(evt);
            }
        });
        popupTable.add(menuOpenMsg);

        menuMoveTo.setText("Move to...");
        menuMoveTo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuMoveToActionPerformed(evt);
            }
        });
        popupTable.add(menuMoveTo);

        menuDelete.setText("Delete");
        menuDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDeleteActionPerformed(evt);
            }
        });
        popupTable.add(menuDelete);

        menuOpenFldr.setText("Open");
        menuOpenFldr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuOpenFldrActionPerformed(evt);
            }
        });
        popupFolders.add(menuOpenFldr);

        menuNewFldr.setText("New folder...");
        menuNewFldr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNewFldrActionPerformed(evt);
            }
        });
        popupFolders.add(menuNewFldr);

        menuRenFldr.setText("Rename...");
        menuRenFldr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRenFldrActionPerformed(evt);
            }
        });
        popupFolders.add(menuRenFldr);

        menuDelFldr.setText("Delete");
        menuDelFldr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDelFldrActionPerformed(evt);
            }
        });
        popupFolders.add(menuDelFldr);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DE-Mail Client");
        setResizable(false);

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
        folders.setShowsRootHandles(true);
        folders.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                foldersMouseClicked(evt);
            }
        });
        scrollFolders.setViewportView(folders);
        if(list != null)
        setFolderList();
        for(int i=0;i<folders.getRowCount();i++){
            folders.expandRow(i);
        }

        buttonMsg.setText("New message");
        buttonMsg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMsgActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            forTable,
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
        scroll.setViewportView(table);

        buttonLgt.setText("Logout");
        buttonLgt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLgtActionPerformed(evt);
            }
        });

        buttonQuit.setText("Quit");
        buttonQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonQuitActionPerformed(evt);
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
                        .addComponent(scrollFolders, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonLgt, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonQuit, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonMsg)
                    .addComponent(buttonLgt)
                    .addComponent(buttonQuit))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scrollFolders)
                    .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonLgtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLgtActionPerformed
        setVisible(false);
        MailChooser.main(arg);
    }//GEN-LAST:event_buttonLgtActionPerformed

    private void buttonMsgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMsgActionPerformed
        NewMessage newm = new NewMessage(username, "", "");
        newm.setVisible(true);
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
            OpenMessage open = new OpenMessage(messages[row][1].toString(), messages[row][3].toString(), messages[row][2].toString(), messages[row][4].toString(), messages[row][0].toString(), row);
            open.setVisible(true);
        }
            
    }//GEN-LAST:event_tableMouseClicked

    private void foldersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_foldersMouseClicked
        if(evt.getButton() == java.awt.event.MouseEvent.BUTTON3)
        {
            int row = folders.getClosestRowForLocation(evt.getX(), evt.getY());
            folders.setSelectionRow(row);
            popupFolders.show(evt.getComponent(), evt.getX(), evt.getY());
        }
        else if(evt.getButton() != java.awt.event.MouseEvent.BUTTON3 && evt.getClickCount() == 1)
        {
            popupFolders.setVisible(false);
        }
        else if(evt.getClickCount() == 2)
        {
            TreePath path = folders.getSelectionPath();
            String foldername = path.getLastPathComponent().toString();
            openFolder(foldername);
        }
    }//GEN-LAST:event_foldersMouseClicked

    private void menuAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAboutActionPerformed
        About.main(arg);
    }//GEN-LAST:event_menuAboutActionPerformed

    private void menuNewMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNewMessageActionPerformed
        NewMessage newm = new NewMessage(username, "", "");
        newm.setVisible(true);
    }//GEN-LAST:event_menuNewMessageActionPerformed

    private void menuLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLogoutActionPerformed
        setVisible(false);
        MailChooser.main(arg);
    }//GEN-LAST:event_menuLogoutActionPerformed

    private void menuQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuQuitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuQuitActionPerformed

    private void menuNewFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNewFolderActionPerformed
        NewFolder.setUsername(username);
        NewFolder.main(arg);
    }//GEN-LAST:event_menuNewFolderActionPerformed

    private void menuNewFldrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNewFldrActionPerformed
        NewFolder.setUsername(username);
        NewFolder.main(arg);
    }//GEN-LAST:event_menuNewFldrActionPerformed

    private void menuRenFldrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRenFldrActionPerformed
        try
        {
            TreePath path = folders.getSelectionPath();
            if(path != null)
            {
                MutableTreeNode node =(MutableTreeNode) path.getLastPathComponent();
                String foldername = path.getLastPathComponent().toString();
                MutableTreeNode parent=(MutableTreeNode)node.getParent();
                if(Validator.permitActionChecking(node.toString()) == false)
                {
                    throw new NullPointerException();
                }
                if(Validator.systemFolderChecking(node.toString()) == true)
                {
                    return ;
                }
                RenameFolder.setCurrentFolderName(foldername);
                RenameFolder.setUsername(username);
                RenameFolder.setActionFields(node);
                RenameFolder.main(arg);
            }
        }
        catch(NullPointerException ex)
        {
            JOptionPane.showMessageDialog(rootPane, "You cannot rename the system folder.");
        }
    }//GEN-LAST:event_menuRenFldrActionPerformed

    private void menuDelFldrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDelFldrActionPerformed
        try
        {
            TreePath path = folders.getSelectionPath();
            if(path != null)
            {
                MutableTreeNode node =(MutableTreeNode) path.getLastPathComponent();
                String foldername = path.getLastPathComponent().toString();
                MutableTreeNode parent=(MutableTreeNode)node.getParent();
                if(Validator.permitActionChecking(node.toString()) == false)
                {
                    throw new NullPointerException();
                }
                if(Validator.systemFolderChecking(node.toString()) == true)
                {
                    return ;
                }
                ConfirmDelete.setUsername(username);
                ConfirmDelete.setFoldername(foldername);
                ConfirmDelete.setActionFields(node, parent);
                ConfirmDelete.main(arg);
            }
        }
        catch(NullPointerException ex){
            JOptionPane.showMessageDialog(rootPane, "You cannot delete the system folder.");
        }
    }//GEN-LAST:event_menuDelFldrActionPerformed

    private void menuOpenFldrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuOpenFldrActionPerformed
        TreePath path = folders.getSelectionPath();
        String foldername = path.getLastPathComponent().toString();
        openFolder(foldername);
    }//GEN-LAST:event_menuOpenFldrActionPerformed

    private void menuOpenMsgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuOpenMsgActionPerformed
        int row = table.getSelectedRow();
        OpenMessage open = new OpenMessage(messages[row][1].toString(), messages[row][3].toString(), messages[row][2].toString(), messages[row][4].toString(), messages[row][0].toString(), row);
        open.setVisible(true);
    }//GEN-LAST:event_menuOpenMsgActionPerformed

    private void menuDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDeleteActionPerformed
        deleteMessage(table.getSelectedRow());
    }//GEN-LAST:event_menuDeleteActionPerformed

    private void menuMoveToActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuMoveToActionPerformed
        int row = table.getSelectedRow();
        String[] folds = new String[list.size()+6];
        folds[0] = "Inbox";
        folds[1] = "Sents";
        folds[2] = "Drafts";
        folds[3] = "Spam";
        folds[4] = "Trash";
        folds[5] = "Priority";
        for(int i = 6; i < list.size()+6; i++)
            folds[i] = list.get(i-6).toString();
        MoveTo move = new MoveTo(folds, row, table, messages[row][5].toString());
        move.setVisible(true);
    }//GEN-LAST:event_menuMoveToActionPerformed

    private void buttonQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonQuitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_buttonQuitActionPerformed

    public static void deleteMessage(int row){
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        model.removeRow(row);
        table.setModel(model);
        Properties p = new Properties();
        p.setProperty("KEY", "DEL_MESSAGE");
        p.setProperty("ID", messages[row][5].toString());
        Client.sendAction(p);
    }
    
    public final void setFolderList(){
        DefaultTreeModel model = (DefaultTreeModel) folders.getModel();
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
        DefaultMutableTreeNode folder = (DefaultMutableTreeNode) model.getChild(root, root.getChildCount() - 1);
        for(int i = 0; i < list.size(); i++)
            folder.add(new DefaultMutableTreeNode(list.get(i)));
        
        model.reload(root);
    }
    
    public static Object[][] getForTableList(String username, String foldername) throws IOException, ClassNotFoundException
    {
            Object[][] arrayOfMessages = getMessagesList(username, foldername);
            Object[][] forTable1 = new Object[arrayOfMessages.length][3];
            for(int i = 0; i < arrayOfMessages.length; i++){
                for(int j = 0; j < 3; j++){
                    forTable1[i][j] = arrayOfMessages[i][j].toString();
                }
            }
            return forTable1;
    }
    
    public static Object[][] getMessagesList(String username, String foldername) throws IOException, ClassNotFoundException
    {
            Properties p2 = new Properties();
            p2.setProperty("KEY", "GET_MESSAGES");
            p2.setProperty("USERNAME", username);
            p2.setProperty("FOLDERNAME", foldername);
            List<Object[]> messages1 = Client.getList(p2);
            Object[][] arrayOfMessages = new Object[messages1.size()][];
            arrayOfMessages=messages1.toArray(arrayOfMessages);
            
            return arrayOfMessages;
    }
    
    private static void openFolder(String foldername){
        try {
            table.setModel(new javax.swing.table.DefaultTableModel(
                    getForTableList(username, foldername),
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
                setMessages(getMessagesList(username, foldername));
        } catch (IOException ex) {
            Logger.getLogger(Mail.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Mail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
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
                new Mail(username, getList(), forTable, messages).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonLgt;
    private javax.swing.JButton buttonMsg;
    private javax.swing.JButton buttonQuit;
    public static javax.swing.JTree folders;
    private javax.swing.JMenuItem menuAbout;
    private javax.swing.JMenuBar menuCommon;
    private javax.swing.JMenuItem menuDelFldr;
    private javax.swing.JMenuItem menuDelete;
    private javax.swing.JMenu menuFile;
    private javax.swing.JMenu menuHelp;
    private javax.swing.JMenuItem menuLogout;
    private javax.swing.JMenuItem menuMoveTo;
    private javax.swing.JMenu menuNew;
    private javax.swing.JMenuItem menuNewFldr;
    private javax.swing.JMenuItem menuNewFolder;
    private javax.swing.JMenuItem menuNewMessage;
    private javax.swing.JMenuItem menuOpenFldr;
    private javax.swing.JMenuItem menuOpenMsg;
    private javax.swing.JMenuItem menuQuit;
    private javax.swing.JMenuItem menuRenFldr;
    private javax.swing.JPopupMenu popupFolders;
    private javax.swing.JPopupMenu popupTable;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JScrollPane scrollFolders;
    private static javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
