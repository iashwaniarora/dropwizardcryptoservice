package com.appleassignment.resource.businesslogic;


import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;


/**
 * Concrete class defining the body for the Interface.
 *
 */
public class ProcessLogicImpl implements ProcessLogic {

    public static final String CRYPTO_ALGORITHM= "AES";
    DataStore dataStore = DataStore.getInstance(CRYPTO_ALGORITHM);//Singleton, ideally should have been DB to store key and the numbers.


    @Override
    public double calculateAverage(int number) {
        dataStore.getList().add(number);
        return average(dataStore);
    }

    @Override
    public double calculateStandardDeviation(int number) {
        double average = calculateAverage(number);
        int standardDeviation = 0;
        for (int num : dataStore.getList()) {
            standardDeviation += Math.pow(num - average, 2);
        }
        return Math.sqrt(standardDeviation / dataStore.getList().size());
    }

    /**
     * Add the number to the existing list and then calculate average and standard deviation
     * @param number
     * @return list with first element as average & the second element as standard deviation.
     */
    @Override
    public List<Double> calculateAverageAndSD(int number) {
        List<Double> list = new ArrayList<>();

        int sum = 0;
        double average;
        List<Integer> dataList = dataStore.getList();
        dataList.add(number);
        for (int num : dataList) {
            sum = sum + num;
        }
        average = (double) sum / (double) dataList.size();
        average = (double) Math.round(average * 1000) / 1000; //To get values upto 3 places of decimal.
        list.add(average);

        double standardDeviation = 0;
        for (int num : dataList) {
            standardDeviation += Math.pow(num - average, 2);
        }
        standardDeviation = Math.sqrt(standardDeviation / dataList.size());
        standardDeviation = (double) Math.round(standardDeviation * 1000) / 1000;
        list.add(standardDeviation);
        return list;
    }

    /**
     * Encrypt plain text.
     * @param plainText
     * @return encrypted base64 string .
     */
    @Override
    public String getEncryptedText(String plainText) {
        Cipher cipher = null;
        byte[] encryptedTextBytes = new byte[0];
        try {
            cipher = Cipher.getInstance(CRYPTO_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, dataStore.getSecretKey());
            encryptedTextBytes = cipher.doFinal(plainText.getBytes());

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();//TODO : Use logger
        } catch (InvalidKeyException e) {
            e.printStackTrace();//Use logger
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();//use logger
        } catch (BadPaddingException e) {
            e.printStackTrace();//use logger.
        }
        return Base64.getEncoder()
                .encodeToString(encryptedTextBytes);
    }

    /**
     * Decrypt the encrypted text.
     * @param encryptedText text already encrypted.
     * @return decrypted text.
     */
    @Override
    public String getDecryptedText(String encryptedText) {
        try {
            Cipher cipher = Cipher.getInstance("AES");//
            cipher.init(Cipher.DECRYPT_MODE, dataStore.getSecretKey());
            byte[] plainText = cipher.doFinal(Base64.getDecoder()
                    .decode(encryptedText));
            return new String(plainText);
        }catch (Exception e){
            System.out.println(e.getMessage());//TODO : Use logger.
        }
        return  null;
    }

    /**
     * Calculate average.
     * @param dataStore datastore for numbers and keys.
     * @return average of the numbers.
     */
    private double average(DataStore dataStore) {
        int sum = 0;
        for (int number : dataStore.getList()) {
            sum = sum + number;
        }
        return (double) sum / (double) dataStore.getList().size();
    }
}
