<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%! 
	int add(int left,int right){
		return left+right;
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Merhaba Godoro</h1>
<% // Main gibi düşün
	String company="Godoro";
	out.println("Kurum:<b><i>"+company+"</i></b>");
%>
	Kurum:<b><i><%=company%></i></b><br/> 
<% 
	int left=3;
	int right=4;
	int sum=add(left,right);
%>
	Toplam:<b><%=sum %></b><br/>
	Toplam:<b><%=add(3,4)%></b><br/>  
</body>
</html>