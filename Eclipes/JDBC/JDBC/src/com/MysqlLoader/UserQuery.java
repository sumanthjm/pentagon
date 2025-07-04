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

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	
//	
//package com.MysqlLoader;
//import java.sql.*;
//import java.util.*;
//
//public class UserQuery {
//
//    public static void demo() throws SQLException {
//        Scanner sc = new Scanner(System.in);
//        Class con = MysqlConnection.m();
//        System.out.println("Driver loaded");
//
//        Statement stmt = MysqlConnection.s();
//        System.out.println("Platform is loaded");
//        System.out.println("---------------------");
//
//        System.out.print("Enter your SQL query:\n> ");
//        String originalQuery = sc.nextLine();
//        String queryType = originalQuery.trim().toLowerCase();
//
//        if (queryType.startsWith("select")) {
//            ResultSet rs = stmt.executeQuery(originalQuery);
//            System.out.println("Query Executed Successfully");
//
//            ResultSetMetaData meta = rs.getMetaData();
//            int columnCount = meta.getColumnCount();
//
//            // Step 1: Collect headers
//            List<String> headers = new ArrayList<>();
//            for (int i = 1; i <= columnCount; i++) {
//                headers.add(meta.getColumnLabel(i));
//            }
//
//            // Step 2: Collect all rows and compute column widths
//            List<List<String>> rows = new ArrayList<>();
//            int[] colWidths = new int[columnCount];
//
//            // Initialize with header widths
//            for (int i = 0; i < columnCount; i++) {
//                colWidths[i] = headers.get(i).length();
//            }
//
//            while (rs.next()) {
//                List<String> row = new ArrayList<>();
//                for (int i = 1; i <= columnCount; i++) {
//                    String value = rs.getString(i);
//                    if (value == null) value = "NULL";
//                    row.add(value);
//                    colWidths[i - 1] = Math.max(colWidths[i - 1], value.length());
//                }
//                rows.add(row);
//            }
//
//            // Step 3: Build format string
//            StringBuilder separator = new StringBuilder("+");
//            StringBuilder format = new StringBuilder("|");
//            for (int width : colWidths) {
//                separator.append("-".repeat(width + 2)).append("+");
//                format.append(" %-").append(width).append("s |");
//            }
//
//            // Step 4: Print header
//            System.out.println(separator);
//            System.out.format(format.toString(), headers.toArray());
//            System.out.println();
//            System.out.println(separator);
//
//            // Step 5: Print rows
//            for (List<String> row : rows) {
//                System.out.format(format.toString(), row.toArray());
//                System.out.println();
//            }
//
//            // Step 6: End border
//            System.out.println(separator);
//
//        } else {
//            int affected = stmt.executeUpdate(originalQuery);
//            System.out.println("Query Executed Successfully");
//            System.out.println("Rows affected: " + affected);
//        }
//
//        sc.close();
//    }
//
//    public static void main(String[] args) {
//        try {
//            demo();
//        } catch (SQLException e) {
//            System.err.println("SQL Error: " + e.getMessage());
//        }
//    }
//}
