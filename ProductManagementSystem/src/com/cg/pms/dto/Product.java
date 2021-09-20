package com.cg.pms.dto;

public class Product {

	private int productId;
	private String productName;
	private double cost;
	private String companyName;

	public Product() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param productName
	 * @param companyName
	 */
	public Product(String productName, String companyName) {
		super();
		this.productName = productName;
		this.companyName = companyName;
	}

	/**
	 * @param productId
	 * @param productName
	 * @param cost
	 * @param companyName
	 */
	public Product(int productId, String productName, double cost, String companyName) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.cost = cost;
		this.companyName = companyName;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", cost=" + cost + ", companyName="
				+ companyName + "]";
	}

}
