package com.littlepay;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * author:  Roger Ting
 * date: 2019-04-20
 * description:
 * Runner to run all unit tests
 */
public class TestRunner {

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(JunitTestSuite.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        if(result.wasSuccessful()) System.out.println("All test cases pass!");
    }
}
