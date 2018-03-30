package com.service;

import java.util.List;

import com.entity.Product;

public interface ProductService {
	public List<Product> findAllProduct();
	public int insertProduct(int productid, String productname, String productimage, String productprice);
}
