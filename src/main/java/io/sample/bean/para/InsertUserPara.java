package io.sample.bean.para;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

public class InsertUserPara {

    @NotNull(message = "userName")
    @Size(min = 1, max = 45 ,message = "userName")
	private String userName;
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

	public MultipartFile getUserImg() {
		return userImg;
	}

	public void setUserImg(MultipartFile userImg) {
		this.userImg = userImg;
	}

}