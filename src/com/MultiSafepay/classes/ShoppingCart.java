package com.MultiSafepay.classes;

import java.util.List;

public class ShoppingCart {
	public List<ShoppingCartItem> items = null;

	public ShoppingCart(List<ShoppingCartItem> items) {
		this.items = items;
	}
}