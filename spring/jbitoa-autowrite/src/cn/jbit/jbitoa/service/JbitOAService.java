package cn.jbit.jbitoa.service;

import java.io.Serializable;
/**
 * 青鸟办公自动化业务 
 * 定义的方法都会被织入事务  
 * 注意方法名称  决定了织入什么事务
 * TODO 
 * @author mxc  
 * @date 2016年6月13日 下午12:18:28    
 *
 */

import cn.jbit.jbitoa.entity.ClaimVoucher;
import cn.jbit.jbitoa.entity.Employee;
public interface JbitOAService extends Serializable {

	/**
	 * 查找员工
	 * TODO
	 * 2016年6月13日下午12:26:02 
	 * @author mxc  
	 *  @param employeeSN
	 *  @return
	 */
	Employee findEmployee(String employeeSN);
	
	/**
	 * 保存员工
	 * TODO
	 * 2016年6月13日下午12:26:21 
	 * @author mxc  
	 *  @param employee
	 */
	void saveEmployee(Employee employee);
	
	/**
	 * 更新员工
	 * TODO
	 * 2016年6月13日下午12:26:47 
	 * @author mxc  
	 *  @param employee
	 */
	void updateEmployee(Employee employee);

	/**
	 * 保存报销单
	 * 2016年6月13日下午5:13:28 
	 * @author mxc  
	 *  @param claimVoucher
	 */
	void saveClaimVoucher(ClaimVoucher claimVoucher);
}
