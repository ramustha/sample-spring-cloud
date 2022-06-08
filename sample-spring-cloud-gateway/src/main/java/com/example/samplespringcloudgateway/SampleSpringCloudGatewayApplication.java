package com.example.samplespringcloudgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@SpringBootApplication
public class SampleSpringCloudGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleSpringCloudGatewayApplication.class, args);
	}

}

@RestController
class FallbackController {
	@GetMapping("/default-fallback")
	Flux<Void> getDefaultFallback() {
		return Flux.empty();
	}

}
