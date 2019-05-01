
package com.synchrony.assessment.album.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "safeFlags", "highRiskFlags", "unsafeFlags", "showsAds" })
public class AdConfig {

	@JsonProperty("safeFlags")
	private List<String> safeFlags = null;
	@JsonProperty("highRiskFlags")
	private List<String> highRiskFlags = null;
	@JsonProperty("unsafeFlags")
	private List<String> unsafeFlags = null;
	@JsonProperty("showsAds")
	private Boolean showsAds;

	@JsonProperty("safeFlags")
	public List<String> getSafeFlags() {
		return safeFlags;
	}

	@JsonProperty("safeFlags")
	public void setSafeFlags(List<String> safeFlags) {
		this.safeFlags = safeFlags;
	}

	@JsonProperty("highRiskFlags")
	public List<String> getHighRiskFlags() {
		return highRiskFlags;
	}

	@JsonProperty("highRiskFlags")
	public void setHighRiskFlags(List<String> highRiskFlags) {
		this.highRiskFlags = highRiskFlags;
	}

	@JsonProperty("unsafeFlags")
	public List<String> getUnsafeFlags() {
		return unsafeFlags;
	}

	@JsonProperty("unsafeFlags")
	public void setUnsafeFlags(List<String> unsafeFlags) {
		this.unsafeFlags = unsafeFlags;
	}

	@JsonProperty("showsAds")
	public Boolean getShowsAds() {
		return showsAds;
	}

	@JsonProperty("showsAds")
	public void setShowsAds(Boolean showsAds) {
		this.showsAds = showsAds;
	}

}
