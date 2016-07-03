/**
 * 
 * 
 * 创建时间：2015-10-28 下午7:28:25
 * @author：moshco zhu
 */
package cn.jbit.demo.service;

import java.io.Serializable;
import java.util.List;

import cn.jbit.demo.entity.Employee;

/**
 * 员工业务
 * 
 * 创建时间：2015-10-28 下午7:28:25
 * 
 * @author moshco zhu
 * 
 */
public interface EmployeeService extends Serializable {

	public List<Employee> queryEmployee();

	public Employee findEmployeeBySN(String sn);

	public void saveEmployee(Employee emp);

}
