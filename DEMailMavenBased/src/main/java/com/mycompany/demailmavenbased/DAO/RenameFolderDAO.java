package com.mycompany.demailmavenbased.DAO;

import com.mycompany.demailmavenbased.Mail;
import com.mycompany.demailmavenbased.Validator;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;

public class RenameFolderDAO 
{
    public static boolean rename(String name, MutableTreeNode folderName, Component rootPane, DefaultTreeModel model,   DefaultMutableTreeNode root, DefaultMutableTreeNode folder)
    {
        if(Validator.folderExistenceChecking(folder, name) == true)
        {
            JOptionPane.showMessageDialog(rootPane, "That folder is already exists.");
            return false;
        }
        if(Validator.permitActionChecking(name) == false || Validator.systemFolderChecking(name))
        {
            JOptionPane.showMessageDialog(rootPane, "You cannot rename folders to system folder names.");
            return false;
        }
        if(name.length() > 0)
        {
            folderName.setUserObject(new DefaultMutableTreeNode(name));
            model.reload(root);
            for(int i=0;i<Mail.folders.getRowCount();i++)  
            {  
                Mail.folders.expandRow(i);  
            }
            return true;
        }
        else{
            JOptionPane.showMessageDialog(rootPane, "Folder name cannot be null.");
            return false;
        }
    }
}
