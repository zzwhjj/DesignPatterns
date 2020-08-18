package com.design.patterns.interceptingfilter;

/**
 * 创建过滤器实体
 */
public class AuthenticationFilter implements Filter {

    @Override
    public void execute(String request) {
        System.out.println("Authenticating request: " + request);
    }
}
