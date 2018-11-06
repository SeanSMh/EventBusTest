package com.example.sean.eventbustest;

/**
 * Created by Sean豆子
 * on 2018/11/6.
 */
public class MessageEvent {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MessageEvent(String message) {
        this.message = message;
    }



}
