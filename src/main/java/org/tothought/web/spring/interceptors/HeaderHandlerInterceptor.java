package org.tothought.web.spring.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.tothought.data.repositories.ThoughtRepository;

public class HeaderHandlerInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private ThoughtRepository repository;
	
	private String thought = "This is a test";
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		//modelAndView.addObject("thought", thought);
		super.postHandle(request, response, handler, modelAndView);
	}

	
}
