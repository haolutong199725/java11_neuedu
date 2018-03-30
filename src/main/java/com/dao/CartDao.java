package com.dao;

import java.util.List;

import com.entity.Cart;

public interface CartDao {

	
	
	public Cart findCartByUserIdAndProductId(Integer userid, Integer productid);
	public int updateCartByUserIdAndProducId(Integer userid, Integer productid, int quantity);
	public int addProductIntoCartByUserIdAndProductId(Integer userid, Integer productid, int quantity);
	public List<Cart> findCartByUserId(Integer userid);
	public int updateChecked(Integer userid, Integer productid, Integer checked);
	public int updateQuantity(Integer userid, Integer productid, Integer quantity);
	public int deleteCart(Integer userid, Integer productid);
	public List<Cart> findCartListByUserid(Integer userid);
	public int deleteCartByUseridAndChecked(Integer userid);
}
