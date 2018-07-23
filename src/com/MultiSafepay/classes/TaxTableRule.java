package com.MultiSafepay.classes;

public class TaxTableRule {
	public String rate = null;
	public String country = null;
	public Boolean world_area = null;

	public static TaxTableRule addRule(String rate, String country,
			Boolean world_area) {
		TaxTableRule rule = new TaxTableRule();
		rule.rate = rate;
		rule.country = country;
		rule.world_area = world_area;
		return rule;
	}
}
