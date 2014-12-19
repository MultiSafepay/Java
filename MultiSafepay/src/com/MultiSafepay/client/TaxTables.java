package com.MultiSafepay.client;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class TaxTables {

	@SerializedName("default") public TaxTable _default = null; //protected name, use gson @SerializedName
	public List<TaxTable> alternate						= null;
}
