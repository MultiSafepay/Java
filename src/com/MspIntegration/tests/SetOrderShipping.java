package com.MspIntegration.tests;

import com.MultiSafepay.client.MultiSafepayClient;
import com.google.gson.JsonObject;

/**
 * @author Multisafepay.com
 */
public class SetOrderShipping {

	public static void main(String[] args) {
 	
    	//Initialises MspClient
    	MultiSafepayClient.init(true);
    	
    	JsonObject jsonResponse	= MultiSafepayClient.SetOrderShipping("1418980067470", "16-12-2014", "UPS", "123456");

    	System.out.println(jsonResponse);
    }
}
