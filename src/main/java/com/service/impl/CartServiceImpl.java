package com.service.impl;

import java.util.List;

import com.dao.CartDao;
import com.entity.Cart;
import com.service.CartService;
import com.single.SingleTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("cartService")
public class CartServiceImpl implements CartService {
	@Autowired
	CartDao cartdao;

	public void setCartdao(CartDao cartdao) {
		this.cartdao = cartdao;
	}

	@Override
	public Cart findCartByUserIdAndProductId(Integer userid, Integer productid) {
		// TODO Auto-generated method stub
		return cartdao.findCartByUserIdAndProductId(userid, productid);
	}

	@Override
	public int AddOrUpdateCart(Integer userid, Integer productid, int quantity) {
		// TODO Auto-generated method stub
		Cart cart=cartdao.findCartByUserIdAndProductId(userid, productid);
		if(cart!=null) {
			cartdao.updateCartByUserIdAndProducId(userid, productid, quantity);
			return 1;
			
		}else {
			cartdao.addProductIntoCartByUserIdAndProductId(userid, productid, quantity);
			return 0;
		}
		

	}

	@Override
	public List<Cart> findCartByUserId(Integer userid) {
		// TODO Auto-generated method stub
		return cartdao.findCartByUserId(userid);
	}

	@Override
	public int updateChecked(Integer userid, Integer productid, int checked) {
		// TODO Auto-generated method stub
		return cartdao.updateChecked(userid, productid, checked);
	}

	@Override
	public int updateQuantity(Integer userid, Integer productid, int quantity) {
		// TODO Auto-generated method stub
		return cartdao.updateQuantity(userid, productid, quantity);
	}

	@Override
	public int deleteCart(Integer userid, Integer productid) {
		// TODO Auto-generated method stub
		return cartdao.deleteCart(userid, productid);
	}


	

}
