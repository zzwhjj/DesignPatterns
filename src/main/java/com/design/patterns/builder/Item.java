package com.design.patterns.builder;

/**
 * 创建一个表示食物条目接口
 */
public interface Item {

    public String name();
    public Packing packing();
    public float price();
}
