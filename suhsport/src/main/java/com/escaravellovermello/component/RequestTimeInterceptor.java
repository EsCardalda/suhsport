package com.escaravellovermello.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component("requestTimeInterceptor") //ADD WebMvcConfiguration
public class RequestTimeInterceptor extends HandlerInterceptorAdapter {
	
	private static final Log LOGGER = LogFactory.getLog(RequestTimeInterceptor.class);
	
	// First
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {	
		request.setAttribute("startTime", System.currentTimeMillis());
		return true;		
	}

	// Second
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		long startTime = (Long) request.getAttribute("startTime");
		LOGGER.info("URL to: '"+ request.getRequestURL().toString() +"' in "+ (System.currentTimeMillis() -startTime) +"ms");
	}

}
