package io.sample.service.impl;

import io.sample.bean.ExtendUser;
import io.sample.bean.model.UserModel;
import io.sample.dao.SlaveDao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

	@Autowired
	private SqlSession slaveDao;
	@Autowired
	private Md5PasswordEncoder passwordEncoder;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		ExtendUser user = null;
		UserModel userModel = null;

		try {
			// Get a user information form DB.

			// Or Get the true/false from Active Directory
			Map<String, Object> mapSelect = new HashMap<String, Object>();
			mapSelect.put("userName", userName);

			try {
				userModel = slaveDao.getMapper(SlaveDao.class).selectSampleByName(mapSelect);
			} catch (Exception e) {
				logger.error("Exception error", e);
			}

			if(userModel == null) {
				return null;
			}

	        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

	        // For java1.6
	        switch(Integer.valueOf(userModel.getUserStatus())) {
	            case 1:
	                authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
	                authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
	            break;
	            default:
	                authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
	            break;
	        }

	        boolean enabled = true;
	        boolean accountNonExpired = true;
	        boolean credentialsNonExpired = true;
	        boolean accountNonLocked = true;
	
	        // Add a user's the game Id.
	        user = new ExtendUser(userModel.getUserId(), userModel.getUserPwd(), enabled, 
	        		accountNonExpired, credentialsNonExpired, accountNonLocked, authorities, userModel);

			logger.info("userId >> " + userName);

//			sample = new SampleBean();
//			// Set a user information
//			sample.setUserModel(userModel);
//			// Set a user's image
//			if(userModel.getUserImg() != null) {
//				byte[] imgBytesAsBase64 = Base64.encodeBase64(userModel.getUserImg());
//				String imgDataAsBase64 = new String(imgBytesAsBase64);
//				String imgAsBase64 = "data:image/png;base64," + imgDataAsBase64;
//				sample.setUserImage(imgAsBase64);
//			}

			
		} catch (Exception e) {
			logger.error("Exception >> ", e);
		}

		return user;
	}

}
