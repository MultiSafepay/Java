package com.MspIntegration.tests;

import com.MultiSafepay.classes.GatewayInfo;
import com.MultiSafepay.classes.Order;
import com.MultiSafepay.classes.PaymentOptions;
import com.MultiSafepay.client.MultiSafepayClient;
import com.google.gson.JsonObject;

public class SetOrderDirectIdealQR {
	public static void main(String[] args) {
	      
    	java.util.Date date		= new java.util.Date();

    	MultiSafepayClient.init(true);
    	
    	Order order = new Order();
    	order.setDirectIdealQR(
    			Long.toString(date.getTime()), 
    			"Product description", 
    			1000, 
    			"EUR",
    			new PaymentOptions("http://example.com/notify", "http://example.com/success", "http://example.com/failed"),
    			GatewayInfo.IdealQR(300)
    			
    	);
    	
    	JsonObject jsonResponse 	= MultiSafepayClient.createOrder(order);
    	System.out.println(jsonResponse);
    	
    	String qr_url			= MultiSafepayClient.getQrUrl(jsonResponse);
    	System.out.println("QR Url: " + qr_url);
    }
}
