package com.project.ecart.JWTConfiguration;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.ecart.model.User;
import com.project.ecart.service.UserServices.UserService;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	UserService userService;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String mobile) throws UsernameNotFoundException {
		try {
			User user = userService.findByMobile(mobile);
			return UserPrincipal.create(user);
		} catch (Exception e) {
			throw new UsernameNotFoundException("User not found with Mobile : " + mobile);
		}
	}

	// This method is used by JWTAuthenticationFilter
	@Transactional
	public UserDetails loadUserById(Long id) {
		try {
			User user = userService.getUserDetailById(id);
			return UserPrincipal.create(user);
		} catch (Exception e) {
			throw new UsernameNotFoundException("User not found with id : " + id);
		}
		// return UserPrincipal.create(user);
	}

//	@Override
//	public UserDetails loadUserByUsername(String mobile) throws UsernameNotFoundException {
//		
//		return null;
//	}

}
