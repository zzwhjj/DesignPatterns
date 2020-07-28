package com.design.patterns.filter;

import java.util.List;

public class OrCriteria implements Criteria {

    private Criteria criteria;
    private Criteria otherCriterial;

    public OrCriteria(Criteria criteria, Criteria otherCriterial) {
        this.criteria = criteria;
        this.otherCriterial = otherCriterial;
    }

    @Override
    public List<Person> meetCriterial(List<Person> persons) {
        List<Person> firstCriterialItems = criteria.meetCriterial(persons);
        List<Person> otherCriterialItems = otherCriterial.meetCriterial(persons);

        for (Person person : otherCriterialItems) {
            if (!firstCriterialItems.contains(person)) {
                firstCriterialItems.add(person);
            }
        }
        return firstCriterialItems;
    }
}
