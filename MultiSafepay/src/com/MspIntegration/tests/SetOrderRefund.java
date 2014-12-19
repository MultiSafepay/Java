package com.MspIntegration.tests;

import com.MultiSafepay.client.MspClient;
import com.MultiSafepay.client.Order;
import com.google.gson.JsonObject;

/**
 * Refunds an order
 * POST - orders/{order_id}/refunds
 * @author Multisafepay.com
 */
public class SetOrderRefund {

	public static void main(String[] args) {
	      
    	//Initialises MspClient
    	MspClient.init(true);
    	
    	Order order				= new Order();
    	order.currency			= "EUR";
    	order.amount			= "100"; //cents
    	order.description		= "Refund from Java Wrapper";

    	JsonObject jsonResponse	= MspClient.sendRequest("orders/1418980067470/refunds","POST",order); //order_id

    	System.out.println("Response");
    	System.out.println(jsonResponse);
    }
}
