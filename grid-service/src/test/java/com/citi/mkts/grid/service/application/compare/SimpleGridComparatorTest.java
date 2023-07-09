package com.citi.mkts.grid.service.application.compare;

import com.opencsv.exceptions.CsvException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SimpleGridComparatorTest {

    private SimpleGridComparator sut;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    /**
     * Compare two grid data where file contents are in diff order.
     */
    public void testGridDataComparatorThatHasSameFileContentsInDifferentOrder() throws URISyntaxException, IOException, CsvException {
        sut = new SimpleGridComparator(Paths.get(getClass().getResource("/grid/TestGridData.csv").toURI()), Paths.get(getClass().getResource("/grid/ExpectedGrid.csv").toURI()));
        assertTrue(sut.compareGridDataSets());
    }

    @Test
    /**
     * Compare two grid data where file contents don't match.
     */
    public void testGridDataComparatorWhereFileContentsDontMatch() throws URISyntaxException, IOException, CsvException {
        sut = new SimpleGridComparator(Paths.get(getClass().getResource("/grid/DifferetDataSetForGrid.csv").toURI()), Paths.get(getClass().getResource("/grid/ExpectedGrid.csv").toURI()));
        assertFalse(sut.compareGridDataSets());
    }

    @Test
    public void testEmptyFile() throws URISyntaxException, IOException, CsvException {
        sut = new SimpleGridComparator(Paths.get(getClass().getResource("/grid/NoGridData.csv").toURI()), Paths.get(getClass().getResource("/grid/ExpectedGrid.csv").toURI()));
        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("Empty File. Hence can't compare Grid Data.");
        sut.compareGridDataSets();
    }

    @Test
    public void testInvalidFilePath() throws URISyntaxException, IOException, CsvException {
        sut = new SimpleGridComparator(Paths.get("some unknown path"), Paths.get(getClass().getResource("/grid/ExpectedGrid.csv").toURI()));
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage("Invalid Path provided");
        sut.compareGridDataSets();
    }
}