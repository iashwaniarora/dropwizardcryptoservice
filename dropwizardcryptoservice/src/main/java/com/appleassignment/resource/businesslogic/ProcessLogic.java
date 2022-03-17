package com.appleassignment.resource.businesslogic;



import java.util.List;

/**
 * Interface to define what all methods Process logic will be using.
 */
public interface ProcessLogic {
    double calculateAverage(int number);
    double calculateStandardDeviation( int number);
    List<Double> calculateAverageAndSD(int number);
    String getEncryptedText(String plainText);
    String getDecryptedText(String encryptedText);

}
