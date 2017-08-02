<%@page import="com.godoro.sports.entity.Player"%>
<%@page import="com.godoro.sports.repository.PlayerRepository"%>
<%@page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
    <%
       long playerId=Long.parseLong(request.getParameter("playerId"));
       PlayerRepository playerRepository=new PlayerRepository();
       Player player=playerRepository.find(playerId);
    %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

 Sporcu Id No:<%=player.getPlayerId()%>
 Sporcu Adı :<%=player.getPlayerName()%>
 Sporcu Team Adı:<%=player.getTeamName()%>
 Sporcu Team Id:<%=player.getTeamId()%>
 Skor:<%=player.getAverageScore()%>


</body>
</html>