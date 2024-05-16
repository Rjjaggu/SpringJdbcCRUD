package org.techhub.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.techhub.model.Register;

@Repository("registerRepo")
public class RegisterRepoImpl implements RegisterRepo {

	@Autowired
	JdbcTemplate template;
	List<Register>list;
	Register register;
	public boolean isAddVoter(final Register register) {
		
		int value=template.update("insert into register values('0',?,?,?,?)",new PreparedStatementSetter() {

			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1,register.getName());
				ps.setString(2, register.getEmail());
				ps.setString(3,register.getContact());
				ps.setInt(4, register.getAge());	
			}
		});
		if(value>0) {
			return true;
		}
		else {
		        return false;
		}
	}
	public List<Register> getAllRecord() {
		
		list=template.query("select * from register",new RowMapper<Register>() {

			public Register mapRow(ResultSet rs, int rowNum) throws SQLException {
				Register r=new Register();
				r.setId(rs.getInt(1));
				r.setName(rs.getString(2));
				r.setEmail(rs.getString(3));
				r.setContact(rs.getString(4));
				r.setAge(rs.getInt(5));
				return r;
			}
			
		});
		
		return list;
	}
	public boolean isDeleteRecordById(int id) {
		
		int val=template.update("delete from register where id=?",new Object[] {id});
		if(val>0) {
			return true;
		}
		else {
			return false;
		}
		

	}
	public boolean isUpdate(final Register register) {
		
		int val=template.update("update register set name=?,email=?,contact=?,age=? where id=?",new PreparedStatementSetter() {

			public void setValues(PreparedStatement ps) throws SQLException {
			ps.setString(1, register.getName());
			ps.setString(2, register.getEmail());
			ps.setString(3, register.getContact());
			ps.setInt(4, register.getAge());
			ps.setInt(5, register.getId());
				
			}
			
		});
		if(val>0) {
			return true;
		}
		else {
		return false;
		}
	}
	public Register isgetUserById(int id) {
		register=template.queryForObject("select *from register where id=?",new Object[] {id},new RowMapper<Register>() {

			public Register mapRow(ResultSet rs, int rowNum) throws SQLException {
			  Register r=new Register();
			  r.setId(rs.getInt(1));
			  r.setName(rs.getString(2));
			  r.setEmail(rs.getString(3));
			  r.setContact(rs.getString(4));
			  r.setAge(rs.getInt(5));
				return r;
			}
			
		});
		return register;
	}
}
