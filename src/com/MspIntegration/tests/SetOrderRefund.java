package com.MspIntegration.tests;

import com.MultiSafepay.client.MultiSafepayClient;
import com.google.gson.JsonObject;

/**
 * @author Multisafepay.com
 */
public class SetOrderRefund {

	public static void main(String[] args) {
	      
    	MultiSafepayClient.init(true);

    	JsonObject jsonResponse	= MultiSafepayClient.SetOrderRefund("1418980067470",100,"EUR","Refund order");

    	System.out.println(jsonResponse);
    }
}
