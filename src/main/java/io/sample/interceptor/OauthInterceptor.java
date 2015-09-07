package io.sample.interceptor;

import io.sample.bean.ExtendUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.configuration.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.view.RedirectView;

public class OauthInterceptor implements HandlerInterceptor {

	final Logger logger = LoggerFactory.getLogger(OauthInterceptor.class);

	@Autowired
    private Configuration configuration;
	@Autowired
	private MessageSource message;

	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object object, ModelAndView modelAndView) throws Exception {
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {

		String pathInfo = request.getPathInfo();
		logger.info("pathInfo >>> " + pathInfo);

//		HttpSession session = request.getSession();
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		if(auth != null) {
//			Object obj = auth.getPrincipal();
//
//			if(obj instanceof ExtendUser) {
//				ExtendUser extendUser = (ExtendUser) obj;
//				session.setAttribute("user", extendUser.getUsername());
//				logger.info("There is ExtendUser, user = " + extendUser.getUsername());
//				session.setMaxInactiveInterval(100*60);
//			} else {
//				RedirectView redirectView = new RedirectView();
//				redirectView.setUrl("https://test.io/redirect");
//				redirectView.addStaticAttribute("para1", "value1");
//				redirectView.addStaticAttribute("para2", "value2");
//		
//				ModelAndView mv = new ModelAndView(redirectView);
//				
//				ModelAndViewDefiningException mvde = new ModelAndViewDefiningException(mv);
//				throw mvde;
//			}
//		}

		return true;
	}

	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}

}