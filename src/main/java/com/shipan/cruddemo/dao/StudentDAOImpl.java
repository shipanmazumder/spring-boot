package com.shipan.cruddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shipan.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO {
    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student thStudent) {
        entityManager.persist(thStudent);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> createQuery = entityManager.createQuery("FROM Student", Student.class);
        return createQuery.getResultList();
    }

    @Override
    public List<Student> findAllByLastName(String theLastName) {
        TypedQuery<Student> createQuery = entityManager.createQuery("FROM Student where lastName=:lastName",
                Student.class);
        createQuery.setParameter("lastName", theLastName);
        return createQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student thStudent) {
        entityManager.merge(thStudent);
    }

    @Override
    @Transactional
    public int delete(Integer id) {
        Student student = findById(id);
        entityManager.remove(student);
        return student.getId();
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return numRowsDeleted;
    }
}
