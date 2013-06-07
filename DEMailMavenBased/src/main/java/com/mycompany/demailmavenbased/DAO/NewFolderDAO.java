package com.mycompany.demailmavenbased.DAO;

import com.mycompany.demailmavenbased.Mail;
import com.mycompany.demailmavenbased.Validator;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class NewFolderDAO {

    public static boolean create(String name, Component rootPane) {
        DefaultTreeModel model = (DefaultTreeModel) Mail.folders.getModel();
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
        DefaultMutableTreeNode folder = (DefaultMutableTreeNode) model.getChild(root, root.getChildCount() - 1);
        if (Validator.folderExistenceChecking(folder, name) == true) {
            JOptionPane.showMessageDialog(rootPane, "This folder is already exists.");
            return false;
        }
        if (Validator.permitActionChecking(name) == false || Validator.systemFolderChecking(name)) {
            JOptionPane.showMessageDialog(rootPane, "You cannot create folders with system folder names.");
            return false;
        }
        folder.add(new DefaultMutableTreeNode(name));
        model.reload(root);
        for (int i = 0; i < Mail.folders.getRowCount(); i++) {
            Mail.folders.expandRow(i);
        }
        return true;
    }
}
