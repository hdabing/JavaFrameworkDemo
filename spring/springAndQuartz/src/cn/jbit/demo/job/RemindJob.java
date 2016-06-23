package cn.jbit.demo.job;

import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import org.springframework.scheduling.quartz.QuartzJobBean;


import cn.jbit.demo.job.service.RemindService;
/**
 * 任务实例 
 * @author mxc  
 * @date 2016年6月22日 上午11:51:30
 */
public class RemindJob extends QuartzJobBean {

	
	
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
	
		
		JobDataMap jobDataMap= context.getJobDetail().getJobDataMap();
		
		RemindService remindService = (RemindService) jobDataMap.get("remindService");
		
		System.out.println(jobDataMap.get("name")+" 有"+remindService.getNum()+" 件未读email！");
	}

	

}
