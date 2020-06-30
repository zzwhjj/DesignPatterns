package com.tank;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        TankFrame frame = new TankFrame();

        //new Thread(()->new Audio("audio/war1.wav").loop()).start();

        while (true) {
            Thread.sleep(25);
            frame.repaint();
        }
    }
}
