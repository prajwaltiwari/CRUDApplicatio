package com.prajwal.cruddemo;

import com.prajwal.cruddemo.dao.StudentDao;
import com.prajwal.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner (StudentDao studentDao) {
		return runner -> {
			//creatStudent(studentDao);

			createMultiStudents(studentDao);

			//readStudent(studentDao);

			//queryForStudents(studentDao);

			//findByLastName(studentDao);

			findByFirstName(studentDao);
			
			//queryForUpdate(studentDao);

			//queryForDelete(studentDao);

			//queryToDeleteAll(studentDao);
		};
	}

	private void queryToDeleteAll(StudentDao studentDao) {
		System.out.println("Deleting the Data.....");
		int x= studentDao.deleteAll();
		System.out.println("Deleted !!! "+ x+" number of rows were deleted from DataBase!");

	}

	private void queryForDelete(StudentDao studentDao) {
		int id= 8;
		System.out.println("deleting the student with id : "+ id );
		studentDao.delete(id);
		System.out.println("item deleted.....\n new data set..... ");
		List<Student> tempList = studentDao.findAll();
		for(Student tempStudent : tempList){
			System.out.println(tempStudent.toString());
		}
	}

	private void queryForUpdate(StudentDao studentDao) {
		// retrieve student based on id
		int id = 1;
		System.out.println("Searching Student wit id : "+ id);
		Student tempStudent = studentDao.findById(id);

		// change the first name of the Student
		System.out.println("Changing the Obj first name ");
		tempStudent.setFirstName("Prajwal");

		// update the new value
		studentDao.update(tempStudent);

		// display the updated value
		System.out.println("the updated value ");
		System.out.println(tempStudent.toString());


	}

	private void findByFirstName(StudentDao studentDao) {
		// create list of students with first name = "Prajwal"
		List<Student> tempList = studentDao.findByFirstname("Prajwal");
		// display the results
		System.out.println("The results ........");
		for(Student tempStudent : tempList){
			System.out.println(tempStudent.toString());
		}
	}

	private void findByLastName(StudentDao studentDao) {
		// create list of students with last name = "Tiwari"
		List<Student> tempList = studentDao.findByLastname("Tiwari");
		// display the results
		System.out.println("The results ........");
		for(Student tempStudent : tempList){
			System.out.println(tempStudent.toString());
		}
	}

	private void queryForStudents(StudentDao studentDao) {

		System.out.println("Running Query on the data base :  .......");

		//  get list of students
		List<Student> templist1 = studentDao.findByFirstNameAsc();
		List<Student> templist2 = studentDao.findByFirstNameDesc();
		List<Student> templist3 = studentDao.findByLastNameAsc();
		List<Student> templist4 = studentDao.findByLastNameDesc();

		// display the list elements
		System.out.println("First Name : Asc Order...............................................................");
		for(Student tempStudent : templist1){
			System.out.println(tempStudent.toString());
		}

		System.out.println("First Name : Desc Order...............................................................");
		for(Student tempStudent : templist2){
			System.out.println(tempStudent.toString());
		}

		System.out.println("Last Name : Asc Order...............................................................");
		for(Student tempStudent : templist3){
			System.out.println(tempStudent.toString());
		}

		System.out.println("Last Name : Desc Order...............................................................");
		for(Student tempStudent : templist1){
			System.out.println(tempStudent.toString());
		}
	}

	private void readStudent(StudentDao studentDao) {
		// create a student obj
		System.out.println("Creating Multiple New Student object");
		Student tempStudent1 = new Student("Rohit","Tiwari","readStudentmethod2@gmail.com");

		// save the student object
		System.out.println("Saving the objects ");
		studentDao.save(tempStudent1);

		// display id of save student
		System.out.println("Saved Student  Generated id is: "+tempStudent1.getId());

		// retrieve the student based on id: primary key
		int id = tempStudent1.getId();
		System.out.println("Retrieving thee info of student with id "+id);
		Student s = studentDao.findById(id);

		// display the student
		System.out.println("Results.......");
		System.out.println(s.toString());
	}

	private void createMultiStudents(StudentDao studentDao) {
		// create the student object
		System.out.println("Creating Multiple New Student object");
		Student tempStudent1 = new Student("Prajwal","Tiwari","example.something@gmail.com");
		Student tempStudent2 = new Student("Sandeep","Joshi","example.sometime@gmail.com");
		Student tempStudent3 = new Student("Anshu","Rai","example.someone@gmail.com");
		Student tempStudent4 = new Student("Praas","Tripathi","example.somebody@gmail.com");
		Student tempStudent5 = new Student("Harshit","Adhikari","example.someShit@gmail.com");

		// save the student object
		System.out.println("Saving the objects ");
		studentDao.save(tempStudent1);
		studentDao.save(tempStudent2);
		studentDao.save(tempStudent3);
		studentDao.save(tempStudent4);
		studentDao.save(tempStudent5);

		// display id of the saved student object
		System.out.println("Saved Student  Generated id is: "+tempStudent1.getId());
		System.out.println("Saved Student  Generated id is: "+tempStudent2.getId());
		System.out.println("Saved Student  Generated id is: "+tempStudent3.getId());
		System.out.println("Saved Student  Generated id is: "+tempStudent4.getId());
		System.out.println("Saved Student  Generated id is: "+tempStudent5.getId());
	}

	private void creatStudent(StudentDao studentDao) {

		// create the student object
		System.out.println("Creating new Student object");
		Student tempStudent = new Student("Prajwal","Tiwari","example.something@gmail.com");

		// save the student object
		System.out.println("Saving the object ");
		studentDao.save(tempStudent);

		// display id of the saved student object
		System.out.println("Saved Student  Generated id is: "+tempStudent.getId());

	}
}