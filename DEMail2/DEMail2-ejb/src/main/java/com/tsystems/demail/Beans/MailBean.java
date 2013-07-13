package com.tsystems.demail.Beans;

import org.primefaces.model.TreeNode;

import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class MailBean implements Serializable{

    private List messageList;
    private List<MessageBean> messages;
    private List folderList;
    private List fullFolderList;
    private String currentFolder;
    private String temp;
    private String temp2;
    private String temp3;
    private MessageBean selectedMail;
    private TreeNode selectedFolder;
    private String selectedFolderName;
    private UIComponent buttonAction;

    public String getCurrentFolder() {
        return currentFolder;
    }

    public void setCurrentFolder(String currentFolder) {
        this.currentFolder = currentFolder;
    }

    public List getMessageList() {
        return messageList;
    }

    public void setMessageList(List messageList) {
        this.messageList = messageList;
    }

    public List getFolderList() {
        return folderList;
    }

    public void setFolderList(List folderList) {
        this.folderList = folderList;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public List getFullFolderList() {
        return fullFolderList;
    }

    public void setFullFolderList(List fullFolderList) {
        this.fullFolderList = fullFolderList;
    }

    public MessageBean getSelectedMail() {
        return selectedMail;
    }

    public void setSelectedMail(MessageBean selectedMail) {
        this.selectedMail = selectedMail;
    }

    public List<MessageBean> getMessages() {
        return messages;
    }

    public void setMessages(List<MessageBean> messages) {
        this.messages = messages;
    }

    public TreeNode getSelectedFolder() {
        return selectedFolder;
    }

    public void setSelectedFolder(TreeNode selectedFolder) {
        this.selectedFolder = selectedFolder;
    }

    public String getSelectedFolderName() {
        return selectedFolderName;
    }

    public void setSelectedFolderName(String selectedFolderName) {
        this.selectedFolderName = selectedFolderName;
    }

    public UIComponent getButtonAction() {
        return buttonAction;
    }

    public void setButtonAction(UIComponent buttonAction) {
        this.buttonAction = buttonAction;
    }

    public String getTemp2() {
        return temp2;
    }

    public void setTemp2(String temp2) {
        this.temp2 = temp2;
    }

    public String getTemp3() {
        return temp3;
    }

    public void setTemp3(String temp3) {
        this.temp3 = temp3;
    }
}
