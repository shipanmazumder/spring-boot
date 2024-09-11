package com.shipan.cruddemo.rest;

import java.util.List;

import com.shipan.cruddemo.service.StudentService;
import org.springframework.web.bind.annotation.*;
import com.shipan.cruddemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentService.findAll();
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        Student student = studentService.findById(studentId);
        if (student == null) {
            throw new NotFoundException("Student Not Found " + studentId);
        }
        return student;
    }

    @PostMapping("/students")
    public Student saveStudent(@RequestBody Student student) {
        student.setId(0);
        studentService.save(student);
        return student;
    }

    @PutMapping("/students/{studentId}")
    public Student updateStudent(@RequestBody Student student, @PathVariable int studentId) {
        Student old = studentService.findById(studentId);
        if (old == null) {
            throw new NotFoundException("Student Not Found " + studentId);
        }
        old = student;
        old.setId(studentId);
        studentService.update(old);
        return old;
    }

    @DeleteMapping("/students/{studentId}")
    public int deleteStudent(@PathVariable int studentId) {
        Student old = studentService.findById(studentId);
        if (old == null) {
            throw new NotFoundException("Student Not Found " + studentId);
        }
        return studentService.delete(studentId);
    }


}
