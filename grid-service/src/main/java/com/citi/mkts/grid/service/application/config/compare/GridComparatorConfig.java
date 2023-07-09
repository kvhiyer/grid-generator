package com.citi.mkts.grid.service.application.config.compare;

import com.citi.mkts.grid.service.application.compare.GridComparator;
import com.citi.mkts.grid.service.application.compare.SimpleGridComparator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.file.Paths;

@Configuration
public class GridComparatorConfig {

    @Value("${valid.file.path}")
    private String validFilePath;

    @Value("${input.file.path.to.be.validated}")
    private String inputFilePathToBeValidated;

    @Bean
    public GridComparator gridComparator() {
        return new SimpleGridComparator(Paths.get(inputFilePathToBeValidated), Paths.get(validFilePath));
    }

}
