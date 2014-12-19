package com.MspIntegration.tests;

import com.MultiSafepay.client.MspClient;
import com.google.gson.JsonObject;

/**
 * Get a list of transactions for an order
 * GET - orders/{order_id}/transactions
 * @author Multisafepay.com
 */
public class GetOrdersTransactions {
	 public static void main(String[] args) {

	    	//Initialises MspClient
	    	MspClient.init(true);

	    	JsonObject jsonResponse = MspClient.sendRequest("orders/849339/transactions"); //order_id
	    	
	    	System.out.println("Response:");
	    	System.out.println(jsonResponse);
	    }

}
