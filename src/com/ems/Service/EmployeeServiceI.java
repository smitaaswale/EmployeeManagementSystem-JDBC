package com.ems.Service;

import java.sql.SQLException;

public interface EmployeeServiceI {
	
	public void createtable() throws ClassNotFoundException, SQLException;
	public void insertData() throws ClassNotFoundException, SQLException;
	public void showData() throws ClassNotFoundException, SQLException;
	public void updateData()throws ClassNotFoundException, SQLException;
	public void deleteById() throws ClassNotFoundException, SQLException;
	public void deleteAll()throws ClassNotFoundException, SQLException;
	
}
