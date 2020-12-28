package com.emp.empwebapp.util;

import com.emp.empwebapp.dao.EmployeeDAO;
import com.emp.empwebapp.dao.EmployeeDAOJdbcImpl;

public class EmployeeDAOManager {

	private EmployeeDAOManager() {}
	
	public static EmployeeDAO getEmployeeDAO()
	{
		return new EmployeeDAOJdbcImpl();
	}
}
