package com.design.patterns.filter;

import java.util.List;

public class AndCriteria implements Criteria {

    private Criteria criteria;
    private Criteria otherCriteria;

    public AndCriteria(Criteria criteria, Criteria otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<Person> meetCriterial(List<Person> persons) {
        List<Person> firstCriterialPersons = criteria.meetCriterial(persons);
        return otherCriteria.meetCriterial(firstCriterialPersons);
    }
}
