package com.design.compositeentity;

public class CompositeEntityPatternDemo {

    public static void main(String[] args) {
        Client client = new Client();
        client.setData("test", "data");
        client.printData();
        client.setData("second test", "data1");
        client.printData();
    }
}
