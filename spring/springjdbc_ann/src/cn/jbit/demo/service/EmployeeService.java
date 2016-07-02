package cn.jbit.demo.service;

import java.io.Serializable;

import cn.jbit.dome.entity.Employee;
/**
 * 配置声明式事务专用接口
 * @author mxc  
 * @date 2016年6月30日 下午10:11:54
 */
public interface EmployeeService extends Serializable {

	/**
	 * 查询员工通过id
	 *  
	 * @author mxc  
	 * @Date 2016年6月30日下午10:21:02
	 *  @param id
	 *  @return
	 */
	Employee findEmployee(int id);

}
