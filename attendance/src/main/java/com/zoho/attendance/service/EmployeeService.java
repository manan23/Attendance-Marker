package com.zoho.attendance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zoho.attendance.entity.EmployeeDetail;
import com.zoho.attendance.repository.EmployeeRepository;

@Service("EmployeeService")
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeerepository;
	

	 public String addUser(EmployeeDetail employeedetail) {

		 	EmployeeDetail empdetail = (EmployeeDetail)employeerepository.findByEmployeeId(employeedetail.getEmployeeId());
	        if(empdetail==null) {
		 	employeerepository.save(employeedetail);
	        return "User account has been added";
	        }
	        return null;
	    }
	 
	    public List<EmployeeDetail> findAllUser() {
	    	List<EmployeeDetail> employeeList = (List<EmployeeDetail>) employeerepository.findAll();

	        if (employeeList != null) {
	        	return employeeList;
	        }
	        return null;
	    }

	    public EmployeeDetail[] findBydeptemp(String standard) {
			 EmployeeDetail[] employee = (EmployeeDetail[]) employeerepository.findByStandardAndType(standard,"Student");

			  if (employee != null) {
		           return employee;
		        }

		        return null;
		  }
	    
	    public EmployeeDetail findByempid(String employeeid) {
		 EmployeeDetail employee = (EmployeeDetail) employeerepository.findByEmployeeId(employeeid);

		  if (employee != null) {
	           return employee;
	        }

	        return null;
	  }



	    public String deleteByEmpid(String employeeid) {
	    	employeerepository.deleteByEmployeeId(employeeid);
	        return "User data has been deleted successfully.";

	    }

	    
}
