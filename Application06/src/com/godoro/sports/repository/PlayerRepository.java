package com.godoro.sports.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.godoro.sports.entity.Player;

public class PlayerRepository {

	
	String driver="com.mysql.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/mdb3";
	String user="root";
	String password="kurban764mehmet";
	
	
	
	public PlayerRepository() throws Exception{
		Class.forName(driver).newInstance();
	}

	 public List<Player> list()throws Exception{
		  List<Player> playerList=new ArrayList<Player>();
		  Connection connection=DriverManager.getConnection(url,user,password);
			
		  
			String sql="select * from Player";
			PreparedStatement statement=connection.prepareCall(sql);
			
			ResultSet resultSet=statement.executeQuery();
			while(resultSet.next()){
				Player player=new Player();
				player.setPlayerId(resultSet.getLong("playerId"));
				player.setPlayerName(resultSet.getString("playerName"));
				player.setAverageScore(resultSet.getDouble("averageScore"));
				playerList.add(player);
			}
			
		    connection.close();  
		    return playerList;
	  }
	 
	 
	 public List<Player> listByTeamId(long teamId)throws Exception{
		  List<Player> playerList=new ArrayList<Player>();
		  Connection connection=DriverManager.getConnection(url,user,password);
			
		  
			String sql="select * from Player"
					+"     left join Team"
					+"     on Player.teamId=Team.teamId"
					+ "  where Player.teamId=?";
			PreparedStatement statement=connection.prepareCall(sql);
			statement.setLong(1, teamId);
			ResultSet resultSet=statement.executeQuery();
			while(resultSet.next()){
				Player player=new Player();
				player.setPlayerId(resultSet.getLong("playerId"));
				player.setPlayerName(resultSet.getString("playerName"));
				player.setAverageScore(resultSet.getDouble("averageScore"));
				player.setTeamId(resultSet.getLong("teamId"));
				player.setTeamName(resultSet.getString("teamName"));
				playerList.add(player);
			}
			
		    connection.close();  
		    return playerList;
	  }
	 
	 
	 public Player find(long playerId)throws Exception{
			
		  
		    Player player=null;
		    Connection connection=DriverManager.getConnection(url,user,password);
			
			String sql="select * from Player"
					+"     left join Team"
					+"     on Player.teamId=Team.teamId"
					+ "  where Player.teamId=?";
			PreparedStatement statement=connection.prepareStatement(sql);
			statement.setLong(1,playerId);
			ResultSet resultSet=statement.executeQuery();
			if(resultSet.next()){
				player=new Player();
				player.setPlayerName(resultSet.getString("playerName"));
				player.setAverageScore(resultSet.getDouble("averageScore"));
				player.setTeamId(resultSet.getLong("teamId"));
				player.setTeamName(resultSet.getString("teamName"));
				
			}
		    connection.close();
		    return player;  
	  }
	
}
