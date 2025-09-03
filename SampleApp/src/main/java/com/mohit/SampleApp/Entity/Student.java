package com.mohit.SampleApp.Entity;

import jakarta.persistence.*;

import java.util.Map;

@Entity
@Table(name = "Student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;

    @Column(unique = true)
    private String name;
    private String email;
    private Integer age;
    private String grade;

    @ElementCollection
    private Map<String, Integer> marks;

    public Student() {

    }

    // A transient method to calculate the grade
    @Transient
    public String getGrade() {
        if (marks == null || marks.isEmpty()) {
            return "N/A";
        }
        double average = marks.values().stream().mapToInt(Integer::intValue).average().orElse(0.0);
        if (average >= 90) return "A+";
        if (average >= 80) return "A";
        if (average >= 70) return "B+";
        if (average >= 60) return "B";
        if (average >= 50) return "C+";
        if (average >= 40) return "C";
        return "F";
    }

    public Student(long id, String name, String email, Integer age, String grade, Map<String, Integer> marks) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.grade = grade;
        this.marks = marks;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Map<String, Integer> getMarks() {
        return marks;
    }

    public void setMarks(Map<String, Integer> marks) {
        this.marks = marks;
    }
}
