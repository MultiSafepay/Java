package com.MultiSafepay.client;

import java.lang.reflect.Type;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;


public class MspClient {
	//Edit this lines
	public static String api_key 		= "10324b12f0386ab3d9fc4090fcc9545e4f424a80"; //Key provided by 
	
	//No edit after this lines
	public static String api_version 	= "v1";
	public static String endPoint 		= "";

	public static boolean testMode 		= true;
	
	private static String tesApitUrl 	= "http://localapi.multisafepay.com/v1/json/";
	private static String apiUrl 		= "https://api.multisafepay.com/v1/json/";
	public static String USER_AGENT 	= "Mozilla/5.0";

	/**
	 * Initialises MspClient
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
	 * Send Http request to Multisafepay
	 * @param url
	 * @param method
	 * @param jsonString
	 * @return
	 */
	public static JsonObject sendRequest(String url, String method,Object mspObject) {

		JsonParser parser 		= new JsonParser();
		JsonObject jsonResponse = null;
		String _overrideMethod	= null;
		String jsonString		= null;
		if(mspObject !=null)
		{
			jsonString 	= JsonHandler(mspObject);
		}
		if(method == "")
		{
			method	= "GET";
		}
		
		if(method == "PATCH") //Workaround HttpURLConnection does not support all modern methods like PATCH
		{
			_overrideMethod = "PATCH";
			method 			= "POST";
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
			
			if(_overrideMethod != null)
			{
				con.setRequestProperty("X-HTTP-Method-Override", _overrideMethod);
			}
			
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
				System.out.println(method + " Data:");
				System.out.println(jsonString);
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
			
			jsonResponse = (JsonObject) parser.parse(response.toString());

			con.disconnect();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return jsonResponse;
	}
	
	/**
	 * Helper 
	 * @param jsonString
	 * @return
	 */
	public static String JsonHandler(Object _object)
	{
		Gson gson 			= new Gson();
		String jsonString	= gson.toJson(_object);
		
		Type type = new TypeToken<Map<String, Object>>() {}.getType();
		Map<String, Object> data = new Gson().fromJson(jsonString, type);

		for (Iterator<Map.Entry<String, Object>> it = data.entrySet().iterator(); it.hasNext();) {
		    Map.Entry<String, Object> entry = it.next();
		    if (entry.getValue() == null) {
		        it.remove();
		    } else if (entry.getValue().getClass().equals(ArrayList.class)) {
		        if (((ArrayList<?>) entry.getValue()).size() == 0) {
		            it.remove();
		        }
		    }
		}
		String json = new GsonBuilder().create().toJson(data);
		return json;
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
