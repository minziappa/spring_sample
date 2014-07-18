package io.sample.bean.model;

import io.sample.bean.SampleBean;

public class SampleModel {

	private SampleBean sample;
	private UserModel userModel;
	private String navi;

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

	public String getNavi() {
		return navi;
	}

	public void setNavi(String navi) {
		this.navi = navi;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
