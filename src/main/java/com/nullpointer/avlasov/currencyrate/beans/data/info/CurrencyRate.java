package com.nullpointer.avlasov.currencyrate.beans.data.info;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Alex Vlasov on 19.10.15.
 */
public class CurrencyRate implements Serializable {

    private String code;
    private double rate;
    private String date;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "CurrencyRate{" +
                "code='" + code + '\'' +
                ", rate=" + rate +
                ", date=" + date +
                '}';
    }
}
