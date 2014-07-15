package io.sample.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import io.sample.bean.SampleBean;
import io.sample.bean.model.SampleModel;
import io.sample.bean.model.UserModel;
import io.sample.bean.para.InsertUserPara;
import io.sample.bean.para.SelectUserPara;
import io.sample.service.SampleService;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.configuration.Configuration;
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
 * The <code>TestTblController</code> class represents action controller.
 * 1. Explain for a method .....
 * 
 * @author  Woong-joon Kim
 * @version 0.1, 12/05/15
 * @see     io.sample.controller.SampleController#index()
 * @see     io.sample.controller.SampleController#insertUser()
 * @see     io.sample.controller.SampleController#selectUser()
 * @since   JDK1.7
 */
@Controller
@RequestMapping("/service")
public class SampleController extends AbstractBaseController {

	final Logger logger = LoggerFactory.getLogger(SampleController.class);

    @Autowired
    private Validator validator;
	@Autowired
	private MessageSource message;
	@Autowired
    private Configuration configuration;
	@Autowired
    private SampleService sampleService;

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
	public String index(ModelMap model) throws Exception {
		return "index";
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
	@RequestMapping(value = {"insertUser.do"})
	public String insertUser(@Valid InsertUserPara insertUserPara, 
			BindingResult bindingResult, ModelMap model, 
			HttpServletResponse response) throws Exception {

		SampleModel sampleModel = new SampleModel();

		// If it occurs a error, set the default value.
		if (bindingResult.hasErrors()) {
			logger.error("insertUser.sp - it is occured a parameter error.");
			response.setStatus(400);
			handleValidator(bindingResult.getAllErrors());
			model.addAttribute("errorMessage", message.getMessage("sample.parameter.error.message", null, LOCALE));
			model.addAttribute("model", sampleModel);
			return "error/error";
		}

		// Execute the transaction
		if(!sampleService.insertSample(insertUserPara)) {
			model.addAttribute("errorMessage", message.getMessage("sample.parameter.error.message", null, LOCALE));
			model.addAttribute("model", sampleModel);
			return "error/error";
		}

		return "redirect:index.do";
	}

    /**
     * Select some data from the Mysql.
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
	@RequestMapping(value = {"selectUser.do"})
	public String selectUser(@Valid SelectUserPara selectUserPara, BindingResult bindingResult, 
			ModelMap model, HttpServletResponse response) throws Exception {

		SampleModel sampleModel = new SampleModel();

		// If it occurs a error, set the default value.
		if (bindingResult.hasErrors()) {
			logger.error("insertTestTbl.sp - it is occured a parameter error.");
			response.setStatus(400);
			model.addAttribute("errorMessage", message.getMessage("sample.parameter.error.message", null, LOCALE));
			return "error/error";
		}

		// Execute the transaction
		SampleBean sampleBean = sampleService.selectSampleByName(selectUserPara.getUserName());
		sampleModel.setSample(sampleBean);

		model.addAttribute("model", sampleModel);

		return "index";
	}

}