package controller;

import javax.servlet.http.*;

/**
 * @Author: LiuLou
 * @Description: Session监听器
 * @Date: Created in 14:34 2018/6/11
 * @Modified By:
 */
public class SessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        System.out.println("SESSION CREATED");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.out.println("LOGIN EXPIRED");
    }
}
