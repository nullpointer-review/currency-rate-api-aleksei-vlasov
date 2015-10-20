package com.nullpointer.avlasov.currencyrate.beans.data.manager.cbr;

/**
 * Created by Alex Vlasov on 19.10.15.
 */


import com.nullpointer.avlasov.currencyrate.beans.RateDate;
import com.nullpointer.avlasov.currencyrate.beans.data.info.CurrencyRate;
import com.nullpointer.avlasov.currencyrate.beans.data.info.cbr.ValCurs;
import com.nullpointer.avlasov.currencyrate.beans.data.manager.DataManager;
import com.nullpointer.avlasov.currencyrate.beans.data.mapping.AbstractMapper;
import com.nullpointer.avlasov.currencyrate.beans.data.mapping.CBRMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.net.URL;
import java.util.Date;
import java.util.Map;

@Repository("dataManager")
public class CBRDataManagerImpl implements DataManager<RateDate> {

    Logger log = Logger.getLogger(CBRDataManagerImpl.class);
    public static final String CBR_URL = "http://www.cbr.ru/scripts/XML_daily.asp?";

    public Map<String, CurrencyRate> getRates(RateDate date) {
        String dateParam = "date_req=" + date.format(RateDate.DatePattern.CBR_HYPHEN_PATTERN.getPattern());
        return getRates(CBR_URL + dateParam);
    }

    private Map<String, CurrencyRate> getRates(String url) {
        Map<String, CurrencyRate> rates = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(ValCurs.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            ValCurs valutes = (ValCurs) jaxbUnmarshaller.unmarshal(new URL(url));
            if(valutes.getValutes() == null) throw new Exception("List of valutes is null");
            AbstractMapper mapper = new CBRMapper();
            rates = mapper.process(valutes);
        } catch (Exception e) {
            log.error(e);
        }

        return rates;
    }

}
