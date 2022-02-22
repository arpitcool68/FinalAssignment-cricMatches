package com.stackroute.userservice.service;

import com.stackroute.userservice.util.exception.UserAlreadyExistsException;
import com.stackroute.userservice.util.exception.UserNotFoundException;
import com.stackroute.userservice.model.User;
import com.stackroute.userservice.repository.UserAuthRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserAuthServiceImpl implements UserAuthService {

	@Autowired
	private UserAuthRepository userAuthRepository;

	@Override
	public User findByUserIdAndPassword(String userId, String password) throws UserNotFoundException {
		if (!StringUtils.isEmpty(password) && !StringUtils.isEmpty(userId)) {
			User fetchedUser = userAuthRepository.findByUserIdAndPassword(userId, password);
			if (null != fetchedUser) {
				return fetchedUser;
			} else {
				throw new UserNotFoundException("User already exist in the system");
			}
		}
		return null;
	}

	@Override
	public boolean saveUser(User user) throws UserAlreadyExistsException {

		boolean isUserSaved = true;
		Optional<User> optionalUser = userAuthRepository.findById(user.getUserId());
		if (optionalUser.isPresent()) {
			isUserSaved = false;
			throw new UserAlreadyExistsException("User Already Exist");
		}
		userAuthRepository.save(user);
		return isUserSaved;

	}
}
