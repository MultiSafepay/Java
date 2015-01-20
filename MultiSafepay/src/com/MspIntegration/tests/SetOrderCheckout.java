package com.MspIntegration.tests;

import java.util.ArrayList;
import java.util.List;

import com.MultiSafepay.client.*;

import com.google.gson.JsonObject;

/**
 * Creates a Checkout Order
 * POST - orders
 * @author Multisafepay.com
 */

public class SetOrderCheckout {

	public static void main(String[] args) {
	      
    	java.util.Date date		= new java.util.Date();
    	
    	//Initialises MspClient
    	MspClient.init(true);
    	
    	Order order					= new Order();
    	order.type					= "checkout";
    	//order.gateway				= "VISA"; //Optional for preselected payment method/gateway
    	order.order_id				= Long.toString(date.getTime());
    	order.amount				= "13500";
    	order.currency				= "EUR";
    	order.description			= "Description from Java Wrapper";
    	order.var1					= "Var 1 sample";
    	order.var2					= "Var 2 sample";
    	order.var3					= "Var 3 sample";
    	
    	//Payment Options
    	order.payment_options 					= new PaymentOptions();
    	order.payment_options.cancel_url		= "http://test.com/cancel_url";
    	order.payment_options.notification_url	= "http://test.com/notification_url";
    	order.payment_options.redirect_url		= "http://test.com/redirect_url";
    	
    	//Plugin
    	order.plugin 					= new Plugin();
    	order.plugin.shop				= "Java MSP Wrapper";
    	order.plugin.plugin_version		= "v1";
    	
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
    	
    	//Delivery
    	order.delivery				= new Delivery();
    	order.delivery.first_name	= "Jhon";
    	order.delivery.last_name	= "Doe";
    	order.delivery.address1		= "Kraanspoor";
    	order.delivery.address2		= "";
    	order.delivery.house_number	= "39";
    	order.delivery.zip_code		= "1033 SC";
    	order.delivery.city			= "Amsterdam";
    	order.delivery.state		= "Amsterdam";
    	order.delivery.country		= "NL";
    	order.delivery.phone		= "777 777 777";
    	order.delivery.email		= "example@example.com";
    	
    	//Checkout Options
    	order.checkout_options					= new CheckoutOptions();
    	
    	//Rounding Policy
    	order.checkout_options.rounding_policy 	= RoundingPolicy.set(RoundingPolicy.modes.UP,RoundingPolicy.rules.PER_ITEM);
    	
    	//Shipping
    	order.checkout_options.shipping_methods	= new ShippingMethods();
    	List<FlatRateShipping> flatRate			= new ArrayList<FlatRateShipping>();
    	
    	flatRate.add(FlatRateShipping.add("TNT - verzending NL","7.00"));
    	flatRate.add(FlatRateShipping.add("TNT - verzending BE en FR","12.00"));
    	
    	order.checkout_options.shipping_methods.flat_rate_shipping	= flatRate;
    	
    	
    	//Tax tables
    	order.checkout_options.tax_tables 		= new TaxTables();
    	
    	//Default tax table
    	order.checkout_options.tax_tables._default	= TaxTable.setDefault("0.21",true);
    	
    	//Tax tables
    	List<TaxTable> tables 			= new ArrayList<TaxTable>();
    	
    	//New rule
    	List<TaxTableRule> tableRule	= new ArrayList<TaxTableRule>();
    	tableRule.add(TaxTableRule.addRule("0.21",null,null));
    	tables.add(TaxTable.setAlternate("BTW21",null,tableRule,null,null));
    	
    	//New rule
    	List<TaxTableRule> tableRule2	= new ArrayList<TaxTableRule>();
    	tableRule2.add(TaxTableRule.addRule("0.21",null,null));
    	tables.add(TaxTable.setAlternate("BTW0",null,tableRule2,null,true));
    	
    	//New rule
    	List<TaxTableRule> tableRule3	= new ArrayList<TaxTableRule>();
    	tableRule3.add(TaxTableRule.addRule("0.21",null,null));
    	tables.add(TaxTable.setAlternate("none",null,tableRule3,null,false));
    	
    	//New rule
    	List<TaxTableRule> tableRule4	= new ArrayList<TaxTableRule>();
    	tableRule4.add(TaxTableRule.addRule("0.0825","US",null));
    	tableRule4.add(TaxTableRule.addRule("0.08375","US",null));
    	tables.add(TaxTable.setAlternate("2",null,tableRule4,null,false));
    	
    	order.checkout_options.tax_tables.alternate	= tables;
    	
    	//Shopping Cart
    	//Tax tables
    	order.shopping_cart				= new ShoppingCart();
    	List<ShoppingCartItem> items 	= new ArrayList<ShoppingCartItem>();
    	
    	//Cart Item
    	items.add(ShoppingCartItem.add(	
    			"Geometric Candle Holders",
    			"Sample description",
    			"90.00",
    			"EUR",
    			"1",
    			"123456",
    			"none",
    			Weight.set("KG", "12")
    			));
    	
    	//Cart Item
    	items.add(ShoppingCartItem.add(	
    			"Nice apple",
    			"Sample description 2",
    			"35.00",
    			"EUR",
    			"1",
    			"123456",
    			"none",
    			Weight.set("KG", "10")
    			));
    	
    	order.shopping_cart.items	= items;

    	JsonObject jsonResponse		= MspClient.sendRequest("orders","POST",order);

    	System.out.println("Response");
    	System.out.println(jsonResponse);
    	
    	//Gets payment_url for redirection
    	String payment_url	= MspClient.getPaymenUrl(jsonResponse);
    	
    	System.out.println("payment_url:");
    	System.out.println(payment_url);
	}
}
