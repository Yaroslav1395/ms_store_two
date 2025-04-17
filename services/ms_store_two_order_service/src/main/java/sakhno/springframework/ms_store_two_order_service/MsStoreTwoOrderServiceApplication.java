package sakhno.springframework.ms_store_two_order_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableFeignClients
@EnableJpaAuditing
public class MsStoreTwoOrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsStoreTwoOrderServiceApplication.class, args);
	}

}
