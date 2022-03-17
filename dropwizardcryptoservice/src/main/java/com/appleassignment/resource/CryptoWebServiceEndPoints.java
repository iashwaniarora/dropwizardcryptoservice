package com.appleassignment.resource;

import com.appleassignment.model.DecryptResponse;
import com.appleassignment.model.PushAndRecalculateResponse;
import com.appleassignment.model.PushRecalculateAndEncryptResponse;
import com.appleassignment.resource.businesslogic.ProcessLogic;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Resource class containing all the three rest end points.
 */
@Path("/crypto")
@Produces(MediaType.APPLICATION_JSON)
public class CryptoWebServiceEndPoints {

    private final ProcessLogic processLogic;

    public CryptoWebServiceEndPoints( ProcessLogic processLogic) {
        this.processLogic = processLogic;
    }

    @GET
    @Path("/pushandrelocate")
    public PushAndRecalculateResponse pushAndRelocate(@QueryParam("number") int number) {
        List<Double> responseList = processLogic.calculateAverageAndSD(number);
        return new PushAndRecalculateResponse(responseList.get(0),responseList.get(1));//first element is average and the second one is standard deviation.
    }
    @GET
    @Path("/pushrecalculateandencrypt")
    public PushRecalculateAndEncryptResponse pushRecalculateAndEncrypt(@QueryParam("number") int number) {
        List<Double> responseList = processLogic.calculateAverageAndSD(number);//Use the exiting method to get the response and then call encrypt method.
        String encryptedAverage =  processLogic.getEncryptedText(String.valueOf(responseList.get(0)));
        String encryptedSD =  processLogic.getEncryptedText(String.valueOf(responseList.get(1)));
        return new PushRecalculateAndEncryptResponse(encryptedAverage, encryptedSD);
    }
    @GET
    @Path("/decrypt")
    public DecryptResponse decrypt(@QueryParam("encryptedText") String encryptedText) {
        return new DecryptResponse(Double.valueOf(processLogic.getDecryptedText(encryptedText)));//Returning double instead of String as double value is expected in the response.
    }


}
