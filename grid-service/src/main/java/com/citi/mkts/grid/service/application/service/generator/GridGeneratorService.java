package com.citi.mkts.grid.service.application.service.generator;

import com.citi.mkts.grid.service.application.generator.GridGenerator;
import com.citi.mkts.grid.service.application.config.generator.GridGeneratorConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;


@SpringBootApplication
@Import({GridGeneratorConfig.class, GridGenerator.class})
@ComponentScan
public class GridGeneratorService {
    @Autowired
    private GridGenerator gridGenerator;

    public static void main(String[] args) {
        SpringApplication.run(GridGeneratorService.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> gridGenerator.run(args);
    }
}