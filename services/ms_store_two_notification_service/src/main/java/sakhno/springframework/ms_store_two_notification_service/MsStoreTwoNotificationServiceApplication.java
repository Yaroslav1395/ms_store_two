package sakhno.springframework.ms_store_two_notification_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class MsStoreTwoNotificationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsStoreTwoNotificationServiceApplication.class, args);
	}

}
