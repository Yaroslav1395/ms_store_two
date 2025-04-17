package sakhno.springframework.msstoretwo.ms_store_two_config_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class MsStoreTwoConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsStoreTwoConfigServerApplication.class, args);
    }

}
