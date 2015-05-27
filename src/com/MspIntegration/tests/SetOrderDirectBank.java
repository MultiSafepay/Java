package com.MspIntegration.tests;

/**
 * @author Multisafepay.com
 */
import com.MultiSafepay.classes.*;
import com.MultiSafepay.client.MultiSafepayClient;
import com.google.gson.JsonObject;

public class SetOrderDirectBank {

	public static void main(String[] args) {
	
		java.util.Date date		= new java.util.Date();
    	
    	MultiSafepayClient.init(true);
    	
    	
    	Order order = new Order();
    	order.setDirectBank(
    			Long.toString(date.getTime()), 
    			"Product description", 
    			1000, 
    			"EUR", 
    			GatewayInfo.setDirectBank(
    					"John Doe", 
    					"Amsterdam", 
    					"NL",
    					"IBAN 999999999",
    					"NL")
    			
    	);
    	
    	JsonObject jsonResponse 	= MultiSafepayClient.createOrder(order);
    	System.out.println(jsonResponse);
	}
}
