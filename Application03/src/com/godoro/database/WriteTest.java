package com.godoro.database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class WriteTest{

	public static void main(String[] args) throws Exception {
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/mdb1";
		String user="root";
		String password="kurban764mehmet";
		Class.forName(driver).newInstance();
		
		Connection connection=DriverManager.getConnection(url,user,password);
		String sql="insert into Product(productName,salesPrice) "
				+" values('Cep Telefonu',1750)";
		Statement statement=connection.createStatement();
		int affected=statement.executeUpdate(sql);
		System.out.println("Etkilenen "+affected);
		
		connection.close();
	}

}