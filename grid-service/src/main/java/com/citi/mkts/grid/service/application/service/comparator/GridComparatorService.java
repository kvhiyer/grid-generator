package com.citi.mkts.grid.service.application.service.comparator;

import com.citi.mkts.grid.service.application.compare.GridComparator;
import com.citi.mkts.grid.service.application.config.compare.GridComparatorConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({GridComparatorConfig.class})
@ComponentScan
public class GridComparatorService {

    @Autowired
    private GridComparator gridComparator;

    public static void main(String[] args) {
        SpringApplication.run(GridComparatorService.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> gridComparator.compareGridDataSets();
    }
}
