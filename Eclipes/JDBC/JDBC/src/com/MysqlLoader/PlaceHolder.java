package com.MysqlLoader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class PlaceHolder {

	public static void demo() throws SQLException {
		Scanner sc=new Scanner(System.in);
		Class con=MysqlConnection.m();
		System.out.println("Driver loaded");
		Connection conn=DriverManager.getConnection
				("jdbc:mysql://localhost:3306/demo","root","root");
//		Statement stmt=MysqlConnection.s();
		String query="insert into user_accounts values(?,?,?,?,?,?)";
		PreparedStatement stmt=conn.prepareStatement(query);
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
		int phone=sc.nextInt();
		
		stmt.setInt(1, id);
		stmt.setString(2, name);
		stmt.setString(3, email);
		stmt.setString(4, pass);
		stmt.setInt(5, age);
		stmt.setInt(6, phone);
//		boolean execute=stmt.execute(query);
		int execute=stmt.executeUpdate();
		if(execute>0) {
			System.out.println("inserted");
			System.out.println(execute);
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

