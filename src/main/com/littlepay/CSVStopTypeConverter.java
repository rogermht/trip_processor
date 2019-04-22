package com.littlepay;

import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.littlepay.Constants.Stops;

/**
 * author:  Roger Ting
 * date: 2019-04-20
 * description:
 * Converter to convert CSV Stop type string to internal Stop type enum type
 */
public class CSVStopTypeConverter extends AbstractBeanField {
    @Override
    protected Object convert(String s) throws CsvDataTypeMismatchException, CsvConstraintViolationException {
        return Stops.valueOf(s);
    }
}
