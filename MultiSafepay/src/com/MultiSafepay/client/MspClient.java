package com.MultiSafepay.client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;

import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.*;

public class MspClient {
	//Edit this lines
	public static String api_key 		= "10324b12f0386ab3d9fc4090fcc9545e4f424a80"; //Api Key
	
	//No edit after this lines
	public static String api_version 	= "v1"; //Api version
	public static String endPoint 		= "";

	public static boolean testMode 		= true;
	
	private static String tesApitUrl 	= "http://localapi.multisafepay.com/v1/json/";
	private static String apiUrl 		= "https://api.multisafepay.com/v1/json/";
	private static String USER_AGENT = "Mozilla/5.0";

	/**
	 * Initializes MspClient
	 * @param testMode true|false
	 */
	public static void init(Boolean testMode) {
		MspClient.endPoint = MspClient.apiUrl;
		MspClient.testMode	=	testMode;
		if (MspClient.testMode) {
			MspClient.endPoint = MspClient.tesApitUrl;
		}
	}

	/**
	 * Send http request to Multisafepay
	 * @param url
	 * @param method
	 * @param jsonString
	 * @return
	 */
	public static JsonObject sendRequest(String url, String method,String jsonString) {

		JsonObject result = null;
		if(method == "")
		{
			method	= "GET";
		}
		method	= method.toUpperCase();
		try {
			System.out.println("Send Api Request: " + MspClient.endPoint + url);
			URL obj = new URL(MspClient.endPoint + url); 
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();           
			con.setDoOutput(true);
			
			con.setInstanceFollowRedirects(false); 
			con.setRequestMethod(method);
			con.setRequestProperty("User-Agent", USER_AGENT);
			con.setRequestProperty("api_key", MspClient.api_key);
			con.setRequestProperty("charset", "utf-8");
			con.setUseCaches (false);
			
			if(method == "POST" || method == "PUT" || method == "PATCH")
			{
				con.setDoInput(true);
				con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded"); 
				con.setRequestProperty("Content-Length", "" + Integer.toString(jsonString.getBytes().length));
				DataOutputStream wr = new DataOutputStream(con.getOutputStream ());
				wr.writeBytes(jsonString);
				wr.flush();
				wr.close();
			}
			
			int status = con.getResponseCode();
			System.out.println("Http response code:");
			System.out.println(status);
			
			String inputLine;
			BufferedReader reader = null;
			if(status == 200)
			{
				 reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			}
			else
			{
				 reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			
			StringBuffer response = new StringBuffer();

			while ((inputLine = reader.readLine()) != null) {
				response.append(inputLine);
			}

			reader.close();
			
			JsonParser parser = new JsonParser();
			JsonObject jsonResponse = (JsonObject) parser.parse(response.toString());

			result	= jsonResponse;
			con.disconnect();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return result;
	}

	public static JsonObject sendRequest(String url, String method) {
		
		return MspClient.sendRequest(url, method,null);
	}
	
	public static JsonObject sendRequest(String url) {
		
		return MspClient.sendRequest(url, "GET",null);
	}
	
	/**
	 * Parse payment_url from response for transactions with redirection or payment_url
	 * @param response
	 * @return
	 */
    public static String getPaymenUrl(JsonObject response)
    {
    	String payment_url	= null;
    	try
    	{
    		JsonObject data   	= response.getAsJsonObject("data");
        	payment_url			= data.get("payment_url").getAsString();
    	}
    	catch(Exception e)
    	{
    		System.out.println(e.toString());
    	}
    	return payment_url;
    }
}
