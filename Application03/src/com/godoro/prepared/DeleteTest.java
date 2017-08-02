package com.godoro.prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteTest{

	public static void main(String[] args) throws Exception {
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/mdb1";
		String user="root";
		String password="kurban764mehmet";
		Class.forName(driver).newInstance();
		
		Connection connection=DriverManager.getConnection(url,user,password);
		
			String sql="delete from Product where productId=?";
			PreparedStatement statement=connection.prepareStatement(sql);
			statement.setLong(1, 2);
			int affected=statement.executeUpdate();
			System.out.println("Etkilenen "+affected);
			
		connection.close();
	}

}
