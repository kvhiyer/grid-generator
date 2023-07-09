package com.citi.mkts.grid.service.application.generator;

import com.citi.mkts.domain.model.Grid;
import com.citi.mkts.grid.service.application.dao.GridWriter;
import com.citi.mkts.grid.service.strategy.grid.GridContext;

import java.io.IOException;
import java.util.Objects;

public class GridGenerator {

    private final GridContext gridContext;

    private final GridWriter gridWriter;

    public GridGenerator(GridContext gridContext, GridWriter gridWriter) {
        this.gridContext = gridContext;
        this.gridWriter = gridWriter;
    }

    public void run(String... args) throws IOException {
        Objects.requireNonNull(args);
        if (args.length != 1) {
            throw new IllegalArgumentException("Expected only one argument");
        }
        Grid grid = gridContext.executeGridStrategy(Integer.parseInt(args[0]));
        gridWriter.write(grid);
    }
}
