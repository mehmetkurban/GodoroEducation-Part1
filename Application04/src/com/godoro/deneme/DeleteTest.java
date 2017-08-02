package com.godoro.deneme;

import com.godoro.repository.ProductRespository;

public class DeleteTest {

	public static void main(String[] args) throws Exception {
		ProductRespository productRespository=new ProductRespository();	
		boolean deleted=productRespository.delete(1);
		if(deleted){
			System.out.println("Silindi");
		}else{
			System.out.println("Bu ID de Ürün yok");
		}

	}

}
