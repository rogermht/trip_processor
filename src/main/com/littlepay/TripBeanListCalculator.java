package com.littlepay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.littlepay.Constants.*;

/**
 * author:  Roger Ting
 * date: 2019-04-20
 * description:
 * Calculate a list of trip from a list of transactions.
 * Four cases:
 * - Complete (tap on and tap off with different stop
 * - Cancelled (tap on and tap off with same stop)
 * - Incomplete (with tap on and no more tap on/off)
 * - Incomplete (with tap on and another tap on)
 */
public class TripBeanListCalculator {

    private StopPairCostReference stopPairCostReference = StopPairCostReference.getInstance();
    private StopMaxCostReference stopMaxCostReference = StopMaxCostReference.getInstance();

    // Calculate the trip bean
    // Assume tap on must precede tap off for each user
    public List<TripBean> calculateTripBeanList(List<TransactionBean> transactionBeanList) throws Exception {
        List<TripBean> tripBeanList = new ArrayList<TripBean>();
        Map<Long, TripBean> panToTripBeanMap = new HashMap<>();

        for (TransactionBean transactionBean : transactionBeanList) {

            if (panToTripBeanMap.containsKey(transactionBean.getPan())) {
                // The user has  previous tap on
                TripBean tripBean = panToTripBeanMap.get(transactionBean.getPan());
                // Push into TripBean List
                tripBeanList.add(tripBean);
                // Pop off from map
                panToTripBeanMap.remove(transactionBean.getPan());
                if (transactionBean.getTapType() == TapType.OFF) {
                    // This tap is tap off
                    tripBean.setFinishedTapTime(transactionBean.getTapTime());
                    tripBean.setToStopId(transactionBean.getStopId());
                    if (tripBean.getFromStopId() == transactionBean.getStopId()) {
                        // Cancelled trip type - zero charge - case 2
                        tripBean.setStatus(TripStatus.Cancelled);
                        tripBean.setChargeAmount(0.0);
                    } else {
                        // Complete trip type - case 1
                        tripBean.setStatus(TripStatus.Completed);
                        Double stopPairCost = stopPairCostReference.getStopPairCost(tripBean.getFromStopId(),
                                tripBean.getToStopId());
                        tripBean.setChargeAmount(stopPairCost);
                    }
                } else {
                    // Special case of incomplete trip where user has two consecutive Tap On - case 4
                    tripBean.setStatus(TripStatus.Incomplete);
                    Double stopMaxCost = stopMaxCostReference.getStopMaxCost(tripBean.getFromStopId());
                    tripBean.setChargeAmount(stopMaxCost);
                    TripBean newTripBean = createNewTripBean(transactionBean);
                    panToTripBeanMap.put(transactionBean.getPan(), newTripBean);
                }
            } else {
                // user has no previous tap on
                if (transactionBean.getTapType() != TapType.ON) {
                    throw new Exception("Tap off must precede tap on");
                }
                TripBean tripBean = createNewTripBean(transactionBean);
                panToTripBeanMap.put(transactionBean.getPan(), tripBean);
            }
        }

        // Now Hashmap now has orphan Tap
        for (TripBean tripBean : panToTripBeanMap.values()) {
            // No matching tap off - case 3
            tripBean.setStatus(TripStatus.Incomplete);
            Double stopMaxCost = stopMaxCostReference.getStopMaxCost(tripBean.getFromStopId());
            tripBean.setChargeAmount(stopMaxCost);
            tripBeanList.add(tripBean);
        }

        return tripBeanList;
    }

    //   Create new TripBean from transaction Bean
    private TripBean createNewTripBean(TransactionBean transactionBean) {

        TripBean tripBean = new TripBean();
        tripBean.setStartedTapTime(transactionBean.getTapTime());
        tripBean.setFromStopId(transactionBean.getStopId());
        tripBean.setCompanyId(transactionBean.getCompanyId());
        tripBean.setBusId(transactionBean.getBusId());
        tripBean.setPan(transactionBean.getPan());


        return tripBean;
    }
}
