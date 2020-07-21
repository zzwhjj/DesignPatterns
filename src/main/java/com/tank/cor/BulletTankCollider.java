package com.tank.cor;

import com.tank.Bullet;
import com.tank.GameObject;
import com.tank.Tank;

public class BulletTankCollider implements Collider {

    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Bullet && o2 instanceof Tank) {
            Bullet bullet = (Bullet) o1;
            Tank tank = (Tank) o2;

            //Todo copy from method collideWidth
            if (bullet.collideWith(tank)) {
                return false;
            }
        } else if (o1 instanceof Tank && o2 instanceof Bullet) {
            return collide(o2, o1);
        }

        return true;
    }
}
