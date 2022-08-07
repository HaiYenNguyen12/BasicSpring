package com.haiyen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.haiyen.dao.UserRepository;
import com.haiyen.model.User;

@Service
public class UserService {
	@Autowired private UserRepository repo;
	
	
		public List<User> listAll () {
		return (List<User>) repo.findAll();
	}
		
		public void save(User user)  {
			 repo.save(user);
		}
	
	

}
