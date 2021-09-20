package com.cg.pms.presentation;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.cg.pms.dto.Product;
import com.cg.pms.exceptions.PMSException;
import com.cg.pms.service.IProductService;
import com.cg.pms.service.ProductService;

public class ProductDetails {

	@SuppressWarnings("resource")
	public static Product addProduct() throws PMSException {

		IProductService service = new ProductService();

		Scanner scanner = null;
		int productId = 0;
		boolean productIdFlag = false;
		do {
			scanner = new Scanner(System.in);
			System.out.println("Enter Product Id");
			try {
				productId = scanner.nextInt();
				productIdFlag = true;
			} catch (InputMismatchException e) {
				productIdFlag = false;
				throw new PMSException("Product id should contain only digits");
			}
		} while (!productIdFlag);

		String productName = "";
		boolean productNameFlag = false;

		do {
			scanner = new Scanner(System.in);
			System.out.println("Enter Product Name");
			productName = scanner.nextLine();

			try {
				service.validateProductName(productName);
				productNameFlag = true;
			} catch (PMSException e) {
				productNameFlag = false;
				System.err.println(e.getMessage());
			}

		} while (!productNameFlag);

		double productCost = 0;
		boolean productCostFlag = false;
		do {
			scanner = new Scanner(System.in);
			System.out.println("Enter Product cost");
			try {
				productCost = scanner.nextDouble();
				productCostFlag = true;
			} catch (InputMismatchException e) {
				productCostFlag = false;
				throw new PMSException("Product cost should contain only digits");
			}
		} while (!productCostFlag);

		String companyName = "";
		boolean companyNameFlag = false;

		do {
			scanner = new Scanner(System.in);
			System.out.println("Enter Compnay Name");
			companyName = scanner.nextLine();
			try {
				service.validateCompanyName(companyName);
				companyNameFlag = true;
			} catch (PMSException e) {
				companyNameFlag = false;
				System.err.println(e.getMessage());
			}
		} while (!companyNameFlag);

		Product product = new Product(productId, productName, productCost, companyName);
		return product;
	}
}
