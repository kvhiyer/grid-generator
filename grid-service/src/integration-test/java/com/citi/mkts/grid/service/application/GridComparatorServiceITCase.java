package com.citi.mkts.grid.service.application;

import com.citi.mkts.grid.service.application.service.comparator.GridComparatorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.NONE,
        classes = GridComparatorService.class)
@ActiveProfiles("integration-test")
public class GridComparatorServiceITCase {

    @Test
    public void testGridGeneratorService() {
        // TODO -- different mechanisms to validate the prog run.
    }
}
