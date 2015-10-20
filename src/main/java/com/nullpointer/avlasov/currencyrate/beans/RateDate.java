package com.nullpointer.avlasov.currencyrate.beans;

import org.apache.log4j.Logger;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Alex Vlasov on 19.10.15.
 */

public class RateDate implements Serializable {

    private static final Logger log = Logger.getLogger(RateDate.class);

    public enum DatePattern {
        INTERNAL_PATTERN("yyyy-MM-dd"), CBR_DOT_PATTERN("dd.MM.yyyy"), CBR_HYPHEN_PATTERN("dd-MM-yyyy");
        private String pattern;

        DatePattern(String pattern) {
            this.pattern = pattern;
        }

        public String getPattern() {
            return pattern;
        }
    }

    private String date;

    public RateDate(String date, String pattern) {
        try {
            SimpleDateFormat userFormat = new SimpleDateFormat(pattern);
            SimpleDateFormat internalFormat = new SimpleDateFormat(DatePattern.INTERNAL_PATTERN.getPattern());
            this.date = internalFormat.format(userFormat.parse(date));
        } catch (Exception e) {
            log.error(e);
            throw new RuntimeException(e);
        }
    }

    public RateDate() {
        init(Calendar.getInstance().getTime());
    }


    public RateDate(Date date) {
        init(date);
    }

    private void init(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(DatePattern.INTERNAL_PATTERN.getPattern());
        try {
            this.date = sdf.format(date);
        } catch (Exception e) {
            log.error(e);
            throw new RuntimeException(e);
        }
    }

    public String format(String pattern) {
        SimpleDateFormat userFormat = new SimpleDateFormat(pattern);
        SimpleDateFormat internalFormat = new SimpleDateFormat(DatePattern.INTERNAL_PATTERN.getPattern());
        String result = null;
        try {
            result =  userFormat.format(internalFormat.parse(date));
        } catch (Exception e) {
            log.debug(e);
        }
        return result;
    }


    public String getDate() {
        return this.date;
    }

    @Override
    public int hashCode() {
        return date.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof RateDate))
            return false;
        return date.equals(((RateDate) obj).date);
    }

}
