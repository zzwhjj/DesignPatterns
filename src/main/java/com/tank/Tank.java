package com.tank;

import java.awt.Graphics;
import java.util.Random;

public class Tank {

    private int x, y;
    private Dir dir = Dir.DOWN;
    final int SPEED = 1;
    private boolean moving = true;
    public static int WIDTH = ResourceMgr.goodTankD.getWidth();
    public static int HEIGHT = ResourceMgr.goodTankD.getHeight();
    private boolean living = true;

    private TankFrame tf = null;
    private Random random = new Random();
    private Group group = Group.BAD;

    public Tank(int x, int y, Dir dir, Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf = tf;
    }

    public void paint(Graphics graphics) {
        if (!living) {
            tf.tanks.remove(this);
        }

        switch (dir) {
            case LEFT:
                if (this.group == Group.GOOD) {
                    graphics.drawImage(ResourceMgr.goodTankL, x, y, null);
                } else {
                    graphics.drawImage(ResourceMgr.badTankL, x, y, null);
                }
                break;
            case UP:
                if (this.group == Group.GOOD) {
                    graphics.drawImage(ResourceMgr.goodTankU, x, y, null);
                } else {
                    graphics.drawImage(ResourceMgr.badTankU, x, y, null);
                }
                break;
            case RIGHT:
                if (this.group == Group.GOOD) {
                    graphics.drawImage(ResourceMgr.goodTankR, x, y, null);
                } else {
                    graphics.drawImage(ResourceMgr.badTankR, x, y, null);
                }
                break;
            case DOWN:
                if (this.group == Group.GOOD) {
                    graphics.drawImage(ResourceMgr.goodTankD, x, y, null);
                } else {
                    graphics.drawImage(ResourceMgr.badTankD, x, y, null);
                }
                break;
            default:
                break;
        }

        move();
    }

    private void move() {
        if (!moving) {
            return;
        }

        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            default:
                break;
        }

        if (this.group == Group.BAD && random.nextInt(100) > 95) {
            this.fire();
        }

        if (this.group == Group.BAD && random.nextInt(10) > 8) {
            randomDir();
        }
    }

    //为坦克生成随机方向
    private void randomDir() {
        this.dir = Dir.values()[random.nextInt(4)];
    }

    public void fire() {
        int bX = this.x + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int bY = this.y + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
        tf.bullets.add(new Bullet(bX, bY, this.dir, this.group, tf));
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

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public int getSPEED() {
        return SPEED;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public void die() {
        living = false;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
