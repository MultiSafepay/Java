package com.MultiSafepay.client;

public class Order {

	public String order_id			= null;
	public String recurring_id		= null;
	public String cost				= null;
	public String type				= null;
	public String currency			= null;
	public String amount			= null;
	public String description		= null;
	public String manual			= null;
	public String gateway			= null;
	public String days_active		= null;
	public String payment_url		= null;
	public String ship_date			= null;
	public String tracktrace_code	= null;
	public String reason			= null;
	public String carrier			= null;
	public String invoice_id		= null;
	public String items				= null;
	public String cart_expiration	= null;

	public String var1				= null;
	public String var2				= null;
	public String var3				= null;
	
	public String use_shipping_notification	= null;
	public String use_field_notifications 	= null;
	
	public Customer customer 				= null;
	public Delivery delivery 				= null;
	public Plugin plugin 					= null;
	public GatewayInfo gateway_info 		= null;
	public PaymentOptions payment_options 	= null;
	public ShoppingCart shopping_cart 		= null;
	public GoogleAnalytics google_analytics = null;
	public CustomFields custom_fields		= null;
	public CustomInfo custom_info			= null;
	public CheckoutOptions checkout_options	= null;
	
}
