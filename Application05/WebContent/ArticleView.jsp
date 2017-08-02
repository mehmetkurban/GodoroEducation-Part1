<%@page import="com.godoro.content.repository.ArticleRepository"%>
<%@page import="com.godoro.content.entity.Article"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	long articleId=Long.parseLong(request.getParameter("articleId"));
	ArticleRepository articleRepository=new ArticleRepository();
	Article article=articleRepository.find(articleId);

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	Makale No:<%=article.getArticleId() %><br/>
	Makale Başlığı:<%=article.getArticleTitle() %><br/>
	Makale Gövdesi:<%=article.getArticleBody() %><br/>
</body>
</html>