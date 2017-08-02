package com.godoro.prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Transaction{

	public static void main(String[] args) throws Exception {
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/mdb1";
		String user="root";
		String password="kurban764mehmet";
		Class.forName(driver).newInstance();
		
		Connection connection=DriverManager.getConnection(url,user,password);
			connection.setAutoCommit(false);
			String sql="insert into Product(productName,salesPrice) values(?,?)";
			
			PreparedStatement statement1=connection.prepareStatement(sql);
			statement1.setString(1, "Ürün A");
			statement1.setDouble(2, 1000);
			int affected1=statement1.executeUpdate();
			System.out.println("Etkilenen I "+affected1);
			
			PreparedStatement statement2=connection.prepareStatement(sql);
			statement2.setString(1, "Ürün B");
			statement2.setDouble(2, 1000);
			int affected2=statement2.executeUpdate();
			System.out.println("Etkilenen II "+affected2);
			
			PreparedStatement statement3=connection.prepareStatement(sql+"X");
			statement3.setString(1, "Ürün C");
			statement3.setDouble(2, 1000);
			int affected3=statement3.executeUpdate();
			System.out.println("Etkilenen III "+affected3);
			
			connection.commit();
		connection.close();
	}
		// ++ROLL BACK,SAVE POÝNT
		// Bench iþlem  excel den 100000 milyon data cak db ye örnek bu
		// row set disconnet modda çalýþýr
}
