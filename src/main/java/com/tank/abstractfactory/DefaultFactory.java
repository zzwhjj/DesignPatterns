package com.tank.abstractfactory;

import com.tank.Bullet;
import com.tank.Dir;
import com.tank.Explode;
import com.tank.Group;
import com.tank.Tank;
import com.tank.TankFrame;

public class DefaultFactory extends GameFactory{

    @Override
    public BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame frame) {
        //return new Tank(x, y, dir, group, frame);
        return null;
    }

    @Override
    public BaseExplode createExplode(int x, int y, TankFrame frame) {
        return null;// new Explode(x, y, frame);
    }

    @Override
    public BaseBullet createBullet(int x, int y, Dir dir, Group group, TankFrame frame) {
        return null;
    }
}
