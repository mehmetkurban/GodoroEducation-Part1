package com.godoro.deneme;

import java.util.List;

import com.godoro.inventory.entity.Product;
import com.godoro.repository.ProductRespository;

public class ListTest {

	public static void main(String[] args) throws Exception {
		ProductRespository productRespository=new ProductRespository();
		List<Product> productList=productRespository.list();
		for(Product product:productList){
			System.out.println(product.getProductId()+""+product.getProductName()+""+product.getSalesPrice());
		}
	}

}
