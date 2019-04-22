package com.littlepay;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import com.opencsv.bean.*;

/**
 * author:  Roger Ting
 * date: 2019-04-20
 * description:
 * A parser of transaction CSV file and build a list of transaction bean.
 */
public class TransactionCsvToBeanListParser {

    private Class transactionBeanClass = TransactionBean.class;
    private ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();


    // Parse the CSV file and return a list of transactionbean
    public List<TransactionBean> parse(Path csvPath) throws IOException {

        Reader reader = Files.newBufferedReader(csvPath);
        strategy.setType(transactionBeanClass);
        CsvToBean cb = new CsvToBeanBuilder(reader).withMappingStrategy(strategy).withType(transactionBeanClass).
                withSeparator(',').withIgnoreLeadingWhiteSpace(true).withSkipLines(1).build();
        List transactionBeanList = cb.parse();
        reader.close();
        return transactionBeanList;
    }




}
