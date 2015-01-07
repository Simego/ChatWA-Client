package com.thesimego.senacrs.sistemasdistribuidos.waclient.view;

import com.thesimego.senacrs.sistemasdistribuidos.waclient.entity.MessageEN;
import com.thesimego.senacrs.sistemasdistribuidos.waclient.entity.ResponseEN;
import com.thesimego.senacrs.sistemasdistribuidos.waclient.type.MessageType;
import com.thesimego.senacrs.sistemasdistribuidos.waclient.util.RequestClient;
import com.thesimego.senacrs.sistemasdistribuidos.waclient.util.Util;
import flexjson.JSONDeserializer;
import java.awt.event.KeyEvent;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Simego
 */
public class MainFrame extends javax.swing.JFrame {

    private final DefaultListModel friendsModel = new DefaultListModel();
    private final DefaultListModel groupsModel = new DefaultListModel();
    private final List<ChatWindowFrame> friendWindows = new ArrayList<>();
    private final List<ChatWindowFrame> groupWindows = new ArrayList<>();
    private Thread listener;

    /**
     * Inicialização da janela
     * @param owner JFrame pai desta janela, usado apenas para localização, se passado null a localização será centralizada
     */
    public MainFrame(JFrame owner) {
        initComponents();
        this.setLocationRelativeTo(owner);
        this.setTitle("Whats Apop Chat - " + Util.getLogin());
        runListener();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        listFriends = new javax.swing.JList();
        lblGroups = new javax.swing.JLabel();
        btnAddFriend = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        listGroups = new javax.swing.JList();
        lblFriends = new javax.swing.JLabel();
        btnAddGroup = new javax.swing.JButton();
        btnRemoveGroup = new javax.swing.JButton();

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        listFriends.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        listFriends.setModel(friendsModel);
        listFriends.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listFriendsMouseClicked(evt);
            }
        });
        listFriends.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                listFriendsKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(listFriends);

        lblGroups.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblGroups.setText("Grupos");

        btnAddFriend.setText("Add Amigo");
        btnAddFriend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddFriendActionPerformed(evt);
            }
        });

        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        listGroups.setModel(groupsModel);
        listGroups.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listGroupsMouseClicked(evt);
            }
        });
        listGroups.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                listGroupsKeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(listGroups);

        lblFriends.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFriends.setText("Amigos");

        btnAddGroup.setText("Add Grupo");
        btnAddGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddGroupActionPerformed(evt);
            }
        });

        btnRemoveGroup.setText("Remover Grupo");
        btnRemoveGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveGroupActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnAddFriend, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                            .addComponent(lblFriends, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(lblGroups)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnRemoveGroup, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                                    .addComponent(btnAddGroup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGroups)
                    .addComponent(lblFriends))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddFriend)
                    .addComponent(btnAddGroup))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRemoveGroup)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLogout)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Adiciona um amigo à conta
     * @param evt 
     */
    private void btnAddFriendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddFriendActionPerformed
        final MainFrame f = this;
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String friendLogin = JOptionPane.showInputDialog(f, "Digite o nome de um amigo");
                    if (friendLogin == null) {
                        return;
                    }
                    ResponseEN response = RequestClient.post("http://" + Util.getHost() + "/ChatWA/friend/add?friend=" + URLEncoder.encode(friendLogin, "UTF-8"));
                    if (response.getCode().equals(200)) {
                        refreshFriendList();
                    } else {
                        JOptionPane.showMessageDialog(f, response.getMessage());
                    }
                } catch (UnsupportedEncodingException ex) {

                }
            }
        });
        t.start();
    }//GEN-LAST:event_btnAddFriendActionPerformed

    /**
     * Faz logout do sistema
     * @param evt 
     */
    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        final MainFrame f = this;
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                ResponseEN response = RequestClient.post("http://" + Util.getHost() + "/ChatWA/account/logout");
                if (response.getCode().equals(200)) {

                    if (listener != null && listener.isAlive()) {
                        listener.interrupt();
                    }

                    LoginFrame frame = new LoginFrame();
                    frame.setVisible(true);
                    setVisible(false);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(f, "Ocorreu um erro ao fazer logout.");
                }
            }
        });
        t.start();
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void listFriendsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listFriendsMouseClicked
        if (evt.getClickCount() == 2) {
            openFriendWindow();
        }
    }//GEN-LAST:event_listFriendsMouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        clearOpenedWindows();
    }//GEN-LAST:event_formWindowClosed

    private void listFriendsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_listFriendsKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            openFriendWindow();
        }
    }//GEN-LAST:event_listFriendsKeyPressed

    private void listGroupsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listGroupsMouseClicked
        if (evt.getClickCount() == 2) {
            openGroupWindow();
        }
    }//GEN-LAST:event_listGroupsMouseClicked

    private void listGroupsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_listGroupsKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            openGroupWindow();
        }
    }//GEN-LAST:event_listGroupsKeyPressed

    /**
     * Botão para adicionar um grupo à conta do usuário
     * @param evt 
     */
    private void btnAddGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddGroupActionPerformed
        final MainFrame f = this;
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String groupName = JOptionPane.showInputDialog(f, "Digite o nome de um grupo");
                    if (groupName == null) {
                        return;
                    }
                    ResponseEN response = RequestClient.post("http://" + Util.getHost() + "/ChatWA/group/join?group=" + URLEncoder.encode(groupName, "UTF-8"));
                    if (response.getCode().equals(200)) {
                        refreshGroupList();
                    } else {
                        JOptionPane.showMessageDialog(f, response.getMessage());
                    }
                } catch (UnsupportedEncodingException ex) {

                }
            }
        });
        t.start();
    }//GEN-LAST:event_btnAddGroupActionPerformed

    /**
     * Botão para remover o grupo da conta do usuário
     * @param evt 
     */
    private void btnRemoveGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveGroupActionPerformed
        final MainFrame f = this;
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String groupName;
                    groupName = (String) listGroups.getSelectedValue();
                    if(groupName == null || groupName.trim().isEmpty()) {
                        return;
                    }
                    ResponseEN response = RequestClient.post("http://" + Util.getHost() + "/ChatWA/group/leave?group=" + URLEncoder.encode(groupName, "UTF-8"));
                    if (response.getCode().equals(200)) {
                        refreshGroupList();
                    } else {
                        JOptionPane.showMessageDialog(f, response.getMessage());
                    }
                } catch (UnsupportedEncodingException ex) {

                }
            }
        });
        t.start();
    }//GEN-LAST:event_btnRemoveGroupActionPerformed

    /**
     * Inicia os listeners de FriendList, GroupList e novas mensagens
     */
    private void runListener() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                boolean isRunning = true;
                while (isRunning) {
                    try {
                        refreshFriendList();
                        refreshGroupList();
                        checkNewMessages();
                        Thread.sleep(10000);
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
     * Atualiza a lista de amigos, buscando-a no servidor
     */
    private void refreshFriendList() {
        final MainFrame f = this;
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                // Carrega informações da friendsModel de usuários para esta conta
                ResponseEN response = RequestClient.get("http://" + Util.getHost() + "/ChatWA/friend/list");
                if (response.getCode().equals(200)) {
                    JSONDeserializer<List<String>> deserializer = new JSONDeserializer<>();
                    List<String> friends = deserializer.deserialize(response.getMessage());
                    friendsModel.clear();
                    for (String friend : friends) {
                        friendsModel.addElement(friend);
                    }
                } else {
                    JOptionPane.showMessageDialog(f, response.getMessage());
                }
            }
        });
        t.start();
    }

    /**
     * Atualiza a lista de grupos, buscando-a no servidor
     */
    private void refreshGroupList() {
        final MainFrame f = this;
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                // Carrega informações da groupsModel de grupos para esta conta
                ResponseEN response = RequestClient.get("http://" + Util.getHost() + "/ChatWA/group/list");
                if (response.getCode().equals(200)) {
                    JSONDeserializer<List<String>> deserializer = new JSONDeserializer<>();
                    List<String> groups = deserializer.deserialize(response.getMessage());
                    groupsModel.clear();
                    for (String group : groups) {
                        groupsModel.addElement(group);
                    }
                } else {
                    JOptionPane.showMessageDialog(f, response.getMessage());
                }
            }
        });
        t.start();
    }

    /**
     * Verifica se usuário tem mensagens novas
     */
    private void checkNewMessages() {
        final MainFrame f = this;
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                ResponseEN response = RequestClient.get("http://" + Util.getHost() + "/ChatWA/message/check");
                if (response.getCode().equals(200)) {
                    List<MessageEN> messages = Util.DeserializeMessages(response.getMessage());
                    for (MessageEN message : messages) {
                        MessageType messageType = MessageType.parse(message.getSenderType());
                        switch (messageType) {
                            case USER:
                                openFriendWindow(message.getSender());
                                break;
                            case GROUP:
                                openGroupWindow(message.getGroupName());
                                break;
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(f, response.getMessage());
                }
            }
        }
        );
        t.start();
    }

    //<editor-fold defaultstate="collapsed" desc="Métodos abrir janela de amigo">
    /**
     * Abre janela de amigo pelo amigo selecionado na listagem
     */
    private void openFriendWindow() {
        openFriendWindow((String) listFriends.getSelectedValue());
    }

    /**
     * Abre janela de amigo pelo parâmetro
     *
     * @param friend
     */
    private void openFriendWindow(String friend) {
        if (friend != null && !friend.trim().isEmpty()) {
            for (ChatWindowFrame f : friendWindows) {
                // Se houver uma janela com o nome do amigo/grupo, trás ela para frente
                if (f.getFriendNick().contains(friend)) {
                    f.toFront();
                    return;
                }
            }
            // Senão, cria uma nova janela
            ChatWindowFrame frame = new ChatWindowFrame(this, friend, MessageType.USER);
            frame.setVisible(true);
            friendWindows.add(frame);
        }

    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos abrir janela de grupo">
    /**
     * Abre janela de grupo pelo grupo selecionado na listagem
     */
    private void openGroupWindow() {
        // Verificar janelas abertas para evitar abrir 2 iguais
        openGroupWindow((String) listGroups.getSelectedValue());
    }

    /**
     * Abre janela de grupo pelo parâmetro
     *
     * @param group
     */
    private void openGroupWindow(String group) {
        if (group != null && !group.trim().isEmpty()) {
            for (ChatWindowFrame f : groupWindows) {
                // Se houver uma janela com o nome do amigo/grupo, trás ela para frente
                if (f.getFriendNick().contains(group)) {
                    f.toFront();
                    return;
                }
            }
            // Senão, cria uma nova janela
            ChatWindowFrame frame = new ChatWindowFrame(this, group, MessageType.GROUP);
            frame.setVisible(true);
            groupWindows.add(frame);
        }
    }
    //</editor-fold>

    /**
     * Fecha janelas que estão abertas, usado normalmente para logout
     */
    public void clearOpenedWindows() {
        for (ChatWindowFrame frame : friendWindows) {
            frame.dispose();
        }

        for (ChatWindowFrame frame : groupWindows) {
            frame.dispose();
        }
    }

    /**
     * Remove das listas de janelas abertas a janela passada por parâmetro
     *
     * @param frame
     */
    public void closeChatWindowFrame(ChatWindowFrame frame) {
        friendWindows.remove(frame);
        groupWindows.remove(frame);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddFriend;
    private javax.swing.JButton btnAddGroup;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnRemoveGroup;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblFriends;
    private javax.swing.JLabel lblGroups;
    private javax.swing.JList listFriends;
    private javax.swing.JList listGroups;
    // End of variables declaration//GEN-END:variables

}
