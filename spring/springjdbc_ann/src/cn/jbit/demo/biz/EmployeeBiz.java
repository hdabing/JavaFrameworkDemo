package cn.jbit.demo.biz;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import cn.jbit.demo.service.EmployeeService;
import cn.jbit.dome.entity.Employee;
/**
 * 员工业务
 * @author mxc  
 * @date 2016年6月30日 下午10:15:28
 */
@Component("employeeBiz")
public class EmployeeBiz implements Serializable {

	@Autowired
	@Qualifier("employeeService")
	protected EmployeeService employeeService = null;

	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	/**
	 *查询员工通过id
	 *  
	 * @author mxc  
	 * @Date 2016年6月30日下午10:20:22
	 *  @param id
	 *  @return
	 */
	public Employee findEmployee(int id) {
		
		return employeeService.findEmployee(id);
	}
	
	
}
