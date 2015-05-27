package com.MspIntegration.tests;

import com.MultiSafepay.client.MultiSafepayClient;
import com.google.gson.JsonObject;

public class SetOrderInvoice {
	public static void main(String[] args) {
	      
    	MultiSafepayClient.init(true);

    	JsonObject jsonResponse	= MultiSafepayClient.SetOrderInvoice("1418980067470","112345");

    	System.out.println(jsonResponse);
    }
}
