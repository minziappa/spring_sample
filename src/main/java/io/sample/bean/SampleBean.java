package io.sample.bean;

import io.sample.bean.model.UserModel;

import java.io.Serializable;

public class SampleBean implements Serializable {

	private static final long serialVersionUID = -2758511412673492544L;

	private UserModel userModel;
	private String userImage;

	public UserModel getUserModel() {
		return userModel;
	}
	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}
	public String getUserImage() {
		return userImage;
	}
	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}


}