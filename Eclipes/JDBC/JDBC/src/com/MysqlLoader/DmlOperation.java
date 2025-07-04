package com.MysqlLoader;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.ResultSet;


public class DmlOperation {
	
	public static void demo() throws SQLException {
	Scanner sc=new Scanner(System.in);
	Class con=MysqlConnection.m();
	System.out.println("Driver loaded");
	
	Statement stmt=MysqlConnection.s();
	System.out.println("Platform is  loaded");
	
	System.out.println("---------------------");
	System.out.println("enter id");
	int id=sc.nextInt();
	System.out.println("enyter name");
	String name=sc.next();
	System.out.println("enter email");
	String email=sc.next();
	System.out.println("enter pass");
	String pass=sc.next();
	System.out.println("enter age");
	int age=sc.nextInt();
	System.out.println("enter phone");
	long phone=sc.nextInt();
	String query="insert into user_accounts values('"+id+"','"+name+"','"+email+"','"+pass+"','"+age+"','"+phone+"')";
//	boolean execute=stmt.execute(query);
	int execute=stmt.executeUpdate(query);
	if(execute>0) {
		System.out.println("inserted");
	}
	else{
		System.out.println(" not inserted");
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