package com.cg.pms.dao;

import java.util.List;

import com.cg.pms.dto.Product;
import com.cg.pms.exceptions.PMSException;

public interface IProductDao {

	public List<Product> addProductDetails(Product product);

	public List<Product> getAllProducts();

	public Product getProduct(int id) throws PMSException;

	public Product updateProduct(double cost);

	public List<Product> removeProduct(int id) throws PMSException;
}
