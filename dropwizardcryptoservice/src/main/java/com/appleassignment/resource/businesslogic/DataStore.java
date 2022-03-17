package com.appleassignment.resource.businesslogic;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Ideally all the number should be stored on the persisted storage like DB ,
 * but for the assignment I am storing numbers in the list.
 * <p>
 * Secret Key again should be stored on the DB or in a secure place with another key(Double encryption).
 * For the Assignment purpose the secret key is not being encrypted.
 * <p>
 * Singleton Pattern is used here to avoid multiple objects with the operation on the list being thread safe.
 */
public class DataStore {
    private static DataStore instance;
    private List<Integer> numbers = Collections.synchronizedList(new ArrayList<Integer>()); //Synchronized list so that it is thread safe.
    private SecretKey secretKey = getKey() ;
    private static String CRYPTO_ALGORITHM;


    public static DataStore getInstance(String algorithm) {
        if (instance == null) {
            CRYPTO_ALGORITHM = algorithm;
            instance = new DataStore();
        }
        return instance;
    }

    private DataStore() {
    }

    public SecretKey getSecretKey() {
        return secretKey;
    }

    /**
     * Get random secret Key with AES Algorithm.
     * Everytime the server is started a new secretkey will be generated.
     * @return secretkey generated.
     */
    private SecretKey getKey() {
        KeyGenerator keyGen = null;
        try {
            keyGen = KeyGenerator.getInstance(CRYPTO_ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();//Use logger
        }
        SecureRandom secureRandom = new SecureRandom();//Generate secure random number .
        keyGen.init(secureRandom);//To make it more strong seed can also be used.
        return keyGen.generateKey();//Finally, generate the Key based on the random and the algorithm selected.
    }


    public List<Integer> getList() {
        return numbers;
    }
}
