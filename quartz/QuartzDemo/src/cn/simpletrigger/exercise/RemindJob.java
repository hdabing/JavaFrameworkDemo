package cn.simpletrigger.exercise;


import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
/**
 * 任务执行类
 * @author mxc  
 * @date 2016年6月22日 上午9:35:34
 */
public class RemindJob implements Job {

	@Override
	/**
	 * 
	 * @author mxc
	 * 2016年6月22日上午9:41:29   
	 * @param context 调度器的上下文信息 
	 * @throws JobExecutionException
	 */
	public void execute(JobExecutionContext context) throws JobExecutionException {
		// TODO Auto-generated method stub
		JobDataMap dataMap = context.getJobDetail().getJobDataMap();
		System.out.println("JobName:"+context.getJobDetail().getName()+",TriggerName:"+context.getTrigger().getName()+","+dataMap.get("name")+"执行秘密任务！");
		
		
	}

}
