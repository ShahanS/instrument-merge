package com.cs.instrumentmerge.rule;

import com.cs.instrumentmerge.model.Instrument;
import com.cs.instrumentmerge.model.Source;
import com.cs.instrumentmerge.utils.DateUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LmeAndPrimeInstrumentPrimePublishMergeRuleTest {

    private LmeAndPrimeInstrumentPrimePublishMergeRule underTest;

    @Before
    public void setUp() {
        underTest = new LmeAndPrimeInstrumentPrimePublishMergeRule(Source.PRIME.name());
    }


    @Test
    public void mergeInstruments() {
        List<Instrument> instruments = new ArrayList<>();
        Instrument lmeInstrument1 = new Instrument(DateUtils.stringToDate("15-03-2018"), DateUtils.stringToDate("17-03-2018"), "LME_PB", "Lead 13 March 2018", false);
        lmeInstrument1.setSource(Source.LME.name());
        Instrument primeInstrument = new Instrument(DateUtils.stringToDate("15-03-2018"), DateUtils.stringToDate("17-03-2018"), "LME_PB", "Lead 13 March 2018", false);
        primeInstrument.setSource(Source.PRIME.name());
        primeInstrument.setExchangeCode("PB_03_2018");
        instruments.add(lmeInstrument1);
        instruments.add(primeInstrument);
        Instrument response = underTest.mergeInstruments(instruments);
        assertEquals(false, response.getTradable());

    }

    @Test
    public void isApplicable() {
        List<Instrument> instruments = mock(List.class);
        when(instruments.size()).thenReturn(2);
        assertTrue(underTest.isApplicable(instruments, Source.PRIME.name()));
    }
}