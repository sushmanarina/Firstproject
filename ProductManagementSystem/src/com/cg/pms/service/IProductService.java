package com.cg.pms.service;

import java.util.List;

import com.cg.pms.dto.Product;
import com.cg.pms.exceptions.PMSException;

public interface IProductService {

	public List<Product> addProduct(Product product);

	public List<Product> getAllProducts();

	public Product getProduct(int id) throws PMSException;

	public Product updateProduct(double cost);

	public List<Product> removeProduct(int id) throws PMSException;

	public boolean validateProductName(String productName) throws PMSException;

	public boolean validateCompanyName(String companyName) throws PMSException;
}
