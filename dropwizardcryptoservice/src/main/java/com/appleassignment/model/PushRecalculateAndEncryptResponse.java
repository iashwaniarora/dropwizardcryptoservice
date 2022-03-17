package com.appleassignment.model;

public class PushRecalculateAndEncryptResponse {
    private String average;
    private String standardDeviation;

    public String getAverage() {
        return average;
    }

    public void setAverage(String average) {
        this.average = average;
    }

    public String getStandardDeviation() {
        return standardDeviation;
    }

    public void setStandardDeviation(String standardDeviation) {
        this.standardDeviation = standardDeviation;
    }


    public PushRecalculateAndEncryptResponse(String average, String standardDeviation) {
        this.average = average;
        this.standardDeviation = standardDeviation;
    }


    public PushRecalculateAndEncryptResponse() {
        // Jackson deserialization
    }


}