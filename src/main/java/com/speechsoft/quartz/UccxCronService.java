package com.speechsoft.quartz;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.speechsoft.ftpclient.UccxFtpFileProcessorJob;

public class UccxCronService 
{
    public static void main( String[] args ) throws Exception
    {
    	JobDetail ssFtpJob = JobBuilder.newJob(UccxFtpFileProcessorJob.class)
				.withIdentity("SSFTPListener", "SSFTPGroup").build();
    	Trigger ssFtpTrigger = TriggerBuilder
				.newTrigger()
				.withIdentity("SSFTPTrigger", "SSFTPGroup")
				.withSchedule(
						CronScheduleBuilder.cronSchedule("0 0/1 * * * ?"))
				.build();
    	Scheduler scheduler = new StdSchedulerFactory().getScheduler();
    	scheduler.start();
    	scheduler.scheduleJob(ssFtpJob, ssFtpTrigger);
    }
}
