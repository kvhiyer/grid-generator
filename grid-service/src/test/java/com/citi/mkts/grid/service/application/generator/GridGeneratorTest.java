package com.citi.mkts.grid.service.application.generator;

import com.citi.mkts.domain.model.Grid;
import com.citi.mkts.grid.service.application.dao.GridWriter;
import com.citi.mkts.grid.service.strategy.grid.GridContext;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class GridGeneratorTest {

    private GridGenerator sut;

    @Captor
    ArgumentCaptor argCaptorGridContext;

    @Mock
    private GridContext gridContext;

    @Mock
    private GridWriter gridWriter;

    @Mock
    private Grid mockGrid;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Before
    public void before() {
        sut = new GridGenerator(gridContext, gridWriter);
    }

    @Test
    public void testRegularFlow() throws IOException {
        when(gridContext.executeGridStrategy(anyInt())).thenReturn(mockGrid);
        sut.run("100");
        verify(gridContext).executeGridStrategy((Integer) argCaptorGridContext.capture());
        assertThat((Integer)argCaptorGridContext.getAllValues().get(0), is(100));
        verify(gridWriter, times(1)).write(mockGrid);
    }

    @Test
    public void checkForEmptyArguments() throws IOException {
        exceptionRule.expect(NullPointerException.class);
        sut.run(null);
    }

    @Test
    public void cehckForOnlyOneArgument() throws IOException {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage("Expected only one argument");
        sut.run("a", "b");
    }
}