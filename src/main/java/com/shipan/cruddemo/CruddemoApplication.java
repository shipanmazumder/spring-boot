package com.shipan.cruddemo;

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
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			System.out.println("Hello World");
			// createStudent(studentDAO);
			// readStudent(studentDAO, 2);
			// updateStudent(studentDAO);
			// readAllStudent(studentDAO);
			// deleteStudent(studentDAO);
			// deleteAllStudent(studentDAO);
		};
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
