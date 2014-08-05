package io.sample.controller;

import io.sample.bean.para.CsvFilePara;
import io.sample.bean.para.InsertUserPara;
import io.sample.bean.para.SelectUserPara;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;

public class AdminValidator implements Validator, BaseValidator {

	final Logger logger = LoggerFactory.getLogger(AdminValidator.class);

	@Autowired
	private MessageSource message;

	@Override
	public boolean supports(Class<?> clazz) {
		if(InsertUserPara.class.equals(clazz)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void validate(Object object, Errors errors) {
	}

	@Override
	public Map<String, String> handleValidator1(List<ObjectError> errorList,
			Object object) throws IOException {

		Map<String, String> mapErrorMsg = new HashMap<String, String>();

		if (object instanceof SelectUserPara) {

			for (Object objectError : errorList) {

		        FieldError fieldError = (FieldError) objectError;
				Field[] declaredFields = SelectUserPara.class.getDeclaredFields();

		        for(Field fieldPara:declaredFields){
		        	if(fieldError.getField().equals(fieldPara.getName())) {
		        		mapErrorMsg.put(fieldError.getField(), fieldError.getDefaultMessage());
		        	}
		        }

			}
		} else if(object instanceof CsvFilePara) {
			//...
		}

		return mapErrorMsg;
	}

	@Override
	public Map<String, String> handleValidator2(List<ObjectError> errorList,
			Object object) throws IOException {

		Map<String, String> mapErrorMsg = new HashMap<String, String>();

		for (Object objectError : errorList) {
		    FieldError fieldError = (FieldError) objectError;
            mapErrorMsg.put(fieldError.getField(), fieldError.getDefaultMessage());
			logger.error("ObjectName = " + fieldError.getField());
            logger.error("DefaultMessage = " + fieldError.getDefaultMessage());
        }
		return mapErrorMsg;
	}


}
