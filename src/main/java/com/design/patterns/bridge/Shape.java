package com.design.patterns.bridge;

/**
 * 使用DrawAPI接口创建抽象类Shape
 */
public abstract class Shape {

    protected DrawAPI drawAPI;
    protected Shape(DrawAPI drawAPI) {
        this.drawAPI = drawAPI;
    }

    public abstract void draw();
}
