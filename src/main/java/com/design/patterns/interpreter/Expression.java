package com.design.patterns.interpreter;

/**
 * 创建一个表达式接口
 */
public interface Expression {

    public boolean interpret(String context);
}