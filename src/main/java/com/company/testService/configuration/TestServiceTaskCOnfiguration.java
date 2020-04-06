package com.company.testService.configuration;

import java.util.concurrent.Executor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

@Configuration
@EnableScheduling
public class TestServiceTaskCOnfiguration implements SchedulingConfigurer{
	
	 @Value("${scheduler.pool.size:10}")
	    private Integer poolSize;

	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		taskRegistrar.setScheduler(taskExecutor());
	}
	
	 @Bean(name = "taskScheduler", destroyMethod = "shutdown")
	    public Executor taskExecutor() {
	        // use the Spring ThreadPoolTaskScheduler
	        ThreadPoolTaskScheduler scheduledExecutorService = new ThreadPoolTaskScheduler();
	        // always set the poolsize
	        scheduledExecutorService.setPoolSize(poolSize);
	        // for logging add a threadNamePrefix
	        scheduledExecutorService.setThreadNamePrefix("myTaskScheduler-");
	        // do not wait for completion of the task
	        scheduledExecutorService.setWaitForTasksToCompleteOnShutdown(false);

	        return scheduledExecutorService;
	    }

}
