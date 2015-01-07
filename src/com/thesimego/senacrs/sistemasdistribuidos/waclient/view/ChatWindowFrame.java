package com.thesimego.senacrs.sistemasdistribuidos.waclient.view;

import com.thesimego.senacrs.sistemasdistribuidos.waclient.entity.ResponseEN;
import com.thesimego.senacrs.sistemasdistribuidos.waclient.util.RequestClient;
import com.thesimego.senacrs.sistemasdistribuidos.waclient.util.Util;
import com.thesimego.senacrs.sistemasdistribuidos.waclient.entity.MessageEN;
import com.thesimego.senacrs.sistemasdistribuidos.waclient.type.MessageType;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Simego
 */
public class ChatWindowFrame extends javax.swing.JFrame {

    private final String friendNick;
    private final MainFrame owner;
    private Thread listener;
    private final MessageType messageType;

    /**
     * Inicialização da janela
     *
     * @param owner JFrame pai desta janela, usado apenas para localização, se passado null a localização será centralizada
     * @param friendNick Login do amigo ou grupo para qual a mensagem será enviada
     * @param messageType Tipo de mensagem, usuário ou grupo para qual a mensagem será enviada
     */
    public ChatWindowFrame(MainFrame owner, String friendNick, MessageType messageType) {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(owner);
        this.friendNick = friendNick;
        this.owner = owner;
        this.messageType = messageType;
        this.setTitle(messageType.equals(MessageType.USER) ? "Usuário: " + this.friendNick : "Grupo: " + this.friendNick);
        rootPane.setDefaultButton(btnSend);
        txtAreaMessages.setEditable(false);
        txtAreaMessages.setFocusable(false);
        txtMessage.requestFocus();
        runMessageListener();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaMessages = new javax.swing.JTextArea();
        txtMessage = new javax.swing.JTextField();
        btnSend = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        txtAreaMessages.setColumns(20);
        txtAreaMessages.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        txtAreaMessages.setRows(5);
        jScrollPane1.setViewportView(txtAreaMessages);

        btnSend.setText("Enviar");
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtMessage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSend)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSend))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @return
     */
    public String getFriendNick() {
        return friendNick;
    }

    /**
     * Fecha a janela de chat, parando o listener de mensagens e removendo-a da lista de janelas abertas
     *
     * @param evt
     */
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        owner.closeChatWindowFrame(this);
        if (listener != null && listener.isAlive()) {
            listener.interrupt();
        }
    }//GEN-LAST:event_formWindowClosing

    /**
     * Envia mensagem ao servidor
     *
     * @param evt
     */
    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        try {
            if (txtMessage.getText().trim().isEmpty()) {
                return;
            }
            RequestClient.post("http://" + Util.getHost() + "/ChatWA/message/send"
                    + "?message=" + URLEncoder.encode(txtMessage.getText(), "UTF-8")
                    + "&receiver=" + URLEncoder.encode(friendNick, "UTF-8")
                    + "&type=" + URLEncoder.encode(messageType.getValue(), "UTF-8")
                    + getGroupUrl()
            );
            // Adiciona a mensagem na janela do usuário.
            txtAreaMessages.append(Util.formatDate(new Date()) + " - " + Util.getLogin() + ": " + txtMessage.getText() + "\n");
            // Limpa a área de digitação
            txtMessage.setText(null);
        } catch (UnsupportedEncodingException ex) {

        }
    }//GEN-LAST:event_btnSendActionPerformed

    /**
     * Carrega as mensagens para o usuário/grupo em questão
     */
    private void loadMessages() {
        final JFrame frame = this;
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    ResponseEN response = RequestClient.get("http://" + Util.getHost() + "/ChatWA/message/list"
                            + "?sender=" + URLEncoder.encode(friendNick, "UTF-8")
                            + "&type=" + URLEncoder.encode(messageType.getValue(), "UTF-8")
                            + getGroupUrl()
                    );
                    if (response.getCode() == 200) {
                        // Gera lista de mensagens baseando no retorno, deserializando-as
                        List<MessageEN> messages = Util.DeserializeMessages(response.getMessage());
                        // Inclui as mensagens ao texto existente
                        for (MessageEN message : messages) {
                            String msg = new StringBuilder().append(message.getSentTimestamp()).append(" - ")
                                    .append(message.getSender()).append(": ")
                                    .append(message.getMessage()).append("\n")
                                    .toString();
                            txtAreaMessages.append(msg);
                        }

                    } else {
                        JOptionPane.showMessageDialog(frame, response.getCode() + " " + response.getMessage());
                    }
                } catch (UnsupportedEncodingException ex) {

                }
            }
        });
        t.start();
    }

    /**
     * Inicia uma thread para receber de tempo em tempo novas mensagens
     */
    private void runMessageListener() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                boolean isRunning = true;
                while (isRunning) {
                    try {
                        loadMessages();
                        Thread.sleep(5000);
                    } catch (InterruptedException ex) {
                        isRunning = false;
                    }
                }
            }
        });
        listener = t;
        listener.start();
    }

    /**
     * Cria a informação de link com grupo, caso seja usada
     * @return String vazia caso não utilize grupo
     */
    private String getGroupUrl() {
        try {
            return messageType.equals(MessageType.GROUP) ? "&group=" + URLEncoder.encode(friendNick, "UTF-8") : "";
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(ChatWindowFrame.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSend;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtAreaMessages;
    private javax.swing.JTextField txtMessage;
    // End of variables declaration//GEN-END:variables

}
