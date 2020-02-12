package com.example.demo.securityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUsersDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepository repo;

	@Override
	public org.springframework.security.core.userdetails.User loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repo.findByUsername(username);
		if(user == null)
			throw new UsernameNotFoundException("user not found !!!!");
		UserDetailsPrincipal userp = new UserDetailsPrincipal(user);
		  org.springframework.security.core.userdetails.User user2;
		  user2 = new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), userp.getAuthorities());
	//	return new UserDetailsPrincipal(user);
		  return user2;
	}

}
