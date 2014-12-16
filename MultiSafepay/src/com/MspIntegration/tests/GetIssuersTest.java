package com.MspIntegration.tests;

import com.MultiSafepay.client.MspClient;
import com.google.gson.JsonObject;

public class GetIssuersTest {

	 public static void main(String[] args) {
	      
	    	JsonObject jsonResponse = null;
	    	
	    	//Initialises MspClient
	    	MspClient.init(true);
	   
	    	jsonResponse = MspClient.sendRequest("issuers/ideal");
	    	
	    	System.out.println("Response:");
	    	System.out.println(jsonResponse);
	    }
}
