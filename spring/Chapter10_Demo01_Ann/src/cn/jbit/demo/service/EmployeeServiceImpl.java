/**
 * 
 * 
 * 创建时间：2015-10-28 下午7:28:48
 * @author：moshco zhu
 */
package cn.jbit.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	@Qualifier("employeeDao")
	protected EmployeeDao employeeDao = null;

	public EmployeeDao getEmployeeDao() {
		return employeeDao;
	}

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Employee> queryEmployee() {
		return employeeDao.queryEmployee();
	}

	@Override
	@Transactional(readOnly = true)
	public Employee findEmployeeBySN(String sn) {
		return employeeDao.findEmployeeBySN(sn);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void saveEmployee(Employee emp) {
		employeeDao.saveEmployee(emp);
	}

}
