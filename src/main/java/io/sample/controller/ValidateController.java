package io.sample.controller;

import java.util.Map;

import javax.validation.Valid;

import io.sample.bean.model.SampleModel;
import io.sample.bean.para.ValidatorPara;
import io.sample.service.SampleService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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

	@RequestMapping(value = {"index"})
	public String admin(ModelMap model) throws Exception {
		return "validator/index";
	}

    /**
     * Check several annotation validate for ......
     * 
     * @param  ModelMap 
     *         model
     *         
     * @throws  Exception
     *          If a error occur, ...
     *
     * @return String
     * 		   a file name of FTL.
     * 
     * @since  1.7
     */
    @RequestMapping(value = {"validator"})
	public String validator(@Valid ValidatorPara validatorPara, BindingResult bindingResult, 
			ModelMap model) throws Exception {

    	SampleModel sample = new SampleModel();
    	sample.setNavi("index");
    	model.addAttribute("model", sample);

		// If it occurs a error, set the default value.
		if (bindingResult.hasErrors()) {
			logger.error("validate.do - it is occured a parameter error.");
			Map<String, String> mapErrorMessage = this.handleErrorMessages(bindingResult.getAllErrors());
			model.addAttribute("errorMessage", mapErrorMessage);
			return "validator/validator";
		}

		return "validator/validator";
	}

}