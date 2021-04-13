package com.zoho.attendance.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zoho.attendance.entity.AttendanceDetail;

@Repository
public interface AttendanceRepository extends CrudRepository<AttendanceDetail, Long> {

    AttendanceDetail[] findByEmployeeId(String employeeid);


    AttendanceDetail findBydate(String month);


    AttendanceDetail findByEmployeeIdAndDate(String employeeid, String date);

    AttendanceDetail[] findByDateAndStandard(String date, String standard);

    AttendanceDetail[] findByEmployeeIdAndMonthAndYear(String employeeid, String month, String year);

}