package com.mohit7.studentapp.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;

public class Student implements Serializable {
    @SerializedName("id")
    private Long id;
    @SerializedName("name")
    private String name;
    @SerializedName("email")
    private String email;
    @SerializedName("age")
    private int age;
    @SerializedName("marks")
    private Map<String, Integer> marks;
    @SerializedName("grade")
    private String grade;

    
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public int getAge() { return age; }
    public Map<String, Integer> getMarks() { return marks; }
    public String getGrade() { return grade; }
    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setAge(int age) { this.age = age; }
    public void setMarks(Map<String, Integer> marks) { this.marks = marks; }
    public void setGrade(String grade) { this.grade = grade; }

}