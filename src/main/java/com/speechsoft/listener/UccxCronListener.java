package com.speechsoft.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import com.speechsoft.ftpclient.UccxFtpFileProcessorJob;


public class UccxCronListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.err.println("Inside contextDestroyed");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.err.println("Inside contextInitialized()..!");
		JobDetail ssFtpJob =null;
		Trigger ssFtpTrigger = null;
		Scheduler scheduler = null;
		ServletContext context=arg0.getServletContext();
		try{
			ssFtpJob = JobBuilder.newJob(UccxFtpFileProcessorJob.class)
					.withIdentity("SSFTPListener", "SSFTPGroup").build();
			ssFtpTrigger = TriggerBuilder
					.newTrigger()
					.withIdentity("SSFTPTrigger", "SSFTPGroup")
					.withSchedule(
							CronScheduleBuilder.cronSchedule("0 0/3 * * * ?"))
					.build();
			scheduler = new StdSchedulerFactory().getScheduler();
			scheduler.start();
			scheduler.scheduleJob(ssFtpJob, ssFtpTrigger);
		}catch(Exception e){
			ssFtpJob =null;
			ssFtpTrigger = null;
			scheduler = null;			
		}finally{

		}
		System.err.println("Exiting. contextInitialized()...!");

	}

}
