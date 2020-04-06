/**
 * 
 */
package com.company.testService.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.company.testService.interceptors.TestServiceInterceptors;

/**
 * @author anush
 *
 */
@Configuration
public class TestServiceInterceptorConfig implements WebMvcConfigurer{
	
	 @Autowired
	    private TestServiceInterceptors testServiceInterceptors;

	    @Override
	    public void addInterceptors(InterceptorRegistry registry) {
	        // Custom interceptor, add intercept path and exclude intercept path
	    	List<String> patt = new ArrayList<>();
	    	patt.add("/loginservice/*");
	    	patt.add("/orderservice/*");
	        registry.addInterceptor(testServiceInterceptors).addPathPatterns(patt);
	    }

}
