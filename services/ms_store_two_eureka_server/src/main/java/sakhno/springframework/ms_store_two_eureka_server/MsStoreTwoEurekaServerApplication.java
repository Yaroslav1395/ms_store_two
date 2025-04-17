package sakhno.springframework.ms_store_two_eureka_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MsStoreTwoEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsStoreTwoEurekaServerApplication.class, args);
	}

}
