package com.mohit.SampleApp;

// import com.mohit.SampleApp.Entity.Student;
// import com.mohit.SampleApp.Repository.StudentRepository;
// import com.mohit.SampleApp.Service.StudentService;
// import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.context.annotation.Bean;
// import java.util.Map;

@SpringBootApplication
public class SampleAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleAppApplication.class, args);

	}
//	@Bean
//	CommandLineRunner runner(StudentRepository repository) {
//		return args -> {
//			Student student1 = new Student();
//			student1.setName("John Doe");
//			student1.setEmail("john.doe@example.com");
//			student1.setAge(21);
//			student1.setMarks(Map.of("Math", 95, "Science", 88, "English", 92, "Nepali", 78));
//
//			Student student2 = new Student();
//			student2.setName("Jane Smith");
//			student2.setEmail("jane.smith@example.com");
//			student2.setAge(22);
//			student2.setMarks(Map.of("Math", 75, "Science", 82, "English", 85, "Nepali", 65));
//
//			repository.save(student1);
//			repository.save(student2);
//		};
//
//	}



}
