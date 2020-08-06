package com.design.patterns.iterator;

/**
 * 使用NameRepository来获取迭代器，并打印名字
 */
public class IteratorPatterDemo {

    public static void main(String[] args) {
        NameRepository nameRepository = new NameRepository();

        for (Iterator it = nameRepository.getIterator(); it.hasNext();) {
            String name = (String)it.next();
            System.out.println("Name: " + name);
        }
    }
}
