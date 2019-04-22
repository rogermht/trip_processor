package com.littlepay;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import static java.lang.System.exit;

/**
 * author:  Roger Ting
 * date: 2019-03-31
 * desciption:
 * LittlePayProcessor driver function
 */
public class LittlePayProcessor {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage:java littlepay <tap filename>");
            exit(1);
        }

        String tapFileName = args[0];
        Path path = Paths.get(tapFileName);
        TransactionCsvToBeanListParser parser = new TransactionCsvToBeanListParser();
        List<TransactionBean> transactionBeanList = null;
        List<TripBean> tripBeanList = null;

        try {
            transactionBeanList = parser.parse(path);
            TripBeanListCalculator calculator = new TripBeanListCalculator();
            tripBeanList = calculator.calculateTripBeanList(transactionBeanList);
            if (tripBeanList != null) {
                // Print out the result
                Path outputCSVPath = Paths.get("trips.csv");
                TripBeanListToCSVPrinter tripBeanListToCSVPrinter = new TripBeanListToCSVPrinter();
                tripBeanListToCSVPrinter.print(outputCSVPath,tripBeanList);
            }
        } catch (Exception e) {
            System.out.println("Error in parsing CSV:" + e.getMessage());
            exit(1);
        }


    }
}
