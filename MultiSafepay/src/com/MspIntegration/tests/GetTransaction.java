package com.MspIntegration.tests;

import com.MultiSafepay.client.MultiSafepayClient;
import com.google.gson.JsonObject;

public class GetTransaction {
	public static void main(String[] args) {

    	MultiSafepayClient.init(true);
    	
    	JsonObject jsonResponse = MultiSafepayClient.GetTransaction("9941812537632491");

    	System.out.println(jsonResponse);
    }
}
