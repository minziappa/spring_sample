package io.sample.controller;

import java.util.Map;

import io.sample.bean.model.SampleModel;
import io.sample.bean.para.InputUserPara;
import io.sample.service.SampleService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

/***
 * The <code>AdminController</code> class represents action controller.
 * 1. Explain for a method .....
 * 
 * @author  Woong-joon Kim
 * @version 0.1, 14/07/17
 * @see     io.sample.controller.AdminController#admin()
 * @see     io.sample.controller.AdminController#insertUser()
 * @since   JDK1.7
 */
@Controller
@RequestMapping("/admin")
public class AdminController extends AbstractBaseController {

	final Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private Validator validator;
	@Autowired
	private MessageSource message;
	@Autowired
    private SampleService sampleService;

    /**
	 * Admin Index
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
	@RequestMapping(value = {"/", "index"})
	public String index(ModelMap model) throws Exception {
    	SampleModel sample = new SampleModel();
    	sample.setNavi("admin");
    	model.addAttribute("model", sample);

		return "admin/index";
	}

	/**
     * Admin Page
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
	@RequestMapping(value = {"admin"})
	public String admin(ModelMap model) throws Exception {
    	SampleModel sample = new SampleModel();
    	sample.setNavi("admin");
    	model.addAttribute("model", sample);

		return "admin/admin";
	}

    /**
     * Insert some data into the Mysql.
     * 
     * @param  SamplePara 
     *         samplePara
     * @param  BindingResult 
     *         bindingResult
     * @param  ModelMap 
     *         model
     * @param  HttpServletResponse 
     *         response
     *         
     * @throws  Exception
     *          If a error occur, ...
     *
     * @return String
     * 		   a file name of FTL.
     * 
     * @since  1.7
     */
	@RequestMapping(value = {"inputUser"})
	public String inputUser(@Valid InputUserPara inputUserPara, 
			BindingResult bindingResult, ModelMap model, 
			HttpServletResponse response, HttpServletRequest request) throws Exception {

		SampleModel sample = new SampleModel();
    	sample.setNavi("admin");

		// If it occurs a error, set the default value.
		if (bindingResult.hasErrors()) {
			logger.error("insertUser.sp - it is occured a parameter error.");
			response.setStatus(400);

			Map<String, String> mapErrorMessage = this.handleErrorMessages(bindingResult.getAllErrors());
			model.addAttribute("errorMessage",  mapErrorMessage);
			model.addAttribute("model", sample);
			return "admin/admin";
		}

		// Execute the transaction
		if(!sampleService.insertSample(inputUserPara)) {
			model.addAttribute("errorMessage", message.getMessage("sample.parameter.error.message", null, LOCALE));
			model.addAttribute("model", sample);
			return "admin/admin";
		}

    	model.addAttribute("model", sample);

		return "redirect:/user/userList";
	}

}