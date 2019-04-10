package com.cs.instrumentmerge.rule;

import com.cs.instrumentmerge.model.Instrument;
import com.cs.instrumentmerge.model.Source;
import com.cs.instrumentmerge.utils.DateUtils;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LmeInstrumentLmePublisMergeRuleTest {
    private LmeInstrumentLmePublisMergeRule underTest;

    @Before
    public void setUp(){
        underTest = new LmeInstrumentLmePublisMergeRule(Source.LME.name());
    }

    @Test
    public void mergeInstruments() {
        List<Instrument> instruments = mock(List.class);
        Stream<Instrument> stream = mock(Stream.class);
        when(instruments.stream()).thenReturn(stream);
        Instrument instrument = new Instrument(DateUtils.stringToDate("15-03-2018"), DateUtils.stringToDate("17-03-2018"), "PB", "Lead 13 March 2018", false);
        instrument.setSource(Source.LME.name());
        when(stream.findFirst()).thenReturn(Optional.of(instrument));
        Instrument response = underTest.mergeInstruments(instruments);
        assertEquals(true, response.getTradable());
    }

    @Test
    public void isApplicable() {
        List<Instrument> instruments = mock(List.class);
        when(instruments.size()).thenReturn(1);
        assertTrue(underTest.isApplicable(instruments, Source.LME.name()));
    }
}