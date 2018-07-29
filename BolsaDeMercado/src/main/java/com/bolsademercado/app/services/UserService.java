package com.bolsademercado.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bolsademercado.app.models.User;
import com.bolsademercado.app.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User createUser(User user) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		return user;
	}
	
	public boolean userExists(String username) {
		
		User userData = userRepository.getUserByUsername(username);
		
		if (userData != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean checkUserCredentials(String username, String password) {
		
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

		User userData = userRepository.getUserByUsername(username);
		
		if (userData != null) {
			
			if (bCryptPasswordEncoder.matches(password, userData.getPassword())) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public User userDataByUsername(String username) {
		User userData = userRepository.getUserByUsername(username);
		return userData;
	}

	
}
