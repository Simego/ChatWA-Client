package com.thesimego.senacrs.sistemasdistribuidos.waclient.view;

import com.thesimego.senacrs.sistemasdistribuidos.waclient.entity.ResponseEN;
import com.thesimego.senacrs.sistemasdistribuidos.waclient.type.AccountActionType;
import com.thesimego.senacrs.sistemasdistribuidos.waclient.util.RequestClient;
import com.thesimego.senacrs.sistemasdistribuidos.waclient.util.Util;
import java.awt.Color;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.UIManager;

/**
 *
 * @author Simego
 */
public class LoginFrame extends javax.swing.JFrame {

    /**
     * Inicialização da janela
     */
    public LoginFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Whats Apop Chat - Sistemas Distribuidos");
        rootPane.setDefaultButton(btnLogin);
        // Seta no campo de Host o ip colocado na propriedade que é setada ao iniciar o programa
        txtHost.setText(Util.getHost());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtLogin = new javax.swing.JTextField();
        lblLogin = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        txtMessage = new javax.swing.JLabel();
        btnCreate = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();
        txtHost = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnProxy = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setResizable(false);

        lblLogin.setText("Login:");

        lblPassword.setText("Senha:");

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        txtMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtMessage.setText(" ");

        btnCreate.setText("Criar conta");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        jLabel1.setText("Host:");

        btnProxy.setText("Proxy");
        btnProxy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProxyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(116, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnProxy, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(94, 94, 94))
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLogin)
                    .addComponent(lblPassword)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtHost, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                    .addComponent(txtPassword)
                    .addComponent(txtLogin))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLogin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPassword))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCreate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnProxy)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Ação do botão de login
     *
     * @param evt
     */
    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // Chama o método para fazer login
        handleAccount(AccountActionType.LOGIN);
    }//GEN-LAST:event_btnLoginActionPerformed

    /**
     * Ação do botão de criar nova conta
     *
     * @param evt
     */
    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        // Chama o método para criar conta e fazer login
        handleAccount(AccountActionType.CREATE);
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnProxyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProxyActionPerformed
        ProxyFrame f = new ProxyFrame(this);
        f.setVisible(true);
    }//GEN-LAST:event_btnProxyActionPerformed

    /**
     * Faz a parte de login ou criação de conta, dependendo do tipo de ação que for passado por parâmetro
     *
     * @param type
     */
    private void handleAccount(final AccountActionType type) {
        try {
            // Parâmetro com o host que será usado
            Util.setHost(txtHost.getText());
            String login = txtLogin.getText();
            String password = String.valueOf(txtPassword.getPassword());

            // Validação de login e senha
            if (validateLogin(txtLogin, txtPassword)) {
                txtMessage.setText("Campos login e senha são obrigatórios");
                return;
            }

            // Faz a requisição ao servidor baseando-se no tipo de operação, criar ou logar
            ResponseEN response = null;
            switch (type) {
                case CREATE:
                    response = RequestClient.post("http://" + Util.getHost() + "/ChatWA/account/create?login="
                            + URLEncoder.encode(login, "UTF-8")
                            + "&password=" + URLEncoder.encode(password, "UTF-8"));
                    break;
                case LOGIN:
                    response = RequestClient.post("http://" + Util.getHost() + "/ChatWA/account/login/"
                            + URLEncoder.encode(login, "UTF-8")
                            + "/" + URLEncoder.encode(password, "UTF-8")
                    );
                    break;
            }

            if (response != null) {
                // Se a resposta tiver um código 200 (sucesso) fazer login e mostrar form Main senão mostra mensagem de erro da resposta
                if (response.getCode().equals(200)) {
                    Util.setLogin(login);
                    MainFrame frame = new MainFrame(this);
                    frame.setVisible(true);
                    setVisible(false);
                    dispose();
                } else {
                    txtMessage.setText(response.getMessage());
                }
            } else {
                // Problema na requisição
                txtMessage.setText("Falha na conexão com o servidor.");
            }
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Faz a validação dos campos de login
     *
     * @param login
     * @param password
     * @return
     */
    private boolean validateLogin(JTextField login, JTextField password) {
        boolean hasErrors = false;
        // Resetar a cor dos campos na tela
        changeBackgroundColor(Color.WHITE, login, password);
        txtMessage.setText("");

        // Se um dos 2 campos forem vazios, validar como erro e pintar o campo
        if (login.getText().trim().isEmpty()) {
            hasErrors = true;
            changeBackgroundColor(Color.RED, login);
        }
        if (password.getText().trim().isEmpty()) {
            hasErrors = true;
            changeBackgroundColor(Color.RED, password);
        }

        return hasErrors;
    }

    /**
     * Muda o background dos JTextField passados por parâmetro
     *
     * @param color
     * @param fields
     */
    private void changeBackgroundColor(Color color, JTextField... fields) {
        for (JTextField field : fields) {
            field.setBackground(color);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Windows".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        // Inicialização da tela de login
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Seta propriedade do host padrão
                Util.setHost("localhost:8080");
                // Seta propriedade para fazer debug dos requests
                Util.setDebugRequest(true);
                // Inicia o sistema
                LoginFrame f = new LoginFrame();
                f.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnProxy;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JTextField txtHost;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JLabel txtMessage;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables
}
