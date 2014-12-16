package com.MspIntegration.tests;

import com.MultiSafepay.client.MspClient;
import com.google.gson.JsonObject;

public class GetGateways {

    public static void main(String[] args) {
      
    	JsonObject jsonResponse = null;
    	
    	//Initialises MspClient
    	MspClient.init(true);
    	
    	//Get list of payment methods
    	jsonResponse = MspClient.sendRequest("gateways");
    	System.out.println(jsonResponse);
    	
    	//Get a selected payment method
    	jsonResponse = MspClient.sendRequest("gateways/visa");
    	System.out.println(jsonResponse);
    }
}
