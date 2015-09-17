package io.sample.controller;

import java.util.Map;

import io.paging.Paging;
import io.paging.bean.PagingBean;
import io.sample.bean.model.SampleModel;
import io.sample.bean.para.InputUserPara;
import io.sample.bean.para.SearchUserPara;
import io.sample.bean.para.UserDetailPara;
import io.sample.bean.para.UserPara;
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
	@RequestMapping(value = {"inputUser"})
	public String inputUser(ModelMap model) throws Exception {
    	SampleModel sample = new SampleModel();
    	sample.setNavi("inputUser");
    	model.addAttribute("model", sample);

		return "admin/inputUser";
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
	@RequestMapping(value = {"inputUserCompleted"})
	public String inputUserCompleted(@Valid InputUserPara inputUserPara, 
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

		return "redirect:/admin/userList";
	}

	@RequestMapping(value = {"userList"})
	public String userList(@Valid UserPara userPara, ModelMap model) throws Exception {

		SampleModel sample = new SampleModel();
		sample.setNavi("userList");
		PagingBean paging = new PagingBean();
		// Set Paging list
		if(userPara.getAllCount() <= 0) {
			paging.setAllCount(sampleService.getSampleListSum());
		} else {
			paging.setAllCount(userPara.getAllCount());
		}
		Paging.linkPaging(paging, userPara.getNowPage());
		sample.setPaging(paging);

		// Execute the transaction
		sample.setSampleList(sampleService.selectUserList(userPara));

		model.addAttribute("model", sample);

		return "admin/userList";
	}

	@RequestMapping(value = {"searchUser"})
	public String searchUser(@Valid SearchUserPara searchUserPara, BindingResult bindingResult, 
			ModelMap model, HttpServletResponse response) throws Exception {
	
		SampleModel sample = new SampleModel();
		sample.setNavi("userList");
		// Custom Validate
		new AdminValidator().validate(searchUserPara, bindingResult);
		// If it occurs a error, set the default value.
		if (bindingResult.hasErrors()) {
			logger.error("userDetail.do - it is occured a parameter error.");
			Map<String, String> mapErrorMessage = this.handleErrorMessages(bindingResult.getAllErrors());
			response.setStatus(400);
			model.addAttribute("errorMessage", mapErrorMessage);
			return "admin/userList";
		}
	
		// Select name's data from User
		sample.setSampleList(sampleService.selectUserListByName(searchUserPara));

		model.addAttribute("model", sample);

		return "admin/userList";
	}

	@RequestMapping(value = {"userDetail"})
	public String userDetail(@Valid UserDetailPara userDetailPara, BindingResult bindingResult, 
			ModelMap model, HttpServletResponse response) throws Exception {

		SampleModel sample = new SampleModel();
		sample.setNavi("userDetail");
		// Custom Validate
		new AdminValidator().validate(userDetailPara, bindingResult);
		// If it occurs a error, set the default value.
		if (bindingResult.hasErrors()) {
			logger.error("userDetail.do - it is occured a parameter error.");
			Map<String, String> mapErrorMessage = this.handleErrorMessages(bindingResult.getAllErrors());
			response.setStatus(400);
			model.addAttribute("errorMessage", mapErrorMessage);
			return "admin/userList";
		}

		// Select name's data from User
		sample.setUserModel(sampleService.selectUserByName(userDetailPara.getUserName()));

		model.addAttribute("model", sample);

		return "admin/userDetail";
	}

}