package com.design.patterns.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用不同的标准和它们的结合来过滤Person对象的列表
 */
public class CriteriaPatternDemo {

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();

        persons.add(new Person("Robert", "Male", "Single"));
        persons.add(new Person("John", "Male", "Married"));
        persons.add(new Person("Laura", "Female", "Married"));
        persons.add(new Person("Diana", "Female", "Single"));
        persons.add(new Person("Mike", "Male", "Single"));
        persons.add(new Person("Bobby", "Male", "Single"));

        Criteria male = new CriterialMale();
        Criteria female = new CriterialFemale();
        Criteria single = new CriteriaSingle();
        Criteria singleMale = new AndCriteria(single, male);
        Criteria singleOrFemale = new OrCriteria(single, female);

        System.out.println("Males: ");
        printPersons(male.meetCriterial(persons));

        System.out.println("\nFemales: ");
        printPersons(female.meetCriterial(persons));

        System.out.println("\nSingle Males: ");
        printPersons(singleMale.meetCriterial(persons));

        System.out.println("\nSingle Or Females: ");
        printPersons(singleOrFemale.meetCriterial(persons));
    }

    private static void printPersons(List<Person> persons) {
        for (Person person : persons) {
            System.out.println("Person: [ Name: " + person.getName()
            + ", Gender: " + person.getGender()
            + ", Marital Status: " + person.getMaritalStatus()
            + " ]");
        }
    }
}
