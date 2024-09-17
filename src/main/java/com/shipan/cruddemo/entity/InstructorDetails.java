package com.shipan.cruddemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "instructor_details")
public class InstructorDetails {

    @OneToOne(mappedBy = "instructorDetails",cascade = CascadeType.ALL)
    private Instructor instructor;

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "hobby")
    private String hobby;

    public InstructorDetails(String hobby) {
        this.hobby = hobby;
    }

    public InstructorDetails() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "InstructorDetails{" +
                "id=" + id +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
