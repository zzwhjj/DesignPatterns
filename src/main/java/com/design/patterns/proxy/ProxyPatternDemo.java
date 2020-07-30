package com.design.patterns.proxy;

public class ProxyPatternDemo {

    public static void main(String[] args) {
        Image image = new ProxyImage("test_10mb.jpg");

        //从磁盘加载图像
        image.display();
        System.out.println(" ");
        //图像不需要从磁盘加载
        image.display();
    }
}
