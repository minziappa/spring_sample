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
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

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

		HttpSession session = request.getSession();
		Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if(obj instanceof ExtendUser) {
			ExtendUser extendUser = (ExtendUser) obj;
			session.setAttribute("user", extendUser.getUsername());
			logger.info("There is ExtendUser, user = " + extendUser.getUsername());
			session.setMaxInactiveInterval(100*60);
		}

		return true;
	}

	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}

}