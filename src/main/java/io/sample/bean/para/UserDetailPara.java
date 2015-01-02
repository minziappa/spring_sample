package io.sample.bean.para;

import javax.validation.constraints.NotNull;

import io.paging.bean.PagingPara;

public class UserDetailPara extends PagingPara {

	@NotNull(message = "userName must be inputted.")
	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}