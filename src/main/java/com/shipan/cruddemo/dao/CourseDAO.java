package com.shipan.cruddemo.dao;

import com.shipan.cruddemo.entity.Course;

import java.util.List;

public interface CourseDAO {
     public void save(Course thCourse);

    public Course findById(Integer id);

    public List<Course> findAll();


    public Course findCoursesByCourseWithJoin(Integer id);

    public List<Course> findAllByLastName(String lastName);

    public void update(Course thCourse);

    public int delete(Integer id);

    public int deleteAll();
}
