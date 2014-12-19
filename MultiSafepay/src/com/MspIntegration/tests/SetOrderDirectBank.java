package com.MspIntegration.tests;

/**
 * Creates a Direct Bank order
 * POST - orders
 * @author Multisafepay.com
 */
import com.MultiSafepay.client.*;
import com.google.gson.JsonObject;

public class SetOrderDirectBank {

	public static void main(String[] args) {
	
		java.util.Date date		= new java.util.Date();
    	
    	//Initialises MspClient
    	MspClient.init(true);
    	
    	Order order					= new Order();
    	order.type					= "direct";
    	order.gateway				= "DIRECTBANK";
    	order.order_id				= Long.toString(date.getTime());
    	order.amount				= "13500";
    	order.currency				= "EUR";
    	order.description			= "Description from Java Wrapper";
    	order.var1					= "Var 1 sample";
    	order.var2					= "Var 2 sample";
    	order.var3					= "Var 3 sample";
    	
    	//Plugin
    	order.plugin 				= new Plugin();
    	order.plugin.shop			= "Java MSP Wrapper";
    	order.plugin.plugin_version	= "v1";
    	
    	//Gateway info *Required
    	order.gateway_info							= new GatewayInfo();
    	order.gateway_info.account_holder_name 		= "John Doe";
    	order.gateway_info.account_holder_city 		= "Amsterdam";
    	order.gateway_info.account_holder_country 	= "NL";
    	order.gateway_info.account_holder_iban 		= "IBAN 999999999";
    	order.gateway_info.account_holder_bic 		= "NL";
    	
    	//Customer
    	order.customer 				= new Customer();
    	order.customer.locale		= "en";
    	order.customer.ip_address	= "127.1.1.1";
    	order.customer.first_name	= "Jhon";
    	order.customer.last_name	= "Doe";
    	order.customer.address1		= "Kraanspoor";
    	order.customer.address2		= "";
    	order.customer.house_number	= "39";
    	order.customer.zip_code		= "1033 SC";
    	order.customer.city			= "Amsterdam";
    	order.customer.state		= "Amsterdam";
    	order.customer.country		= "NL";
    	order.customer.phone		= "777 777 777";
    	order.customer.email		= "example@example.com";
    	order.customer.referrer		= "";
    	order.customer.user_agent	= "";

    	JsonObject jsonResponse		= MspClient.sendRequest("orders","POST",order);

    	System.out.println("Response");
    	System.out.println(jsonResponse);
	}
}
