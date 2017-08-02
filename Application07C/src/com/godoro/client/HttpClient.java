package com.godoro.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class HttpClient {

	public static void main(String[] args) throws Exception {
		//String address="http://www.google.com";
		//String address="http://localhost:8080/Application07/xml";
		String address="http://localhost:8080/Application07/json";
		URL url=new URL(address);
		URLConnection connection=url.openConnection();

		String string=read(connection.getInputStream());
		System.out.println("Sonuç:\r\n"+string);
	}
	
	public static String read(InputStream is)throws Exception{
		
		BufferedReader reader=new BufferedReader(new InputStreamReader(is,"utf-8"));
		StringBuilder builder=new StringBuilder();
		
		String line;
		while((line=reader.readLine())!=null){
			builder.append(line).append("\r\n");
		}
		reader.close();
		return builder.toString();
		
	}

}
