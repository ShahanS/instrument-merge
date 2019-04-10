package com.cs.instrumentmerge.rule;

import com.cs.instrumentmerge.model.Instrument;

import java.util.List;

public class LmeInstrumentLmePublisMergeRule implements IMergeRule {
    private String publisher;

    public LmeInstrumentLmePublisMergeRule(String publisher) {
        this.publisher = publisher;
    }


    @Override
    public Instrument mergeInstruments(List<Instrument> instruments) {
        return instruments.stream().findFirst().map(instrument -> {
            instrument.setTradable(true);
            return instrument;
        }).get();
    }

    @Override
    public boolean isApplicable(List<Instrument> instruments, String publisher) {
        return instruments.size() == 1 && this.publisher.equals(publisher);
    }
}
