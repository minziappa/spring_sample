package io.sample.bean.model;

import java.io.Serializable;

public class UserModel implements Serializable {

	private static final long serialVersionUID = -2535179337713336941L;

	private String userId;
	private String userName;
	private String userAge;
	private byte[] imgAge;

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserAge() {
		return userAge;
	}
	public void setUserAge(String userAge) {
		this.userAge = userAge;
	}
	public byte[] getImgAge() {
		return imgAge;
	}
	public void setImgAge(byte[] imgAge) {
		this.imgAge = imgAge;
	}

}