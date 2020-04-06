/**
 * 
 */
package com.company.testService.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author anush
 *
 */
@Component
public class TestServiceInterceptors implements HandlerInterceptor{
	
	@Override
	   public boolean preHandle(
	      HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println(request.getHeader("userId"));
		System.out.println("aaaaaa");
	      
	      return true;
	   }
	   @Override
	   public void postHandle(
	      HttpServletRequest request, HttpServletResponse response, Object handler, 
	      ModelAndView modelAndView) throws Exception {
		   
		   System.out.println("bbbbbbbbb");
	   }
	   
	   @Override
	   public void afterCompletion(HttpServletRequest request, HttpServletResponse response, 
	      Object handler, Exception exception) throws Exception {
		   
		   System.out.println("ccccccccc");
	   }

}
