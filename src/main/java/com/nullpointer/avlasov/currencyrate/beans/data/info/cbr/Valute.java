package com.nullpointer.avlasov.currencyrate.beans.data.info.cbr;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by Alex Vlasov on 15.10.15.
 */

public class Valute {

    private String numCode;
    private String charCode;
    private String nominal;
    private String name;
    private String value;

    @XmlElement(name = "NumCode")
    public String getNumCode() {
        return numCode;
    }

    public void setNumCode(String numCode) {
        this.numCode = numCode;
    }

    @XmlElement(name = "CharCode")
    public String getCharCode() {
        return charCode;
    }

    public void setCharCode(String charCode) {
        this.charCode = charCode;
    }

    @XmlElement(name = "Nominal")
    public String getNominal() {
        return nominal;
    }

    public void setNominal(String nominal) {
        this.nominal = nominal;
    }

    @XmlElement(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "Value")
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}

