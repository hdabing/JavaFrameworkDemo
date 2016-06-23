package cn.simpletrigger.exercise;

import java.util.Date;

import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
/**
 * 任务调度测试类
 * 每隔一段时间执行
 * @author mxc  
 * @date 2016年6月22日 上午9:35:46
 */
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * 1.创建任务
		 * 2.创建触发器
		 * 3.创建调度者
		 * 4.注册调度
		 * 5.启动调度
		 */
		try {
			//创建Job任务
		JobDetail jobDetail= new JobDetail("remindJob", "g1", RemindJob.class);
		
		//设置初始数据
		JobDataMap jobDataMap= jobDetail.getJobDataMap();
		
		jobDataMap.put("name", "鳖孙");
		
		//创建触发器  每隔5000毫秒执行一次
		Trigger simple = new SimpleTrigger("simpleTrigger",SimpleTrigger.REPEAT_INDEFINITELY,5000);
		
		//延迟一秒执行
		simple.setStartTime(new Date(System.currentTimeMillis()+1000));
		
		//调度器工厂
		SchedulerFactory schedulerFactory= new StdSchedulerFactory();
		
		//调度器
			Scheduler scheduler= schedulerFactory.getScheduler();
			
		//将触发器和任务绑定
		scheduler.scheduleJob(jobDetail, simple);
		
		//调度者开启
		scheduler.start();
		
		Thread.sleep(1000);
		
		//scheduler.shutdown();
		
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
