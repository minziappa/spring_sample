package io.sample.controller;

import io.sample.bean.model.SampleModel;

import javax.servlet.http.HttpSession;

import org.apache.commons.configuration.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

/***
 * The <code>LoginSampleController</code> class represents action controller.
 * 
 * @adminor  Woong-joon Kim
 * @version 0.1, 14/07/15
 * @see     io.sample.controller.LoginController#login()
 * @see     io.sample.controller.LoginController#logout()
 * @see     io.sample.controller.LoginController#denied()
 * 
 * @since   JDK1.7
 */
@Controller
@RequestMapping("/login")
public class LoginController extends AbstractBaseController {

	final Logger logger = LoggerFactory.getLogger(LoginController.class);
	boolean blnSession = false;

    @Autowired
    private Validator validator;
	@Autowired
	private MessageSource message;
	@Autowired
	private Configuration configuration;

	@RequestMapping(value = {"login"})
	public String login(@RequestParam(value="error", required=false) boolean error, ModelMap model, HttpSession session) throws Exception {

		logger.info("this is login");

		if (error == true) {
			model.put("error", "You have entered an invalid username or password!");
		} else {
			model.put("error", "");
		}

		return "login/login";
	}

	@RequestMapping(value = {"login2"})
	public ModelAndView login2(@RequestParam(value="error", required=false) boolean error, ModelMap model, 
			RedirectAttributes redirectAttrs, HttpSession session) throws Exception {

		logger.info("this is login");

		if (error == true) {
			model.put("error", "You have entered an invalid username or password!");
		} else {
			model.put("error", "");
		}

		if(SecurityContextHolder.getContext().getAuthentication() == null) {
			blnSession = true;
			logger.info("aaaaa");
		} else {
			Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if(obj == null) {
				logger.info("cccccc");
				blnSession = true;
			}
		}

		RedirectView redirectView = new RedirectView();
		if(configuration.getString("system.environment").equals("develop") && blnSession) {

			redirectView.setUrl("https://test.io/redirect");
			redirectView.addStaticAttribute("para1", "value1");
			redirectView.addStaticAttribute("para2", "value2");

			return new ModelAndView(redirectView);
			// return redirectView;
		}

		return new ModelAndView("login/login");

		// return "login/login";
	}

	@RequestMapping(value = {"logout"})
	public String logout(ModelMap model, SessionStatus sessionStatus) throws Exception {

		SampleModel hadoopModel = new SampleModel();
		hadoopModel.setNavi("login");

		// Clear data in the session.
		sessionStatus.isComplete();

		model.addAttribute("model", hadoopModel);

		return "redirect:/sample/index/";
	}

	@RequestMapping(value = {"denied"})
	public String denied(ModelMap model, HttpSession session) throws Exception {

		return "login/denied";
	}

}