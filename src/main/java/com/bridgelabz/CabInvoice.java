package com.bridgelabz;

public class CabInvoice {
    static final double COST_PER_KM = 10;
    static final double COST_PER_MIN = 1;
    private RideRepository rideRepository;


    public CabInvoice() {
        this.rideRepository = new RideRepository();
    }
    public double calculateFare(double distance, double time) {
        double fare = COST_PER_KM * distance + COST_PER_MIN * time;
        return  fare < 5 ? 5: 5;
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
}
