package com.bolsademercado.app.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.bolsademercado.app.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	User getUserByUsername(@Param("username") String username);

}