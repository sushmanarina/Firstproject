package com.cg.pms.presentation;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.cg.pms.dto.Product;
import com.cg.pms.exceptions.PMSException;
import com.cg.pms.service.IProductService;
import com.cg.pms.service.ProductService;

public class UIClass {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		IProductService service = new ProductService();

		String input = "";
		do {

			System.out.println("***** Welcome to Product Management System");
			System.out.println("Select your operation");
			System.out.println("1. Add Product");
			System.out.println("2. Update Product");
			System.out.println("3. Delete Product");
			System.out.println("4. Get Product");
			System.out.println("5. Get All Products");
			System.out.println("6. Exit");

			Scanner scanner = null;
			int choice = 0;
			boolean choiceFlag = false;

			do {
				scanner = new Scanner(System.in);
				System.out.println("Enter your input");
				try {
					choice = scanner.nextInt();
					choiceFlag = true;
				} catch (InputMismatchException e) {
					choiceFlag = false;
					System.err.println("Input should contain only digits");
				}
			} while (!choiceFlag);

			int id = 0;
			boolean idFlag = false;

			switch (choice) {

			case 1:
				boolean flag = false;
				Product product = null;
				do {
					try {
						product = ProductDetails.addProduct();
						flag = true;
					} catch (PMSException e) {
						flag = false;
						System.err.println(e.getMessage());
					}
				} while (!flag);

				List<Product> list = service.addProduct(product);
				for (Product productData : list) {
					System.out.println(productData);
				}

				break;
			case 2:

				break;
			case 3:

				id = 0;
				idFlag = false;
				do {
					scanner = new Scanner(System.in);
					System.out.println("Enter id to delete");
					try {
						id = scanner.nextInt();
						idFlag = true;
						List<Product> productList = service.removeProduct(id);
						for (Product productData : productList) {
							System.out.println(productData);
						}
					} catch (InputMismatchException e) {
						idFlag = false;
						System.err.println("Id should be digits");
					}
				} while (!idFlag);

				break;

			case 4:
				id = 0;
				idFlag = false;
				do {
					scanner = new Scanner(System.in);
					System.out.println("Enter id to get the Product details");
					try {
						id = scanner.nextInt();
						idFlag = true;
						Product productData = service.getProduct(id);
						System.out.println(productData);
					} catch (InputMismatchException e) {
						idFlag = false;
						System.err.println("Id should be digits");
					}
				} while (!idFlag);

				break;

			case 5:

				List<Product> proList = service.getAllProducts();
				for (Product productData : proList) {
					System.out.println(productData);
				}
				break;
			case 6:
				System.exit(0);
				System.out.println("Please visit again");
				break;

			default:
				break;
			}

			System.out.println("do u want top continue again (yes/no)");
			input = scanner.next();

		} while (input.equals("yes"));

	}

}
