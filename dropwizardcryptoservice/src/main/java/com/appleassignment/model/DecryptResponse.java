package com.appleassignment.model;

/**
 * Model class for Decrypt response.
 */
public class DecryptResponse {
    private double number;

    public DecryptResponse(double number) {
        this.number = number;
    }

    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
    }


    public DecryptResponse() {
        // Jackson deserialization
    }


}