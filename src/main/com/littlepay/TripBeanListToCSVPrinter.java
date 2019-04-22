package com.littlepay;


import com.opencsv.CSVWriter;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * author:  Roger Ting
 * date: 2019-04-20
 * description:
 * Print the CSV file given the list of Trips and file pointer
 */

public class TripBeanListToCSVPrinter {

    private static String[] csvHeading = new String[]{
            "Started",
            "Finished",
            "DurationSecs",
            "FromStopId",
            "ToStopId",
            "ChargeAmount",
            "CompanyId",
            "BusID",
            "PAN",
            "Status"
    };

    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(Constants.littlepayDateTimeFormat);

    public void print(Path outputCSVPath, List<TripBean> tripBeanList) throws IOException {
        Writer writer = Files.newBufferedWriter(outputCSVPath);
        CSVWriter csvWriter = new CSVWriter(writer,
                CSVWriter.DEFAULT_SEPARATOR,
                CSVWriter.NO_QUOTE_CHARACTER,
                CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                CSVWriter.DEFAULT_LINE_END);
        csvWriter.writeNext(csvHeading);
        ArrayList<String[]> lines = new ArrayList<String[]>();
        for(TripBean tripBean:tripBeanList){
            String[] line = getTripBeanLine(tripBean);
            lines.add(line);
        }
        csvWriter.writeAll(lines);
        csvWriter.flush();
    }

    private String[] getTripBeanLine(TripBean tripBean) {

        String[] line = new String[csvHeading.length];
        line[0] = dateTimeFormatter.format(tripBean.getStartedTapTime());
        line[1] = tripBean.getFinishededTapTime() == null ? "": dateTimeFormatter.format(tripBean.getFinishededTapTime());
        line[2] = Long.toString(tripBean.getDurationSecs());
        line[3] = tripBean.getFromStopId().toString();
        line[4] = tripBean.getToStopId() == null ? "" :tripBean.getToStopId().toString();
        line[5] = tripBean.getChargeAmount().toString();
        line[6] = tripBean.getCompanyId();
        line[7] = tripBean.getBusId();
        line[8] = Long.toString(tripBean.getPan());
        line[9] = tripBean.getStatus().toString();

        return line;
    }


}
