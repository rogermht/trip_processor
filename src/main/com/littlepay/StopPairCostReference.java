package com.littlepay;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.littlepay.Constants.Stops;

/**
 * author:  Roger Ting
 * date: 2019-04-20
 * description:
 * This utilizes Google Guava library for composite key hashmap to get the stop pair cost
 */
public class StopPairCostReference {


    // Static map for each stop pair cost
    private static final Table<Stops, Stops, Double> TRIP_PAIR_COST;

    static {
        TRIP_PAIR_COST = HashBasedTable.create();
        TRIP_PAIR_COST.put(Stops.Stop1, Stops.Stop2, 3.25);
        TRIP_PAIR_COST.put(Stops.Stop2, Stops.Stop3, 5.50);
        TRIP_PAIR_COST.put(Stops.Stop3, Stops.Stop1, 7.30);
    }

    private StopPairCostReference() {
        // Private constructor
    }

    // Singleton class for StopMaxCostReference
    private static final StopPairCostReference instance = new StopPairCostReference();


    public static StopPairCostReference getInstance() {
        //  Get the singleton instance
        return instance;
    }

    public Double getStopPairCost(Stops stop1, Stops stop2) {
        // Unordered pair of stop names as key to retrieve cost
        Double pair1cost = TRIP_PAIR_COST.get(stop1, stop2);
        Double pair2cost = TRIP_PAIR_COST.get(stop2, stop1);
        if (pair1cost != null){
            return pair1cost;
        } else if (pair2cost != null) {
            return pair2cost;
        }

        return null;
    }


}
