package com.MultiSafepay.classes;

public class PaymentOptions {

	public String notification_url = "";
	public String notification_method = ""; // GET - POST
	public String cancel_url = "";
	public String redirect_url = "";
	public boolean close_window = false;
	public String template_id = "";
	public Template template = null;

	public PaymentOptions(String notification_url, String cancel_url,
			String redirect_url) {
		this.notification_url = notification_url;
		this.cancel_url = cancel_url;
		this.redirect_url = redirect_url;
	}
}