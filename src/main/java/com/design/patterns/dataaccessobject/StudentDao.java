package com.design.patterns.dataaccessobject;

import java.util.List;

/**
 * 创建数据访问对象接口
 */
public interface StudentDao {

    public List<Student> getAllStudents();
    public Student getStudent(int rollNo);
    public void updateStudent(Student student);
    public void deleteStudent(Student student);
}
