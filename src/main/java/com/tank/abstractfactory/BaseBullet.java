package com.tank.abstractfactory;

import com.tank.Tank;
import java.awt.Graphics;

public abstract class BaseBullet {

    public abstract void paint(Graphics graphics);

    public abstract void collideWith(Tank tank);
}
