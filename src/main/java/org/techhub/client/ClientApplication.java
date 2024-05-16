package org.techhub.client;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.techhub.Config.DBConfig;
import org.techhub.model.Register;
import org.techhub.service.RegisterServiceImpl;
import java.util.*;

public class ClientApplication {
	public static void main(String[] args) {

		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(DBConfig.class);
		RegisterServiceImpl regService=(RegisterServiceImpl)context.getBean("registerService");
		
		do {
			 Scanner sc=new Scanner(System.in);
			 System.out.println("1:Insert Record");
			 System.out.println("2:view All Record");
			 System.out.println("3:Delete by Id");
			 System.out.println("4:Update by Id");
			 System.out.println("5:Search by Id");
			 System.out.println("Enter your choice");
			 int choice=sc.nextInt();
			 sc.nextLine();
			 int id;
			switch(choice) {
			 case 1:
				   System.out.println("Enter name email contact and age of voter:");
				   String name=sc.nextLine();
				   String email=sc.nextLine();
				   String contact=sc.nextLine();
				   int age=sc.nextInt();
					Register r=new Register();
					r.setName(name);
					r.setEmail(email);
					r.setContact(contact);
					r.setAge(age);
					
					 boolean b=regService.isAddVoter(r);
					if(b) {
						System.out.println("Voter Added Sucessfully...");
					}
					else {
						System.out.println("Voter Not Added..");
					}
				   
				 break;
			 case 2:
				 List<Register>list=regService.getAllRecord();
				 for(Register reg:list) {
					 System.out.println(reg.getId()+"\t"+reg.getName()+"\t"+reg.getEmail()+"\t"+reg.getContact()+"\t"+reg.getAge());
				 }
				 break;
			 case 3:
				    System.out.println("Enter the Id");
				     id=sc.nextInt();
				    boolean b1=regService.isDeleteRecordById(id);
				   
				    if(b1) {
				    	System.out.println("Delete Record by ID Successfully...");
				    }
				    else {
				    	System.out.println("Some problem is there..");
				    }
				 break;
			 case 4:
				 System.out.println("Enter the name email contact and Age:");
				  name=sc.nextLine();
				  email=sc.nextLine();
				  contact=sc.nextLine();
				  age=sc.nextInt();
				  Register register=new Register();
				  register.setName(name);
				  register.setEmail(email);
				  register.setContact(contact);
				  register.setAge(age);
				  System.out.println("Enter the Id:");
				  id=sc.nextInt();
				  register.setId(id);
				  boolean b2=regService.isUpdate(register);
				  if(b2) {
					  System.out.println("Record Update Successfully...");
				  }
				  else {
					  System.out.println("Some Problem is there..");
				  }
				 break;
			 case 5:
				  System.out.println("Enter the Id:");
				  id=sc.nextInt();
				  register=regService.isgetUserById(id);
				  System.out.println(register.getId()+"\t"+register.getName()+"\t"+register.getEmail()+"\t"+register.getContact()+"\t"+register.getAge());
				 break;
			 
			 }
			
			
		}while(true);
	}

}
