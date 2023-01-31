package com.ems.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.ems.model.Employee;

public class EmployeeServiceImpl implements EmployeeServiceI {
	
	Employee emp = new Employee();

	@Override
	public void createtable() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "root");
		String sql = "create table Employee (id int, name varchar(50), dept varchar(50),address varchar(100),salary double(7,2),email varchar(100))";
		Statement st = con.createStatement();
		st.execute(sql);
		System.out.println("Table created");
		st.close();
		con.close();
	}

	@Override
	public void insertData() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "root");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Insert your ID: ");
		int id = sc.nextInt();
		emp.setEmpid(id);
		
		System.out.println("Please Enter your Name: ");
		String name = sc.next();
		emp.setName(name);
		
		System.out.println("Please Enter your dept: ");
		String dept = sc.next();
		emp.setDept(dept);
		
		System.out.println("Please Enter your Address: ");
		String address = sc.next();
		emp.setAddress(address);
		
		System.out.println("Please Insert your Salary: ");
		double salary = sc.nextDouble();
		emp.setSalary(salary);
		
		System.out.println("Please Enter your email: ");
		String email = sc.next();
		emp.setEmail(email);	
		
		
		
		String sql = "insert into employee values (?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, emp.getEmpid());
		ps.setString(2,emp.getName());
		ps.setString(3, emp.getDept());
		ps.setString(4, emp.getAddress());
		ps.setDouble(5, emp.getSalary());
		ps.setString(6, emp.getEmail());

		ps.execute();
		ps.close();
		System.out.println("Data Inserted Succefully\n");
		con.close();
		
		
	}

	@Override
	public void showData() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "root");
		Scanner sc = new Scanner(System.in);
		System.out.print("Please insert your ID: ");
		int idz = sc.nextInt();
		
		String sql = "Select * from employee where id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, idz);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
		System.out.println("ID:"+rs.getString("id")+" "+" Name:"+rs.getString("name")+" "+" Department:"+rs.getString("dept")+" "+" Address:"+rs.getString("address")+" "+" Salary:"+rs.getString("salary")+" "+" Email:"+rs.getString("email")+"\n");
		}
		
	}

	@Override
	public void updateData()throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Please insert your ID: ");
		int idz = sc.nextInt();
		
		
		
		boolean bool=true;
		while(bool) {
			System.out.println("\nPress 1 for Update Name");
			System.out.println("Press 2 for Update Department");
			System.out.println("Press 3 for Update Address");
			System.out.println("Press 4 for Upadte Salary");
			System.out.println("Press 5 for Upadte Email");
			System.out.println("Press 6 for Exit!\n");
			
			int ch = sc.nextInt();
			
			switch(ch) {
			case 1:
				System.out.println("Insert updated name: ");
				String name = sc.next();
				emp.setName(name);
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "root");
				String sql1 = "update employee set name = ? where id = ?";
				PreparedStatement ps1 = con1.prepareStatement(sql1);
				ps1.setString(1, emp.getName());
				ps1.setInt(2, emp.getEmpid());
				ps1.executeUpdate();
				ps1.close();
				con1.close();
				System.out.println("Name Updated Sucessfully!!! \nYour Updated Name is: "+emp.getName());
				System.out.println();
				break;
				
			case 2:
				System.out.println("Insert updated department: ");
				String dept = sc.next();
				emp.setDept(dept);
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "root");
				String sql2 = "update employee set dept = ? where id = ?";
				PreparedStatement ps2 = con2.prepareStatement(sql2);
				ps2.setString(1, emp.getDept());
				ps2.setInt(2, emp.getEmpid());
				ps2.executeUpdate();
				ps2.close();
				con2.close();
				System.out.println("Department Updated Sucessfully!!! \nYour Updated Department is: "+emp.getDept());
				System.out.println();				
				break;
				
			case 3:
				System.out.println("Insert updated  Address: ");
				String address = sc.next();
				emp.setAddress(address);
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con3 = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "root");
				String sql3 = "update employee set address = ? where id = ?";
				PreparedStatement ps3 = con3.prepareStatement(sql3);
				ps3.setString(1, emp.getAddress());
				ps3.setInt(2, emp.getEmpid());
				ps3.executeUpdate();
				ps3.close();
				con3.close();
				System.out.println("Address Updated Sucessfully!!! \nYour Updated Address is: "+emp.getAddress());
				System.out.println();				
				break;
				
			case 4:
				System.out.println("Insert updated Salary: ");
				double salary = sc.nextDouble();
				emp.setSalary(salary);
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con4 = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "root");
				String sql4 = "update employee set salary = ? where id = ?";
				PreparedStatement ps4 = con4.prepareStatement(sql4);
				ps4.setDouble(1, emp.getSalary());
				ps4.setInt(2, emp.getEmpid());
				ps4.executeUpdate();
				ps4.close();
				con4.close();
				System.out.println("Salary Updated Sucessfully!!! \nYour Updated Salary: "+emp.getSalary());
				System.out.println();				
				break;
				
			case 5:
				System.out.println("Insert updated email: ");
				String email = sc.next();
				emp.setEmail(email);	
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con5 = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "root");
				String sql5 = "update employee set name = ? where id = ?";
				PreparedStatement ps5 = con5.prepareStatement(sql5);
				ps5.setString(1, emp.getEmail());
				ps5.setInt(2, emp.getEmpid());
				ps5.executeUpdate();
				ps5.close();
				con5.close();
				System.out.println("Email Updated Sucessfully!!! \nYour Updated Email is: "+emp.getEmail());
				System.out.println();				
				break;	
			case 6:
				bool=false;
				break;
				
			default:
				System.out.println("Invalid Choice!!!\n");
					
			}	
		
	}
}		

	@Override
	public void deleteById() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "root");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please insert id to be deleted: ");
		int idz = sc.nextInt();
		
		String sql="delete from employee where id =?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, idz);
		ps.execute();
		
		ps.close();
		con.close();
		System.out.println("Data deleted for the id= "+idz+"\n");
		
	}

	@Override
	public void deleteAll() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "root");
		
		String sql="delete from employee";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.execute();
		
		ps.close();
		con.close();
		System.out.println("Data deleted Successfully!!\n");

		
	}

}
