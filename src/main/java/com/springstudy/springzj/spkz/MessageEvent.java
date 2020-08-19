package com.springstudy.springzj.spkz;


import org.springframework.context.ApplicationEvent;

/**
 * 事件监听器
 */
public class MessageEvent extends ApplicationEvent {

    private final String message;

    public MessageEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
    public void printMsg(String message) {
        System.out.println(message);
    }
}