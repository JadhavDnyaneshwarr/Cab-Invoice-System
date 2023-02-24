package com.bridgelabz;

import java.util.List;
import java.util.Map;

public class CabInvoice {
    static final double COST_PER_KM = 10;
    static final double PREMIUM_RIDE_COST_PER_KM = 15;
    static final double COST_PER_MIN = 1;
    static final double PREMIUM_RIDE_COST_PER_MIN = 2;
    static final double MIN_FARE = 5;
    static final double MIN_FARE_PREMIUM = 20;
    private RideRepository rideRepository;


    public CabInvoice() {
        this.rideRepository = new RideRepository();
    }


    public double calculateFare(double distance, double time) {
        double fare = COST_PER_KM * distance + COST_PER_MIN * time;
        return  fare < MIN_FARE ? MIN_FARE: fare;
    }

    public double calculateFare(Ride[] rides) {
        double aggregateFare = 0;
        for (Ride ride: rides) {
            double fare =calculateFare(ride.getDistance(), ride.getTime());
            aggregateFare += fare;
        }
        return aggregateFare;
    }

    public Invoice generateInvoice(Ride[] rides) {
        int totalRides = rides.length;
        double totalFare = calculateFare(rides);
        double averageFare = totalFare/totalRides;
        return new Invoice(totalRides, totalFare, averageFare);
    }

    public void addRides(String userId, Ride[] rides) {
        rideRepository.addRide(userId, rides);
    }

    public Invoice getInvoice(String userId) {
        return this.generateInvoice(rideRepository.getRides(userId));
    }
    public double calculateRideFare(String rideType, double distance, int time) {
        double totalFare =0;
        if (rideType.equalsIgnoreCase("Normal")){
            totalFare = COST_PER_KM * distance + COST_PER_MIN * time;
            return totalFare < MIN_FARE ? MIN_FARE : totalFare;
        }else {
            totalFare = PREMIUM_RIDE_COST_PER_KM * distance + PREMIUM_RIDE_COST_PER_MIN * time;
            return totalFare < MIN_FARE ? MIN_FARE_PREMIUM : totalFare;
        }
    }
}
