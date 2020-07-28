package com.design.patterns.filter;

import java.util.List;

/**
 * 为标准创建一个窗口
 */
public interface Criteria {

    public List<Person> meetCriterial(List<Person> persons);
}
