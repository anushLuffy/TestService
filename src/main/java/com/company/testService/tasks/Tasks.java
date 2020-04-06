/**
 * 
 */
package com.company.testService.tasks;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author anush
 *
 */
@Component
public class Tasks {
	
	private static final Logger logger = LoggerFactory.getLogger(Tasks.class);
//	
//	@Scheduled(initialDelay = 1000, fixedRate = 1000)
//	public void run() {
//		logger.info("Current time is :: " + Calendar.getInstance().getTime());
//	}
//	
//	@Scheduled(fixedDelay = 1000)
//	public void run1() throws InterruptedException {
//		logger.info("Current Fixed time is :: " + Calendar.getInstance().getTime());
////		TimeUnit.SECONDS.sleep(3);
//	}
//	
//	 @Scheduled(cron="*/5 * * * * ?")
//	    public void demoServiceMethod()
//	    {
//		 logger.info("Method executed at every 5 seconds. Current time is :: "+ new Date());
//	    }

}
