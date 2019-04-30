package com.synchrony.assessment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.synchrony.assessment.UserPrincipal;
import com.synchrony.assessment.beans.UserInformation;
import com.synchrony.assessment.repository.MyUserInformationRepository;

@Service
public class MyUserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private MyUserInformationRepository myUserInformationRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserInformation userInformation = myUserInformationRepository.findByUserName(username);
		return new UserPrincipal(userInformation);
	}

}
