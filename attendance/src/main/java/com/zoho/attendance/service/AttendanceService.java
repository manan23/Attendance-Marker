package com.zoho.attendance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.zoho.attendance.entity.AttendanceDetail;
import com.zoho.attendance.repository.AttendanceRepository;

@Service("attendanceservice")
public class AttendanceService {

	
	private AttendanceRepository attendancerepository;
	
	@Autowired
	public AttendanceService(AttendanceRepository attendancerepository) {
		super();
		this.attendancerepository = attendancerepository;
	}

	public String addUserAttendance(AttendanceDetail attendancedetail) {
		AttendanceDetail studentData=attendancerepository.findByEmployeeIdAndDate(attendancedetail.getEmployeeId(),attendancedetail.getDate());
			if(studentData == null) {
				attendancerepository.save(attendancedetail);
			}
			else
			{
				studentData.setAvailable(attendancedetail.getAvailable());
				studentData.setDate(attendancedetail.getDate());
				studentData.setMonth(attendancedetail.getMonth());
				studentData.setYear(attendancedetail.getYear());
				attendancerepository.save(studentData);
			}
		return "User account has been added, Employee ID = " + attendancedetail.getEmployeeId();

	}
	public String addUserAttendanceIfNot(AttendanceDetail attendancedetail) {
		AttendanceDetail studentData=attendancerepository.findByEmployeeIdAndDate(attendancedetail.getEmployeeId(),attendancedetail.getDate());
		if(studentData == null) {
			attendancerepository.save(attendancedetail);
		}
		return "User account has been added, Employee ID = " + attendancedetail.getEmployeeId();

	}
	 
	    public List<AttendanceDetail> findAllUser() {
	        List<AttendanceDetail> attendanceList = (List<AttendanceDetail>) attendancerepository.findAll();

	        if (attendanceList != null) {
	        	return attendanceList;
	        }
	        return null;
	    }

	    public AttendanceDetail[] findByempid(String employeeid) {
		AttendanceDetail[] attendanceList =  attendancerepository.findByEmployeeId(employeeid);

	        if (attendanceList != null) {
	            return attendanceList;
	        }
	        return null;
	  }

	    public AttendanceDetail findBydate(String month) {
			AttendanceDetail attendanceList = (AttendanceDetail) attendancerepository.findBydate(month);

		        if (attendanceList != null) {
		            return attendanceList;
		        }
		        return null;
		  }

	public AttendanceDetail[] findByDateAndStandard(String date,String standard) {
		AttendanceDetail[] attendanceList = attendancerepository.findByDateAndStandard(date,standard);

		if (attendanceList != null) {
			return attendanceList;
		}
		return null;
	}

	public AttendanceDetail[] getattendanceByIdAndMonthAndYear(String id,String month,String year) {
		AttendanceDetail[] attendanceList = attendancerepository.findByEmployeeIdAndMonthAndYear(id,month,year);

		if (attendanceList != null) {
			return attendanceList;
		}
		return null;
	}

	    public String updateUser(String employeeid,String available,String date) {
	    	AttendanceDetail attendanceList = (AttendanceDetail) attendancerepository.findByEmployeeIdAndDate(employeeid,date);
	    	if (attendanceList != null) {
	        	
	        	attendanceList.setAvailable(available);
	        	attendancerepository.save(attendanceList);
	        	return "User updated Successfully";
	        }
	        return "User update Failed";
	    }

}
