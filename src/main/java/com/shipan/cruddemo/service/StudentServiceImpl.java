package com.shipan.cruddemo.service;

import com.shipan.cruddemo.dao.StudentDAO;
import com.shipan.cruddemo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentDAO studentDAO;

    @Autowired
    public StudentServiceImpl(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public List<Student> findAll() {
        return studentDAO.findAll();
    }

    @Override
    public List<Student> findAllByLastName(String lastName) {
        return List.of();
    }

    @Override
    public Student findById(Integer id) {
        return studentDAO.findById(id);
    }

    @Override
    public void save(Student student) {
        studentDAO.save(student);
    }

    @Override
    public void update(Student student) {
        studentDAO.update(student);
    }

    @Override
    public int delete(Integer id) {
        return studentDAO.delete(id);
    }

    @Override
    public int deleteAll() {
        return studentDAO.deleteAll();
    }
}
