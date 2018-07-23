package com.MultiSafepay.classes;

import java.util.List;

public class ShippingMethods {

	public List<ShippingMethod> flat_rate_shipping = null;
	public ShippingMethod pickup = null;

	public ShippingMethods setFlatRate(List<ShippingMethod> list) {
		this.flat_rate_shipping = list;
		return this;
	}

	public ShippingMethods setPickup(ShippingMethod method) {
		this.pickup = method;
		return this;
	}
}