package com.chatapp.utils;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.chatapp.servlets.Formatter;
public class RegisterDao {
	public static int save(String name,String email,String password,String gender,String dob,String addressLine,String city,String state,String country,String contact){
		int status=0;
		java.sql.Date sqlDOB=Formatter.getSqlDate(dob);
		try{
			Connection con=ConProvider.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into frndschat_user(username,email,pass,gender,dob,addressLine,city,state,country,contact,registereddate,authorized) values(?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1,name);
			ps.setString(2,email);
			ps.setString(3,password);
			ps.setString(4,gender);
			ps.setDate(5,sqlDOB);
			ps.setString(6,addressLine);
			ps.setString(7,city);
			ps.setString(8,state);
			ps.setString(9,country);
			ps.setString(10,contact);
			ps.setDate(11,Formatter.getCurrentDate());
			ps.setString(12,"yes");
			
			status=ps.executeUpdate();
						
		}catch(Exception e){System.out.println(e);}
		
		
		
		return status;
	}
}