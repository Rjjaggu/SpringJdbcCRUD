package org.techhub.service;
import java.util.List;

import org.techhub.model.*;
public interface RegisterService {
	
	public boolean isAddVoter(Register register);
	
	public List<Register> getAllRecord();
	
	public boolean isDeleteRecordById(int id);
	
	public boolean isUpdate(Register register);
	
	public Register isgetUserById(int id);

}
