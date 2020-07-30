package com.design.patterns.filter;

import java.util.ArrayList;
import java.util.List;

public class CriterialFemale implements Criteria {

    @Override
    public List<Person> meetCriterial(List<Person> persons) {
        List<Person> femalePersons = new ArrayList<Person>();
        for (Person person : persons) {
            if (person.getGender().equalsIgnoreCase("female")) {
                femalePersons.add(person);
            }
        }
        return femalePersons;
    }
}
