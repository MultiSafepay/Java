package com.MspIntegration.tests;

import com.MultiSafepay.client.MspClient;
import com.google.gson.JsonObject;

/**
 * GET - transactions/{transaction_id}
 * @author Multisafepay.com
 */
public class GetTransactions {

	 public static void main(String[] args) {
	      	
	    	//Initialises MspClient
	    	MspClient.init(true);
	   
	    	JsonObject jsonResponse = MspClient.sendRequest("transactions/9941812537632491"); //transaction_id
	    	
	    	System.out.println("Response:");
	    	System.out.println(jsonResponse);
	    }
}
