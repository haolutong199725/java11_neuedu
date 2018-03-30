package com.entity;

import java.math.BigDecimal;

public class Product {
		public int	product_id ;
		public String	product_name ;
		public String	product_image ;
		public BigDecimal	product_price ;
		public int getProduct_id() {
			return product_id;
		}
		public void setProduct_id(int product_id) {
			this.product_id = product_id;
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
		public BigDecimal getProduct_price() {
			return product_price;
		}
		public void setProduct_price(BigDecimal product_price) {
			this.product_price = product_price;
		}
		public Product(int product_id, String product_name, String product_image, BigDecimal product_price) {
			super();
			this.product_id = product_id;
			this.product_name = product_name;
			this.product_image = product_image;
			this.product_price = product_price;
		}
		public Product() {
			super();
		}
		
}
