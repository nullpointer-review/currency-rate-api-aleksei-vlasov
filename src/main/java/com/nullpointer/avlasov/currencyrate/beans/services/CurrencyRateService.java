package com.nullpointer.avlasov.currencyrate.beans.services;

import com.nullpointer.avlasov.currencyrate.beans.RateDate;
import com.nullpointer.avlasov.currencyrate.beans.data.info.CurrencyRate;

import java.util.Date;
import java.util.Map;

/**
 * Created by Alex Vlasov on 15.10.15.
 */
public interface CurrencyRateService {

    public static final String CACHE_NAME = "CURRENCY_RATE_CACHE";
    public static final long DAILY_CACHE_UPDATE_INTERVAL = 90000L;

    public Map<String, CurrencyRate> getRates(RateDate date);

}
