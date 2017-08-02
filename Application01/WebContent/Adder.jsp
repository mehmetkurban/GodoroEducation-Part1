<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<% 
	int left=Integer.parseInt(request.getParameter("left"));
	int right=Integer.parseInt(request.getParameter("right"));
	int sum=left+right;
%>     <!--?left=3&right=4 =reqest yazmayı unutma-->

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	Toplam:<%=sum%>
</body>
</html>