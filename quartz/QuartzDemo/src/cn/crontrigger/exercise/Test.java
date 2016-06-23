package cn.crontrigger.exercise;

import java.text.ParseException;
import java.util.Date;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

/**
 * 测试CronTrigger 
 * 指定时间执行
 * @author mxc  
 * @date 2016年6月22日 上午10:47:58
 */
public class Test {

	public static void main(String[] args) {

		/**
		 * 1.创建一个任务
		 * 2.创建一个触发器
		 * 3.设置启动时间
		 * 4.创建一个调度者工厂
		 * 5.使用调度者工厂创建调度者
		 * 5.使用调度者将任务和触发器绑定
		 * 7.启动调度
		 * 
		 */
		try {
		//任务创建
		JobDetail jobDetail= new JobDetail("remindJob", "g1", RemindJob.class);
		
		jobDetail.getJobDataMap().put("name", "鳖孙");
		
		//创建触发器
				// 22日 11点 7分 从0秒开始 每隔三秒执行一次，到8分结束
			Trigger cronTrigger = new CronTrigger("cronTrigger","g1","0/3 7 11 22 * ?");
			
		//设置启动时间 一秒后启动
			cronTrigger.setStartTime(new Date(System.currentTimeMillis()+1000));
		
		//创建调度者工厂
			SchedulerFactory schedulerFactory = new StdSchedulerFactory();
		//创建调度者
			Scheduler scheduler= schedulerFactory.getScheduler();
		
		//将任务和触发器绑定
			scheduler.scheduleJob(jobDetail, cronTrigger);
		//启动
			scheduler.start();
			
			//一分钟后关闭调度者 连带着关闭任务 不管有没有执行完
			Thread.sleep(1000*60);
		//关闭
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
