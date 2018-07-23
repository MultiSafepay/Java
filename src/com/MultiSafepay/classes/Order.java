package com.MultiSafepay.classes;

public class Order {

	public String order_id = null;
	public String recurring_id = null;
	public String cost = null;
	public String type = null;
	public String currency = null;
	public Integer amount = null;
	public String description = null;
	public String manual = null;
	public String gateway = null;
	public String days_active = null;
	public Integer seconds_active = null;
	public String payment_url = null;
	public String ship_date = null;
	public String tracktrace_code = null;
	public String reason = null;
	public String carrier = null;
	public String invoice_id = null;
	public String items = null;
	public String cart_expiration = null;

	public String var1 = null;
	public String var2 = null;
	public String var3 = null;

	public String use_shipping_notification = null;
	public String use_field_notifications = null;

	public Customer customer = null;
	public Delivery delivery = null;
	public Plugin plugin = null;
	public GatewayInfo gateway_info = null;
	public PaymentOptions payment_options = null;
	public ShoppingCart shopping_cart = null;
	public GoogleAnalytics google_analytics = null;
	public CustomFields custom_fields = null;
	public CustomInfo custom_info = null;
	public CheckoutOptions checkout_options = null;

	public Order setRedirect(String order_id, String description,
			Integer amount, String currency, PaymentOptions payment_options) {
		this.type = "redirect";
		this.order_id = order_id;
		this.description = description;
		this.amount = amount;
		this.currency = currency;
		this.payment_options = payment_options;
		return this;
	}

	public Order setFastCheckout(String order_id, String description,
			Integer amount, String currency, PaymentOptions payment_options,
			ShoppingCart shopping_cart, CheckoutOptions checkout_options) {
		this.type = "checkout";
		this.order_id = order_id;
		this.description = description;
		this.amount = amount;
		this.currency = currency;
		this.payment_options = payment_options;
		this.shopping_cart = shopping_cart;
		this.checkout_options = checkout_options;
		return this;
	}

	public Order setDirectPayAfter(String order_id, String description,
			Integer amount, String currency, PaymentOptions payment_options,
			GatewayInfo gateway_info, ShoppingCart shopping_cart,
			CheckoutOptions checkout_options, Customer customer) {
		this.type = "direct";
		this.gateway = "PAYAFTER";
		this.order_id = order_id;
		this.description = description;
		this.amount = amount;
		this.currency = currency;
		this.payment_options = payment_options;
		this.gateway_info = gateway_info;
		this.shopping_cart = shopping_cart;
		this.checkout_options = checkout_options;
		this.customer = customer;
		return this;
	}

	public Order setDirectEinvoice(String order_id, String description,
			Integer amount, String currency, PaymentOptions payment_options,
			GatewayInfo gateway_info, ShoppingCart shopping_cart,
			CheckoutOptions checkout_options, Customer customer) {
		this.type = "direct";
		this.gateway = "EINVOICE";
		this.order_id = order_id;
		this.description = description;
		this.amount = amount;
		this.currency = currency;
		this.payment_options = payment_options;
		this.gateway_info = gateway_info;
		this.shopping_cart = shopping_cart;
		this.checkout_options = checkout_options;
		this.customer = customer;
		return this;
	}

	public Order setDirectKlarna(String order_id, String description,
			Integer amount, String currency, PaymentOptions payment_options,
			GatewayInfo gateway_info, ShoppingCart shopping_cart,
			CheckoutOptions checkout_options, Customer customer,
			Delivery delivery) {
		this.type = "direct";
		this.gateway = "KLARNA";
		this.order_id = order_id;
		this.description = description;
		this.amount = amount;
		this.currency = currency;
		this.payment_options = payment_options;
		this.gateway_info = gateway_info;
		this.shopping_cart = shopping_cart;
		this.checkout_options = checkout_options;
		this.customer = customer;
		this.delivery = delivery;
		return this;
	}

	public Order setDirectBank(String order_id, String description,
			Integer amount, String currency, GatewayInfo gateway_info) {
		this.type = "direct";
		this.gateway = "DIRECTBANK";
		this.order_id = order_id;
		this.description = description;
		this.amount = amount;
		this.currency = currency;
		this.gateway_info = gateway_info;
		return this;
	}

	public Order setDirectIdeal(String order_id, String description,
			Integer amount, String currency, PaymentOptions payment_options,
			GatewayInfo gateway_info) {
		this.type = "direct";
		this.gateway = "IDEAL";
		this.order_id = order_id;
		this.description = description;
		this.amount = amount;
		this.currency = currency;
		this.payment_options = payment_options;
		this.gateway_info = gateway_info;
		return this;
	}

	public Order setDirectIdealQR(String order_id, String description,
			Integer amount, String currency, PaymentOptions payment_options,
			GatewayInfo gateway_info) {
		this.type = "redirect";
		this.gateway = "IDEALQR";
		this.order_id = order_id;
		this.description = description;
		this.amount = amount;
		this.currency = currency;
		this.payment_options = payment_options;
		this.gateway_info = gateway_info;
		return this;
	}
}
