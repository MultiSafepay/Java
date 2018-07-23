package com.MultiSafepay.classes;

import java.util.List;

public class TaxTable {

	public String name = null;
	public String rate = null;
	public Boolean shipping_taxed = null;
	public Boolean standalone = null;
	public List<TaxTableRule> rules = null;

	public static TaxTable setAlternate(String name, String rate,
			List<TaxTableRule> rules, Boolean shipping_taxed, Boolean standalone) {
		TaxTable table = new TaxTable();
		table.name = name;
		table.rate = rate;
		table.shipping_taxed = shipping_taxed;
		table.standalone = standalone;
		table.rules = rules;
		return table;
	}

	public static TaxTable setDefault(String name, List<TaxTableRule> rules,
			Boolean shipping_taxed) {
		TaxTable table = new TaxTable();
		table.name = name;
		table.shipping_taxed = shipping_taxed;
		table.rules = rules;
		return table;
	}
}
