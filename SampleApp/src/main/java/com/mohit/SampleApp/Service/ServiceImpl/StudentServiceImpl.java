package com.mohit.SampleApp.Service.ServiceImpl;

import com.mohit.SampleApp.Entity.Student;
import com.mohit.SampleApp.Repository.StudentRepository;
import com.mohit.SampleApp.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        return studentRepository.findById(id)
                .map(Student -> {
                    Student.setName(student.getName());
                    Student.setEmail(student.getEmail());
                    Student.setAge(student.getAge());
                    return studentRepository.save(Student);
                })
                .orElseThrow(()-> new RuntimeException("Student not found"));
    }

    @Override
    public Optional<Boolean> deleteStudent(Long id) {
        return studentRepository.findById(id).map(student -> {
            studentRepository.delete(student);
            return true;
        });
    }
}
