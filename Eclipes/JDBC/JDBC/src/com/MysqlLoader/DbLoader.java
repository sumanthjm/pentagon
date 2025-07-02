//package com.MysqlLoader;
//import java.sql.Connection;
//import java.sql.Statement;
//import java.sql.SQLException;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//
//import com.mysql.cj.jdbc.Driver;
//public class DbLoader 
//{
//
//	public void m() {
//		try {
//			System.out.println(Class.forName("com.mysql.cj.jdbc.Driver"));
//			System.out.println("Loaded and Registered");
//		}catch(ClassNotFoundException e) 
//		{
//		System.out.println("Not able to load");
//	    }
//					}
//	public void mysqlConnect() {
//		String userName="root";
//		String password="root";
//		try {
//			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jcbc",userName,password);
//			System.out.println("connected to Mysql");
//			System.out.println(con);
//			Statement stmt=con.createStatement();
//			System.out.println(stmt);
//			
////			String query="SELECT * FROM student where age>18";
//			String query="SELECT sid FROM student where age>20";
////			String query="insert into student values(1,\"sumanth\",18)";
//			
////			Boolean se= stmt.execute(query);
//			ResultSet se= stmt.executeQuery(query);
////			int se2= stmt.executeUpdate(query);
//			
////			System.out.println(se);
//			System.out.println("Query executed succesfully");
////			int eid=se.getInt("eid");
////			System.out.println(eid);
//			 System.out.println("SID\tSName\t\tAge");
//			while (se.next()) {
//                int id = se.getInt("sid");
//                String name = se.getString("snam");
//                int age = se.getInt("age");
//                System.out.println(id + "\t" + name + "\t\t" + age);
//            }
//			
//		}catch(SQLException e) 
//		{
//		System.out.println("Not able to connect");
//	    }
//	}
//}
//
//class Main{
//	public static void main(String[] args) {
//		DbLoader db=new DbLoader();
//		db.m();
//		db.mysqlConnect();
//	}
//}















































//
//
//
//package com.MysqlLoader;
//
//import java.sql.*;
//
//public class DbLoader {
//
//    public void m() {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            System.out.println("Driver Loaded and Registered");
//        } catch (ClassNotFoundException e) {
//            System.out.println("Not able to load driver: " + e.getMessage());
//        }
//    }
//
//    public void mysqlConnect() {
//        String userName = "root";
//        String password = "root";
//        String url = "jdbc:mysql://localhost:3306/jcbc";
//
//        try (Connection con = DriverManager.getConnection(url, userName, password);
//             Statement stmt = con.createStatement()) {
//
//            System.out.println("Connected to MySQL");
//            System.out.println(con);
//
//            // You can change this query dynamically
//            String query = "SELECT sid FROM student WHERE age > 20";
//            ResultSet rs = stmt.executeQuery(query);
//            System.out.println("Query executed successfully");
//
//            // Get metadata to handle dynamic columns
//            ResultSetMetaData metaData = rs.getMetaData();
//            int columnCount = metaData.getColumnCount();
//
//            // Print column headers
//            for (int i = 1; i <= columnCount; i++) {
//                System.out.print(metaData.getColumnLabel(i) + "\t");
//            }
//            System.out.println();
//
//            // Print each row
//            while (rs.next()) {
//                for (int i = 1; i <= columnCount; i++) {
//                    System.out.print(rs.getString(i) + "\t");
//                }
//                System.out.println();
//            }
//
//        } catch (SQLException e) {
//            System.out.println("Not able to connect or execute query: " + e.getMessage());
//        }
//    }
//}
//
//class Main {
//    public static void main(String[] args) {
//        DbLoader db = new DbLoader();
//        db.m();
//        db.mysqlConnect();
//    }
//}
//
//
//
//



