package com.godoro.deneme;
import com.godoro.inventory.entity.Product;
import com.godoro.repository.*;
public class InsertTest {

	public static void main(String[] args) throws Exception {
		ProductRespository productRespository=new ProductRespository();
		Product product=new Product();
		product.setProductName("Þisme Koltuk");
		product.setSalesPrice(165);
		boolean result=productRespository.insert(product);
		System.out.println(result);
	}

}
