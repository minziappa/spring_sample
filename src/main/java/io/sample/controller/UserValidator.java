package io.sample.controller;

import io.sample.bean.para.SelectUserPara;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserValidator implements Validator {

	final Logger logger = LoggerFactory.getLogger(UserValidator.class);

	@Override
	public boolean supports(Class<?> clazz) {
		if(SelectUserPara.class.equals(clazz)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void validate(Object object, Errors errors) {
		if (object instanceof SelectUserPara) {
			SelectUserPara selectUserPara = (SelectUserPara) object;

	        if(selectUserPara != null) {
	    		if(selectUserPara.getUserData() == null){
					errors.rejectValue("validate", "sample.parameter.error.message");
					logger.warn("the start date is error.");
					// If you want to set the default value, remove the comment
	    			// selectUserPara.setUserName("user");
	    		}
	        }
		}
	}

}
