package io.sample.bean.para;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SelectUserPara {

    @NotNull(message = "userName")
    @Size(min = 1, max = 45 ,message = "userName")
	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}