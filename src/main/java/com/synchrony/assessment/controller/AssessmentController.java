package com.synchrony.assessment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.synchrony.assessment.beans.UserInformation;
import com.synchrony.assessment.service.UserInformationService;

@Controller
public class AssessmentController {

	@Autowired
	private UserInformationService userInformationService;

	@RequestMapping(name = "/user/register", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void registerUser(@RequestBody UserInformation userInformation) {
		userInformationService.registerUser(userInformation);
	}

	@RequestMapping(name = "/image/upload", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE,
			MediaType.APPLICATION_FORM_URLENCODED_VALUE }, method = RequestMethod.POST)
	public void addImage(@RequestParam("image") MultipartFile file) {
		System.out.println(file);
	}

	@RequestMapping(name = "/image/delete", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_FORM_URLENCODED_VALUE }, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> getUserDetails() {
		System.out.println("getUser Detail");
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
