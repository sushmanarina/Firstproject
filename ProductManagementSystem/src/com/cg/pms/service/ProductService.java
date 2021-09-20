package com.cg.pms.service;

import java.util.List;
import java.util.regex.Pattern;

import com.cg.pms.dao.IProductDao;
import com.cg.pms.dao.ProductDao;
import com.cg.pms.dto.Product;
import com.cg.pms.exceptions.PMSException;

public class ProductService implements IProductService {

	IProductDao productDao = new ProductDao();

	@Override
	public List<Product> addProduct(Product product) {
		return productDao.addProductDetails(product);
	}

	@Override
	public List<Product> getAllProducts() {
		return productDao.getAllProducts();
	}

	@Override
	public Product getProduct(int id) throws PMSException {
		return productDao.getProduct(id);
	}

	@Override
	public Product updateProduct(double cost) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> removeProduct(int id) throws PMSException {
		return productDao.removeProduct(id);
	}

	@Override
	public boolean validateProductName(String productName) throws PMSException {

		boolean flag = false;
		String nameRegEx = "[A-Z]{1}[a-zA-Z\\s]{4,9}";

		if (Pattern.matches(nameRegEx, productName)) {
			flag = true;
		} else {
			throw new PMSException("Product Name should start with CApital and length should be in between 5 to 10");
		}
		return flag;
	}

	@Override
	public boolean validateCompanyName(String companyName) throws PMSException {
		boolean flag = false;
		String nameRegEx = "[a-zA-Z\\s]+";

		if (Pattern.matches(nameRegEx, companyName)) {
			flag = true;
		} else {
			throw new PMSException("company name should contain only alphabets");
		}
		return flag;
	}

}
