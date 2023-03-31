package com.stl.ManagerAcceptRejectLeave.service;

import java.util.List;

import com.stl.ManagerAcceptRejectLeave.model.LeaveModels;

public interface LeaveService {
	LeaveModels updateLeave(LeaveModels leave, Long id);
	List<LeaveModels> findbymanager(String manageremail);
}
