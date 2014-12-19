package com.MspIntegration.tests;

import com.MultiSafepay.client.MspClient;
import com.google.gson.JsonObject;

/**
 * Get order information: status, etc...
 * GET - orders/{id}
 * @author Multisafepay.com
 */
public class GetOrders {
	
    public static void main(String[] args) {

    	//Initialises MspClient
    	MspClient.init(true);
   
    	JsonObject jsonResponse = MspClient.sendRequest("orders/849339"); //order_id
    	
    	System.out.println("Response:");
    	System.out.println(jsonResponse);
    }
}
