package com.synchrony.assessment.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.synchrony.assessment.album.response.AlbumResponse;
import com.synchrony.assessment.imgur.response.ImageCreationResponse;

@Service
public interface ImgurImageService {

	public ImageCreationResponse addImage(String albumId,MultipartFile file);

	public String deleteImage(String imageId);

	public AlbumResponse viewImages(String albumId);
}
