package com.dao;

import java.util.List;

import com.entity.Product;

public interface ProductDao {
    public Product findProductByProductId(Integer productid);
    public int searchProductQuantity(Integer productid);
    public int reduceProductStock(Integer productid, Integer quantity);
    public List<Product> findAllProduct();
    public int insertProduct(int productid, String productname, String productimage, String productprice);
}
