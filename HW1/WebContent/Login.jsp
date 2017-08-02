<%@page import="java.security.NoSuchAlgorithmException"%>
<%@page import="javax.servlet.jsp.tagext.TryCatchFinally"%>
<%@page import="java.security.MessageDigest"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%!
	String cryptWithMD5(String pass){
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] passBytes = pass.getBytes();
			md.reset();
			byte[] digested = md.digest(passBytes);
			StringBuffer sb = new StringBuffer();
	        for(int i=0;i<digested.length;i++){
	            sb.append(Integer.toHexString(0xff & digested[i]));
	        }
	        return sb.toString();
		} catch(NoSuchAlgorithmException ex) {
			
		}
	 	return null;
	}
%>    
<%
	
	String uname = "";
	String pw = "";
	Map<String,String> errorMsgs = new HashMap<String,String>();
	
	if (request.getParameter("login") != null) {
		if (request.getParameter("username") != null) {
			uname = request.getParameter("username").toString();
		} 
		if (request.getParameter("password") != null) {
			pw = request.getParameter("password").toString();
		}
		
		if (uname == null || "".equals(uname) || !uname.toUpperCase().equals("GODORO")) {
			//out.println("No user can be found");
			errorMsgs.put("uname", "No user can be found");
		} else if (pw == null || "".equals(pw) || !cryptWithMD5(pw.toUpperCase()).equals(cryptWithMD5("ABC"))) {
			//out.println("No password can be found");
			errorMsgs.put("pw", "No password can be found");
		} else {
			session.setAttribute("username", uname);
			session.setMaxInactiveInterval(100000);
			response.sendRedirect("Home.jsp");
		}
	}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body class="profile-login">
<header class="global-header">
<div>
<nav class="global-nav">
<a class="logo" data-analytics="site logo" href="/">
<img width="150" title="Godoro - Yeteneğin Bilgiyle Buluştuğu Nokta" alt="GODORO" src="//t3.gstatic.com/images?q=tbn:ANd9GcTQXzGx-V__ppX6nlqKd2StZF9CkIA6KENPDN3aK8Tg-DCs35gpFQ">
</a>
</nav>
</div>
</header>
<section class="login">
<form method="post" action="Login.jsp">
Username : <input type="text" name="username"  placeholder="Email or Username">
<%
	if (errorMsgs.containsKey("uname")) { 
	%>
		<label id="errLabel">
		<%=
			errorMsgs.get("uname")
		%>
		</label>
	<%
	}
	%><br />
 
Password : <input type="password" name="password">
<%
	if (errorMsgs.containsKey("pw")) { 
	%>
		<label id="errLabel">
		<%=
			errorMsgs.get("pw")
		%>
		</label>
	<%
	}
	%><br />

<input type="submit" class="button submit" data-analytics="sign-in"  value="Login" name="login" />
</form>
</section>


</body>
</html>