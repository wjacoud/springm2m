package com.whjj.springm2m;

import java.util.Arrays;

import com.whjj.springm2m.models.Course;
import com.whjj.springm2m.models.Student;
import com.whjj.springm2m.repositories.CourseRepository;
import com.whjj.springm2m.repositories.StudentRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Springm2mApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springm2mApplication.class, args);
	}

	// @Bean
	// public CommandLineRunner mappingDemo(StudentRepository studentRepository, CourseRepository courseRepository) {
	// 	return args -> {
	// 		Student larry = new Student("Larry Dooo",(byte) 23,"8th");
	// 		larry = studentRepository.save(larry);

	// 		Student jack = new Student("Jack Sparow",(byte) 19,"3th");
	// 		jack = studentRepository.save(jack);

	// 		Course course_one = new Course("Lógica de Programação");
	// 		Course course_two = new Course("Database");
	// 		Course course_tree = new Course("Java");
	// 		courseRepository.saveAll(Arrays.asList(course_one, course_two, course_tree));

	// 		larry.getCourses().addAll(Arrays.asList(course_one, course_two));
	// 		jack.getCourses().addAll(Arrays.asList(course_one, course_tree));
	// 		studentRepository.save(larry);
	// 		studentRepository.save(jack);
	// 	};
	// }

}
