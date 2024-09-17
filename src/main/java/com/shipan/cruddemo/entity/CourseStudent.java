package com.shipan.cruddemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "course_students")
public class CourseStudent {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


}
