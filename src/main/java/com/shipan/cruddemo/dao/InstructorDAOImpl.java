package com.shipan.cruddemo.dao;

import com.shipan.cruddemo.entity.Course;
import com.shipan.cruddemo.entity.Instructor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public class InstructorDAOImpl implements InstructorDAO {
    private EntityManager entityManager;

    @Autowired
    public InstructorDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor thInstructor) {
        entityManager.persist(thInstructor);
    }

    @Override
    public Instructor findById(Integer id) {
        return entityManager.find(Instructor.class,id);
    }

    @Override
    public List<Instructor> findAll() {
         TypedQuery<Instructor> createQuery = entityManager.createQuery("FROM Instructor", Instructor.class);
        return createQuery.getResultList();
    }

    @Override
    public List<Course> findCoursesByInstructor(Integer id) {
        TypedQuery<Course> createQuery = entityManager.createQuery("FROM Course where instructor.id=:data", Course.class);
        createQuery.setParameter("data",id);
        return createQuery.getResultList();
    }

    @Override
    public Instructor findCoursesByInstructorWithJoin(Integer id) {
         TypedQuery<Instructor> createQuery = entityManager.createQuery(
                 "select i from Instructor i "
                 +"JOIN FETCH i.courses " + "JOIN FETCH i.instructorDetails "
                  + "where i.id = :data", Instructor.class);
        createQuery.setParameter("data",id);
        Instructor instructor=createQuery.getSingleResult();
        return instructor;
    }

    @Override
    public List<Instructor> findAllByLastName(String lastName) {
        return List.of();
    }

    @Override
    @Transactional
    public void update(Instructor thInstructor) {
            entityManager.merge(thInstructor);
    }

    @Override
    @Transactional
    public int delete(Integer id) {
         Instructor instructor = findById(id);
        entityManager.remove(instructor);
        return instructor.getId();
    }

    @Override
    public int deleteAll() {
        return 0;
    }
}
