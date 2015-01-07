package com.thesimego.senacrs.sistemasdistribuidos.waclient.entity;

import java.io.Serializable;

/**
 *
 * @author drafaelli
 */
public class MessageEN implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer id;

    private String sender;
    
    private String message;
    
    private String sentTimestamp;
    
    private String senderType;
    
    private String groupName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSentTimestamp() {
        return sentTimestamp;
    }

    public void setSentTimestamp(String sentTimestamp) {
        this.sentTimestamp = sentTimestamp;
    }

    public String getSenderType() {
        return senderType;
    }

    public void setSenderType(String senderType) {
        this.senderType = senderType;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MessageEN)) {
            return false;
        }
        MessageEN other = (MessageEN) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MessageEN{" + "id=" + id + ", sender=" + sender + ", message=" + message + ", sentTimestamp=" + sentTimestamp + ", senderType=" + senderType + ", groupName=" + groupName + '}';
    }

}
