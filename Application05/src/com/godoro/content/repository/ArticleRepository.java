package com.godoro.content.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.godoro.content.entity.Article;


public class ArticleRepository{
	private String driver="com.mysql.jdbc.Driver";
	private String url="jdbc:mysql://localhost:3306/mdb2";
	private String user="root";
	private String password="kurban764mehmet";
	
		public ArticleRepository() throws Exception{
			Class.forName(driver).newInstance();
		}
	

	public List<Article> list()throws Exception{
		List<Article> articleList=new ArrayList<Article>();
		Connection connection=DriverManager.getConnection(url,user,password);
		
		String sql="select*from Article";
		PreparedStatement statement=connection.prepareCall(sql);
		
		ResultSet resultSet=statement.executeQuery();
		while(resultSet.next()){
			Article article=new Article();
			article.setArticleId(resultSet.getLong("articleId"));
			article.setArticleTitle(resultSet.getString("articleTitle"));
			article.setArticleBody(resultSet.getString("articleBody"));
			articleList.add(article);	
		}
		connection.close();
		return articleList;
	}
	
	public Article find(long articleId)throws Exception{
		Article article=null;
		Connection connection=DriverManager.getConnection(url,user,password);
		
		String sql="select * from Article where articleId=?";
		PreparedStatement statement=connection.prepareStatement(sql);
		statement.setLong(1,articleId);
		ResultSet resultSet=statement.executeQuery();
		while(resultSet.next()){
			article=new Article();
			article.setArticleId(resultSet.getLong("articleId"));
			article.setArticleTitle(resultSet.getString("articleTitle"));
			article.setArticleBody(resultSet.getString("articleBody"));
		}
		connection.close();
		return article;
	}
}
