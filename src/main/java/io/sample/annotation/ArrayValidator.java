package io.sample.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ArrayValidator implements ConstraintValidator<Array, String[]>{

	@Override
	public void initialize(Array constraintAnnotation) {
	}

	@Override
	public boolean isValid(String[] array, ConstraintValidatorContext ctx) {
		for(String para : array) {
			if(para == null) return false;
			else if(para.trim().length() < 1) return false;
		}
		return true;
		
	}

}
