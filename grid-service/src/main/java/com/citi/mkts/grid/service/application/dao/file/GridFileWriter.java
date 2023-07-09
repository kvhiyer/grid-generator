package com.citi.mkts.grid.service.application.dao.file;

import com.citi.mkts.domain.model.Grid;
import com.citi.mkts.domain.model.MarketDimension;
import com.citi.mkts.domain.model.MarketFact;
import com.citi.mkts.grid.service.application.dao.GridWriter;
import com.opencsv.CSVWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GridFileWriter implements GridWriter {

    Logger logger = LoggerFactory.getLogger(GridFileWriter.class);
    private final Path filePath;

    public GridFileWriter(Path filePath) {
        this.filePath = filePath;
    }

    @Override
    public void write(Grid grid) throws IOException {
        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath.toFile()))) {
            List<String[]> csvFormattedLines = new ArrayList<>(); // If memory is a concern then stream line by line into the file.
            grid.getGridDetail().entrySet().forEach(entry -> {
                        LocalDate key = entry.getKey();
                        entry.getValue().entrySet().forEach(innerEntry -> {
                            MarketFact marketFact = innerEntry.getValue().getLeft();
                            MarketDimension marketDimension = innerEntry.getValue().getRight();
                            csvFormattedLines.add(new String[]{key.toString(), Long.toString(innerEntry.getKey()), marketFact.marketFact(), marketDimension.marketDimension()});
                        });
                    }
            );
            logger.info("The number of lines that'll be written into the Grid file is {}", csvFormattedLines.size());
            writer.writeAll(csvFormattedLines);
        }
    }
}