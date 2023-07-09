package com.citi.mkts.grid.service.application.compare;

import com.opencsv.exceptions.CsvException;

import java.io.IOException;

@FunctionalInterface
public interface GridComparator {

    boolean compareGridDataSets() throws IOException, CsvException;
}
