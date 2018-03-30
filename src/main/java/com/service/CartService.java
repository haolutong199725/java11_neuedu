package com.service;

import java.util.List;

import com.entity.Cart;

public interface CartService {
	public Cart findCartByUserIdAndProductId(Integer userid, Integer productid);
	public int AddOrUpdateCart(Integer userid, Integer productid, int quantity);
	public List<Cart> findCartByUserId(Integer userid);
	public int updateChecked(Integer userid, Integer productid, int checked);
	public int updateQuantity(Integer userid, Integer productid, int quantity);
	public int deleteCart(Integer userid, Integer productid);
}
