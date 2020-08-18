package com.design.patterns.interceptingfilter;

public class Target {

    public void execute(String request) {
        System.out.println("Executing request: " + request);
    }
}
