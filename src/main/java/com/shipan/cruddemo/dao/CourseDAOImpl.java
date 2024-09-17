package com.shipan.cruddemo.dao;

import com.shipan.cruddemo.entity.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CourseDAOImpl implements CourseDAO {

    private EntityManager entityManager;

    @Autowired
    public CourseDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Course thCourse) {
        entityManager.persist(thCourse);
    }

    @Override
    public Course findById(Integer id) {
        return null;
    }

    @Override
    public List<Course> findAll() {
        return List.of();
    }

    @Override
    public Course findCoursesByCourseWithJoin(Integer id) {
        // create query
        TypedQuery<Course> query = entityManager.createQuery(
                "select c from Course c "
                        + "JOIN FETCH c.students "
                        + "where c.id = :data", Course.class);

        query.setParameter("data", id);

        // execute query
        Course course = query.getSingleResult();

        return course;
    }

    @Override
    public List<Course> findAllByLastName(String lastName) {
        return List.of();
    }

    @Override
    public void update(Course thCourse) {

    }

    @Override
    public int delete(Integer id) {
        return 0;
    }

    @Override
    public int deleteAll() {
        return 0;
    }
}
