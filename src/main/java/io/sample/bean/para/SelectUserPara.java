package io.sample.bean.para;

import io.paging.bean.PagingPara;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SelectUserPara extends PagingPara {

	private String userName;

    @NotNull(message = "userData")
    @Size(min = 1, max = 10 ,message = "userData must not exceed {max} characters")
    private String userData;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserData() {
		return userData;
	}

	public void setUserData(String userData) {
		this.userData = userData;
	}

}