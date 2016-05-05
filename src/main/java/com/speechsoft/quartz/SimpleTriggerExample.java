package com.speechsoft.quartz;

import java.util.Date;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.speechsoft.ftpclient.UccxFtpFileProcessorJob;

public class SimpleTriggerExample {
	public static void main(String[] args) throws Exception {
		
		JobDetail job = JobBuilder.newJob(UccxFtpFileProcessorJob.class)
				.withIdentity("dummyJobName", "group1").build();

		// Trigger the job to run on the next round minute
		Trigger trigger = TriggerBuilder
				.newTrigger()
				.withIdentity("dummyTriggerName", "group1")
				.withSchedule(
						SimpleScheduleBuilder.simpleSchedule()
								.withIntervalInSeconds(5).repeatForever())
				.build();

		Scheduler scheduler = new StdSchedulerFactory().getScheduler();
		scheduler.start();
		scheduler.scheduleJob(job, trigger);
	}
}
