package com.littlepay;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        StopPairCostReferenceTest.class,
        StopMaxCostReferenceTest.class,
        TripBeanListCalculatorTest.class
})

public class JunitTestSuite {
}
