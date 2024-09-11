package com.shipan.cruddemo.dao;

import java.util.List;

import com.shipan.cruddemo.entity.Student;

public interface StudentDAO {
    public void save(Student thStudent);

    public Student findById(Integer id);

    public List<Student> findAll();

    public List<Student> findAllByLastName(String lastName);

    public void update(Student thStudent);

    public int delete(Integer id);

    public int deleteAll();

}
