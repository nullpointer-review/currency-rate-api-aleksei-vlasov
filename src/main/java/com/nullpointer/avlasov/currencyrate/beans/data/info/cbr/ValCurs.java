package com.nullpointer.avlasov.currencyrate.beans.data.info.cbr;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by Alex Vlasov on 19.10.15.
 */

@XmlRootElement(name="ValCurs")
public class ValCurs {

    private List<Valute> valutes = null;

    private String date;

    @XmlElement(name = "Valute")
    public List<Valute> getValutes() {
        return valutes;
    }

    public void setValutes(List<Valute> valutes) {
        this.valutes = valutes;
    }

    @XmlAttribute(name = "Date")
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
