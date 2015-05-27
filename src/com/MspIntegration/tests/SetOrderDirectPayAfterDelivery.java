package com.MspIntegration.tests;

import java.util.ArrayList;
import java.util.List;

import com.MultiSafepay.classes.*;
import com.MultiSafepay.client.MultiSafepayClient;
import com.google.gson.JsonObject;

/**
 * @author Multisafepay.com
 */

public class SetOrderDirectPayAfterDelivery {

	public static void main(String[] args) {
	      
    	java.util.Date date		= new java.util.Date();
    	
    	MultiSafepayClient.init(true);
    	
    	CheckoutOptions checkout_options	= new CheckoutOptions();
    	checkout_options.no_shipping_method = true;
    	
    	List<ShoppingCartItem> items 		= new ArrayList<ShoppingCartItem>();
    	items.add(ShoppingCartItem.add(	"Test Product","Sample description","90.00","EUR","1","123456","none",Weight.set("KG", "12")));
    	
    	Order order = new Order();
    	order.setDirectPayAfter(Long.toString(date.getTime()), "Product description", 1000, "EUR", 
    			new PaymentOptions("http://example.com/notify", "http://example.com/success", "http://example.com/failed"),
    			GatewayInfo.setPayAfter("1980-01-30","NL18ABNA0484869868","0208500500","example@example.com"),
    			new ShoppingCart(items),
    			checkout_options
    	);
    	
    	JsonObject jsonResponse  = MultiSafepayClient.createOrder(order);
    	System.out.println(jsonResponse);
	}
}
