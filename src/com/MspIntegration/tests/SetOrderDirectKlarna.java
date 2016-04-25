package com.MspIntegration.tests;

import java.util.ArrayList;
import java.util.List;

import com.MultiSafepay.classes.*;
import com.MultiSafepay.client.MultiSafepayClient;
import com.google.gson.JsonObject;

/**
 * @author Multisafepay.com
 */

public class SetOrderDirectKlarna {

	public static void main(String[] args) {
	      
    	java.util.Date date		= new java.util.Date();
    	
    	MultiSafepayClient.init(true);
    	
    	Customer customer	 	= new Customer();
    	customer.first_name  	= "Testperson-nl";
    	customer.last_name   	= "Approved";
    	customer.house_number 	= "1/XI";
    	customer.address1 		= "Neherkade";
    	customer.city 			= "Gravenhage";
    	customer.country 		= "NL";
    	customer.zip_code 		= "2521VA";
    	
    	Delivery delivery	 	= new Delivery();
    	delivery.first_name  	= "Testperson-nl";
    	delivery.last_name   	= "Approved";
    	delivery.house_number 	= "1/XI";
    	delivery.address1 		= "Neherkade";
    	delivery.city 			= "Gravenhage";
    	delivery.country 		= "NL";
    	delivery.zip_code 		= "2521VA";
    	
    	CheckoutOptions checkout_options	= new CheckoutOptions();
    	checkout_options.no_shipping_method = true;
    	
    	checkout_options.tax_tables	= new TaxTables();
    	List<TaxTableRule> tableRule= new ArrayList<TaxTableRule>();
    	
    	tableRule.add(TaxTableRule.addRule("0.21",null,null));
    	checkout_options.tax_tables.addDefault(TaxTable.setDefault("Default",tableRule,false));
 
    	List<ShoppingCartItem> items 		= new ArrayList<ShoppingCartItem>();
    	items.add(ShoppingCartItem.add(	"Test Product","Sample description","200.0","EUR","1","123456",""));
    	
    	Order order = new Order();
    	order.setDirectKlarna(Long.toString(date.getTime()), "Product description", 24200, "EUR", 
    			new PaymentOptions("http://example.com/notify", "http://example.com/success", "http://example.com/failed"),
    			GatewayInfo.Klarna("1980-01-30","male","+31 (0)20 8500 500","test@multisafepay.com"),
    			new ShoppingCart(items),
    			checkout_options,
    			customer,
    			delivery
    	);
    	
    	JsonObject jsonResponse  = MultiSafepayClient.createOrder(order);
    	System.out.println(jsonResponse);
	}
}
