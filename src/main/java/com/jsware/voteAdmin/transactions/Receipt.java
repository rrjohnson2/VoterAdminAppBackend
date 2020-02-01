package com.jsware.voteAdmin.transactions;

public class Receipt {
	
	private String results;
	private Object data;
	
	public Receipt(String results, Object data)
	{
		this.results = results;
		this.data = data;
	}

	public String getResults() {
		return results;
	}

	public Object getData() {
		return data;
	}
	
	

}
