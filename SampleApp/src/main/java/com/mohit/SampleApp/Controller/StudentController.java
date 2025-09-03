package com.mohit.SampleApp.Controller;

import com.mohit.SampleApp.Entity.Student;
import com.mohit.SampleApp.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/students")
public class StudentController {

    private final StudentService service;

    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student){
        System.out.println(student);
         return service.saveStudent(student);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        return service.getStudentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable long id,@RequestBody Student student){
       return service.updateStudent(id,student);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable long id){
        return service.deleteStudent(id)
                .map(isDeleted -> ResponseEntity.ok().<Void>build())
                .orElse(ResponseEntity.notFound().build());
    }

}
