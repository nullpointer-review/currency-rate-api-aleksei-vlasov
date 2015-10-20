import com.nullpointer.avlasov.currencyrate.beans.RateDate;
import com.nullpointer.avlasov.currencyrate.beans.data.info.CurrencyRate;
import com.nullpointer.avlasov.currencyrate.beans.data.info.cbr.ValCurs;
import com.nullpointer.avlasov.currencyrate.beans.data.info.cbr.Valute;
import com.nullpointer.avlasov.currencyrate.beans.services.CurrencyRateService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

public class CurrencyRateServiceTest {

    private static CurrencyRateService service;

    public static final String USD_CODE = "USD";

    @BeforeClass
    public static void prepareData() {
        ApplicationContext context = new FileSystemXmlApplicationContext("/src/main/resources/beans.xml");
        service = (CurrencyRateService) context.getBean("currencyRateService");
    }

    @Test
    public void getCurrentRates() {
        StringBuffer out = new StringBuffer();
        Map<String, CurrencyRate> rates = service.getRates(new RateDate());
        Assert.assertNotNull(rates);
        for (Map.Entry<String, CurrencyRate> entry: rates.entrySet()) {
            Assert.assertNotNull(entry);
            Assert.assertNotNull(entry.getValue());
            out.append(entry.getValue().toString()).append("\n");
        }
        System.out.println(out);
    }

    @Test
    public void getPastRates() {
        StringBuffer out = new StringBuffer();
        String date = "2010-09-24";
        Map<String, CurrencyRate> rates = service.getRates(new RateDate(date, RateDate.DatePattern.INTERNAL_PATTERN.getPattern()));
        Assert.assertNotNull(rates);
        for (Map.Entry<String, CurrencyRate> entry: rates.entrySet()) {
            Assert.assertNotNull(entry);
            Assert.assertNotNull(entry.getValue());
            out.append(entry.getValue().toString()).append("\n");
        }
        System.out.println(out);
    }

    @Test
    public void getPastRateByCode() {
        StringBuffer out = new StringBuffer();
        String date = "2010-09-24";
        Map<String, CurrencyRate> rates = service.getRates(new RateDate(date, RateDate.DatePattern.INTERNAL_PATTERN.getPattern()));
        Assert.assertNotNull(rates);
        out.append(rates.get(USD_CODE).toString());
        System.out.println(out);
    }

    @Test
    public void getCurrentRateByCode() {
        StringBuffer out = new StringBuffer();
        Map<String, CurrencyRate> rates = service.getRates(new RateDate());
        Assert.assertNotNull(rates);
        out.append(rates.get(USD_CODE).toString());
        System.out.println(out);
    }

    @Test
    public void test() {
         Double.parseDouble(new String("343434.34343"));
    }

    @Test
    public void marshall() {
        try {
            ValCurs curs = new ValCurs();
            List<Valute> vals = new ArrayList<Valute>();
            Valute v1 = new Valute();
            v1.setCharCode("USD");
            v1.setName("NAME");
            v1.setValue("4545.5");
            Valute v2 = new Valute();
            v2.setCharCode("RUB");
            v2.setName("NAME1");
            v2.setValue("3445.5");
            vals.add(v1);
            vals.add(v2);
            curs.setValutes(vals);
            JAXBContext jaxbContext = JAXBContext.newInstance(ValCurs.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.marshal(curs, new File("/marshall.xml"));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
