package com.stl.ManagerAcceptRejectLeave.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stl.ManagerAcceptRejectLeave.model.LeaveModels;
import com.stl.ManagerAcceptRejectLeave.service.LeaveService;

@RequestMapping("acceptreject")
@RestController
@CrossOrigin("http://localhost:3000")
public class Controller {

	@Autowired
	LeaveService service;
	
	@PutMapping("/update/{leaveid}")
	public ResponseEntity<LeaveModels> updateLeave(@PathVariable("leaveid") Long leaveid,@RequestBody LeaveModels leave){
		return new ResponseEntity<LeaveModels> (service.updateLeave(leave, leaveid),HttpStatus.OK);
	}
	
	@GetMapping("/getbymanager/{manageremail}")
	public List<LeaveModels> findbymanager(@PathVariable ("manageremail") String manageremail){
		return service.findbymanager(manageremail);
	}
}
