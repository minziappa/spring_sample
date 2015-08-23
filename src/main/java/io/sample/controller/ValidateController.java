package io.sample.controller;

import io.sample.service.SampleService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.RequestMapping;

/***
 * The <code>AdminController</code> class represents action controller.
 * 1. Explain for a method .....
 * 
 * @author  Woong-joon Kim
 * @version 0.1, 14/07/17
 * @see     io.sample.controller.ValidateController#admin()
 * @see     io.sample.controller.ValidateController#insertUser()
 * @since   JDK1.7
 */
@Controller
@RequestMapping("/validator")
public class ValidateController extends AbstractBaseController {

	final Logger logger = LoggerFactory.getLogger(ValidateController.class);

    @Autowired
    private Validator validator;
	@Autowired
	private MessageSource message;
	@Autowired
    private SampleService sampleService;

	@RequestMapping(value = {"validator"})
	public String admin(ModelMap model) throws Exception {
		return "validator/validator";
	}

}