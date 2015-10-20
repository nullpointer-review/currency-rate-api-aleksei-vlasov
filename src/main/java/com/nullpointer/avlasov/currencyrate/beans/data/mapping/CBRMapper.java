package com.nullpointer.avlasov.currencyrate.beans.data.mapping;

import com.nullpointer.avlasov.currencyrate.beans.RateDate;
import com.nullpointer.avlasov.currencyrate.beans.data.info.CurrencyRate;
import com.nullpointer.avlasov.currencyrate.beans.data.info.cbr.ValCurs;
import com.nullpointer.avlasov.currencyrate.beans.data.info.cbr.Valute;
import com.sun.rowset.internal.WebRowSetXmlReader;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alex Vlasov on 19.10.15.
 */
public class CBRMapper implements AbstractMapper<ValCurs> {

    public Map<String, CurrencyRate> process(ValCurs cbrVals) {

        String date = getDate(cbrVals.getDate());
        Map<String, CurrencyRate> rates = new HashMap<String, CurrencyRate>();
        for (Valute cbrVal : cbrVals.getValutes()) {
            CurrencyRate rate = process(cbrVal, date);
            rates.put(rate.getCode(), rate);
        }
        return rates;
    }

    public CurrencyRate process(Valute cbrValute, String date) {
        CurrencyRate rate = new CurrencyRate();
        rate.setCode(cbrValute.getCharCode());
        rate.setDate(date);
        rate.setRate(Double.parseDouble(cbrValute.getValue().replaceAll(",",".")) / Integer.parseInt(cbrValute.getNominal().replaceAll(",",".")));
        return rate;
    }


    private String getDate(String date) {
        RateDate internal = null;
        try {
            internal = new RateDate(date, RateDate.DatePattern.CBR_HYPHEN_PATTERN.getPattern());
        } catch (Exception e) {
            internal = new RateDate(date, RateDate.DatePattern.CBR_DOT_PATTERN.getPattern());
        }
        return internal.getDate();
    }
}
