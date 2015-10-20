package com.nullpointer.avlasov.currencyrate.beans.services.impl;

import com.nullpointer.avlasov.currencyrate.beans.RateDate;
import com.nullpointer.avlasov.currencyrate.beans.data.info.CurrencyRate;
import com.nullpointer.avlasov.currencyrate.beans.data.manager.DataManager;
import com.nullpointer.avlasov.currencyrate.beans.services.CurrencyRateService;
import com.nullpointer.avlasov.currencyrate.cache.JCSCache;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.*;

/**
 * Created by Alex Vlasov on 15.10.15.
 */

@Service("currencyRateService")
@Transactional
public class CurrencyRateServiceImpl implements CurrencyRateService {

    Logger log = Logger.getLogger(CurrencyRateServiceImpl.class);


    private static long lastDailyCacheUpdate;
    private static JCSCache<RateDate, Map<String, CurrencyRate>> cache;

    @Autowired
    DataManager manager;

    @PostConstruct
    private void init() {
        try {
            lastDailyCacheUpdate = 0;
            cache = new JCSCache(CACHE_NAME);
        } catch (Exception e) {
            log.error(e);
            throw new RuntimeException(e);
        }
    }

    public Map<String, CurrencyRate> getRates(RateDate date) {
        Map<String, CurrencyRate> rates = new HashMap();
        Calendar cal = java.util.Calendar.getInstance();
        if(new RateDate().equals(date)) {
            if ((cal.getTimeInMillis() - DAILY_CACHE_UPDATE_INTERVAL) > lastDailyCacheUpdate) {
                lastDailyCacheUpdate = cal.getTimeInMillis();
                rates = manager.getRates(date);
                cache.put(date, rates);
            } else {
                rates = cache.get(date);
            }
        } else {
            rates = cache.get(date);
            if(rates == null) {
                rates = manager.getRates(date);
                cache.put(date, rates);
            }
        }
        return rates;
    }



}
