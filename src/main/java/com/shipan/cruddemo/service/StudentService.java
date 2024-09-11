package com.shipan.cruddemo.service;

import com.shipan.cruddemo.entity.Student;

import java.util.List;

public interface StudentService {
    public void save(Student thStudent);

    public Student findById(Integer id);

    public List<Student> findAll();

    public List<Student> findAllByLastName(String lastName);

    public void update(Student thStudent);

    public void delete(Integer id);

}
