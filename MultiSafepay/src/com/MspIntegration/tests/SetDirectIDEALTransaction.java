package com.MspIntegration.tests;

import com.MultiSafepay.client.MspClient;
import com.MultiSafepay.client.Order;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class SetDirectIDEALTransaction {

    public static void main(String[] args) {
      
    	java.util.Date date		= new java.util.Date();
    
    	JsonObject jsonResponse = null;
    	
    	//Initialises MspClient
    	MspClient.init(true);
    	
    	Order order			= new Order();
    	order.type			= "direct";
    	order.gateway		= "IDEAL";
    	order.order_id		= Long.toString(date.getTime());
    	order.amount		= 1000; // cents
    	order.currency		= "EUR";
    	order.description	= "This the description for Java cart Item";
    	
    	order.plugin.shop			= "Java Test";
    	order.plugin.plugin_version	= "1.0";

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
    	
    	order.payment_options.cancel_url		= "http://test.com/cancel_url";
    	order.payment_options.notification_url	= "http://test.com/notification_url";
    	order.payment_options.redirect_url		= "http://test.com/redirect_url";
    	
    	order.gateway_info.issuer_id	= "3151"; //*Required see getIssuersTest Sample
    	
    	//Generates Json from Orders object
    	Gson gson 		= new Gson();
    	
    	jsonResponse	= MspClient.sendRequest("orders","POST",gson.toJson(order));
        
    	//Gets IDEAL payment_url
    	String payment_url	= MspClient.getPaymenUrl(jsonResponse);
    	
    	System.out.println("payment_url:");
    	System.out.println(payment_url);

    	System.out.println("Response");
    	System.out.println(jsonResponse);
    }
}
