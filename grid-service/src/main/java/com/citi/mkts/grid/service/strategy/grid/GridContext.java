package com.citi.mkts.grid.service.strategy.grid;

import com.citi.mkts.domain.model.Grid;

public class GridContext {

    private final GridStrategy gridStrategy;

    public GridContext(GridStrategy gridStrategy) {
        this.gridStrategy = gridStrategy;
    }

    public Grid executeGridStrategy(Integer numberOfGridItems) {
        return gridStrategy.generateGridDetails(numberOfGridItems);
    }
}