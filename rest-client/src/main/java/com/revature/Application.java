package com.revature;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.revature.entities.Role;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		RestTemplate rt = new RestTemplate();
		String url = "http://localhost:8000/roles";
		ResponseEntity<Role[]> response = rt.getForEntity(url, Role[].class);

		Role[] roles = response.getBody();
		System.out.println(Arrays.toString(roles));
		System.out.println("status " + response.getStatusCode());
	}

}
