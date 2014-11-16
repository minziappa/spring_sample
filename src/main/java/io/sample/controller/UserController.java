package io.sample.controller;

import java.util.Map;

import io.paging.Paging;
import io.paging.bean.PagingBean;
import io.sample.bean.model.SampleModel;
import io.sample.bean.para.SelectUserPara;
import io.sample.bean.para.UserPara;
import io.sample.service.SampleService;

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
 * The <code>UserController</code> class represents action controller.
 * 1. Explain for a method .....
 * 
 * @author  Woong-joon Kim
 * @version 0.1, 14/07/17
 * @see     io.sample.controller.UserController#user()
 * @see     io.sample.controller.UserController#selectUser()
 * @since   JDK1.7
 */
@Controller
@RequestMapping("/user")
public class UserController extends AbstractBaseController {

	final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private Validator validator;
	@Autowired
	private MessageSource message;
	@Autowired
    private SampleService sampleService;

    /**
     * User Page
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
	@RequestMapping(value = {"user.do"})
	public String user(@Valid UserPara userPara, ModelMap model) throws Exception {

		SampleModel sampleModel = new SampleModel();

		PagingBean paging = new PagingBean();
		// Set Paging list
		if(userPara.getAllCount() <= 0) {
			paging.setAllCount(sampleService.getSampleListSum());
		} else {
			paging.setAllCount(userPara.getAllCount());
		}
		Paging.linkPaging(paging, userPara.getNowPage());
		sampleModel.setPaging(paging);

		// Execute the transaction
		sampleModel.setSampleList(sampleService.selectSampleList(userPara));

		model.addAttribute("model", sampleModel);

		return "sample/user";
	}

    /**
     * Select some data from the Mysql.
     * 
     * @param  SelectUserPara 
     *         a user name
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

		// Custom Validate
		new UserValidator().validate(selectUserPara, bindingResult);

		// If it occurs a error, set the default value.
		if (bindingResult.hasErrors()) {
			logger.error("selectUser.do - it is occured a parameter error.");
			Map<String, String> mapErrorMessage = this.handleErrorMessages(bindingResult.getAllErrors());
			response.setStatus(400);
			model.addAttribute("errorMessage", mapErrorMessage);
			return "sample/user";
		}

		// Execute the transaction
		sampleModel.setSampleList(sampleService.selectSampleByName(selectUserPara));

		model.addAttribute("model", sampleModel);

		return "sample/user";
	}

}