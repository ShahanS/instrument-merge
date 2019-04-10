package com.cs.instrumentmerge.model;

import com.cs.instrumentmerge.utils.DateUtils;
import org.junit.Test;

import static org.junit.Assert.*;

public class InstrumentTest {

    @Test
    public void toStringTest() {
        Instrument lmeInstrument1 = new Instrument(DateUtils.stringToDate("15-03-2018"), DateUtils.stringToDate("17-03-2018"), "LME_PB", "Lead 13 March 2018", false);
        assertEquals("Instrument{lastTradingDate='15-03-2018', deliverySate='17-03-2018', market='LME_PB', label='Lead 13 March 2018', tradable=false}", lmeInstrument1.toString());
    }
}