package com.bridgelabz;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class CabInvoiceTest {
    CabInvoice cabInvoice;
    @Before
    public void setup(){
        cabInvoice = new CabInvoice();
    }

    @Test
    public void givenDistanceAndTimeShouldReturnFare(){
        double fare = cabInvoice.calculateFare(5, 2);
        Assert.assertEquals(52, fare, 0.0);
    }
    @Test
    public void givenMultipleRidesShouldReturnAggregateFare(){
        Ride rides[] = {new Ride(5, 2), new Ride(0.4, 0.5), new Ride(8, 5)};
        double fare = cabInvoice.calculateFare(rides);
        Assert.assertEquals(142, fare, 0.0);
    }
    @Test
    public void givenMultipleRidesShouldReturnInvoice(){
        Ride rides[] = {new Ride(5, 2), new Ride(1.4, 0.5), new Ride(8, 5)};
        Invoice actualInvoice = cabInvoice.generateInvoice(rides);
        Invoice expcetedInvoice = new Invoice(3, 151.5, 50.5);
        Assert.assertEquals(expcetedInvoice, actualInvoice);
    }
    @Test
    public void givenUserIdShouldReturnTheInvoice() {
        String userId = "abc@123";
        Ride[] rides = {new Ride(2.0, 5), new Ride(0.1, 1)};
        cabInvoice.addRides(userId, rides);
        Invoice summary = cabInvoice.getInvoice(userId);
        Invoice checkSummary = new Invoice(2, 30.0, 15.0);
        Assert.assertEquals(summary, checkSummary);
    }

    @Test
    public void givenRideTypeNormal_ShouldReturnFare(){
        double distance = 0.1;
        int time = 1;
        double fare = cabInvoice.calculateRideFare("NORMAL", distance, time);
        Assert.assertEquals(5, fare, 0.0);
    }
    @Test
    public void givenRideTypePremium_ShouldReturnFare() {
        double distance = 0.1;
        int time = 1;
        double fare = cabInvoice.calculateRideFare("PREMIUM", distance, time);
        Assert.assertEquals(20, fare, 0.0);
    }
}
