package com.design.patterns.Memento;

public class MementoPatternDemo {

    public static void main(String[] args) {
        Originator originator = new Originator();
        CareTacker careTacker = new CareTacker();
        originator.setState("State #1");
        originator.setState("State #2");
        careTacker.add(originator.saveStateMemento());
        originator.setState("State #3");
        careTacker.add(originator.saveStateMemento());
        originator.setState("State #4");

        System.out.println("Current State: " + originator.getState());
        originator.getStateFromMemento(careTacker.get(0));
        System.out.println("First saved State: " + originator.getState());
        originator.getStateFromMemento(careTacker.get(1));
        System.out.println("Second saved State: " + originator.getState());
    }
}
