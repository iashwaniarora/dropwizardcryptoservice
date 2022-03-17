package com.appleassignment.application;

import com.appleassignment.configuration.CryptoServiceConfiguration;
import com.appleassignment.resource.CryptoWebServiceEndPoints;
import com.appleassignment.resource.businesslogic.ProcessLogic;
import com.appleassignment.resource.businesslogic.ProcessLogicImpl;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Main Application which will load and call run.
 */
public class CryptoWebServiceApplication extends Application<CryptoServiceConfiguration> {

    /*
    Ideal way would be to inject this, but could not get this working with dropwizard.
    If given some more time, I should be able to get it wired.
    ProcessLogic processLogic;
    */

    public static void main(String[] args) throws Exception {
        new CryptoWebServiceApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<CryptoServiceConfiguration> bootstrap) {
    }

    @Override
    public void run(CryptoServiceConfiguration configuration,
                    Environment environment) {
        //Dirty hack . Should have been initialized by some injector.
        ProcessLogic processLogic = new ProcessLogicImpl();

        final CryptoWebServiceEndPoints resource = new CryptoWebServiceEndPoints(
                processLogic);
        environment.jersey().register(resource);// register the resource with jersey.
    }



}
