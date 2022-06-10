package com.example.samplespringcloudclient1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@SpringBootApplication
public class SampleSpringCloudClient1Application {

	public static void main(String[] args) {
		SpringApplication.run(SampleSpringCloudClient1Application.class, args);
	}

}

class Person {
	public String name;
	public Integer age;

	public Person(String name, Integer age) {
		this.name = name;
		this.age = age;
	}
}

@RestController
class PersonResources {
	@GetMapping(value = "/api/persons", produces = MediaType.APPLICATION_JSON_VALUE)
	public Flux<Person> getPersons() {

		return Flux.just(
				new Person("Abud", 20),
				new Person("Budi", 21),
				new Person("Caca", 22)
		);
	}
}
