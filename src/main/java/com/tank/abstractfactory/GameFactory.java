package com.tank.abstractfactory;

import com.tank.Dir;
import com.tank.Group;
import com.tank.TankFrame;

public abstract class GameFactory {

    public abstract BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame frame);
    public abstract BaseExplode createExplode(int x, int y, TankFrame frame);
    public abstract BaseBullet createBullet(int x, int y, Dir dir, Group group, TankFrame frame);
}
