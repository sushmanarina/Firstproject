package com.cg.pms.dao;

import java.util.List;

import com.cg.pms.dto.Product;
import com.cg.pms.exceptions.PMSException;
import com.cg.pms.utility.PMSUtility;

public class ProductDao implements IProductDao {

	@Override
	public List<Product> addProductDetails(Product product) {

		List<Product> list = PMSUtility.getList();
		list.add(product);
		return list;
	}

	@Override
	public List<Product> getAllProducts() {
		return PMSUtility.getList();
	}

	@Override
	public Product getProduct(int id) throws PMSException {

		List<Product> list = PMSUtility.getList();
		Product productData = null;

		for (Product product : list) {
			if (product.getProductId() == id) {
				productData = product;
				break;
			}
		}
		if (productData == null) {
			throw new PMSException("No Product present with the given id: " + id);
		}

		return productData;
	}

	@Override
	public Product updateProduct(double cost) {

		return null;
	}

	@Override
	public List<Product> removeProduct(int id) throws PMSException {

		boolean flag = false;
		List<Product> list = PMSUtility.getList();
		for (Product product : list) {
			if (product.getProductId() == id) {
				flag = true;
				list.remove(product);
				break;
			}
		}
		if (flag == false) {
			throw new PMSException("No Product present with the given id: " + id + " to delete");
		}
		return PMSUtility.getList();
	}

}
