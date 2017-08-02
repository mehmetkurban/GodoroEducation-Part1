package com.godoro.prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;



public class ListTest{

	public static void main(String[] args) throws Exception {
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/mdb1";
		String user="root";
		String password="kurban764mehmet";
		Class.forName(driver).newInstance();
		
		Connection connection=DriverManager.getConnection(url,user,password);
		
			String sql="select*from Product";
			PreparedStatement statement=connection.prepareCall(sql);
			
			ResultSet resultSet=statement.executeQuery();
			while(resultSet.next()){
				long productId=resultSet.getLong("productId");
				String productName=resultSet.getString("productName");
				double salesPrice=resultSet.getDouble("salesPrice");
				System.out.println(productId+" "+productName+" "+salesPrice);
			}
		connection.close();
	}

}