package com.mycompany.demailmavenbased.DAO;

import com.mycompany.demailmavenbased.Mail;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;

public class DeleteFolderDAO 
{
    public static void folderRemove(MutableTreeNode node, MutableTreeNode parent)
    {
        int index=parent.getIndex(node);
        parent.remove(node);
        DefaultTreeModel model=(DefaultTreeModel)Mail.folders.getModel();
        model.nodesWereRemoved(parent,new int[]{index},null);
    }

}
