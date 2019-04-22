package com.littlepay;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


/**
 * author:  Roger Ting
 * date: 2019-04-20
 * description:
 * Unit test trip calculator
 */
public class TripBeanListCalculatorTest {

    TripBeanListCalculator tripBeanListCalculator;
    @Before
    public void setUp() throws Exception {
        tripBeanListCalculator = new TripBeanListCalculator();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void calculateTripBeanListComplete() {

        ArrayList<TransactionBean> transactionBeanArrayList = new ArrayList<TransactionBean>();
        TransactionBean transactionBean1 = new TransactionBean();
        TransactionBean transactionBean2 = new TransactionBean();

        transactionBean1.setBusId("1");
        transactionBean1.setCompanyId("1");
        transactionBean1.setId(1);
        transactionBean1.setStopId(Constants.Stops.Stop1);
        transactionBean1.setTapTime(LocalDateTime.of(2019,4,21,11,00,00));
        transactionBean1.setTapType(Constants.TapType.ON);
        transactionBean1.setPan(10000);

        transactionBean2.setBusId("1");
        transactionBean2.setCompanyId("1");
        transactionBean2.setId(2);
        transactionBean2.setStopId(Constants.Stops.Stop2);
        transactionBean2.setTapTime(LocalDateTime.of(2019,4,21,11,10,00));
        transactionBean2.setTapType(Constants.TapType.OFF);
        transactionBean2.setPan(10000);

        transactionBeanArrayList.add(transactionBean1);
        transactionBeanArrayList.add(transactionBean2);

        List<TripBean> actualTripBeanList=null;
        try {
            actualTripBeanList = tripBeanListCalculator.calculateTripBeanList(transactionBeanArrayList);
        }
        catch (Exception e){

        }

        Assert.assertNotEquals(actualTripBeanList, null);

        TripBean tripBean = actualTripBeanList.get(0);
        Assert.assertNotEquals(tripBean, null);
        Assert.assertTrue(tripBean.getChargeAmount().doubleValue()==3.25);
        Assert.assertTrue(tripBean.getDurationSecs()==600);
        Assert.assertTrue(tripBean.getFromStopId()== Constants.Stops.Stop1);
        Assert.assertTrue(tripBean.getToStopId()== Constants.Stops.Stop2);
        Assert.assertTrue(tripBean.getStatus()== Constants.TripStatus.Completed);
    }

    @Test
    public void calculateTripBeanListCancelled() {

        ArrayList<TransactionBean> transactionBeanArrayList = new ArrayList<TransactionBean>();
        TransactionBean transactionBean1 = new TransactionBean();
        TransactionBean transactionBean2 = new TransactionBean();

        transactionBean1.setBusId("1");
        transactionBean1.setCompanyId("1");
        transactionBean1.setId(1);
        transactionBean1.setStopId(Constants.Stops.Stop1);
        transactionBean1.setTapTime(LocalDateTime.of(2019,4,21,11,00,00));
        transactionBean1.setTapType(Constants.TapType.ON);
        transactionBean1.setPan(10000);

        transactionBean2.setBusId("1");
        transactionBean2.setCompanyId("1");
        transactionBean2.setId(2);
        transactionBean2.setStopId(Constants.Stops.Stop1);
        transactionBean2.setTapTime(LocalDateTime.of(2019,4,21,11,10,00));
        transactionBean2.setTapType(Constants.TapType.OFF);
        transactionBean2.setPan(10000);

        transactionBeanArrayList.add(transactionBean1);
        transactionBeanArrayList.add(transactionBean2);

        List<TripBean> actualTripBeanList=null;
        try {
            actualTripBeanList = tripBeanListCalculator.calculateTripBeanList(transactionBeanArrayList);
        }
        catch (Exception e){

        }

        Assert.assertNotEquals(actualTripBeanList, null);

        TripBean tripBean = actualTripBeanList.get(0);
        Assert.assertNotEquals(tripBean, null);
        Assert.assertTrue(tripBean.getChargeAmount().doubleValue()==0);
        Assert.assertTrue(tripBean.getDurationSecs()==600);
        Assert.assertTrue(tripBean.getFromStopId()== Constants.Stops.Stop1);
        Assert.assertTrue(tripBean.getToStopId()== Constants.Stops.Stop1);
        Assert.assertTrue(tripBean.getStatus()== Constants.TripStatus.Cancelled);
    }

    @Test
    public void calculateTripBeanListIncompleteDoubleOn() {

        ArrayList<TransactionBean> transactionBeanArrayList = new ArrayList<TransactionBean>();
        TransactionBean transactionBean1 = new TransactionBean();
        TransactionBean transactionBean2 = new TransactionBean();

        transactionBean1.setBusId("1");
        transactionBean1.setCompanyId("1");
        transactionBean1.setId(1);
        transactionBean1.setStopId(Constants.Stops.Stop1);
        transactionBean1.setTapTime(LocalDateTime.of(2019,4,21,11,00,00));
        transactionBean1.setTapType(Constants.TapType.ON);
        transactionBean1.setPan(10000);


        transactionBean2.setBusId("1");
        transactionBean2.setCompanyId("1");
        transactionBean2.setId(2);
        transactionBean2.setStopId(Constants.Stops.Stop2);
        transactionBean2.setTapTime(LocalDateTime.of(2019,4,21,11,10,00));
        transactionBean2.setTapType(Constants.TapType.ON);
        transactionBean2.setPan(10000);


        transactionBeanArrayList.add(transactionBean1);
        transactionBeanArrayList.add(transactionBean2);

        List<TripBean> actualTripBeanList=null;
        try {
            actualTripBeanList = tripBeanListCalculator.calculateTripBeanList(transactionBeanArrayList);
        }
        catch (Exception e){

        }

        Assert.assertNotEquals(actualTripBeanList, null);

        TripBean tripBean = actualTripBeanList.get(0);
        Assert.assertNotEquals(tripBean, null);
        Assert.assertTrue(tripBean.getChargeAmount().doubleValue()==7.3);
        Assert.assertTrue(tripBean.getDurationSecs()==0);
        Assert.assertTrue(tripBean.getFromStopId()== Constants.Stops.Stop1);
        Assert.assertTrue(tripBean.getStatus()== Constants.TripStatus.Incomplete);
    }

    @Test
    public void calculateTripBeanListIncompleteNoOff() {

        ArrayList<TransactionBean> transactionBeanArrayList = new ArrayList<TransactionBean>();
        TransactionBean transactionBean1 = new TransactionBean();

        transactionBean1.setBusId("1");
        transactionBean1.setCompanyId("1");
        transactionBean1.setId(1);
        transactionBean1.setStopId(Constants.Stops.Stop1);
        transactionBean1.setTapTime(LocalDateTime.of(2019,4,21,11,00,00));
        transactionBean1.setTapType(Constants.TapType.ON);

        transactionBeanArrayList.add(transactionBean1);

        List<TripBean> actualTripBeanList=null;
        try {
            actualTripBeanList = tripBeanListCalculator.calculateTripBeanList(transactionBeanArrayList);
        }
        catch (Exception e){

        }

        Assert.assertNotEquals(actualTripBeanList, null);

        TripBean tripBean = actualTripBeanList.get(0);
        Assert.assertNotEquals(tripBean, null);
        Assert.assertTrue(tripBean.getChargeAmount().doubleValue()==7.3);
        Assert.assertTrue(tripBean.getDurationSecs()==0);
        Assert.assertTrue(tripBean.getFromStopId()== Constants.Stops.Stop1);
        Assert.assertTrue(tripBean.getStatus()== Constants.TripStatus.Incomplete);
    }

}