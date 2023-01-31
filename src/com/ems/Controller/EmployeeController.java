package com.ems.Controller;

import java.sql.SQLException;
import java.util.Scanner;

import com.ems.Service.EmployeeServiceImpl;

public class EmployeeController {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		EmployeeServiceImpl service = new EmployeeServiceImpl();
		boolean bool=true;
		while(bool) {
		System.out.println("###########################################");
		System.out.println("#  Welcome to Employee Management System  #");
		System.out.println("###########################################\n");		
		System.out.println("Press 1 for creating a Table");
		System.out.println("Press 2 for Insert Data");
		System.out.println("Press 3 for Show Data");
		System.out.println("Press 4 for update Data");
		System.out.println("Press 5 for delete Particular Data by id");
		System.out.println("Press 6 for Delete all Data");
		System.out.println("Press 7 for exit App");

		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		
		switch(choice) {
		case 1:
			service.createtable();
			break;
		case 2:
			service.insertData();
			break;
		case 3:
			service.showData();
			break;
		case 4:
			service.updateData();
			break;
		case 5:
			service.deleteById();
			break;
		case 6:
			service.deleteAll();
			break;
		case 7:
			bool=false;
			System.out.println("Existing system !!!");
			break;
			
		default:
			System.out.println("Invalid ID");
			break;
				
			
		}
		
		}
	}

}
