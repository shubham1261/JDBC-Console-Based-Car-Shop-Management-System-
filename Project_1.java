package Demo;

import java.sql.*;
import java.util.Scanner;
public class Project_1 {
	static{
		System.err.println("Welcome to Car World");
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Press 1 for Insert Details in Latest Cars");
		System.out.println("Press 2 for Insert Details in Cars");
		System.out.println("Press 3 for Update Data in Cars & Latest Cars");
		System.out.println("Press 4 for Collection of Latest Cars");
		System.out.println("Press 5 for Collection of Cars & Latest Cars");
		System.out.println("Press 6 for Delete Data from Latest Cars");
		int x = sc.nextInt();
		switch (x) {
		case 1:
			insertLatestCars();
			break;
		case 2:
			insertcars();
		    break;
		case 3:
			updateCars_LatestCars();
			break;
		case 4:
			collection_LatestCars();
			break;
		case 5:
			collection_Cars_LatestCars();
			break;
		case 6:
			delete_LatestCars();
			break;
		default:
			System.err.println("Invalid Input!! Please Try Again");
			main(null);
			
		}
    }
	
	public static void insertLatestCars(){		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Latest Car Number");
		int cNo = scan.nextInt();
		scan.nextLine();
		System.out.println("Enter Latest Car Name");
		String cName = scan.nextLine();
		System.out.println("Enter Latest Car Colour");
		String cColor = scan.nextLine();
		System.out.println("Enter Latest Car Model");
		String cModel = scan.nextLine();
		System.out.println("Inserted Successfully");
		
		String query = "insert into demo.latestcars values (? , ? , ? , ?)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1,cNo);
			pstmt.setString(2, cName);
			pstmt.setString(3,cColor);
			pstmt.setString(4, cModel);
			
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void insertcars(){		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Car Number");
		int cNo = scan.nextInt();
		scan.nextLine();
		System.out.println("Enter Car Name");
		String cName = scan.nextLine();
		System.out.println("Enter Car Colour");
		String cColor = scan.nextLine();
		System.out.println("Enter Car Model");
		String cModel = scan.nextLine();
		System.out.println("Inserted Successfully");
		
		String query = "insert into demo.cars values (? , ? , ? , ?)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			PreparedStatement pstmt1 = con1.prepareStatement(query);
			
			pstmt1.setInt(1,cNo);
			pstmt1.setString(2, cName);
			pstmt1.setString(3,cColor);
			pstmt1.setString(4, cModel);
			
			pstmt1.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void updateCars_LatestCars() {
		try {
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 Connection con = DriverManager.getConnection("jdbc:mysql://localhost/?user=root&password=root");
		 Scanner sc=new Scanner(System.in);
		 String query = "update demo.latestcars set Cname = ? where Cno = ?";
		 PreparedStatement stmt=con.prepareStatement(query);
		 int cno=sc.nextInt();
		 sc.nextLine();
		 String cname=sc.nextLine();
		 stmt.setString(1,cname);
		 stmt.setInt(2,cno);
		 stmt.executeUpdate();
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
	}
	
	public static void collection_LatestCars() {
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection con = DriverManager.getConnection("jdbc:mysql://localhost/?user=root&password=root");
			 PreparedStatement pstmt = con.prepareStatement("select * from demo.latestcars");
			 
			 ResultSet rs = pstmt.executeQuery();
			 
			 while(rs.next()) {
				 int cNo = rs.getInt(1);
				 String cName = rs.getString(2);
				 String cColor = rs.getString(3);
				 String cModel = rs.getString(4);
				 
				 System.out.println(cNo + " " + cName + " " + cColor + " " + cModel);
			 }
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
	 }
	
	public static void collection_Cars_LatestCars() {
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection con = DriverManager.getConnection("jdbc:mysql://localhost/?user=root&password=root");
			 
			 PreparedStatement pstmt = con.prepareStatement("select * from demo.latestcars");
			 ResultSet rs = pstmt.executeQuery(); 
			 while(rs.next()) {
				 int cNo = rs.getInt(1);
				 String cName = rs.getString(2);
				 String cColor = rs.getString(3);
				 String cModel = rs.getString(4);
				 System.out.println("Latest Cars Details:");
				 System.out.println(cNo + " " + cName + " " + cColor + " " + cModel);
				 System.out.println();
			 }
			 
			 PreparedStatement pstmt1 = con.prepareStatement("select * from demo.cars");
			 ResultSet rs1 = pstmt1.executeQuery();
			 while(rs1.next()) {
				 int cNo = rs1.getInt(1);
				 String cName = rs1.getString(2);
				 String cColor = rs1.getString(3);
				 String cModel = rs1.getString(4);
				 System.out.println("Cars Details:");
				 System.out.println(cNo + " " + cName + " " + cColor + " " + cModel);
			 }
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
	 }
	
	public static void delete_LatestCars() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Car Number");
		int cNo = sc.nextInt();
		System.out.println("Record Deleted");
		
		String query2 = "delete from demo.latestcars where Cno = ?";
		
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection con = DriverManager.getConnection("jdbc:mysql://localhost/?user=root&password=root");
			
			 PreparedStatement pstmt = con.prepareStatement(query2);
			 pstmt.setInt(1,cNo);
			 pstmt.executeUpdate();
			 
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}	
