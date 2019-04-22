package com.littlepay;

import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CSVLocalDateTimeConverter extends AbstractBeanField {
    @Override
    protected Object convert(String s) throws CsvDataTypeMismatchException, CsvConstraintViolationException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constants.littlepayDateTimeFormat);
        LocalDateTime parsedLocalDateTime = LocalDateTime.parse(s, formatter);
        return parsedLocalDateTime;
    }
}
