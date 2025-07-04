package com.MysqlLoader;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.ResultSet;
public class MysqlConnection {

	public static Class m() {
		try {
//			System.out.println(Class.forName("com.mysql.cj.jdbc.Driver"));
			Class c=Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Loaded and Registered");
			return c;
		}catch(ClassNotFoundException e) 
		{
		System.out.println("Not able to load");
		return null;
	    }
					}
	public static Statement s() {
			String userName="root";
			String password="root";
			try {
//				Connection con=DriverManager.getConnection
//	("jdbc:mysql://localhost:3306/demo",userName,password);
				
		Connection con=DriverManager.getConnection
	("jdbc:mysql://localhost:3306/zomato",userName,password);
				System.out.println("connected to Mysql");
				System.out.println(con);
				Statement stmt=con.createStatement();
				return stmt;
			}catch(SQLException e) 
			{
			System.out.println("Not able to connect");
			return null;
		    }
			
			
		}
	}

