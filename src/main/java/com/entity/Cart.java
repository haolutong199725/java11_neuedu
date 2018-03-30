package com.entity;

import java.util.Date;

public class Cart {
      int userid;
      int productid;
      int quantity;
      int checked;
      int product_price;
      String product_name;
      String product_image;
      Date createtime;
      Date updatetime;
      
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getChecked() {
		return checked;
	}
	public void setChecked(int checked) {
		this.checked = checked;
	}
	public int getProduct_price() {
		return product_price;
	}
	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_image() {
		return product_image;
	}
	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	
	public Cart(int userid, int productid, int quantity, int checked, int product_price, String product_name,
			String product_image, Date createtime, Date updatetime) {
		super();
		this.userid = userid;
		this.productid = productid;
		this.quantity = quantity;
		this.checked = checked;
		this.product_price = product_price;
		this.product_name = product_name;
		this.product_image = product_image;
		this.createtime = createtime;
		this.updatetime = updatetime;
	}
	public Cart(int userid, int productid, int quantity, int checked, Date createtime, Date updatetime) {
		super();
		this.userid = userid;
		this.productid = productid;
		this.quantity = quantity;
		this.checked = checked;
		this.createtime = createtime;
		this.updatetime = updatetime;
	}
	public Cart() {
		super();
	}
	@Override
	public String toString() {
		return "Cart [userid=" + userid + ", productid=" + productid + ", quantity=" + quantity + ", checked=" + checked
				+ ", product_price=" + product_price + ", product_name=" + product_name + ", product_image="
				+ product_image + ", createtime=" + createtime + ", updatetime=" + updatetime + "]";
	}
	
      
      
}
