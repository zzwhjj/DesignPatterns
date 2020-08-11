package com.design.patterns.visitor;

/**
 * 访问者接口
 */
public interface ComputerPartVisitor {

    public void visit(Computer computer);
    public void visit(Mouse mouse);
    public void visit(KeyBoard keyBoard);
    public void visit(Monitor monitor);
}
