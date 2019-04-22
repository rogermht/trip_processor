package com.littlepay;

import java.util.HashMap;
import java.util.Map;
import com.littlepay.Constants.Stops;

/**
 * author:  Roger Ting
 * date: 2019-04-20
 * description:
 * Singleton class to store the statically initialized pre- calculated stop max cost
 */
public class StopMaxCostReference {

    // Static map for each stop max cost
    private static final Map<Stops, Double> TRIP_MAX_COST;

    static {
        TRIP_MAX_COST = new HashMap<Stops, Double>();
        TRIP_MAX_COST.put(Stops.Stop1, 7.3);
        TRIP_MAX_COST.put(Stops.Stop2, 5.5);
        TRIP_MAX_COST.put(Stops.Stop3, 7.3);
    }

    private StopMaxCostReference() {
        // Private constructor
    }

    // Singleton class for StopMaxCostReference
    private static final StopMaxCostReference instance = new StopMaxCostReference();


    //  Get the singleton instance
    public static StopMaxCostReference getInstance() {
        return instance;
    }

    // Get stop max cost
    public Double getStopMaxCost(Stops stopName) {
        return TRIP_MAX_COST.getOrDefault(stopName, null);
    }


}
