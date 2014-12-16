package com.MspIntegration.tests;

import com.MultiSafepay.client.MspClient;
import com.google.gson.JsonObject;

public class GetTransactions {

	 public static void main(String[] args) {
	      
	    	JsonObject jsonResponse = null;
	    	
	    	//Initialises MspClient
	    	MspClient.init(true);
	   
	    	jsonResponse = MspClient.sendRequest("transactions/9941812537632491"); //transaction_id
	    	
	    	System.out.println("Response:");
	    	System.out.println(jsonResponse);
	    }
}
