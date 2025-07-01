package com.MysqlLoader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import com.mysql.cj.jdbc.Driver;
public class DbLoader 
{

	public void m() {
		try {
			System.out.println(Class.forName("com.mysql.cj.jdbc.Driver"));
			System.out.println("Loaded and Registered");
		}catch(ClassNotFoundException e) 
		{
		System.out.println("Not able to load");
	    }
					}
	public void mysqlConnect() {
		String userName="root";
		String password="root";
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/zomato",userName,password);
			System.out.println("connected to Mysql");
			System.out.println(con);
		}catch(SQLException e) 
		{
		System.out.println("Not able to connect");
	    }
		
		
	}
}

class Main{
	public static void main(String[] args) {
		DbLoader db=new DbLoader();
		db.m();
		db.mysqlConnect();
	}
}