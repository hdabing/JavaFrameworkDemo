package cn.crontrigger.exercise;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.quartz.CronTrigger;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.calendar.AnnualCalendar;

/**
 * calendar测试 排除 节假日
 * 
 * 排除年中某一天
 * @author mxc  
 * @date 2016年6月23日 上午8:13:17
 */
public class CalenderTest {

	public static void main(String[] args) {
		try {
		JobDetail jobDetail = new JobDetail("remindJob", "G1", RemindJob.class);
		JobDataMap jobDataMap= jobDetail.getJobDataMap();
		jobDataMap.put("name", "鳖孙");
		
		
			CronTrigger cronTrigger = new CronTrigger("cronTrigger", "g1", "0/3 * * * * ?");
			
			cronTrigger.setStartTime(new Date(System.currentTimeMillis()+1000));
			
		SchedulerFactory schedulerFactory= new StdSchedulerFactory();
		
		Scheduler scheduler= schedulerFactory.getScheduler();
		
		//开始排除 AnnualCalendar 排除年中的某一天
		AnnualCalendar cal = new AnnualCalendar();
		
		//构建日期
		Calendar mycal = GregorianCalendar.getInstance();
		//6月份 前面是月份 后面是值
		mycal.set(Calendar.MONTH, Calendar.JULY);
		
		//天
		mycal.set(Calendar.DATE, 23);
		
		//设定要抛出的日期 如果设置为false则为包含 true 为包含
		cal.setDayExcluded(mycal, true);
		
		//注册 Calender 
		scheduler.addCalendar("24", cal, true, true);
		//绑定触发器
		cronTrigger.setCalendarName("24");
		scheduler.scheduleJob(jobDetail, cronTrigger);
		
		scheduler.start();
		
		Thread.sleep(1000*60*60);
		
		scheduler.shutdown();
		
		
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
