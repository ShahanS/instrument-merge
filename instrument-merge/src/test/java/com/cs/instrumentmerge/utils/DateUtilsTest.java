package com.cs.instrumentmerge.utils;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class DateUtilsTest {

    @Test
    public void dateToString() {
        assertEquals("15-03-2018", DateUtils.dateToString(DateUtils.stringToDate("15-03-2018")));
    }

    @Test
    public void stringToDate(){
        assertNull(DateUtils.stringToDate(""));
    }



}
