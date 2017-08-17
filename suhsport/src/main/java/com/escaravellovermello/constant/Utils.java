package com.escaravellovermello.constant;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

public final class Utils {
	private Utils() {
		
	}
	
	public static BindingResult validateFormWhithPattern(String regex, String value, BindingResult bindingResult, String entityName, String field, String errorMessage) {
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(value);
		if (!matcher.find()) {
			FieldError error = new FieldError(entityName, field, errorMessage);
			bindingResult.addError(error);
		}			
		return bindingResult;
	}

	public static BindingResult duplicatedField(BindingResult bindingResult, String entityName, String field, String errorMessage) {
		FieldError error = new FieldError(entityName, field, errorMessage);
		bindingResult.addError(error);		
		return bindingResult;		
	}
	
	
}
