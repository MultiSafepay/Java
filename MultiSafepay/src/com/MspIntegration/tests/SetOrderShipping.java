package com.MspIntegration.tests;

import com.MultiSafepay.client.MspClient;
import com.MultiSafepay.client.Order;
import com.google.gson.JsonObject;

/**
 * Sets Order shipping information
 * PATCH - orders/{order_id}
 * @author Multisafepay.com
 */
public class SetOrderShipping {

	public static void main(String[] args) {
 	
    	//Initialises MspClient
    	MspClient.init(true);
    	
    	Order order				= new Order();
    	order.ship_date			= "16-12-2014";
    	order.carrier			= "UPS";
    	order.tracktrace_code	= "123456";
    	
    	//optional
    	order.invoice_id		= "7891011";
    	
    	JsonObject jsonResponse	= MspClient.sendRequest("orders/849339","PATCH",order); //uses order_id

    	System.out.println("Response");
    	System.out.println(jsonResponse);
    }
}
