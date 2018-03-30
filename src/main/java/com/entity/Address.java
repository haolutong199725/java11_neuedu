
package com.entity;

public class Address {
           int user_id;
           String receiver_name;
           String receiver_phone;
           String receiver_mobile;
           String receiver_province;
           String receiver_city;
		public int getUserid() {
			return user_id;
		}
		public void setUserid(int userid) {
			user_id = userid;
		}
		public String getReceivername() {
			return receiver_name;
		}
		public void setReceivername(String receivername) {
			receiver_name = receivername;
		}
		public String getReceiverphone() {
			return receiver_phone;
		}
		public void setReceiverphone(String receiverphone) {
			receiver_phone = receiverphone;
		}
		public String getReceivermobile() {
			return receiver_mobile;
		}
		public void setReceivermobile(String receivermobile) {
			receiver_mobile = receivermobile;
		}
		public String getReceiverprovince() {
			return receiver_province;
		}
		public void setReceiverprovince(String receiverprovince) {
			receiver_province = receiverprovince;
		}
		public String getReceivercity() {
			return receiver_city;
		}
		public void setReceivercity(String receivercity) {
			receiver_city = receivercity;
		}
		public Address(int userid, String receivername, String receiverphone, String receivermobile,
				String receiverprovince, String receivercity) {
			super();
			user_id = userid;
			receiver_name = receivername;
			receiver_phone = receiverphone;
		    receiver_mobile = receivermobile;
			receiver_province = receiverprovince;
			receiver_city = receivercity;
		}
		public Address() {
			super();
		}
		@Override
		public String toString() {
			return "Address [user_id=" + user_id + ", receiver_name=" + receiver_name + ", receiver_phone="
					+ receiver_phone + ", receiver_mobile=" + receiver_mobile + ", receiver_province="
					+ receiver_province + ", receiver_city=" + receiver_city + "]";
		}
	
           
}
