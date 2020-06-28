package com.tank;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Tank {

    public Rectangle rect = new Rectangle();
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

        rect.x = this.x;
        rect.y = this.y;
        rect.width = WIDTH;
        rect.height = HEIGHT;
    }

    public void paint(Graphics graphics) {
        if (!living) {
            tf.tanks.remove(this);
        }

        switch (dir) {
            case LEFT:
                graphics.drawImage(
                    this.group == Group.GOOD ? ResourceMgr.goodTankL : ResourceMgr.badTankL, x, y,
                    null);
                break;
            case UP:
                graphics.drawImage(
                    this.group == Group.GOOD ? ResourceMgr.goodTankU : ResourceMgr.badTankU, x, y,
                    null);
                break;
            case RIGHT:
                graphics.drawImage(
                    this.group == Group.GOOD ? ResourceMgr.goodTankR : ResourceMgr.badTankR, x, y,
                    null);
                break;
            case DOWN:
                graphics.drawImage(
                    this.group == Group.GOOD ? ResourceMgr.goodTankD : ResourceMgr.badTankD, x, y,
                    null);
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

        rect.x = this.x;
        rect.y = this.y;

        //敌方坦克自由开火
        if (this.group == Group.BAD && random.nextInt(100) > 95) {
            this.fire();
        }

        //敌方坦克方向随机
        if (this.group == Group.BAD && random.nextInt(10) > 8) {
            randomDir();
        }

        boundsCheck();
    }

    //边界检测
    private void boundsCheck() {
        if (this.x < 2) {
            x = 2;
        }
        if (this.y < 28) {
            y = 28;
        }
        if (this.x > TankFrame.GAME_WIDTH - Tank.WIDTH - 2) {
            x = TankFrame.GAME_WIDTH - Tank.WIDTH - 2;
        }
        if (this.y > TankFrame.GAME_HEIGHT - Tank.HEIGHT - 2) {
            y = TankFrame.GAME_HEIGHT - Tank.HEIGHT - 2;
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
