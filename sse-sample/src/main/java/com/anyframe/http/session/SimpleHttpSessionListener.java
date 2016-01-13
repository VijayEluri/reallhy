package com.anyframe.http.session;

import javax.servlet.http.HttpSessionEvent;
import java.util.Date;


public class SimpleHttpSessionListener implements javax.servlet.http.HttpSessionListener{

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("["+new Date() + "] Created : " + se.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("["+new Date() + "] Destroyed : " + se.getSession().getId());
    }
}
