package com.consts;

public enum PaymentTypeEnum {
	
	ONLINE(1,"����֧��"),
	OFFLINE(2,"��������");
	
	private int type;
	private String message;
	public int getStatus() {
		return type;
	}
	public void setStatus(int status) {
		this.type = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	private PaymentTypeEnum(int type, String message) {
		this.type = type;
		this.message = message;
	}
	
}
