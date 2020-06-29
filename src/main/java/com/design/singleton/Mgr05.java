package com.design.singleton;

/**
 * 懒汉式
 * 虽然达到了按需初始化的目的，但却带来线程不安全的问题 可以通过synchronized解决，但也带来效率下降
 */
public class Mgr05 {

    private static Mgr05 INSTANCE;

    private Mgr05() {
    };

    public static Mgr05 getInstance() {
        if (INSTANCE == null) {
            //试图通过减小同步代码块的方式提高效率，然而不可行
            //在对象生成之前，可能多个线程进入此处，会造成申请多个对象
            synchronized (Mgr05.class) {
                //测试代码，为了演示线程不安全
            /*try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
                INSTANCE = new Mgr05();
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
                System.out.println(Mgr05.getInstance().hashCode());
            }).start();
        }
    }
}
