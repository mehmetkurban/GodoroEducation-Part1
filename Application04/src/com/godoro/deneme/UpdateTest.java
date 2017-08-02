package com.godoro.deneme;

import com.godoro.inventory.entity.Product;
import com.godoro.repository.ProductRespository;

public class UpdateTest {

	public static void main(String[] args) throws Exception {
		ProductRespository productRespository=new ProductRespository();
		Product product =productRespository.find(4);
		product.setSalesPrice(250);
		boolean updated=productRespository.update(product);
		if(updated){
			System.out.println("�r�n g�ncellendi");
		}else{
			System.out.println("Bir yanl��l�k oldu");
		}

	}

}
