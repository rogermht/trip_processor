package com.littlepay;

import java.time.LocalDateTime;
import com.littlepay.Constants.*;
import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvCustomBindByPosition;

/**
 * author:  Roger Ting
 * date: 2019-04-20
 * description:
 * An instance of this class represents a transaction
 */
public class TransactionBean {

    @CsvBindByPosition(position = 0)
    private long id;
    @CsvCustomBindByPosition(converter = CSVLocalDateTimeConverter.class, position = 1)
    private LocalDateTime tapTime;
    @CsvCustomBindByPosition(converter = CSVTapTypeConverter.class, position = 2)
    private TapType tapType;
    @CsvCustomBindByPosition(converter = CSVStopTypeConverter.class, position = 3)
    private Stops stopId;
    @CsvBindByPosition(position = 4)
    private String companyId;
    @CsvBindByPosition(position = 5)
    private String busId;
    @CsvBindByPosition(position = 6)
    private long pan;


    public TransactionBean() {

    }

    /**
     * All getter and setter
     */
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getTapTime() {
        return tapTime;
    }

    public void setTapTime(LocalDateTime tapTime) {
        this.tapTime = tapTime;
    }

    public TapType getTapType() {
        return tapType;
    }

    public void setTapType(TapType tapType) {
        this.tapType = tapType;
    }

    public Stops getStopId() {
        return stopId;
    }

    public void setStopId(Stops stopId) {
        this.stopId = stopId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getBusId() {
        return busId;
    }

    public void setBusId(String busId) {
        this.busId = busId;
    }

    public long getPan() {
        return pan;
    }

    public void setPan(long pan) {
        this.pan = pan;
    }

}
