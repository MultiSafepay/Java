package com.MultiSafepay.classes;

public class ShoppingCartItem {
	public String name = null;
	public String description = null;
	public String unit_price = null;
	public String currency = null;
	public String quantity = null;
	public String merchant_item_id = null;
	public String tax_table_selector = null;
	public Weight weight = null;

	public static ShoppingCartItem add(String name, String description,
			String unit_price, String currency, String quantity,
			String merchant_item_id, String tax_table_selector, Weight weight) {
		ShoppingCartItem item = new ShoppingCartItem();

		item.name = name;
		item.description = description;
		item.unit_price = unit_price;
		item.currency = currency;
		item.quantity = quantity;
		item.merchant_item_id = merchant_item_id;
		item.tax_table_selector = tax_table_selector;
		item.weight = weight;
		return item;
	}

	public static ShoppingCartItem add(String name, String description,
			String unit_price, String currency, String quantity,
			String merchant_item_id, String tax_table_selector) {
		ShoppingCartItem item = new ShoppingCartItem();

		item.name = name;
		item.description = description;
		item.unit_price = unit_price;
		item.currency = currency;
		item.quantity = quantity;
		item.merchant_item_id = merchant_item_id;
		item.tax_table_selector = tax_table_selector;
		return item;
	}
}
