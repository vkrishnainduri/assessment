package com.synchrony.assessment.service;

import org.springframework.stereotype.Service;

import com.imgur.response.AlbumCreationResponse;

@Service
public interface ImgurAlbumService {

	public AlbumCreationResponse createAlbum(String userName, String comments);

	public String deleteAlbum(String albumId);

}
