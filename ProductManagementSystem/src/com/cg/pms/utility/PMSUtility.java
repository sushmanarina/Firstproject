package com.cg.pms.utility;

import java.util.ArrayList;
import java.util.List;

import com.cg.pms.dto.Product;

public class PMSUtility {

	static List<Product> list = null;

	static {
		list = new ArrayList<>();
		list.add(new Product(1231, "TV", 43000, "VU"));
		list.add(new Product(1209, "Wasing Machine", 23000, "LG"));
		list.add(new Product(1109, "Fridge", 34000, "LG"));
		list.add(new Product(1100, "Laptop", 63000, "HP"));
		list.add(new Product(1010, "Cooler", 15000, "Bajaj"));
	}

	public static List<Product> getList() {
		return list;
	}

	public static void setList(List<Product> list) {
		PMSUtility.list = list;
	}

}
