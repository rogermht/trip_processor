package com.littlepay;

import org.junit.Test;

import static org.junit.Assert.*;


/**
 * author:  Roger Ting
 * date: 2019-04-20
 * description:
 * Unit test Stop max cost Singleton instance
 */
public class StopMaxCostReferenceTest {

    @Test
    public void getStopMaxCost() {
        double cost = StopMaxCostReference.getInstance().getStopMaxCost(Constants.Stops.Stop2);
        assertTrue(cost == 5.5);
        cost = StopMaxCostReference.getInstance().getStopMaxCost(Constants.Stops.Stop3);
        assertTrue(cost == 7.3);
    }
}