package com.godoro.prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateTest{

	public static void main(String[] args) throws Exception {
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/mdb1";
		String user="root";
		String password="kurban764mehmet";
		Class.forName(driver).newInstance();
		
		Connection connection=DriverManager.getConnection(url,user,password);
		
			String sql="update Product set productName=?,salesPrice=? where productId=?";
			PreparedStatement statement=connection.prepareStatement(sql);
			statement.setString(1, "Yeni Ürün");
			statement.setDouble(2, 999);
			statement.setLong(3, 1);
			int affected=statement.executeUpdate();
			System.out.println("Etkilenen "+affected);
			
		connection.close();
	}

}
