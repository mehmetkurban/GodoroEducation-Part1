<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<% 
	List<String> provinceList=new ArrayList<String>();
	provinceList.add("İstanbul");
	provinceList.add("Ankara");
	provinceList.add("Antalya");
	provinceList.add("Trabzon");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<ul type=I>
<% 
	for(String province:provinceList){
	%>
		<li><%=province%></li>
	<% 
	}
%>
</ul>
</body>
</html>