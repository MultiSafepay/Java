package com.MultiSafepay.classes;

public class Weight {
	public String unit = null;
	public String value = null;

	public static Weight set(String unit, String value) {
		Weight weight = new Weight();
		weight.unit = unit;
		weight.value = value;
		return weight;
	}
}