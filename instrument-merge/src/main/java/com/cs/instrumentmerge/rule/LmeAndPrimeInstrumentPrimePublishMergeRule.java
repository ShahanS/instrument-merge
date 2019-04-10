package com.cs.instrumentmerge.rule;

import com.cs.instrumentmerge.model.Instrument;
import com.cs.instrumentmerge.model.Source;

import java.util.List;

public class LmeAndPrimeInstrumentPrimePublishMergeRule implements IMergeRule {

    private String publisher;

    public LmeAndPrimeInstrumentPrimePublishMergeRule(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public Instrument mergeInstruments(List<Instrument> instruments) {
        Instrument lmeInstrument = null;
        Instrument primeInstrument = null;
        for (Instrument instrument : instruments) {
            if (Source.LME.name().equals(instrument.getSource())) {
                lmeInstrument = instrument;
            } else if (Source.PRIME.name().equals(instrument.getSource())) {
                primeInstrument = instrument;
            }
        }
        return new Instrument(lmeInstrument.getLastTradingDate(), lmeInstrument.getDeliveryDate(), "PB", lmeInstrument.getLabel(), primeInstrument.getTradable());
    }

    @Override
    public boolean isApplicable(List<Instrument> instruments, String publisher) {
        return instruments.size() == 2 && this.publisher.equals(publisher);
    }

}