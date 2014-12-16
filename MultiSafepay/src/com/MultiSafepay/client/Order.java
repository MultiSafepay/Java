package com.MultiSafepay.client;

public class Order {

	public  String type 			= "";
	public  String order_id 		= "";
	public  String currency 		= "";
	public  String gateway  		= "";
	public  String description 		= "";
	public  String var1 			= "";
	public  String var2 			= "";
	public  String var3 			= "";
	public  String items 			= "";
	
	public int amount 				= 0 ; //cents
	
	public final Customer customer 				= new Customer();
	public final Delivery delivery 				= new Delivery();
	public final Plugin plugin 					= new Plugin();
	public final GatewayInfo gateway_info 		= new GatewayInfo();
	public final PaymentOptions payment_options = new PaymentOptions();
	
}
