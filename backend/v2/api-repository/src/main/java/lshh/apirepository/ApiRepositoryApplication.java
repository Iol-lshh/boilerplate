package lshh.apirepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ApiRepositoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRepositoryApplication.class, args);
	}

}