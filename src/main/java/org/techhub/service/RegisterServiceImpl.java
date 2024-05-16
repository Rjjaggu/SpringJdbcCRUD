package org.techhub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.techhub.model.Register;
import org.techhub.repository.RegisterRepo;

@Service("registerService")
public class RegisterServiceImpl implements RegisterService{

	@Autowired
	RegisterRepo registerRepo;
	public boolean isAddVoter(Register register) {
		
		if(register.getAge()>18) {
			
		boolean b=registerRepo.isAddVoter(register);
		return b;
			
		}else {
			
		return false;

		}
	}
	public List<Register> getAllRecord() {
		
		return registerRepo.getAllRecord() ;
	}
	public boolean isDeleteRecordById(int id) {
		
		return registerRepo.isDeleteRecordById(id);
	}
	public boolean isUpdate(Register register) {
		
		return registerRepo.isUpdate(register);
	}
	public Register isgetUserById(int id) {
		return registerRepo.isgetUserById(id);
		
	}
}
