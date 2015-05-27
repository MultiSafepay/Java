package com.MultiSafepay.classes;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class TaxTables {

	@SerializedName("default") public TaxTable _default = null; //protected name, use gson @SerializedName
	public List<TaxTable> alternate						= null;
	
	public TaxTables addDefault(TaxTable table)
	{
		this._default	= table;
		return this;
	}
	
	public TaxTables addAlternates(List<TaxTable> list)
	{
		this.alternate	= list;
		return this;
	}
}
