package lux.hal;

import io.vanillabp.springboot.ModuleAndWorkerAwareSpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainContainer {
    public static void main(String[] args) {
        // SpringApplication.run(MainContainer.class, args);
        ModuleAndWorkerAwareSpringApplication.run(MainContainer.class, args);
    }
}