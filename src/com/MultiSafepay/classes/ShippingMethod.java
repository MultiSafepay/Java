package com.MultiSafepay.classes;

public class ShippingMethod {
	public String name = null;
	public String price = null;
	public String currency = null;
	public String[] allowed_areas = null;
	public String[] excluded_areas = null;

	/**
	 * 
	 * @param name
	 * @param price
	 * @param allowed_areas
	 *            [NL,ES,US,...]
	 * @param excluded_areas
	 *            [NL,ES,US,...]
	 * @return
	 */

	public static ShippingMethod set(String name, String price,
			String currency, String[] allowed_areas, String[] excluded_areas) {
		ShippingMethod shipping = new ShippingMethod();
		shipping.name = name;
		shipping.price = price;
		shipping.currency = currency;
		shipping.allowed_areas = allowed_areas;
		shipping.excluded_areas = excluded_areas;
		return shipping;
	}

	public static ShippingMethod set(String name, String price,
			String currency, String[] allowed_areas) {
		return ShippingMethod.set(name, price, currency, allowed_areas, null);
	}

	public static ShippingMethod set(String name, String price, String currency) {
		return ShippingMethod.set(name, price, currency, null, null);
	}
}