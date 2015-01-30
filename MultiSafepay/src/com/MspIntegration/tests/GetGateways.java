package com.MspIntegration.tests;

import com.MultiSafepay.client.MultiSafepayClient;
import com.google.gson.JsonObject;

/**
 * @author Multisafepay.com
 */
public class GetGateways {

    public static void main(String[] args) {
     
    	MultiSafepayClient.init(true);
    	
    	JsonObject jsonResponse = MultiSafepayClient.GetGateways();
    	
    	System.out.println(jsonResponse);
    }
}
