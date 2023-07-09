package com.citi.mkts.grid.service.application.compare;

import com.citi.mkts.domain.model.GridFeedFileRow;
import com.citi.mkts.domain.model.MarketDimension;
import com.citi.mkts.domain.model.MarketFact;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SimpleGridComparator implements GridComparator {

    Logger logger = LoggerFactory.getLogger(SimpleGridComparator.class);
    private static final String PIPE = "\\|";

    private final Path pathOfInputToBeValidated;
    private final Path actualGridDataPath;
    public SimpleGridComparator(Path pathOfInputToBeValidated, Path actualGridDataPath) {
        this.pathOfInputToBeValidated = pathOfInputToBeValidated;
        this.actualGridDataPath = actualGridDataPath;
    }

    @Override
    public boolean compareGridDataSets() throws IOException, CsvException {
        validateFilePaths(pathOfInputToBeValidated, actualGridDataPath);
        Map<LocalDate, Map<Long, Pair<MarketFact, MarketDimension>>> inputGridData = extractGridData(pathOfInputToBeValidated);
        Map<LocalDate, Map<Long, Pair<MarketFact, MarketDimension>>> actualGridData = extractGridData(actualGridDataPath);
        logger.info("The total number of entries in the input file to be validated is {}", inputGridData.values().stream().flatMap(map -> map.values().stream()).mapToInt(i -> 1).sum());
        logger.info("The total number of entries in the actual  file is {}", actualGridData.values().stream().flatMap(map -> map.values().stream()).mapToInt(i -> 1).sum());
        return inputGridData.equals(actualGridData);
    }

    private Map<LocalDate, Map<Long, Pair<MarketFact, MarketDimension>>> extractGridData(Path path) throws IOException, CsvException {
        try (Reader reader = Files.newBufferedReader(path)) {
            try (CSVReader csvReader = new CSVReader(reader)) {
                List<String[]> lines = csvReader.readAll();
                if (CollectionUtils.isEmpty(lines)) {
                    throw new RuntimeException("Empty File. Hence can't compare Grid Data.");
                }
                return lines.stream()
                        .map(this::convertToGridFeedFileRow)
                        .collect(Collectors.groupingBy(GridFeedFileRow::getGridDate,
                                    Collectors.groupingBy(GridFeedFileRow::getId,
                                        Collectors.reducing(null, row -> Pair.of(row.getMarketFact(), row.getMarketDimension()), (old, curr) -> curr))));
            }
        }
    }

    private GridFeedFileRow convertToGridFeedFileRow(String[] row) {
        return GridFeedFileRow.aGridFeedFileRowBuilder()
                .gridDate(LocalDate.parse(row[0]))
                .id(Long.parseLong(row[1]))
                .marketFact(buildMarketFact(row[2]))
                .marketDimension(buildMarketDimension(row[3]))
                .build();
    }

    private MarketFact buildMarketFact(String marketFactCol) {
        int[] marketFactAttributes = Arrays.stream(marketFactCol.split(PIPE)).mapToInt(Integer::parseInt).toArray();
        return MarketFact.aMarketFactBuilder()
                .age(marketFactAttributes[0])
                .height(marketFactAttributes[1])
                .weight(marketFactAttributes[2])
                .build();
    }

    private MarketDimension buildMarketDimension(String marketDimensionCol) {
        String[] marketDimensionAttributes = marketDimensionCol.split(PIPE);
        return MarketDimension.aMarketDimensionBuilder()
                .gender(marketDimensionAttributes[0])
                .city(marketDimensionAttributes[1])
                .build();
    }

    private void validateFilePaths(Path inputFeedPath, Path generatedFeedPath) {
        validatePath(inputFeedPath);
        validatePath(generatedFeedPath);
    }

    private void validatePath(Path path) {
        if (Files.notExists(path)) {
            throw new IllegalArgumentException("Invalid Path provided");
        }
    }
}
