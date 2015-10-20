package com.nullpointer.avlasov.currencyrate.beans.data.mapping;

import com.nullpointer.avlasov.currencyrate.beans.data.info.CurrencyRate;

import java.util.List;
import java.util.Map;

/**
 * Created by Alex Vlasov on 19.10.15.
 */
public interface AbstractMapper<T> {

    Map<String, CurrencyRate> process(T o);

}
