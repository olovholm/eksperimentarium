package net.lovholm.eksperimentarium.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages = "net.lovholm")
@EnableJpaRepositories(basePackages ={"net.lovholm"})
@EntityScan(basePackages = {"net.lovholm"})
public class AppServer {

    public static void main(String[] args) {
        SpringApplication.run(AppServer.class, args);
    }



}