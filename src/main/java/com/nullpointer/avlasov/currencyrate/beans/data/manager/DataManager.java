package com.nullpointer.avlasov.currencyrate.beans.data.manager;

import com.nullpointer.avlasov.currencyrate.beans.data.info.CurrencyRate;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Alex Vlasov on 19.10.15.
 */
public interface DataManager<Source> {

    Map<String, CurrencyRate> getRates(Source date);

}
