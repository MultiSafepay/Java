package com.MspIntegration.tests;

import com.MultiSafepay.client.*;
import com.google.gson.JsonObject;

/**
 * Creates an redirect Order
 * POST - orders
 * @author Multisafepay.com
 */

public class SetOrderRedirect {

    public static void main(String[] args) {
      
    	java.util.Date date		= new java.util.Date();
    	
    	//Initialises MspClient
    	MspClient.init(true);
    	
    	Order order					= new Order();
    	order.type					= "redirect";
    	order.order_id				= Long.toString(date.getTime());
    	order.amount				= "1000";
    	order.currency				= "EUR";
    	order.description			= "This the description for Java cart Item";
    	
    	order.plugin 				= new Plugin();
    	order.plugin.shop			= "Java MSP Wrapper";
    	order.plugin.plugin_version	= "v1";

    	order.customer 				= new Customer();
    	order.customer.locale		= "en";
    	order.customer.ip_address	= "127.1.1.1";
    	order.customer.first_name	= "Test name";
    	order.customer.last_name	= "Last name";
    	order.customer.address1		= "My address";
    	order.customer.address2		= "My address 2";
    	order.customer.house_number	= "39";
    	order.customer.zip_code		= "123456";
    	order.customer.city			= "My City";
    	order.customer.state		= "My State";
    	order.customer.country		= "NL";
    	order.customer.phone		= "6663456694";
    	order.customer.email		= "test@test.com";
    	order.customer.referrer		= "";
    	order.customer.user_agent	= "";
    	
    	order.payment_options 					= new PaymentOptions();
    	order.payment_options.cancel_url		= "http://test.com/cancel_url";
    	order.payment_options.notification_url	= "http://test.com/notification_url";
    	order.payment_options.redirect_url		= "http://test.com/redirect_url";
    	order.payment_options.close_window		= false;
    	
    	JsonObject jsonResponse	= MspClient.sendRequest("orders","POST",order);

    	System.out.println("Response");
    	System.out.println(jsonResponse);
    	
    	//Gets payment_url for redirection
    	String payment_url	= MspClient.getPaymenUrl(jsonResponse);
    	
    	System.out.println("payment_url:");
    	System.out.println(payment_url);
    }
}
