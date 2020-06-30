package com.tank;

import com.tank.abstractfactory.BaseTank;

//子弹发射使用策略模式
public interface FireStrategy {

    void fire(Tank tank);
}
