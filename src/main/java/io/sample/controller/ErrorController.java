package io.sample.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class ErrorController {

	final Locale LOCALE = Locale.JAPAN;
	final Logger logger = LoggerFactory.getLogger(ErrorController.class);

    @Autowired
    private Validator validator;
	@Autowired
	private MessageSource message;

	@RequestMapping(value = {"404error"})
	public String user(ModelMap model) throws Exception {
		return "error/404error";
	}

}