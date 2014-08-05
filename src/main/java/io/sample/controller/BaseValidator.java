package io.sample.controller;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.validation.ObjectError;

public interface BaseValidator {

	final Locale LOCALE = Locale.JAPAN;

	public Map<String, String> handleValidator1(List<ObjectError> errorList, Object object) throws IOException;
	public Map<String, String> handleValidator2(List<ObjectError> errorList, Object object) throws IOException;

}
