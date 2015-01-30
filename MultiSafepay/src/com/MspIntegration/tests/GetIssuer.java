package com.MspIntegration.tests;

import com.MultiSafepay.client.MultiSafepayClient;
import com.google.gson.JsonObject;

/**
 * @author Multisafepay.com
 */
public class GetIssuer {

	public static void main(String[] args) {

		MultiSafepayClient.init(true);

		JsonObject jsonResponse = MultiSafepayClient.GetIssuer("ideal");

		System.out.println(jsonResponse);
	}
}
