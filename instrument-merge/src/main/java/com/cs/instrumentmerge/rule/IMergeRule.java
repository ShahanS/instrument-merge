package com.cs.instrumentmerge.rule;

import com.cs.instrumentmerge.model.Instrument;

import java.util.List;

public interface IMergeRule {
    Instrument mergeInstruments(List<Instrument> instruments);
    boolean isApplicable(List<Instrument> instruments, String publisher);
}
