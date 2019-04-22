package com.littlepay;

import org.junit.Test;

import static org.junit.Assert.*;


/**
 * author:  Roger Ting
 * date: 2019-04-20
 * description:
 * Unit test Stop pair cost Singleton instance
 */
public class StopPairCostReferenceTest {

    @Test
    public void getStopPairCost() {
        double cost = StopPairCostReference.getInstance().getStopPairCost(Constants.Stops.Stop1,Constants.Stops.Stop2);
        assertTrue(cost == 3.25);
        cost = StopPairCostReference.getInstance().getStopPairCost(Constants.Stops.Stop2,Constants.Stops.Stop1);
        assertTrue(cost == 3.25);
    }
}