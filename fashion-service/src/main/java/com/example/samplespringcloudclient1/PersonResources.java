package com.example.samplespringcloudclient1;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
class PersonResources {
  @GetMapping(value = "/api/persons", produces = MediaType.APPLICATION_JSON_VALUE)
  public Flux<Person> getPersons() {

    return Flux.just(new Person("Abud", 20), new Person("Budi", 21), new Person("Caca", 22));
  }

}
