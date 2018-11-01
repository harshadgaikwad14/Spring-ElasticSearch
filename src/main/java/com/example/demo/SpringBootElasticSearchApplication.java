package com.example.demo;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootElasticSearchApplication implements CommandLineRunner {

	@Resource
	StudentRepository studentRepository;

	public static void main(String[] args) {

		/*
		 * Check All Student
		 * http://localhost:9200/students/student/_search?size=1000
		 * Check Mapping
		 * http://localhost:9200/students/
		 * Check Student
		 * http://localhost:9200/students/student/2
		 */
		SpringApplication.run(SpringBootElasticSearchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Address address =new Address();
		address.setCity("Mumbai");
		Student student1 = new Student(1, "JIP1", 11);
		student1.setAddress(address);
		Student student2 = new Student(2, "JIP2", 22);
		student2.setAddress(address);
		Student student3 = new Student(3, "JIP3", 33);
		student3.setAddress(address);
		Student student4 = new Student(4, "JIP4", 44);
		student4.setAddress(address);
		Student student5 = new Student(5, "JIP5", 55);
		student5.setAddress(address);
		Student student6 = new Student(6, "JIP6", 66);
		student6.setAddress(address);

		// Saving Student to StudentRepository
		studentRepository.save(student1);
		studentRepository.save(student2);
		studentRepository.save(student3);
		studentRepository.save(student4);
		studentRepository.save(student5);
		studentRepository.save(student6);

		// Getting all Students
		System.out.println("***** Getting All Students *******");
		for (Student student : studentRepository.findAll()) {
			System.out.println(student);
		}

		// Getting the student with Id 4
		System.out.println("***** Student with Id 4 *******");
		System.out.println(studentRepository.findById((long) 4));

		// Getting the student with Name JIP3
		System.out.println("***** Student with Name JIP3 *******");
		System.out.println(studentRepository.findByName("JIP3"));

		// Getting the student with Age 22
		System.out.println("***** Student with ID 2 *******");
		System.out.println(studentRepository.findByAge(22));

		// Delete the Student with Id 5
		studentRepository.deleteById((long) 5);
		// Check whether the student is deleted or not
		System.out.println("***** Student with id 5 : " + (studentRepository.findById((long) 5)));
		
		

	}
}
