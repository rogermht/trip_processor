package com.littlepay;

import java.time.LocalDateTime;
import java.time.Duration;
import com.littlepay.Constants.*;

/**
 * author:  Roger Ting
 * date: 2019-03-31
 * desciption:
 * This class represent trip bean
 */
public class TripBean {


    private LocalDateTime startedTapTime;
    private LocalDateTime finishedTapTime;
    private Stops fromStopId;
    private Stops toStopId;
    private Double chargeAmount;
    private String companyId;
    private String busId;
    private long pan;
    private TripStatus status;


    public TripBean(){}


    /**
     * All the getters and setters
     */
    public long getDurationSecs(){
        if (finishedTapTime != null && startedTapTime != null){
            return Duration.between( startedTapTime, finishedTapTime).getSeconds();
        }

        return 0;
    }

    public LocalDateTime getStartedTapTime() {
        return startedTapTime;
    }

    public LocalDateTime getFinishededTapTime() {
        return finishedTapTime;
    }

    public Stops getFromStopId() {
        return fromStopId;
    }

    public Stops getToStopId() {
        return toStopId;
    }

    public Double getChargeAmount() {
        return chargeAmount;
    }

    public String getCompanyId() {
        return companyId;
    }

    public String getBusId() {
        return busId;
    }

    public long getPan() {
        return pan;
    }

    public TripStatus getStatus() {
        return status;
    }

    public void setStartedTapTime(LocalDateTime startedTapTime) {
        this.startedTapTime = startedTapTime;
    }

    public void setFinishedTapTime(LocalDateTime finishedTapTime) {
        this.finishedTapTime = finishedTapTime;
    }

    public void setFromStopId(Stops fromStopId) {
        this.fromStopId = fromStopId;
    }

    public void setToStopId(Stops toStopId) {
        this.toStopId = toStopId;
    }

    public void setChargeAmount(Double chargeAmount) {
        this.chargeAmount = chargeAmount;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public void setBusId(String busId) {
        this.busId = busId;
    }

    public void setPan(long pan) {
        this.pan = pan;
    }

    public void setStatus(TripStatus status) {
        this.status = status;
    }


}
