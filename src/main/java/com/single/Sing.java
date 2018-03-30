package com.single;

import com.dao.AddressDao;
import com.dao.CartDao;
import com.dao.impl.AddressDaoImpl;
import com.dao.impl.AddressDaoImplByMyBatis;
import com.dao.impl.CartDaoImpl;
import com.entity.Address;

public class Sing {
	private static AddressDao address;
	public static AddressDao getInstance() {
		if(address==null) {
			address=new AddressDaoImplByMyBatis();
		}
		return address;
	}
}
