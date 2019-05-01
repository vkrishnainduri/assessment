package com.synchrony.assessment.service;

import org.springframework.stereotype.Service;

import com.synchrony.assessment.beans.UserInformation;

@Service
public interface UserInformationService {

	public Boolean registerUser(UserInformation userInformation);

	public UserInformation userDetails(String userName);

	public UserInformation updateUserInformationWithAlbumId(UserInformation userInformation);

}
