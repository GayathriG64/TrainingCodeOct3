package com.customer.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.customer.entity.Customer;
import com.customer.repository.CustomerRepo;
@Lazy
@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private CustomerRepo customerRepo;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<Customer> custList = customerRepo.findByUsername(username);
		if(custList.isEmpty()) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		String usernameFromdb= custList.get(0).getUsername();
		String passwordFromdb =custList.get(0).getPassword();
		if (usernameFromdb.equals(username)) {
			return new User(usernameFromdb, passwordFromdb,
					new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}

}
