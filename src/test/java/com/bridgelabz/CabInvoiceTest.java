package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

public class CabInvoiceTest {
    @Test
    public void givenDistanceAndTimeShouldReturnFare(){
        CabInvoice cabInvoice = new CabInvoice();
        double fare = cabInvoice.calculateFare(5, 2);
        Assert.assertEquals(5, fare, 0.0);
    }
    @Test
    public void givenMultipleRidesShouldReturnAggregateFare(){
        CabInvoice cabInvoice = new CabInvoice();
        Ride rides[] = {new Ride(5, 2), new Ride(0.4, 0.5), new Ride(8, 5)};
        double fare = cabInvoice.calculateFare(rides);
        Assert.assertEquals(15, fare, 0.0);
    }
    @Test
    public void givenMultipleRidesShouldReturnInvoice(){
        CabInvoice cabInvoice = new CabInvoice();
        Ride rides[] = {new Ride(5, 2), new Ride(0.4, 0.5), new Ride(8, 5)};
        Invoice actualInvoice = cabInvoice.generateInvoice(rides);
        Invoice expcetedInvoice = new Invoice(3, 15, 5);
        Assert.assertEquals(expcetedInvoice, actualInvoice);
    }
    @Test
    public void givenUserIdShouldReturnTheInvoice() {
        CabInvoice cabInvoice = new CabInvoice();
        String userId = "abc@123";
        Ride[] rides = {new Ride(2.0, 5), new Ride(0.1, 1)};
        cabInvoice.addRides(userId, rides);
        Invoice summary = cabInvoice.getInvoice(userId);
        Invoice checkSummary = new Invoice(2, 10.0, 5);
        Assert.assertEquals(summary, checkSummary);
    }
}
