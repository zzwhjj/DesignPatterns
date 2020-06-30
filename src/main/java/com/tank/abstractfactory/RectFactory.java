package com.tank.abstractfactory;

import com.tank.Bullet;
import com.tank.Dir;
import com.tank.Group;
import com.tank.TankFrame;

public class RectFactory extends GameFactory {

    @Override
    public BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame frame) {
        return null;
    }

    @Override
    public BaseExplode createExplode(int x, int y, TankFrame frame) {
        return new RectExplode(x, y, frame);
    }

    @Override
    public BaseBullet createBullet(int x, int y, Dir dir, Group group, TankFrame frame) {
        return new RectBullet(x, y, dir, group, frame);
    }
}
