package com.entity.vo;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.consts.OrderStatusEnum;
import com.consts.PaymentTypeEnum;
import com.entity.User;
import com.entity.UserOrder;

public class OrderVO  {
	private Integer	id ;
	private User user;
	private Long	order_no;
	private Integer	user_id ;
	private Integer	shipping_id ;
	private String	payment ;
	private String	payment_type;
	private Integer	postage;
	private String	status ;
	private	String payment_time ;
	private	String send_time ;
	private	String end_time ;
	private	String close_time;
	private	String create_time;
	private	String update_time ;
	
     
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Long getOrder_no() {
		return order_no;
	}


	public void setOrder_no(Long order_no) {
		this.order_no = order_no;
	}


	public Integer getUser_id() {
		return user_id;
	}


	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}


	public Integer getShipping_id() {
		return shipping_id;
	}


	public void setShipping_id(Integer shipping_id) {
		this.shipping_id = shipping_id;
	}


	public String getPayment() {
		return payment;
	}


	public void setPayment(String payment) {
		this.payment = payment;
	}


	public String getPayment_type() {
		return payment_type;
	}


	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}


	public Integer getPostage() {
		return postage;
	}


	public void setPostage(Integer postage) {
		this.postage = postage;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getPayment_time() {
		return payment_time;
	}


	public void setPayment_time(String payment_time) {
		this.payment_time = payment_time;
	}


	public String getSend_time() {
		return send_time;
	}


	public void setSend_time(String send_time) {
		this.send_time = send_time;
	}


	public String getEnd_time() {
		return end_time;
	}


	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}


	public String getClose_time() {
		return close_time;
	}


	public void setClose_time(String close_time) {
		this.close_time = close_time;
	}


	public String getCreate_time() {
		return create_time;
	}


	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}


	public String getUpdate_time() {
		return update_time;
	}


	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}


	public void converUserOrderToOrderVo(UserOrder userOrder) {
    	 this.id=userOrder.getId();
    	 this.order_no=userOrder.getOrder_no();
    	 this.payment=userOrder.getPayment().toString();
    	 Integer paymenttype=userOrder.getPayment_type();
    	 if(paymenttype==PaymentTypeEnum.ONLINE.getStatus()) {
    		 this.payment_type="在线支付";
    	 }else {
    		 this.payment_type="货到付款";
    	 }
    	 this.postage=userOrder.getPostage();
    	 Integer status=userOrder.getStatus();
    	 if(status==OrderStatusEnum.CANCEL.getStatus()) {
    		 this.status="已取消";
    	 }else if(status==OrderStatusEnum.UNPAY.getStatus()) {
    		 this.status="未付款";
    	 }else if(status==OrderStatusEnum.PAY.getStatus()) {
    		 this.status="已付款";
    	 }else if(status==OrderStatusEnum.SEND.getStatus()) {
    		 this.status="已发货";
    	 }else if(status==OrderStatusEnum.SUCCESS.getStatus()) {
    		 this.status="交易成功";
    	 }else if(status==OrderStatusEnum.CLOSE.getStatus()) {
    		 this.status="交易关闭";
    	 }
    	 Date create_time=userOrder.getCreate_time();
    	 
    	 SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	 this.create_time=format.format(create_time.getTime());
    	 this.update_time=format.format(userOrder.getUpdate_time().getTime());
    	 this.user=userOrder.getUser();
     }
}
