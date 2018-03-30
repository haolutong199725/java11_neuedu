package com.dao.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.common.MyBatisUtils;
import com.dao.ProductDao;
import com.entity.Cart;
import com.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("productDao")
public class ProductDaoImpl implements ProductDao {
	@Autowired
	SqlSessionFactory factory;

	public void setFactory(SqlSessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public Product findProductByProductId(Integer productid) {
		// TODO Auto-generated method stub
		SqlSession session=factory.openSession(true);
		Product product=session.selectOne("com.entity.Product.findProductByProductId", productid);
		session.close();
		return product;
	}

	@Override
	public int searchProductQuantity(Integer productid) {
		// TODO Auto-generated method stub
		SqlSession session=factory.openSession(true);
		int a=session.selectOne("com.entity.Product.searchProductQuantity", productid);
		session.close();
		return a;
	}

	@Override
	public int reduceProductStock(Integer productid, Integer quantity) {
		// TODO Auto-generated method stub
		SqlSession session=factory.openSession(true);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("quantity", quantity);
		map.put("productid",productid);
		int a=session.update("com.entity.Product.reduceProductStock", map);
		session.close();
		return a;
	}

	@Override
	public List<Product> findAllProduct() {
		// TODO Auto-generated method stub
		SqlSession session=factory.openSession(true);
		List<Product> product=session.selectList("com.entity.Product.findAllProduct");
		session.close();
		return product;
	}

	@Override
	public int insertProduct(int productid,String productname,String productimage,String productprice) {
		// TODO Auto-generated method stub
		SqlSession session=factory.openSession(true);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("productid", productid);
		map.put("productname", productname);
		map.put("productimage",productimage);
		map.put("productprice",productprice);
		int a=session.insert("com.entity.Product.insertProduct", map);
		return a;
	}

}
