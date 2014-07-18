package io.sample.bean.para;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

public class InsertUserPara {

    @NotNull(message = "userName")
    @Size(min = 1, max = 45 ,message = "userName")
	private String userName;
    @NotNull(message = "userPwd")
    @Size(min = 1, max = 45 ,message = "userPwd")
	private String userPwd;
    @NotNull(message = "userStatus")
    @Size(min = 1, max = 45 ,message = "userStatus")
	private String userStatus;
    @NotNull(message = "userAge")
    @Size(min = 1, max = 3 ,message = "userAge")
	private String userAge;

	private MultipartFile userImg;

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

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public MultipartFile getUserImg() {
		return userImg;
	}

	public void setUserImg(MultipartFile userImg) {
		this.userImg = userImg;
	}

}