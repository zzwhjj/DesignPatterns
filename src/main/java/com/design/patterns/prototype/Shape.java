package com.design.patterns.prototype;

/**
 * 原型模式
 * <p>
 * 创建一个实现了Cloneable接口的抽象类
 */
public abstract class Shape implements Cloneable {

    private String id;
    protected String type;
    abstract void draw();

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}
