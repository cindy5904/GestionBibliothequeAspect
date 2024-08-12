package org.example.exogestionbibliotheque;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ExoGestionBibliothequeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExoGestionBibliothequeApplication.class, args);
    }

}
