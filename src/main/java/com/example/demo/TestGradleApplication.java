package com.example.demo;


import com.example.demo.model.EntityBt.Group;
import com.example.demo.model.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@SpringBootApplication
public class TestGradleApplication {

	public static void main(String[] args) {

		ApplicationContext context =SpringApplication.run(TestGradleApplication.class, args);
		int numberThread = 10;

		ExecutorService executor = Executors.newFixedThreadPool(numberThread);
		List<Future> futures = new ArrayList<>();
		for (int i = 0; i < numberThread; i++) {
			if (i < 1) {
				Callable<Person> task = new ThreadTest();
				Future<Person> future = executor.submit(task);
				futures.add(future);
			} else if (i == 1){
				Callable<List<Group>> test2 = context.getBean(ThreadTest2.class);
				Future<?> future = executor.submit(test2);
				futures.add(future);
			}else {
				System.out.println("thaidui");
			}


		}
		for (Future<?> future : futures) {
			try {
				// Use ObjectMapper to convert future result to Person object
				ObjectMapper objectMapper = new ObjectMapper();
				Object result = future.get();

				if (result instanceof Person) {
					Person deserializedPerson = objectMapper.convertValue(result, Person.class);
					if (deserializedPerson != null) {
						System.out.println("Successfully deserialized Person: " + deserializedPerson);
					} else {
						System.out.println("Failed to deserialize Person");
					}
				} else if (result instanceof List<?>) {
					// Handle List<Group> if necessary
					List<Group> groups = (List<Group>) result;
					// Process groups as needed
					System.out.println("Retrieved groups: " + groups.size());
				}
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}

			// Đóng ExecutorService sau khi sử dụng xong
			executor.shutdown();
		}
	}
}




