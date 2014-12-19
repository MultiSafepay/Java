package com.MultiSafepay.client;

public class FlatRateShipping {
	public String name 			= null;
	public String price 			= null;
	public String[] allowed_areas 	= null;
	public String[] excluded_areas = null;
	
	/**
	 * 
	 * @param name
	 * @param price
	 * @param allowed_areas	[NL,ES,US,...]
	 * @param excluded_areas [NL,ES,US,...]
	 * @return
	 */
	public static FlatRateShipping add(String name,String price, String[] allowed_areas,String[] excluded_areas)
	{
		FlatRateShipping flatRate	=	new FlatRateShipping();
		flatRate.name				= name;
		flatRate.price				= price;
		flatRate.allowed_areas		= allowed_areas;
		flatRate.excluded_areas		= excluded_areas;
		return flatRate;
	}
	public static FlatRateShipping add(String name,String price, String[] allowed_areas)
	{
		return FlatRateShipping.add(name,price,allowed_areas,null);
	}
	
	public static FlatRateShipping add(String name,String price)
	{
		return FlatRateShipping.add(name,price,null,null);
	}
}
