package com.godoro.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnetionTest {

	public static void main(String[] args) throws Exception {
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/mdb1";
		String user="root";
		String password="kurban764mehmet";
		Class.forName(driver).newInstance();
		
		Connection connection=DriverManager.getConnection(url,user,password);
			System.out.println("VeriTabaný Sunucu: "
					+connection.getMetaData().getDatabaseProductName());
		connection.close();
	}

}
