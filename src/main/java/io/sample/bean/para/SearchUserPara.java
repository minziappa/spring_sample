package io.sample.bean.para;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.paging.bean.PagingPara;

public class SearchUserPara extends PagingPara {

	@NotNull(message = "userName must be inputted.")
	@Size(min = 2, max = 10 ,message = "userName")
	private String userName;

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