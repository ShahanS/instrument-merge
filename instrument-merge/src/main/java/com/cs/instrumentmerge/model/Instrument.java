package com.cs.instrumentmerge.model;

import com.cs.instrumentmerge.utils.DateUtils;

import java.util.Date;

public class Instrument {
    private Date lastTradingDate;
    private Date deliveryDate;
    private String market;
    private String label;
    private Boolean tradable;
    private String source;
    private String exchangeCode;

    public Instrument(Date lastTradingDate, Date deliveryDate, String market, String label, Boolean tradable) {
        this.lastTradingDate = lastTradingDate;
        this.deliveryDate = deliveryDate;
        this.market = market;
        this.label = label;
        this.tradable = tradable;
    }

    public Date getLastTradingDate() {
        return lastTradingDate;
    }

    public void setLastTradingDate(Date lastTradingDate) {
        this.lastTradingDate = lastTradingDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Boolean getTradable() {
        return tradable;
    }

    public void setTradable(Boolean tradable) {
        this.tradable = tradable;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getExchangeCode() {
        return exchangeCode;
    }

    public void setExchangeCode(String exchangeCode) {
        this.exchangeCode = exchangeCode;
    }

    @Override
    public String toString() {
        return "Instrument{" +
                "lastTradingDate='" + DateUtils.dateToString(lastTradingDate) + '\'' +
                ", deliverySate='" + DateUtils.dateToString(deliveryDate) + '\'' +
                ", market='" + market + '\'' +
                ", label='" + label + '\'' +
                ", tradable=" + tradable +
                '}';
    }

}
