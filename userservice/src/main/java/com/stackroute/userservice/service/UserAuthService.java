package com.stackroute.userservice.service;

import com.stackroute.userservice.util.exception.UserAlreadyExistsException;
import com.stackroute.userservice.util.exception.UserNotFoundException;
import com.stackroute.userservice.model.User;

public interface UserAuthService {

    public User findByUserIdAndPassword(String userId, String password) throws UserNotFoundException;

    boolean saveUser(User user) throws UserAlreadyExistsException;
}
