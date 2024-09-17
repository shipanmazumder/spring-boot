package com.shipan.cruddemo;

import com.shipan.cruddemo.dao.CourseDAO;
import com.shipan.cruddemo.dao.InstructorDAO;
import com.shipan.cruddemo.entity.Course;
import com.shipan.cruddemo.entity.Instructor;
import com.shipan.cruddemo.entity.InstructorDetails;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.shipan.cruddemo.dao.StudentDAO;
import com.shipan.cruddemo.entity.Student;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(CourseDAO courseDAO, InstructorDAO instructorDAO) {
        return runner -> {
            System.out.println("Hello World");
            saveCourseAndStudents(courseDAO, instructorDAO);
//            findCourseAndStudents(courseDAO);
//			saveInstructorWithCourse(instructorDAO);
//			saveInstructor(instructorDAO);
//			readInstructor(instructorDAO,1);
            // createStudent(studentDAO);
            // readStudent(studentDAO, 2);
            // updateStudent(studentDAO);
            // readAllStudent(studentDAO);
            // deleteStudent(studentDAO);
            // deleteAllStudent(studentDAO);
        };
    }

    private void findCourseAndStudents(CourseDAO appDAO) {

        int theId = 19;
        Course tempCourse = appDAO.findCoursesByCourseWithJoin(theId);

        System.out.println("Loaded course: " + tempCourse);
        System.out.println("Students: " + tempCourse.getStudents());

        System.out.println("Done!");
    }

    private void saveCourseAndStudents(CourseDAO courseDAO, InstructorDAO instructorDAO) {
        Instructor tempInstructor = new Instructor("John", "Doe", "john.doe@example.com");
        Course tempCourse = new Course("C#");
        tempInstructor.add(tempCourse);

        Student tempStudent1 = new Student("Shipan", "mazumder", "shipan@gmail.com");
        Student tempStudent2 = new Student("Joy", "mazumder", "joy@gmail.com");
        tempCourse.addStudent(tempStudent1);
        tempCourse.addStudent(tempStudent2);
//        // save the course and associated students
        System.out.println("Saving the course: " + tempCourse);
        System.out.println("associated students: " + tempCourse.getStudents());

//        courseDAO.save(tempCourse);
        instructorDAO.save(tempInstructor);

        System.out.println("Done!");

    }

    private void saveInstructorWithCourse(InstructorDAO instructorDAO) {
        Instructor instructor = new Instructor("Shipan", "Mazumder", "shipan@gmail.com");

        InstructorDetails instructorDetail = new InstructorDetails("Coding");
        instructor.add(new Course("Programming"));
        instructor.setInstructorDetails(instructorDetail);
        System.out.println("Saving Instructor");
        instructorDAO.save(instructor);

    }

    private void saveInstructor(InstructorDAO instructorDAO) {
        Instructor instructor = new Instructor("Shipan", "Mazumder", "shipan@gmail.com");

        InstructorDetails instructorDetail = new InstructorDetails("Coding");

        instructor.setInstructorDetails(instructorDetail);
        System.out.println("Saving Instructor");
        instructorDAO.save(instructor);

    }

    private void readInstructor(InstructorDAO instructorDAO, Integer id) {
        System.out.println("Read the Object");
        Instructor instructor = instructorDAO.findCoursesByInstructorWithJoin(id);
//		List<Course> courses=instructorDAO.findCoursesByInstructor(id);
//		instructor.setCourses(courses);
//		System.out.println(instructor.getCourses());
        System.out.println("Saved student. Generated id: " + instructor.toString());
    }

    private void createStudent(StudentDAO studentDAO) {
        // create the student object
        System.out.println("Create the Object");
        Student tempStudent = new Student("Shipan", "Mazumder", "shipan@gmail.com");
        // save the student
        System.out.println("Save the Object");
        studentDAO.save(tempStudent);
        readStudent(studentDAO, tempStudent.getId());

        System.out.println("Saved student. Generated id: " + tempStudent.getId());
    }

    private void readStudent(StudentDAO studentDAO, Integer id) {
        System.out.println("Read the Object");
        Student student = studentDAO.findById(id);

        System.out.println("Saved student. Generated id: " + student.toString());
    }

    private void readAllStudent(StudentDAO studentDAO) {
        System.out.println("Read all the Object");
        List<Student> student = studentDAO.findAll();

        // List<Student> student = studentDAO.findAllByLastName("Mazumder");
        for (Student student2 : student) {

            System.out.println("Saved student. Generated id: " + student2.toString());
        }
    }

    private void updateStudent(StudentDAO studentDAO) {
        // Student old = studentDAO.findById(1);
        // old.setFirstName("Joy");
        // old.setLastName("Joy");
        // studentDAO.update(old);
        // System.out.println("Saved student. Generated id: " + old.getFirstName());
    }

    private void deleteStudent(StudentDAO studentDAO) {
        Integer row = studentDAO.delete(2);
        System.out.println("Saved student. Delete id: " + row);
    }

    private void deleteAllStudent(StudentDAO studentDAO) {
        Integer row = studentDAO.deleteAll();
        System.out.println("Saved student. Delete rows count: " + row);
    }
}
