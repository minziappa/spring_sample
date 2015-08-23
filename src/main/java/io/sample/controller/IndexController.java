package io.sample.controller;

import java.util.Map;

import io.sample.bean.para.ValidatorPara;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/***
 * The <code>IndexController</code> class represents action controller.
 * 1. Explain for a method .....
 * 
 * @author  Woong-joon Kim
 * @version 0.1, 14/07/17
 * @see     io.sample.controller.IndexController#index()
 * @since   JDK1.7
 */
@Controller
public class IndexController extends AbstractBaseController {

	final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private Validator validator;
	@Autowired
	private MessageSource message;

    /**
     * Index for ......
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
    @RequestMapping(value = {"/", "", "index.do"}, method=RequestMethod.GET)
	public String index(HttpSession session, ModelMap model) throws Exception {

    	this.handleLogin(session);

		return "index";
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
    @RequestMapping(value = {"validator.do"})
	public String validator(@Valid ValidatorPara validatorPara, BindingResult bindingResult, 
			ModelMap model) throws Exception {

		// If it occurs a error, set the default value.
		if (bindingResult.hasErrors()) {
			logger.error("validate.do - it is occured a parameter error.");
			Map<String, String> mapErrorMessage = this.handleErrorMessages(bindingResult.getAllErrors());
			model.addAttribute("errorMessage", mapErrorMessage);
			return "sample/validator";
		}

		return "sample/validator";
	}

    @RequestMapping(value = {"layout.do"})
	public String layout() throws Exception {
		return "layout/home";
	}

}