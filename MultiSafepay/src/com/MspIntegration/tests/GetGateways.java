package com.MspIntegration.tests;

import com.MultiSafepay.client.MspClient;
import com.google.gson.JsonObject;

/**
 * Get list of payment methods
 * GET - gateways
 * GET - gateways/{id}
 * @author Multisafepay.com
 */
public class GetGateways {

    public static void main(String[] args) {
      
    	JsonObject jsonResponse = null;
    	
    	//Initialises MspClient
    	MspClient.init(true);
    	
    	jsonResponse = MspClient.sendRequest("gateways");
    	System.out.println(jsonResponse);
    	
    	//by preselected id
    	jsonResponse = MspClient.sendRequest("gateways/visa");
    	System.out.println(jsonResponse);
    }
}
