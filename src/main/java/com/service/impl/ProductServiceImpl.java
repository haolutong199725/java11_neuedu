package com.service.impl;

import java.util.List;

import com.dao.ProductDao;
import com.dao.impl.ProductDaoImpl;
import com.entity.Product;
import com.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("productService")
public class ProductServiceImpl implements ProductService {
@Autowired
ProductDao productDao;

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	public List<Product> findAllProduct() {
		// TODO Auto-generated method stub
		return productDao.findAllProduct();
	}

	@Override
	public int insertProduct(int productid,String productname, String productimage, String productprice) {
		// TODO Auto-generated method stub
		return  productDao.insertProduct(productid,productname, productimage, productprice);
	}

}
