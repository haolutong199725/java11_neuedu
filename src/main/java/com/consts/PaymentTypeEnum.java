package com.consts;

public enum PaymentTypeEnum {
	
	ONLINE(1,"在线支付"),
	OFFLINE(2,"货到付款");
	
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
