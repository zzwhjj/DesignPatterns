package com.tank;

import com.tank.cor.BulletTankCollider;
import com.tank.cor.ColliderChain;
import com.tank.cor.Collider;
import com.tank.cor.TankTankCollider;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class GameModel {

    Tank myTank = new Tank(200, 400, Dir.DOWN, Group.GOOD, this);

//    List<Bullet> bullets = new ArrayList<>();
//    List<Tank> tanks = new ArrayList<>();
//    List<Explode> explodes = new ArrayList<>();
    Collider collider = new BulletTankCollider();
    Collider collider2 = new TankTankCollider();
    ColliderChain chain = new ColliderChain();

    private List<GameObject> objects = new ArrayList<>();

    public GameModel() {
        int initTankCount = Integer.parseInt((String) PropertyMgr.get("initTankCount"));

        //初始化敌方坦克
        for (int i = 0; i < initTankCount; i++) {
            this.add(new Tank(50 + i * 80, 200, Dir.DOWN, Group.BAD, this));
        }
    }

    public void add(GameObject go) {
        this.objects.add(go);
    }

    public void remove(GameObject go) {
        this.objects.remove(go);
    }

    public void paint(Graphics graphics) {
        Color color = graphics.getColor();
        graphics.setColor(Color.WHITE);
//        graphics.drawString("子弹的数量：" + bullets.size(), 10, 60);
//        graphics.drawString("敌人的数量：" + tanks.size(), 10, 80);
//        graphics.drawString("爆炸的数量：" + explodes.size(), 10, 100);
        graphics.setColor(color);

        myTank.paint(graphics);

        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).paint(graphics);
        }

        //互相碰撞
        for (int i = 0; i < objects.size(); i++) {
            for (int j = i + 1; j < objects.size(); j++) {
                GameObject o1 = objects.get(i);
                GameObject o2 = objects.get(j);

                chain.collide(o1, o2);
            }
        }

//        for (int i = 0; i < bullets.size(); i++) {
//            for (int j = 0; j < tanks.size(); j++) {
//                bullets.get(i).collideWith(tanks.get(j));
//            }
//        }
    }

    public Tank getMainTank() {
        return myTank;
    }
}
