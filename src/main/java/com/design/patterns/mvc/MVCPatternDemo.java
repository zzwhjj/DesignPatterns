package com.design.patterns.mvc;

public class MVCPatternDemo {

    public static void main(String[] args) {
        Student model = retrieveStudentFromDatabase();
        
        StudentView view = new StudentView();
        
        StudentController controller = new StudentController(model, view);
        
        controller.updateView();
        
        controller.setStudentName("John");
        controller.updateView();
    }

    private static Student retrieveStudentFromDatabase() {
        Student student = new Student();
        student.setName("Robert");
        student.setRollNo("10");
        return student;
    }
}
