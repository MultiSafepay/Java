package com.MspIntegration.tests;

import com.MultiSafepay.client.*;
import com.google.gson.JsonObject;

/**
 * Creates a Bank Transfer Request
 * POST - orders
 * @author Multisafepay.com
 */
public class SetBankTransferRequest {

	public static void main(String[] args) {
		
		java.util.Date date		= new java.util.Date();
    	
    	//Initialises MspClient
    	MspClient.init(true);
    	
    	Order order					= new Order();
    	order.type					= "direct";
    	order.gateway				= "BANKTRANS";
    	order.order_id				= Long.toString(date.getTime());
    	order.amount				= "1000";
    	order.currency				= "EUR";
    	order.description			= "Description from Java Wrapper";
    	
    	//Plugin
    	order.plugin 				= new Plugin();
    	order.plugin.shop			= "Java MSP Wrapper";
    	order.plugin.plugin_version	= "v1";

    	JsonObject jsonResponse		= MspClient.sendRequest("orders","POST",order);

    	System.out.println("Response");
    	System.out.println(jsonResponse);
	}
}
