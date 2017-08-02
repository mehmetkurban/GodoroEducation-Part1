<%@page import="com.godoro.sports.entity.*"%>
<%@page import="java.util.List"%>
<%@page import="com.godoro.sports.repository.PlayerRepository"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    
       long teamId=Long.parseLong(request.getParameter("teamId"));
       PlayerRepository playerRepository=new PlayerRepository();
       List<Player> playerList=playerRepository.listByTeamId(teamId);
      // Article del=articleRepository.delete(articleIdd);
    
    
    %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


<%
   for(Player player : playerList){
%>
    <tr>
       <td><%=player.getPlayerId()%></td>
       <td>
       <a href="PlayerView.jsp?playerId=<%=player.getPlayerId()%>">Git</a>
       <%=player.getPlayerName()%></td>
   

       <td><%=player.getAverageScore()%></td>
        <td><%=player.getTeamId()%></td>
        
         <td><%=player.getTeamName()%></td>
       
    </tr><br>
<%
   }
%>

</body>
</html>