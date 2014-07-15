package io.sample.bean.model;

import io.sample.bean.SampleBean;

public class SampleModel {

	private SampleBean sample;
	private UserModel userModel;
	private String userImage;

    /** Show the message to page.**/
    private String errorMessage;

	public SampleBean getSample() {
		return sample;
	}

	public void setSample(SampleBean sample) {
		this.sample = sample;
	}

	public UserModel getUserModel() {
		return userModel;
	}

	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getUserImage() {
		return userImage;
	}

	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}

}
