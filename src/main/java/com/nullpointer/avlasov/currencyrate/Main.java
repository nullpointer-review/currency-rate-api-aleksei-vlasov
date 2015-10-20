package com.nullpointer.avlasov.currencyrate;

import com.nullpointer.avlasov.currencyrate.beans.services.CurrencyRateService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.util.Assert;

/**
 * Created by Alex Vlasov on 19.10.15.
 */
public class Main {

    public static void main(String[] args) {
        boolean arg = args != null && args.length == 1 && args[0] != null;
        if(!arg)
            throw new RuntimeException("Set input argument correctly");
        ApplicationContext context = new FileSystemXmlApplicationContext("/src/main/resources/beans.xml");
        CurrencyRateService service = (CurrencyRateService) context.getBean("currencyRateService");
    }

}
