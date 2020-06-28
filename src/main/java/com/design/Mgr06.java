package com.design;

/**
 * 懒汉式
 *
 * 双重检查
 */
public class Mgr06 {

    private static Mgr06 INSTANCE;

    private Mgr06() {
    }

    ;

    public static Mgr06 getInstance() {
        if (INSTANCE == null) {
            //双重检查
            synchronized (Mgr06.class) {
                if (INSTANCE == null) {
                    //测试代码，为了演示线程不安全
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new Mgr06();
                }
            }
        }
        return INSTANCE;
    }

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Mgr06.getInstance().hashCode());
            }).start();
        }
    }
}
