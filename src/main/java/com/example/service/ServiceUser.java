package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.DTOUser;
import com.example.entity.EntityUser;
import com.example.repository.UserRepository;

@Service
public class ServiceUser {
   
   @Autowired
   UserRepository userRepo;

   public void Join(DTOUser user) {
      // TODO Auto-generated method stub
      System.out.println(user.User_Name);
      System.out.println(user.User_Age);
      
      userRepo.save(user.ToEntity());
   }
   
   public boolean Login(DTOUser user) {
	   System.out.println(user.User_Name);
	   System.out.println(user.User_Age);
	   
      List<EntityUser> list = 
    		  userRepo.findByUsernameAndUserage(user.User_Name, user.User_Age);

       if(list.isEmpty())
         return false;
       else
         return true;
   }

   public void RePass(String id, String pass, String rePass)
   {
	   List<EntityUser> list =
			   userRepo.findByUsernameAndUserage(id, pass);

	   if(!list.isEmpty())
	   {
		   list.get(0).setUserage(rePass);
		   userRepo.save(list.get(0));
	   }
   }

    //반복자를 통해 값을 가져오고 커서를 이동
   public Iterable<EntityUser> getAllUser() {
      return userRepo.findAll();
   }
   
   public void Delete(String id, String pass) {
	   List<EntityUser> list = userRepo.findByUsernameAndUserage(id, pass);
	   if(!list.isEmpty()) {
		   userRepo.delete(list.get(0));
	   }
   }


   
}