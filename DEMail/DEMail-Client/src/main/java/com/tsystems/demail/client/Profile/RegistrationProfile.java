package com.tsystems.demail.client.Profile;

import com.tsystems.demail.client.App;
import com.tsystems.demail.client.Client;
import com.tsystems.demail.client.Validator;
import java.io.IOException;
import java.sql.Date;
import java.util.Properties;
import javax.swing.JOptionPane;

public class RegistrationProfile extends javax.swing.JFrame {

    public RegistrationProfile() {
        initComponents();
    }
    private boolean clickBox = false;
    private final String[] arg = {};

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonSbmt = new javax.swing.JButton();
        buttonClr = new javax.swing.JButton();
        buttonCncl = new javax.swing.JButton();
        checkAgr = new javax.swing.JCheckBox();
        fieldFName = new javax.swing.JTextField();
        fieldLName = new javax.swing.JTextField();
        labelFName = new javax.swing.JLabel();
        labelLName = new javax.swing.JLabel();
        labelPass = new javax.swing.JLabel();
        labelRTPass = new javax.swing.JLabel();
        fieldPass = new javax.swing.JPasswordField();
        fieldRTPass = new javax.swing.JPasswordField();
        labelBDay = new javax.swing.JLabel();
        labelPhone = new javax.swing.JLabel();
        boxMonths = new javax.swing.JComboBox();
        fieldPhone = new javax.swing.JTextField();
        field7 = new javax.swing.JTextField();
        boxDays = new javax.swing.JComboBox();
        boxYears = new javax.swing.JComboBox();
        labelUName = new javax.swing.JLabel();
        fieldUName = new javax.swing.JTextField();
        fieldDEMail = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Registration");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        buttonSbmt.setText("Submit");
        buttonSbmt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSbmtActionPerformed(evt);
            }
        });

        buttonClr.setText("Clear");
        buttonClr.setPreferredSize(new java.awt.Dimension(55, 27));
        buttonClr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClrActionPerformed(evt);
            }
        });

        buttonCncl.setText("Cancel");
        buttonCncl.setPreferredSize(new java.awt.Dimension(55, 27));
        buttonCncl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCnclActionPerformed(evt);
            }
        });

        checkAgr.setText("I accept the registration agreement");
        checkAgr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkAgrActionPerformed(evt);
            }
        });

        labelFName.setText("First Name:");

        labelLName.setText("Last Name:");

        labelPass.setText("Password:");

        labelRTPass.setText("Retype password:");

        labelBDay.setText("Birthday:");

        labelPhone.setText("Mobile phone:");

        boxMonths.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "Noveber", "December" }));
        boxMonths.setToolTipText("");

        field7.setEditable(false);
        field7.setText("+7");
        field7.setEnabled(false);

        boxDays.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        boxYears.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951", "1950", "1949", "1948", "1947", "1946", "1945", "1944", "1943", "1942", "1941", "1940", "1939", "1938", "1937", "1936", "1935", "1934", "1933", "1932", "1931", "1930", "1929", "1928", "1927", "1926", "1925", "1924", "1923", "1922", "1921", "1920", "1919", "1918", "1917", "1916", "1915", "1914", "1913", "1912", "1911", "1910", "1909", "1908", "1907", "1906", "1905", "1904", "1903", "1902", "1901", "1900" }));

        labelUName.setText("Username:");

        fieldDEMail.setEditable(false);
        fieldDEMail.setText("@demail.com");
        fieldDEMail.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(buttonSbmt, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttonClr, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(buttonCncl, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(checkAgr))
                        .addGap(60, 60, 60))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelLName)
                                    .addComponent(labelFName)
                                    .addComponent(labelUName)
                                    .addComponent(labelPhone))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(fieldPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(fieldFName, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(fieldLName)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(fieldUName)
                                                .addGap(1, 1, 1)
                                                .addComponent(fieldDEMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelRTPass)
                                    .addComponent(labelBDay)
                                    .addComponent(labelPass))
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(field7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(fieldRTPass)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(boxMonths, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(boxDays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(boxYears, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(fieldPass))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldFName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelFName))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldLName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelLName))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelUName)
                    .addComponent(fieldUName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldDEMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelPhone)
                    .addComponent(field7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPass)
                    .addComponent(fieldPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelRTPass)
                    .addComponent(fieldRTPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelBDay)
                    .addComponent(boxMonths, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxDays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxYears, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkAgr)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonSbmt)
                    .addComponent(buttonClr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonCncl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void checkAgrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkAgrActionPerformed
        clickBox = !clickBox;
    }//GEN-LAST:event_checkAgrActionPerformed

    private void buttonClrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClrActionPerformed
        fieldFName.setText("");
        fieldLName.setText("");
        fieldPass.setText("");
        fieldUName.setText("");
        fieldRTPass.setText("");
        fieldPhone.setText("");
    }//GEN-LAST:event_buttonClrActionPerformed

    private void buttonCnclActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCnclActionPerformed
        setVisible(false);
        App.main(arg);
    }//GEN-LAST:event_buttonCnclActionPerformed

    private void buttonSbmtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSbmtActionPerformed
        String firstname, lastname, username, password, rtpassword, phone;
        boolean nameCheck = false, userCheck = false, passCheck = false, rtpassCheck = false,
                phoneCheck = false;
        Date birthday;

        firstname = fieldFName.getText();
        lastname = fieldLName.getText();
        username = fieldUName.getText();
        password = fieldPass.getText();
        rtpassword = fieldRTPass.getText();
        phone = "+7" + fieldPhone.getText();
        birthday = new Date(2013 - boxYears.getSelectedIndex() - 1900, boxMonths.getSelectedIndex(), boxDays.getSelectedIndex() + 1);
        String nameAlert = "";
        String userAlert = "";
        String passAlert = "";
        String rtpasswordAlert = "";
        String phoneAlert = "";
        String agreementAlert = "";
        userCheck = Validator.userNameChecking(username);
        nameCheck = Validator.nameChecking(firstname) && Validator.nameChecking(lastname);
        phoneCheck = Validator.phoneChecking(phone);
        if (password.length() > 6) {
            passCheck = true;
        }
        if (password.equals(rtpassword)) {
            rtpassCheck = true;
        }
        if ((nameCheck && userCheck && passCheck && rtpassCheck && phoneCheck && clickBox) == false) {
            if (nameCheck == false) {
                nameAlert = "Firstname and lastname must contain only characters and can not be null.\n";
            }
            if (userCheck == false){
                userAlert = "Username must be between 6 and 30 characters and contain only letters (a-z) and numbers.\n";
            }
            if (passCheck == false) {
                passAlert = "Password must be at least 6 characters.\n";
            }
            if (rtpassCheck == false) {
                rtpasswordAlert = "Passwords don't match.\n";
            }
            if (phoneCheck == false) {
                phoneAlert = "Phone number format is not recognized.\n";
            }
            if (clickBox == false) {
                agreementAlert = "You are not agree with the registration agreement.\n";
            }
            JOptionPane.showMessageDialog(rootPane, nameAlert + userAlert + passAlert
                    + rtpasswordAlert + phoneAlert + agreementAlert);
        } else {
            Properties data = new Properties();
            data.setProperty("KEY", "REG_PROFILE");
            data.setProperty("USERNAME", username + "@demail.com");
            data.setProperty("PASSWORD", password);
            data.setProperty("FIRSTNAME", firstname);
            data.setProperty("LASTNAME", lastname);
            data.setProperty("PHONE", phone);
            data.setProperty("BIRTHDAY", birthday.toString());
            try {           
                if (Client.getAnswer(data) == true) {
                    JOptionPane.showMessageDialog(rootPane, "Registration was successful. \nNow you can login to your profile.");
                    setVisible(false);
                    App.main(arg);
                } else {
                    JOptionPane.showMessageDialog(rootPane, "User with that name or phone is already registered.");
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_buttonSbmtActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        setVisible(false);
        App.main(arg);
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(RegistrationProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrationProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrationProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrationProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrationProfile().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox boxDays;
    private javax.swing.JComboBox boxMonths;
    private javax.swing.JComboBox boxYears;
    private javax.swing.JButton buttonClr;
    private javax.swing.JButton buttonCncl;
    private javax.swing.JButton buttonSbmt;
    private javax.swing.JCheckBox checkAgr;
    private javax.swing.JTextField field7;
    private javax.swing.JTextField fieldDEMail;
    private javax.swing.JTextField fieldFName;
    private javax.swing.JTextField fieldLName;
    private javax.swing.JPasswordField fieldPass;
    private javax.swing.JTextField fieldPhone;
    private javax.swing.JPasswordField fieldRTPass;
    private javax.swing.JTextField fieldUName;
    private javax.swing.JLabel labelBDay;
    private javax.swing.JLabel labelFName;
    private javax.swing.JLabel labelLName;
    private javax.swing.JLabel labelPass;
    private javax.swing.JLabel labelPhone;
    private javax.swing.JLabel labelRTPass;
    private javax.swing.JLabel labelUName;
    // End of variables declaration//GEN-END:variables
}
