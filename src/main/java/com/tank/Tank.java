package com.tank;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;

public class Tank {

    public Rectangle rect = new Rectangle();
    private int x, y;
    private Dir dir = Dir.DOWN;
    final int SPEED_GOOD = 5;
    final int SPEED_BAD = 1;
    private boolean moving = true;
    public static int WIDTH = ResourceMgr.goodTankD.getWidth();
    public static int HEIGHT = ResourceMgr.goodTankD.getHeight();
    private boolean living = true;

    private TankFrame tf = null;
    private Random random = new Random();
    private Group group = Group.BAD;

    private FireStrategy fireStrategy;

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

        //根据敌我，设置不同的开火方式
        if (group == Group.GOOD) {
            String goodFSName = (String) PropertyMgr.get("goodFS");
            try {
                fireStrategy = (FireStrategy) Class.forName(goodFSName).getDeclaredConstructor()
                    .newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            String badFSName = (String) PropertyMgr.get("badFS");
            try {
                fireStrategy = (FireStrategy) Class.forName(badFSName).getDeclaredConstructor()
                    .newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
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

        int speed = (this.group == Group.GOOD ? SPEED_GOOD : SPEED_BAD);

        switch (dir) {
            case LEFT:
                x -= speed;
                break;
            case UP:
                y -= speed;
                break;
            case RIGHT:
                x += speed;
                break;
            case DOWN:
                y += speed;
                break;
            default:
                break;
        }

        //敌方坦克自由开火
        if (this.group == Group.BAD && random.nextInt(100) > 95) {
            this.fire();
        }

        //敌方坦克方向随机
        if (this.group == Group.BAD && random.nextInt(100) > 95) {
            randomDir();
        }

        boundsCheck();

        rect.x = this.x;
        rect.y = this.y;
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
        fireStrategy.fire(this);
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
        return (this.group == Group.GOOD ? SPEED_GOOD : SPEED_BAD);
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

    public TankFrame getTf() {
        return tf;
    }

    public void setTf(TankFrame tf) {
        this.tf = tf;
    }
}
