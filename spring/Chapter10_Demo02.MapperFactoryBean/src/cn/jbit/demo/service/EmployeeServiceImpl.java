/**
 * 
 * 
 * 创建时间：2015-10-28 下午7:28:48
 * @author：moshco zhu
 */
package cn.jbit.demo.service;

import java.util.List;

import cn.jbit.demo.dao.EmployeeDao;
import cn.jbit.demo.entity.Employee;

/**
 * 员工业务
 * 
 * 创建时间：2015-10-28 下午7:28:48
 * 
 * @author moshco zhu
 * 
 */
public class EmployeeServiceImpl implements EmployeeService {

	protected EmployeeDao employeeDao = null;

	public EmployeeDao getEmployeeDao() {
		return employeeDao;
	}

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	public List<Employee> queryEmployee() {
		return employeeDao.queryEmployee();
	}

	@Override
	public Employee findEmployeeBySN(String sn) {
		return employeeDao.findEmployeeBySN(sn);
	}

	@Override
	public void saveEmployee(Employee emp) {
		employeeDao.saveEmployee(emp);
	}

}
