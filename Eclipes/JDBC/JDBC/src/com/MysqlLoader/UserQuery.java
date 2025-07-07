package com.MysqlLoader;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;


	public class UserQuery {

		public static void demo() throws SQLException {
		Scanner sc=new Scanner(System.in);
		Class con=MysqlConnection.m();
		System.out.println("Driver loaded");

		Statement stmt=MysqlConnection.s();
		System.out.println("Platform is  loaded");
		System.out.println("---------------------");

		System.out.println("enter your query");
	
		String query = sc.nextLine().trim().toLowerCase();
	
		if (query.startsWith("select")) {
			
		ResultSet rs=stmt.executeQuery(query);
		System.out.println("Query Executed Succesfully ");
		
		 ResultSetMetaData meta =rs.getMetaData();
	     int columnCount = meta.getColumnCount();
	
	     System.out.println("Results:");
	     System.out.println("--------------------------------------------------");
	     
	     while (rs.next()) {
	            for (int i = 1; i <= columnCount; i++) {
	                String label = meta.getColumnLabel(i);   // uses alias if present
	                String value = rs.getString(i);          // fetches data
	                System.out.print(label + ": " + value + "  ");
	            }
	            System.out.println(); // newline after each row
	        }
	     sc.close();
		}
		else {
			 int affected = stmt.executeUpdate(query);
		        System.out.println("Query Executed Successfully");
		        System.out.println("Rows affected: " + affected);
		    }
		sc.close();
    
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


