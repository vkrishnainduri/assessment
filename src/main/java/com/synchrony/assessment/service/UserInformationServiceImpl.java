package com.synchrony.assessment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.synchrony.assessment.beans.UserInformation;
import com.synchrony.assessment.repository.UserInformationRepository;

@Component
public class UserInformationServiceImpl implements UserInformationService {

	@Autowired
	private UserInformationRepository userInformationRepository;

	@Override
	public Boolean registerUser(UserInformation userInformation) {
		userInformationRepository.save(userInformation);
		return true;
	}

}
