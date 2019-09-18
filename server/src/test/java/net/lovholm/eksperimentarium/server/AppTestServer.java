package net.lovholm.eksperimentarium.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages = "net.lovholm")
@EnableJpaRepositories(basePackages ={"net.lovholm"})
@EntityScan(basePackages = {"net.lovholm"})
public class AppTestServer {
    public static void main(String[] args) {
        SpringApplication.run(AppTestServer.class, args);
    }

}