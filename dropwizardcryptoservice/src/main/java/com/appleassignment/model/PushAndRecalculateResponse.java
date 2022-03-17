package com.appleassignment.model;

/**
 * Model class for PushAndRecalculateResponse.
 */
public class PushAndRecalculateResponse {
    private double average;
    private double standardDeviation;


    public PushAndRecalculateResponse() {
    }

    public PushAndRecalculateResponse(double average, double standardDeviation) {
        this.average = average;
        this.standardDeviation = standardDeviation;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public double getStandardDeviation() {
        return standardDeviation;
    }

    public void setStandardDeviation(double standardDeviation) {
        this.standardDeviation = standardDeviation;
    }



}