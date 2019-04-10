package com.cs.instrumentmerge.service;

import com.cs.instrumentmerge.model.Instrument;
import com.cs.instrumentmerge.model.Source;
import com.cs.instrumentmerge.rule.IMergeRule;
import com.cs.instrumentmerge.rule.LmeAndPrimeInstrumentLmePublishMergeRule;
import com.cs.instrumentmerge.rule.LmeAndPrimeInstrumentPrimePublishMergeRule;
import com.cs.instrumentmerge.rule.LmeInstrumentLmePublisMergeRule;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InstrumentMergeService{
    private Set<IMergeRule> mergeRules = new HashSet<>();
    public InstrumentMergeService(){
        mergeRules.add(new LmeInstrumentLmePublisMergeRule(Source.LME.name()));
        mergeRules.add(new LmeAndPrimeInstrumentLmePublishMergeRule(Source.LME.name()));
        mergeRules.add(new LmeAndPrimeInstrumentPrimePublishMergeRule(Source.PRIME.name()));
    }

    public Instrument mergeInstruments(List<Instrument> instruments, String publisher) {
        Instrument instrument = null;
        for (IMergeRule mergeRule : mergeRules){
            if(mergeRule.isApplicable(instruments, publisher)){
                instrument = mergeRule.mergeInstruments(instruments);
            }
        }
        return  instrument;
    }

}
