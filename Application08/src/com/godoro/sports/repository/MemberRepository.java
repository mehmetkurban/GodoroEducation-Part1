package com.godoro.sports.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import com.godoro.membership.entity.Member;

public class MemberRepository {
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/mdb4";
	private String user = "root";
	private String password = "kurban764mehmet";
	
	public MemberRepository() throws Exception {
		Class.forName(driver).newInstance();
	}
	
	public Member findByUserName(String memberUsername) throws Exception {
		Member member=null;
		Connection connection = null;
		connection = DriverManager.getConnection(url, user, password);
		
		String sql = "SELECT * FROM Member "+" where memberUsername=?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, memberUsername);
		ResultSet resultSet = statement.executeQuery();
		if(resultSet.next()){
			member = new Member();
			member.setMemberId(resultSet.getLong("memberId"));
			member.setMemberUsername(resultSet.getString("memberUsername"));
			member.setMemberPassword(resultSet.getString("memberPassword"));
		}
		connection.close();
		
		return member;
	}
	public boolean insert(Member member)throws Exception{
		Connection connection=DriverManager.getConnection(url,user,password);
		
		String sql="insert into Member(memberUsername,memberPassword) values(?,?)";
		PreparedStatement statement=connection.prepareStatement(sql);		
		statement.setString(1,member.getMemberUsername());
		statement.setString(2, member.getMemberPassword());
		int affected=statement.executeUpdate();		
		connection.close();
		return affected>0;
	}
}
