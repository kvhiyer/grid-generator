package com.citi.mkts.grid.service.application;

import com.citi.mkts.grid.service.application.service.generator.GridGeneratorService;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(
        args = "100",
        webEnvironment = SpringBootTest.WebEnvironment.NONE,
        classes = GridGeneratorService.class)
@ActiveProfiles("integration-test")
public class GridGeneratorServiceITCase {

    @Value("${file.path}")
    private String filePath;

    @After
    public void after() throws IOException {
        Files.delete(Path.of(filePath));
    }

    @Test
    public void testGridGeneratorService() throws URISyntaxException, IOException {
        assertTrue(FileUtils.contentEqualsIgnoreEOL(Paths.get(getClass().getResource("/grid/ExpectedGrid.csv").toURI()).toFile(), Paths.get(filePath).toFile(), null));
    }
}