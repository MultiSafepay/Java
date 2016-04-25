package com.MspIntegration.tests;

import com.MultiSafepay.classes.*;
import com.MultiSafepay.client.MultiSafepayClient;
import com.google.gson.JsonObject;

/**
 * @author Multisafepay.com
 */
public class SetOrderDirectIDEAL {

    public static void main(String[] args) {
      
    	java.util.Date date		= new java.util.Date();

    	MultiSafepayClient.init(true);
    	
    	Order order = new Order();
    	order.setDirectIdeal(
    			Long.toString(date.getTime()), 
    			"Product description", 
    			1000, 
    			"EUR",
    			new PaymentOptions("http://example.com/notify", "http://example.com/success", "http://example.com/failed"),
    			GatewayInfo.Ideal("3151")
    			
    	);
    	
    	JsonObject jsonResponse 	= MultiSafepayClient.createOrder(order);
    	System.out.println(jsonResponse);
    	
    	String payment_url			= MultiSafepayClient.getPaymenUrl(jsonResponse);
    	System.out.println("Payment Url: " + payment_url);
    }
}
