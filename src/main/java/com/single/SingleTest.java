package com.single;

import com.dao.CartDao;
import com.dao.impl.CartDaoImpl;

public class SingleTest {
		private static CartDao cartdao;
		public static CartDao getInstance() {
			if(cartdao==null) {
				cartdao=new CartDaoImpl();
			}
			return cartdao;
		}

	}
