package com.MspIntegration.tests;

import java.util.ArrayList;
import java.util.List;

import com.MultiSafepay.classes.*;
import com.MultiSafepay.client.MultiSafepayClient;
import com.google.gson.JsonObject;

/**
 * @author Multisafepay.com
 */

public class SetOrderDirectEinvoice {

	public static void main(String[] args) {
	      
    	java.util.Date date		= new java.util.Date();
    	
    	MultiSafepayClient.init(true);
    	
    	Customer customer	 	= new Customer();
    	customer.first_name  	= "John";
    	customer.last_name   	= "Doe";
    	customer.house_number 	= "39";
    	customer.address1 		= "Kraanspoor";
    	customer.city 			= "Amsterdam";
    	customer.country 		= "NL";
    	customer.zip_code 		= "1033SC";
    	
    	CheckoutOptions checkout_options	= new CheckoutOptions();
    	checkout_options.no_shipping_method = true;
    	
    	checkout_options.tax_tables	= new TaxTables();
    	List<TaxTableRule> tableRule= new ArrayList<TaxTableRule>();
    	
    	tableRule.add(TaxTableRule.addRule("0.21",null,null));
    	checkout_options.tax_tables.addDefault(TaxTable.setDefault("Default",tableRule,false));
 
    	List<ShoppingCartItem> items 		= new ArrayList<ShoppingCartItem>();
    	items.add(ShoppingCartItem.add(	"Test Product","Sample description","200.0","EUR","1","123456",""));
    	
    	Order order = new Order();
    	order.setDirectEinvoice(Long.toString(date.getTime()), "Product description", 24200, "EUR", 
    			new PaymentOptions("http://example.com/notify", "http://example.com/success", "http://example.com/failed"),
    			GatewayInfo.Einvoice("1980-01-30","NL39 RABO 0300 0652 64","+31 (0)20 8500 500","test@multisafepay.com","referrer","user-agent"),
    			new ShoppingCart(items),
    			checkout_options,
    			customer
    	);
    	
    	JsonObject jsonResponse  = MultiSafepayClient.createOrder(order);
    	System.out.println(jsonResponse);
	}
}
