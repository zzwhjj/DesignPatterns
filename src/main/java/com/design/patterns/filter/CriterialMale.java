package com.design.patterns.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建实现了Criteria接口的实体类
 */
public class CriterialMale implements Criteria {

    @Override
    public List<Person> meetCriterial(List<Person> persons) {
        List<Person> malePersons = new ArrayList<Person>();
        for (Person person : persons) {
            if (person.getGender().equalsIgnoreCase("MALE")) {
                malePersons.add(person);
            }
        }
        return malePersons;
    }
}
