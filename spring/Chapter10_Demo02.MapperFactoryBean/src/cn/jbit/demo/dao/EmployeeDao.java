package cn.jbit.demo.dao;

import java.io.Serializable;
import java.util.List;

import cn.jbit.demo.entity.Employee;

public interface EmployeeDao extends Serializable {

	/**
	 * 10.3.1节示例：根据员工编号获取员工信息
	 * 
	 * @param sn
	 * @return
	 */
	public Employee findEmployeeBySN(String sn);

	/**
	 * 10.3.3节示例：增加员工信息
	 * 
	 * @param emp
	 */
	public void saveEmployee(Employee emp);

	/**
	 * 10.3.3节示例：查询全部员工信息
	 * 
	 * @param emp
	 */
	public List<Employee> queryEmployee();

}
