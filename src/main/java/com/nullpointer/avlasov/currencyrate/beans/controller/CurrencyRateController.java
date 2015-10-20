package com.nullpointer.avlasov.currencyrate.beans.controller;

import com.nullpointer.avlasov.currencyrate.beans.RateDate;
import com.nullpointer.avlasov.currencyrate.beans.data.info.CurrencyRate;
import com.nullpointer.avlasov.currencyrate.beans.services.CurrencyRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Map;

/**
 * Created by Alex Vlasov on 19.10.15.
 */

@RestController("currencyRateController")
@RequestMapping(value = "/currency/api/rate", produces = MediaType.APPLICATION_JSON_VALUE)
public class CurrencyRateController {

    @Autowired
    CurrencyRateService service;

    @RequestMapping(value = "/{code}", method = RequestMethod.GET)
    @ResponseBody
    public CurrencyRate getRate(@PathVariable String code) {
        Map<String, CurrencyRate> rates = service.getRates(new RateDate());
        return rates.get(code);
    }

    @RequestMapping(value = "/{code}/{date}", method = RequestMethod.GET)
    @ResponseBody
    public CurrencyRate getRate(@PathVariable String code, @PathVariable String date) {
        Map<String, CurrencyRate> rates = service.getRates(new RateDate(date, RateDate.DatePattern.INTERNAL_PATTERN.getPattern()));
        return rates.get(code);
    }

}
