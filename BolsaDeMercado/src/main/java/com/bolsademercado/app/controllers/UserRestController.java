package com.bolsademercado.app.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.bolsademercado.app.models.User;
import com.bolsademercado.app.services.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserRestController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/createUser")
	public void createUser() {
		User user = new User();
		user.setPassword("admin");
		user.setUsername("admin");
		user.setPersonaId((long) 1);
		user.setStatus(1);
		userService.createUser(user);
	}

	@RequestMapping(value = "/checkUserCredentials")
	public List<String> checkUserCredentials(User user) {
		List<String> errorList = new ArrayList<String>();
		// Check if user do not exists
		if (userService.userExists(user.getUsername()) == false) {
			errorList.add("Usuario inexistente");
		} else {
			
			// Check if user credentials are not OK
			if (userService.checkUserCredentials(user.getUsername(), user.getPassword()) == false) {
				errorList.add("Datos no coinciden");
			} else {
				
				User userData = userService.userDataByUsername(user.getUsername());
				
				// No errors found
				ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
				HttpSession httpSession = servletRequestAttributes.getRequest().getSession();
				
				// Set session parameters
				httpSession.setAttribute("isLogged", true);
				httpSession.setAttribute("personaId", userData.getPersonaId());
				httpSession.setAttribute("username", userData.getUsername());
				
			}
		}
		
		return errorList;
	}
}
