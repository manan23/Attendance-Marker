package com.zoho.attendance.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "employeedetail")
public class EmployeeDetail {

    @Id
    @Column(name = "employeeId")
    String employeeId;

    @Column(name = "name")
    String Name;

    @Column(name = "phno")
    long phno;

    @Column(name = "mailid")
    String mailId;

    @Column(name = "type")
    String type;

    @Column(name="class")
    String standard;



    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }


    public long getPhno() {
        return phno;
    }

    public void setPhno(long phno) {
        this.phno = phno;
    }


    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String firstName) {
        this.Name = firstName;
    }

    public String getType() {return type; }

    public void setType(String type) {this.type = type; }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }
}
