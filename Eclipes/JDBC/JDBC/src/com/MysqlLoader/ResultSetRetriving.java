package com.MysqlLoader;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.ResultSet;


public class ResultSetRetriving {
	
	public static void demo() throws SQLException {
	Scanner sc=new Scanner(System.in);
	Class con=MysqlConnection.m();
	System.out.println("Driver loaded");
	
	Statement stmt=MysqlConnection.s();
	System.out.println("Platform is  loaded");
	System.out.println("---------------------");
	
	System.out.println("enyter name");
	String name=sc.nextLine();
	System.out.println("enter pass");
	String pass=sc.nextLine();

//	String query="select * from user_accounts where(name='"+name+"' and pass='"+pass+"')";
//	String query="select * from user_accounts";
	String query="select name from user_accounts where(name='"+name+"' and pass='"+pass+"')";
//	boolean execute=stmt.execute(query);
//	int execute=stmt.executeUpdate(query);
	ResultSet rs=stmt.executeQuery(query);
	System.out.println("Data Featched ");
	
	while(rs.next()) {

		int id=rs.getInt("id");
		
		String name1=rs.getString("name");
		
		String email=rs.getString("email");
		
		String passs=rs.getString("pass");
		
		int age=rs.getInt("age");
		
		int phone=rs.getInt("phone");
		System.out.println(id+"  "+name1+"  "+email+"  "+passs+"  "+age+"  "+phone);
	}
	
}
	public static void main(String[] args) {
		try {
			demo();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}