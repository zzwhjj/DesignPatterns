package com.tank.cor;

import com.tank.GameObject;

public interface Collider {

    boolean collide(GameObject o1, GameObject o2);
}
