package com.lvh.lab5.model;

import android.media.Image;


public class Message {
    private int msgType;
    private String msg,dateCreated;
    private Image avata;

    public Message() {
    }

    public Message(int msgType, String msg, String dateCreated, Image avata) {
        this.msgType = msgType;
        this.msg = msg;
        this.dateCreated = dateCreated;
        this.avata = avata;
    }

    public int getMsgType() {
        return msgType;
    }

    public void setMsgType(int msgType) {
        this.msgType = msgType;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Image getAvata() {
        return avata;
    }

    public void setAvata(Image avata) {
        this.avata = avata;
    }

    @Override
    public String toString() {
        return "Message{" +
                "msgType=" + msgType +
                ", msg='" + msg + '\'' +
                ", dateCreated='" + dateCreated + '\'' +
                ", avata=" + avata +
                '}';
    }
}
