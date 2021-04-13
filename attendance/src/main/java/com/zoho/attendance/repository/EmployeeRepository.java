package com.zoho.attendance.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zoho.attendance.entity.EmployeeDetail;
@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeDetail, Long> {
   
    EmployeeDetail findByEmployeeId(String employeeid);

    EmployeeDetail[] findByStandardAndType(String standard,String type);
    @Transactional
    void deleteByEmployeeId(String employeeId);

}	