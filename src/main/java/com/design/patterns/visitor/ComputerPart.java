package com.design.patterns.visitor;

public interface ComputerPart {

    public void accept(ComputerPartVisitor computerPartVisitor);
}
