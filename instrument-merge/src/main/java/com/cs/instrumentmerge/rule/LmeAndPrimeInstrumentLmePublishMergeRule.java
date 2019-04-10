package com.cs.instrumentmerge.rule;

import com.cs.instrumentmerge.model.Instrument;

import java.util.List;

public class LmeAndPrimeInstrumentLmePublishMergeRule implements IMergeRule {

    private String publisher;

    public LmeAndPrimeInstrumentLmePublishMergeRule(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public Instrument mergeInstruments(List<Instrument> instruments) {
        Instrument instrument = instruments.stream().filter(i -> i.getSource().equals("LME")).findFirst().get();
        instrument.setTradable(true);
        return instrument;
    }

    @Override
    public boolean isApplicable(List<Instrument> instruments, String publisher) {
        return instruments.size() == 2 && this.publisher.equals(publisher);
    }
}
