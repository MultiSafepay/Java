package com.MspIntegration.tests;

import com.MultiSafepay.client.MspClient;
import com.google.gson.JsonObject;

public class GetOrders {
	
    public static void main(String[] args) {
      
    	JsonObject jsonResponse = null;
    	
    	//Initialises MspClient
    	MspClient.init(true);
   
    	//Get order information: status, etc...
    	jsonResponse = MspClient.sendRequest("orders/849339"); //order_id
    	
    	System.out.println("Response:");
    	System.out.println(jsonResponse);
    	
    	//Get a list of transactions for an order
    	jsonResponse = MspClient.sendRequest("orders/849339/transactions"); //order_id
    	
    	System.out.println("Response:");
    	System.out.println(jsonResponse);
    }
}
