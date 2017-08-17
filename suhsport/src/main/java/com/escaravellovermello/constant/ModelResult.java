package com.escaravellovermello.constant;

public enum ModelResult {
	ADD_OK("add_ok"), 
	ADD_FAIL("add_fail"),
	REMOVE_OK("remove_ok"),
	REMOVE_FAIL("remove_fail");
	
	private String value;

	private ModelResult(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	

}
