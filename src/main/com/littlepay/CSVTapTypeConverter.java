package com.littlepay;

import com.littlepay.Constants.TapType;
import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;

/**
 * author:  Roger Ting
 * date: 2019-04-20
 * description:
 * Converter to convert CSV Tap type string to internal Tap type enum type
 */
public class CSVTapTypeConverter extends AbstractBeanField {
    @Override
    protected Object convert(String s) throws CsvDataTypeMismatchException, CsvConstraintViolationException {
        return TapType.valueOf(s);
    }
}
