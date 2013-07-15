package com.tsystems.demail.ValueObjects;

import com.tsystems.demail.Beans.MailBean;
import com.tsystems.demail.Beans.MessageBean;
import com.tsystems.demail.Constants.Localization;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class Mailbox {

    private TreeNode mailboxes;

    @Inject
    private MailBean mailBean;

    @PostConstruct
    public void init() {
        Localization pp = new Localization();

        mailboxes = new DefaultTreeNode("root", null);
        TreeNode inbox = new DefaultTreeNode("i", pp.INBOX , mailboxes);
        TreeNode sent = new DefaultTreeNode("s", pp.SENT, mailboxes);
        TreeNode drafts = new DefaultTreeNode("d", pp.DRAFTS, mailboxes);
        TreeNode trash = new DefaultTreeNode("t", pp.TRASH, mailboxes);
        TreeNode spam = new DefaultTreeNode("sp", pp.SPAM, mailboxes);
        TreeNode folders = new DefaultTreeNode("f", pp.USERFOLDER, mailboxes);

        mailBean.setSelectedFolder(inbox);
        List folderList = mailBean.getFolderList();
        if(folderList.size() > 0){
            TreeNode[] test = new TreeNode[folderList.size()];
            for(int i = 0; i < folderList.size(); i++)
                test[i] = new DefaultTreeNode(folderList.get(i), folders);
            mailBean.setCurrentFolder(folderList.get(0).toString());
        }
        else mailBean.setCurrentFolder("");
        List<MessageBean> messages = new ArrayList<MessageBean>();
        List<Object[]> messageList = mailBean.getMessageList();
        if(messageList.size() > 0)
        {
            Object[][] arrayOfMessages = new Object[messageList.size()][];
            arrayOfMessages=messageList.toArray(arrayOfMessages);
            for(int i = 0; i < messageList.size(); i++){
                messages.add(new MessageBean(arrayOfMessages[i][0].toString(), arrayOfMessages[i][1].toString(),
                        arrayOfMessages[i][2].toString(), arrayOfMessages[i][3].toString(), (Date)arrayOfMessages[i][4], arrayOfMessages[i][5].toString()));
            }
        }
        mailBean.setMessages(messages);
    }

    public TreeNode getMailboxes() {
        return mailboxes;
    }
}
