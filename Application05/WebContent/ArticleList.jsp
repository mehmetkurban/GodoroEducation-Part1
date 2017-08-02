<%@page import="com.godoro.content.entity.Article"%>
<%@page import="java.util.List"%>
<%@page import="com.godoro.content.repository.ArticleRepository"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArticleRepository articleRepository=new ArticleRepository();
	List<Article> articleList=articleRepository.list();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
	<% 
	for(Article article:articleList){
	%>
		<tr>
			<td><%=article.getArticleId()%></td>
			
			<td>
		<a href="ArticleView.jsp?articleId=<%=article.getArticleId()%>"><%=article.getArticleTitle()%></a>
			</td>
		</tr>
	<% 
	}
	%>
	</table>
</body>
</html>