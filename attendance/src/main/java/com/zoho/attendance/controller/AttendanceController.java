package com.zoho.attendance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zoho.attendance.entity.AttendanceDetail;
import com.zoho.attendance.service.AttendanceService;


@RestController
@RequestMapping(path = "/attendancedetail")
public class AttendanceController {

    @Autowired
    AttendanceService attendanceservice;

    @PostMapping(path = "/addatten")
    @CrossOrigin
    @ResponseBody
    public ResponseEntity<?> addAttendance(@RequestBody AttendanceDetail attendancedetail) {
        HttpHeaders headers = new HttpHeaders();

        try {
            return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(attendanceservice.addUserAttendance(attendancedetail));
        } catch (Exception e) {
            headers.add("Message", "false");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(headers).body("Failed to add the user attendance ");
        }

    }

    @PostMapping(path = "/addattenIfNot")
    @CrossOrigin
    @ResponseBody
    public ResponseEntity<?> addAttendanceIfNot(@RequestBody AttendanceDetail attendancedetail) {
        HttpHeaders headers = new HttpHeaders();

        try {
            return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(attendanceservice.addUserAttendanceIfNot(attendancedetail));
        } catch (Exception e) {
            headers.add("Message", "false");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(headers).body("Failed to add the user attendance ");
        }

    }
    @GetMapping(path = "/findAllatten")
    @CrossOrigin
    @ResponseBody
    public ResponseEntity<?> findAllUser() {
        HttpHeaders headers = new HttpHeaders();

        try {
            return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(attendanceservice.findAllUser());
        } catch (Exception e) {
            headers.add("Message", "false");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(headers).body("Failed to get all attendance");
        }

    }


    @GetMapping(path = "/findbyempidatten")
    @CrossOrigin
    @ResponseBody
    public ResponseEntity<?> findByempid(@RequestParam String employeeid) {
        HttpHeaders headers = new HttpHeaders();

        try {
            return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(attendanceservice.findByempid(employeeid));
        } catch (Exception e) {
            headers.add("Message", "false");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(headers).body("Failed to get the user attendance");
        }

    }


    @GetMapping(path = "/findbydate")
    @CrossOrigin
    @ResponseBody
    public ResponseEntity<?> findBydate(@RequestParam String month) {
        HttpHeaders headers = new HttpHeaders();

        try {
            return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(attendanceservice.findBydate(month));
        } catch (Exception e) {
            headers.add("Message", "false");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(headers).body("Failed to get the user attendance");
        }

    }

    @GetMapping(path = "/getattendanceByDateAndStandard")
    @CrossOrigin
    @ResponseBody
    public ResponseEntity<?> findByDateAndStandard(@RequestParam String date, @RequestParam String standard) {
        HttpHeaders headers = new HttpHeaders();

        try {
            System.out.println(date + " " + standard);
            return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(attendanceservice.findByDateAndStandard(date, standard));
        } catch (Exception e) {
            headers.add("Message", "false");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(headers).body("Failed to get the user attendance");
        }

    }

    @GetMapping(path = "/getattendanceByIdAndMonthAndYear")
    @CrossOrigin
    @ResponseBody
    public ResponseEntity<?> getattendanceByIdAndMonthAndYear(@RequestParam String employeeid, @RequestParam String month, @RequestParam String year) {
        HttpHeaders headers = new HttpHeaders();

        try {
            System.out.println(employeeid + " " + month + " " + year);
            return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(attendanceservice.getattendanceByIdAndMonthAndYear(employeeid, month, year));
        } catch (Exception e) {
            headers.add("Message", "false");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(headers).body("Failed to get the user attendance");
        }

    }

	 
	 

    @GetMapping(path = "/updateatten")
    @CrossOrigin
    @ResponseBody
    public ResponseEntity<?> updateUser(@RequestParam String employeeid, @RequestParam String available, @RequestParam String date) {
        HttpHeaders headers = new HttpHeaders();

        try {
            return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(attendanceservice.updateUser(employeeid, available, date));
        } catch (Exception e) {
            headers.add("Message", "false");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(headers).body("Failed to update the user attendance");
        }

    }
	  

}