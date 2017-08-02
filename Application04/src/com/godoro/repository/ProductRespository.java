package com.godoro.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.godoro.inventory.entity.Product;

public class ProductRespository  {
	private String driver="com.mysql.jdbc.Driver";
	private String url="jdbc:mysql://localhost:3306/mdb1";
	private String user="root";
	private String password="kurban764mehmet";
	
		public ProductRespository() throws Exception{
			Class.forName(driver).newInstance();
		}
		
			public boolean insert(Product product)throws Exception{
				Connection connection=DriverManager.getConnection(url,user,password);
				
				String sql="insert into Product(productName,salesPrice) values(?,?)";
				PreparedStatement statement=connection.prepareStatement(sql);
				statement.setString(1,product.getProductName());
				statement.setDouble(2,product.getSalesPrice());
				int affected=statement.executeUpdate();
				
				connection.close();
				return affected>0;
			}
			
			public boolean update(Product product)throws Exception{
				Connection connection=DriverManager.getConnection(url,user,password);
				
				String sql="update Product set productName=?,salesPrice=? where productId=?";
				PreparedStatement statement=connection.prepareStatement(sql);
				statement.setString(1,product.getProductName());
				statement.setDouble(2,product.getSalesPrice());
				statement.setLong(3,product.getProductId());
				int affected=statement.executeUpdate();
				
				connection.close();
				return affected>0;
			}
			
			public boolean delete(long productId)throws Exception{
				Connection connection=DriverManager.getConnection(url,user,password);
				
				String sql="delete from Product where productId=?";
				PreparedStatement statement=connection.prepareStatement(sql);
				statement.setLong(1,productId);
				int affected=statement.executeUpdate();
				
				
				connection.close();
				return affected>0;
			}
			
			public Product find(long productId)throws Exception{
				Product product=null;
				Connection connection=DriverManager.getConnection(url,user,password);
				
				String sql="select*from Product where productId=?";
				PreparedStatement statement=connection.prepareStatement(sql);
				statement.setLong(1,productId);
				ResultSet resultSet=statement.executeQuery();
				while(resultSet.next()){
					product=new Product();
					product.setProductId(resultSet.getLong("productId"));
					product.setProductName(resultSet.getString("productName"));
					product.setSalesPrice(resultSet.getDouble("salesPrice"));
				}
				connection.close();
				return product;
			}
			
			public List<Product> list()throws Exception{
				List<Product> productList=new ArrayList<Product>();
				Connection connection=DriverManager.getConnection(url,user,password);
				
				String sql="select*from Product";
				PreparedStatement statement=connection.prepareCall(sql);
				
				ResultSet resultSet=statement.executeQuery();
				while(resultSet.next()){
					Product product=new Product();
					product.setProductId(resultSet.getLong("productId"));
					product.setProductName(resultSet.getString("productName"));
					product.setSalesPrice(resultSet.getDouble("salesPrice"));
					productList.add(product);	
				}
				connection.close();
				return productList;
			}
}
