package com.company;

public class Main {

    public static void main(String[] args) {
        GradeBook g = new GradeBook();
        g.addStudent(new Student("A",100));
        g.addStudent(new Student("B", 90));
        g.rankStudents();
        System.out.println(g);
    }
}
