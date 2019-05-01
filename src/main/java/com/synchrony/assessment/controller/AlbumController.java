package com.synchrony.assessment.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

import com.imgur.response.AlbumCreationResponse;
import com.imgur.response.AlbumResponse;
import com.imgur.response.ImageCreationResponse;
import com.synchrony.assessment.beans.UserInformation;
import com.synchrony.assessment.service.ImgurAlbumService;
import com.synchrony.assessment.service.ImgurImageService;
import com.synchrony.assessment.service.UserAuthenticationService;
import com.synchrony.assessment.service.UserInformationService;

@Controller
public class AlbumController {

	@Autowired
	private UserAuthenticationService userAuthenticationService;

	@Autowired
	private UserInformationService userInformationService;

	@Autowired
	private ImgurAlbumService imgurAlbumService;

	@Autowired
	private ImgurImageService imgurImageService;

	@RequestMapping(value = "/album", method = RequestMethod.POST)
	@ResponseStatus
	public ResponseEntity<ImageCreationResponse> uploadImage(@RequestHeader("authorization") final String authorization,
			@RequestParam("file") final MultipartFile file) throws IOException {
		if (!userAuthenticationService.isUserAuthenticated(authorization)) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}

		final String userName = userAuthenticationService.getUserName(authorization);
		String albumId = "";
		final UserInformation userDetails = userInformationService.userDetails(userName);
		if (userDetails != null && userDetails.getAlbumId() != null) {
			albumId = userDetails.getAlbumId();
		} else {
			final AlbumCreationResponse createAlbum = imgurAlbumService.createAlbum(userName, userName + " Album");
			albumId = createAlbum.getData().getId();
			userDetails.setAlbumId(albumId);
			userDetails.setDeleteAlbumId(createAlbum.getData().getDeletehash());
			userInformationService.updateUserInformationWithAlbumId(userDetails);
		}

		final ImageCreationResponse addImage = imgurImageService.addImage(albumId, file);

		return new ResponseEntity<ImageCreationResponse>(addImage, HttpStatus.OK);
	}

	@RequestMapping(value = "/album", method = RequestMethod.GET)
	@ResponseStatus
	public ResponseEntity<AlbumResponse> viewAlbum(@RequestHeader("authorization") final String authorization) {
		if (!userAuthenticationService.isUserAuthenticated(authorization)) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		final String userName = userAuthenticationService.getUserName(authorization);
		final UserInformation userDetails = userInformationService.userDetails(userName);
		final AlbumResponse viewImages = imgurImageService.viewImages(userDetails.getAlbumId());
		return new ResponseEntity<AlbumResponse>(viewImages, HttpStatus.OK);
	}

	@RequestMapping(value = "/album", method = RequestMethod.DELETE)
	@ResponseStatus
	public ResponseEntity<String> deleteAlbum(@RequestHeader("authorization") final String authorization) {
		if (!userAuthenticationService.isUserAuthenticated(authorization)) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		final String userName = userAuthenticationService.getUserName(authorization);
		final UserInformation userDetails = userInformationService.userDetails(userName);
		imgurImageService.deleteImage(userDetails.getDeleteAlbumId());
		return new ResponseEntity<String>("Album Deleted Successfully", HttpStatus.OK);
	}

}
