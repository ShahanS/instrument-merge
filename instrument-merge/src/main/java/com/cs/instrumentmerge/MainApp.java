package com.cs.instrumentmerge;

import com.cs.instrumentmerge.model.Instrument;
import com.cs.instrumentmerge.model.Source;
import com.cs.instrumentmerge.service.InstrumentMergeService;
import com.cs.instrumentmerge.utils.DateUtils;

import java.util.ArrayList;
import java.util.List;

public class MainApp {

    public static void main(String[] args) {
        InstrumentMergeService instrumentMergeService = new InstrumentMergeService();
        List<Instrument> lmeInstrumentLmePublisher = new ArrayList<>();
        Instrument lmeInstrument = new Instrument(DateUtils.stringToDate("15-03-2018"), DateUtils.stringToDate("17-03-2018"), "PB", "Lead 13 March 2018", false);
        lmeInstrument.setSource(Source.LME.name());
        lmeInstrumentLmePublisher.add(lmeInstrument);


        System.out.println(instrumentMergeService.mergeInstruments(lmeInstrumentLmePublisher, Source.LME.name()));
        List<Instrument> instruments = new ArrayList<>();
        Instrument lmeInstrument1 = new Instrument(DateUtils.stringToDate("15-03-2018"), DateUtils.stringToDate("17-03-2018"), "LME_PB", "Lead 13 March 2018", false);
        lmeInstrument1.setSource(Source.LME.name());
        Instrument primeInstrument = new Instrument(DateUtils.stringToDate("15-03-2018"), DateUtils.stringToDate("17-03-2018"), "LME_PB", "Lead 13 March 2018", false);
        primeInstrument.setSource(Source.PRIME.name());
        primeInstrument.setExchangeCode("PB_03_2018");
        instruments.add(lmeInstrument1);
        instruments.add(primeInstrument);
        System.out.println(instrumentMergeService.mergeInstruments(instruments, Source.LME.name()));
        System.out.println(instrumentMergeService.mergeInstruments(instruments, Source.PRIME.name()));
    }


}
