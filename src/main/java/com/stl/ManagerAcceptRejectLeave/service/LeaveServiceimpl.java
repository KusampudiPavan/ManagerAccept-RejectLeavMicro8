package com.stl.ManagerAcceptRejectLeave.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stl.ManagerAcceptRejectLeave.exception.ResourceNotFoundException;
import com.stl.ManagerAcceptRejectLeave.model.LeaveModels;
import com.stl.ManagerAcceptRejectLeave.repository.LeaveMRepository;

@Service
public class LeaveServiceimpl implements LeaveService{
	
	@Autowired
	LeaveMRepository repo;

	@Override
	public LeaveModels updateLeave(LeaveModels leave, Long leaveid) {
		LeaveModels existingleave = repo.findById(leaveid).orElseThrow(() -> new ResourceNotFoundException("Leave","Id",leaveid));
		existingleave.setLeavestatus(leave.getLeavestatus());
		repo.save(existingleave);
		return existingleave;
	}

	@Override
	public List<LeaveModels> findbymanager(String manageremail) {
		return repo.findbymanager(manageremail);
	}

}
