package com.shipan.cruddemo.dao;

import com.shipan.cruddemo.entity.Course;
import com.shipan.cruddemo.entity.Instructor;

import java.util.List;

public interface InstructorDAO {
    public void save(Instructor thInstructor);

    public Instructor findById(Integer id);

    public List<Instructor> findAll();

    public List<Course> findCoursesByInstructor(Integer id);

    public Instructor findCoursesByInstructorWithJoin(Integer id);

    public List<Instructor> findAllByLastName(String lastName);

    public void update(Instructor thInstructor);

    public int delete(Integer id);

    public int deleteAll();
}
