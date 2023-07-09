package com.citi.mkts.grid.service.application.dao;

import com.citi.mkts.domain.model.Grid;

import java.io.IOException;

@FunctionalInterface
public interface GridWriter {
    public void write(Grid grid) throws IOException;
}
