package com.tank.abstractfactory;

import com.tank.ResourceMgr;
import com.tank.TankFrame;
import java.awt.Color;
import java.awt.Graphics;

public class RectExplode extends BaseExplode {

    private int x, y;
    public static int WIDTH = ResourceMgr.explodes[0].getWidth();
    public static int HEIGHT = ResourceMgr.explodes[0].getHeight();

    private TankFrame tf = null;
    private int step = 0;

    public RectExplode(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;

        //new Thread(()->new Audio("audio/explode.wav").play()).start();
    }

    @Override
    public void paint(Graphics graphics) {
        //graphics.drawImage(ResourceMgr.explodes[step++], x, y, null);
        Color color = graphics.getColor();
        graphics.setColor(Color.RED);
        graphics.fillRect(x, y, 10 * step, 10 * step);
        step++;
        if (step >= 5) {
            //tf.explodes.remove(this);
        }
        graphics.setColor(color);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
