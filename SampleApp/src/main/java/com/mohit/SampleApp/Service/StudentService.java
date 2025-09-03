package com.mohit.SampleApp.Service;

import com.mohit.SampleApp.Entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface StudentService  {

    Student saveStudent(Student student);
    List<Student> getAllStudents();
    Optional<Student> getStudentById(Long id);
    Student updateStudent(Long id,Student student);
    Optional<Boolean> deleteStudent(Long id);


}
