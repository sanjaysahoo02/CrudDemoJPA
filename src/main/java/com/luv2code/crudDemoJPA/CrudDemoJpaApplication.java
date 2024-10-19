package com.luv2code.crudDemoJPA;

import com.luv2code.crudDemoJPA.dao.StudentDAO;
import com.luv2code.crudDemoJPA.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

import static org.antlr.v4.runtime.tree.xpath.XPath.findAll;

@SpringBootApplication
public class CrudDemoJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoJpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){

		return runner -> {
			//System.out.println("Hello World");

			//createStudent(studentDAO);

			//createMultipleStudents(studentDAO);

			//readStudent(studentDAO);

			//queryForAllStudents(studentDAO);

			//queryForStudentsByLastName(studentDAO);

			//updateStudent(studentDAO);

			//deleteStudent(studentDAO);

			deleteALLStudents(studentDAO);

		};

	}

	private void deleteALLStudents(StudentDAO studentDAO) {
		System.out.println("Deleting All students.....");

		int numOfRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count: " + numOfRowsDeleted);

	}

	private void deleteStudent(StudentDAO studentDAO) {
		//delete the student
		int theId = 9;
		System.out.println("Deleting the student.....");
		studentDAO.delete(theId);



	}

	private void updateStudent(StudentDAO studentDAO) {

		//retrieve the student based on id: primary key
		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);

		Student myStudent = studentDAO.findById(studentId);

		System.out.println("Updating student.....");

		//change first name as you wish
		myStudent.setFirstName("Amlan");
		studentDAO.update(myStudent);

		//display the updated student
		System.out.println("Updated Student : " + myStudent);

	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {

		//get a list of students
		List<Student> theStudents = studentDAO.findByLastName("Sahoo");

		//display that list of students
		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}

	}

	private void queryForAllStudents(StudentDAO studentDAO) {

		//get a list of students
		List<Student> theStudents = studentDAO.findByLastName("Sahoo");

		//display the list of  students
		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}

	}

	private void readStudent(StudentDAO studentDAO) {

		//create a student object
		System.out.println("Creating a new student object....");
		Student tempStudent = new Student("Pookie", "Puppy", "pp@hotmail.com");

		//save the student
		System.out.println("Saving the new student");
		studentDAO.save(tempStudent);

		//display the id of that student
		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated Id: " + theId);

		//retrieve the student based on id
		System.out.println("Retrieving the student id.....");
		Student myStudent = studentDAO.findById(theId);

		//display student
		System.out.println("Found the student: " + myStudent);

	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		//create multiple students
		System.out.println("Creating multiple new student objects .......");
		Student tempStudent1 = new Student("Biren", "Sahoo", "birenkumar@gmail.com");
		Student tempStudent2 = new Student("Shreyansh", "Giri", "shey@gmail.com");
		Student tempStudent3 = new Student("Anwesh", "Roy", "roy.anwesh@gmail.com");

		//save these students
		System.out.println("Saving the student objects......");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);



	}

	private void createStudent(StudentDAO studentDAO){

		// create the student object
		System.out.println("Creating new student object .......");
		Student tempStudent = new Student("Sanjay", "Sahoo", "sanjaysahoo@gmail.com");

		// save the student object
		System.out.println("Saving the student......");
		studentDAO.save(tempStudent);

		//display id of the saved student
		System.out.println("Saved student. Generated Id: " + tempStudent.getId());



	}

}
