package com.stackroute.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.stackroute.userservice.model.User;


/*
* This class is implementing the JpaRepository interface for Note.
* Annotate this class with @Repository annotation
* */


public interface UserAuthRepository  extends JpaRepository<User,String>{

	public User findByUserIdAndPassword(String userId, String password);

}
