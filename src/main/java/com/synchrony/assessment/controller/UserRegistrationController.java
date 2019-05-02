package com.synchrony.assessment.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.synchrony.assessment.beans.UserInformation;
import com.synchrony.assessment.service.UserInformationService;

@Controller
public class UserRegistrationController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserRegistrationController.class);

	@Autowired
	private UserInformationService userInformationService;

	@RequestMapping(name = "/user/register", method = RequestMethod.POST)
	@ResponseBody
	public void registerUser(@RequestBody UserInformation userInformation) {
		userInformationService.registerUser(userInformation);
	}

}
