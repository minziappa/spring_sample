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
import org.springframework.context.i18n.LocaleContextHolder;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
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
			Map<String, Object> mapSelect = new HashMap<String, Object>();
			mapSelect.put("userName", userName);

			try {
				userModel = slaveDao.getMapper(SlaveDao.class).selectSampleByName(mapSelect);
			} catch (Exception e) {
				logger.error("Exception error", e);
			}

			if(userModel == null) {
				throw new UsernameNotFoundException( userName + " is not found." );
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

//	        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//	        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(userModel.getUserName(), "test", auth.getAuthorities());
//	        SecurityContextHolder.getContext().setAuthentication(authRequest);
//	        auth.setAuthenticated(false);
	        
	        SecurityContext securityContext = SecurityContextHolder.getContext();
	        Authentication authentication = securityContext.getAuthentication();
	        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(userModel.getUserName(), "test");
	        securityContext.setAuthentication(authRequest);
	        
	        // Add a user's the game Id. userModel.getUserPwd()
	        user = new ExtendUser(userModel.getUserName(), "test", enabled, 
	        		accountNonExpired, credentialsNonExpired, accountNonLocked, authorities, userModel);

			logger.info("UserDetailsService >> userId >> " + userName);
			// logger.info("UserDetailsService >> passowrd >> " + passowrd);
		} catch (Exception e) {
			logger.error("Select error, userName={}, userStatus={}", userModel.getUserName(), userModel.getUserStatus());
			logger.error("Exception >> ", e);
		}

		return user;
	}

}
