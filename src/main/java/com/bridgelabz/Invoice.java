package com.bridgelabz;

import java.util.Objects;

public class Invoice {
    private  int totalRides;
    private  double totalFare;
    private  double averageFare;


    public Invoice(int totalRides, double totalFare, double averageFare){
        this.totalRides = totalRides;
        this.totalFare = totalFare;
        this.averageFare = averageFare;
    }

    public int getTotalRides() {
        return totalRides;
    }

    public double getTotalFare() {
        return totalFare;
    }

    public double getAverageFare() {
        return averageFare;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return totalRides == invoice.totalRides && Double.compare(invoice.totalFare, totalFare) == 0 && Double.compare(invoice.averageFare, averageFare) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalRides, totalFare, averageFare);
    }
    @java.lang.Override
    public java.lang.String toString() {
        return "InvoiceSummary{" +
                "numofRides=" + totalRides +
                ", totalFare=" + totalFare +
                ", avrageFare=" + averageFare +
                '}';
    }
}
