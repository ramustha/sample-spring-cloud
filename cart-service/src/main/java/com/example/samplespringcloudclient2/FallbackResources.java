package com.example.samplespringcloudclient2;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
class FallbackResources {

  @GetMapping(value = "/fallback", produces = MediaType.APPLICATION_JSON_VALUE)
  public Mono<Map<String, Object>> defaultFallback() {
    return Mono.just(Map.of("fallback", "client2"));
  }

}
