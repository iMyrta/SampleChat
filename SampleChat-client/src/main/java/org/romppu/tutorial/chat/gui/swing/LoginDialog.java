/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.romppu.tutorial.chat.gui.swing;

import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.beansbinding.ELProperty;
import org.romppu.tutorial.chat.ExceptionHandler;
import org.romppu.tutorial.chat.SampleChatApplication;
import org.romppu.tutorial.chat.common.SampleChatException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

/**
 *
 * @author roman
 */
public class LoginDialog extends javax.swing.JDialog {

    boolean cancelPressed;
    
    /**
     * Creates new form LoginDialog
     */
    protected LoginDialog() {
        setModal(true);
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        setSize(400, 220);
        setLocationRelativeTo(null);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        ResourceBundle bundle = ResourceBundle.getBundle("org.romppu.tutorial.chat.gui.swing.LoginDialogBundle");
        jPanel5 = new JPanel();
        jPanel4 = new JPanel();
        uidPanel = new JPanel();
        jLabel1 = new JLabel();
        uidField = new JTextField();
        pwdPanel = new JPanel();
        jLabel2 = new JLabel();
        jPasswordField1 = new JPasswordField();
        jLabel3 = new JLabel();
        jPanel6 = new JPanel();
        jPanel1 = new JPanel();
        cancelButton = new JButton();
        loginButton = new JButton();
        loginBean = new LoginBean();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(bundle.getString("LoginDialog.this.title"));
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== jPanel5 ========
        {
            jPanel5.setBorder(new EmptyBorder(20, 20, 20, 20));
            jPanel5.setLayout(new BorderLayout(10, 10));

            //======== jPanel4 ========
            {
                jPanel4.setLayout(new GridLayout(2, 0, 10, 10));

                //======== uidPanel ========
                {
                    uidPanel.setLayout(new BorderLayout(10, 0));

                    //---- jLabel1 ----
                    jLabel1.setText(bundle.getString("LoginDialog.jLabel1.text"));
                    jLabel1.setPreferredSize(new Dimension(100, 14));
                    uidPanel.add(jLabel1, BorderLayout.WEST);
                    uidPanel.add(uidField, BorderLayout.CENTER);
                }
                jPanel4.add(uidPanel);

                //======== pwdPanel ========
                {
                    pwdPanel.setLayout(new BorderLayout(10, 0));

                    //---- jLabel2 ----
                    jLabel2.setText(bundle.getString("LoginDialog.jLabel2.text"));
                    jLabel2.setPreferredSize(new Dimension(100, 14));
                    pwdPanel.add(jLabel2, BorderLayout.WEST);
                    pwdPanel.add(jPasswordField1, BorderLayout.CENTER);
                }
                jPanel4.add(pwdPanel);
            }
            jPanel5.add(jPanel4, BorderLayout.CENTER);

            //---- jLabel3 ----
            jLabel3.setText(bundle.getString("LoginDialog.jLabel3.text"));
            jLabel3.setVerticalAlignment(SwingConstants.TOP);
            jPanel5.add(jLabel3, BorderLayout.NORTH);

            //======== jPanel6 ========
            {
                jPanel6.setLayout(new BorderLayout());

                //======== jPanel1 ========
                {
                    jPanel1.setLayout(new GridLayout(1, 0, 5, 0));

                    //---- cancelButton ----
                    cancelButton.setText(bundle.getString("LoginDialog.cancelButton.text"));
                    cancelButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            cancelButtonActionPerformed(e);
                        }
                    });
                    jPanel1.add(cancelButton);

                    //---- loginButton ----
                    loginButton.setText(bundle.getString("LoginDialog.loginButton.text"));
                    loginButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            loginButtonActionPerformed(e);
                        }
                    });
                    jPanel1.add(loginButton);
                }
                jPanel6.add(jPanel1, BorderLayout.EAST);
            }
            jPanel5.add(jPanel6, BorderLayout.PAGE_END);
        }
        contentPane.add(jPanel5, BorderLayout.CENTER);
        setSize(385, 205);
        setLocationRelativeTo(getOwner());

        //---- bindings ----
        bindingGroup = new BindingGroup();
        bindingGroup.addBinding(Bindings.createAutoBinding(UpdateStrategy.READ_WRITE,
            loginBean, ELProperty.create("${userName}"),
            uidField, BeanProperty.create("text"), "userName"));
        bindingGroup.addBinding(Bindings.createAutoBinding(UpdateStrategy.READ_WRITE,
            loginBean, ELProperty.create("${password}"),
            jPasswordField1, BeanProperty.create("text"), "password"));
        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

    public boolean isCancelPressed() {
        return cancelPressed;
    }

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        cancelPressed = true;
        setVisible(false);
    }//GEN-LAST:event_cancelButtonActionPerformed

    public static LoginDialog execute() {
        LoginDialog dialog = new LoginDialog();
        dialog.setVisible(true);
        return dialog;
    }
    
    
    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        try {
            SampleChatApplication.userSessionBean.login(loginBean.getUserName(), loginBean.getPassword());
            setVisible(false);
        } catch (SampleChatException ex) {
            ExceptionHandler.handleException(ex);
        }
    }//GEN-LAST:event_loginButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JPanel jPanel5;
    private JPanel jPanel4;
    private JPanel uidPanel;
    private JLabel jLabel1;
    private JTextField uidField;
    private JPanel pwdPanel;
    private JLabel jLabel2;
    private JPasswordField jPasswordField1;
    private JLabel jLabel3;
    private JPanel jPanel6;
    private JPanel jPanel1;
    private JButton cancelButton;
    private JButton loginButton;
    private LoginBean loginBean;
    private BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

}
