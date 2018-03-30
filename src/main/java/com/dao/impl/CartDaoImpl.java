package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.common.DBUtils;
import com.common.MyBatisUtils;
import com.dao.CartDao;
import com.entity.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("cartDao")
public class CartDaoImpl implements CartDao {
	@Autowired
	SqlSessionFactory factory;

	public void setFactory(SqlSessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public Cart findCartByUserIdAndProductId(Integer userid, Integer productid) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		Cart cart=null;
			 try {
				conn=DBUtils.getConnection();
				String sql="select user_id,product_id,quantity,checked,create_time,update_time from cart where user_id=? and product_id=?";
				pst=conn.prepareStatement(sql);
				pst.setInt(1, userid);
				pst.setInt(2, productid);
				rs=pst.executeQuery();
				if(rs.next()) {
					cart=new Cart(rs.getInt("user_id"),rs.getInt("product_id"),rs.getInt("quantity"),rs.getInt("checked"),rs.getDate("create_time"),rs.getDate("update_time"));
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					DBUtils.close(conn, pst, rs);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			 return cart;
	}

	@Override
	public int updateCartByUserIdAndProducId(Integer userid, Integer productid, int quantity) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pst=null;
			 try {
				conn=DBUtils.getConnection();
				String sql="update cart set  quantity=quantity+?,update_time=now() where user_id=? and product_id=?";
				
				pst=conn.prepareStatement(sql);
				pst.setInt(1,quantity);
				pst.setInt(2,userid);
				pst.setInt(3,productid);
				pst.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					DBUtils.close(conn, pst);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			 return 0;
	}

	@Override
	public int addProductIntoCartByUserIdAndProductId(Integer userid, Integer productid, int quantity) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pst=null;
			 try {
				conn=DBUtils.getConnection();
				String sql="insert into cart(user_id,product_id,quantity,create_time,update_time) values(?,?,?,now(),now())";
				 pst=conn.prepareStatement(sql);
				 pst.setInt(1, userid);
				 pst.setInt(2, productid);
				 pst.setInt(3, quantity);
				return pst.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					DBUtils.close(conn,pst);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			 return 0;
	}

	@Override
	public List<Cart> findCartByUserId(Integer userid) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		Cart cart=null;
		List<Cart> list=new ArrayList<Cart>();
			 try {
				conn=DBUtils.getConnection();
				String sql="select p.product_price product_price,p.product_name product_name,p.product_image product_image,c.user_id,c.product_id,c.quantity,c.checked,c.create_time,c.update_time from cart c left join product p on c.product_id=p.product_id where user_id=?";
				pst=conn.prepareStatement(sql);
				pst.setInt(1, userid);
				rs=pst.executeQuery();
				while(rs.next()) {
					cart=new Cart(rs.getInt("user_id"),rs.getInt("product_id"),rs.getInt("quantity"),rs.getInt("checked"),rs.getInt("product_price"),rs.getString("product_name"),rs.getString("product_image"),rs.getDate("create_time"),rs.getDate("update_time"));
					list.add(cart);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					DBUtils.close(conn, pst, rs);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			 return list;
	}

	@Override
	public int updateChecked(Integer userid, Integer productid, Integer checked) {
		// TODO Auto-generated method stub
		SqlSession session=factory.openSession(true);
		
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("userid", userid);
		map.put("productid",productid);
		map.put("checked",checked);
		int a=session.update("com.entity.Cart.updateChecked", map);
		session.close();
		return a;
	}

	@Override
	public int updateQuantity(Integer userid, Integer productid, Integer quantity) {
		// TODO Auto-generated method stub
		SqlSession session=factory.openSession(true);
		
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("userid", userid);
		map.put("productid",productid);
		map.put("quantity",quantity);
		int a=session.update("com.entity.Cart.updateQuantity", map);
		session.close();
		return a;
	}

	@Override
	public int deleteCart(Integer userid, Integer productid) {
		// TODO Auto-generated method stub
		SqlSession session=factory.openSession(true);
		
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("userid", userid);
		map.put("productid",productid);
		int a=session.update("com.entity.Cart.deleteCart", map);
		session.close();
		return a;
	}

	@Override
	public List<Cart> findCartListByUserid(Integer userid) {
		// TODO Auto-generated method stub
		SqlSession session=factory.openSession(true);
		List<Cart> cart=session.selectList("com.entity.Cart.findCartListByUserid", userid);
		session.close();
		return cart;
	}

	@Override
	public int deleteCartByUseridAndChecked(Integer userid) {
		// TODO Auto-generated method stub
		SqlSession session=factory.openSession(true);
		int a=session.delete("com.entity.Cart.deleteCartByUseridAndChecked", userid);
		session.close();
		return a;
	}


}
