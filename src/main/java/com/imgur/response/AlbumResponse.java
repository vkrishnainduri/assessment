package com.imgur.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "UserAlbumResponse", "success", "status" })
public class AlbumResponse {

	@JsonProperty("UserAlbumResponse")
	private UserAlbumResponse userAlbumResponse;
	@JsonProperty("success")
	private Boolean success;
	@JsonProperty("status")
	private Integer status;

	@JsonProperty("UserAlbumResponse")
	public UserAlbumResponse getUserAlbumResponse() {
		return userAlbumResponse;
	}

	@JsonProperty("UserAlbumResponse")
	public void setUserAlbumResponse(UserAlbumResponse userAlbumResponse) {
		this.userAlbumResponse = userAlbumResponse;
	}

	@JsonProperty("success")
	public Boolean getSuccess() {
		return success;
	}

	@JsonProperty("success")
	public void setSuccess(Boolean success) {
		this.success = success;
	}

	@JsonProperty("status")
	public Integer getStatus() {
		return status;
	}

	@JsonProperty("status")
	public void setStatus(Integer status) {
		this.status = status;
	}

}
