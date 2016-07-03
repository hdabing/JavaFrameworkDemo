package cn.jbit.ex.biz;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
/**
 * 业务层
 * @author mxc  
 * @date 2016年7月1日 下午3:33:05
 */
import java.util.Map;

import cn.jbit.ex.entity.ClaimVoucher;
import cn.jbit.ex.service.ExerciseService;
public class ExerciseBiz implements Serializable {

	//接口类型
	protected ExerciseService exerciseService = null;

	public ExerciseService getExerciseService() {
		return exerciseService;
	}

	public void setExerciseService(ExerciseService exerciseService) {
		this.exerciseService = exerciseService;
	}

	/**
	 * 查询报销单
	 *  
	 * @author mxc  
	 * @Date 2016年7月1日下午3:39:00
	 */
	public void queryClaimVoucher() {
		
		//封装查询条件
		Map<String, Object> queryParams = new HashMap<String, Object>();
		
		queryParams.put("submitMan", "张三");
		queryParams.put("maxMoney", "1000");
		
		//查询数据
		List<ClaimVoucher> claimVouchers =  exerciseService.queryClaimVoucher(queryParams);
		
		//输出查询结果
		
		if (claimVouchers!=null&&claimVouchers.size()>0) {
			System.err.println("查询结果：");
			for (ClaimVoucher claimVoucher : claimVouchers) {
				System.out.println("id:"+claimVoucher.getId()+"; submitMan:"+claimVoucher.getSubmitMan()+"; totalMoney:"+claimVoucher.getTotalMoney());
			}
		}else {
			System.err.println("没有数据");
		}
	}

	/**
	 * 天机报销单
	 *  
	 * @author mxc  
	 * @Date 2016年7月1日下午4:47:38
	 */
	public void addClaimVoucher() {
		//创建报销单 对象
		ClaimVoucher claimVoucher = new ClaimVoucher();
		claimVoucher.setEvent("吃饭报销");
		claimVoucher.setSubmitMan("张三");
		claimVoucher.setSubmitTime(new  Date());
		claimVoucher.setTotalMoney("500");
		exerciseService.saveClaimVoucher(claimVoucher);
		System.out.println("保存成功！");
	}

	/**
	 * 查询一个报销单
	 *  
	 * @author mxc  
	 * @Date 2016年7月3日下午3:05:58
	 */
	public void findClaimVoucher() {
		Map<String, Object> queryParams = new HashMap<String, Object>();
		queryParams.put("id", 1);
		ClaimVoucher claimVoucher = exerciseService.findClaimVoucher(queryParams);
		System.out.println(claimVoucher.getSubmitMan());
		System.out.println(claimVoucher.getTotalMoney());
	}
	
	
}
