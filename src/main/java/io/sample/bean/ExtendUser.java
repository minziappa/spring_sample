package io.sample.bean;

import io.sample.bean.model.UserModel;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class ExtendUser extends User {

	private static final long serialVersionUID = 2086202300685821979L;

	UserModel userModel;

	public ExtendUser(String username, String password, boolean enabled,
			boolean accountNonExpired, boolean credentialsNonExpired,
			boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities, UserModel userModel) {

		super(username, password, enabled, accountNonExpired, credentialsNonExpired,
				accountNonLocked, authorities);

		// user information
		this.userModel = userModel;

	}

	public UserModel getUserModel() {
		return userModel;
	}

	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}

}
