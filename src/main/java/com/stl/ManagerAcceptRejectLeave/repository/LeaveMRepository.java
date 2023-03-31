package com.stl.ManagerAcceptRejectLeave.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.stl.ManagerAcceptRejectLeave.model.LeaveModels;

public interface LeaveMRepository extends JpaRepository<LeaveModels, Long> {
	
	
	
	@Query(value = "select * from leaves where manageremail = ?;", nativeQuery = true)
	public List<LeaveModels> findbymanager(String manageremail);

	
	@Query(value = "Select * from tasks where employeeemailid = ? and status=\"0%\";", nativeQuery = true)
	public List<LeaveModels> findnotaskbyemail(String employeeemailid);
}
