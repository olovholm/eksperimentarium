package net.lovholm.eksperimentarium.server;

import net.lovholm.eksperimentarium.server.prosess.ServiceHandler;
import net.lovholm.eksperimentarium.server.prosess.TaskManager;
import org.h2.util.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;
import java.util.Map;


@SpringBootApplication(scanBasePackages = "net.lovholm")
@EnableJpaRepositories(basePackages ={"net.lovholm"})
@EntityScan(basePackages = {"net.lovholm"})
public class AppServer {

    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        taskManager.start();
        SpringApplication.run(AppServer.class, args);
    }



}
