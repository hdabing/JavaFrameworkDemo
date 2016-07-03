/**
 * 
 */
package cn.jbit.demo.biz;

import java.io.Serializable;
import java.util.List;

import cn.jbit.demo.entity.Employee;
import cn.jbit.demo.service.EmployeeService;

/**
 * 员工业务
 * 
 * @author moshco
 * 
 */
public class EmployeeBiz implements Serializable {

	protected EmployeeService employeeService = null;

	/**
	 * @return the employeeService
	 */
	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	/**
	 * @param employeeService
	 *            the employeeService to set
	 */
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	/**
	 * 查询所有员工
	 * 
	 * 
	 * 开发时间：2015-10-29 上午7:58:15
	 * 
	 * @author：moshco zhu
	 */
	public void queryEmployee() {

		// 查询所有员工
		List<Employee> listEmployee = employeeService.queryEmployee();

		if (listEmployee == null || listEmployee.size() <= 0) {
			System.out.println("没有找到数据。");
			return;
		}

		System.out.println("查询结果如下（size=" + listEmployee.size() + "）：");
		System.out.println("-------------------------------------------------");

		for (int i = 0; i < listEmployee.size(); i++) {

			Employee employee = listEmployee.get(i);

			System.out.println("sn：" + employee.getSn());
			System.out.println("name：" + employee.getName());
			System.out.println("password：" + employee.getPassword());
			System.out.println("status：" + employee.getStatus());
			System.out.println("positionId：" + employee.getPositionId());
			System.out.println("departmentId：" + employee.getDepartmentId());
			System.out.println("\n\n");

		}

	}

	/**
	 * 找寻员工
	 * 
	 * 
	 * 开发时间：2015-10-29 上午7:58:29
	 * 
	 * @author：moshco zhu
	 */
	public void findEmployeeBySN() {

		// 找寻员工
		Employee employee = employeeService.findEmployeeBySN("1");

		if (employee == null) {
			System.out.println("没有找到数据。");
			return;
		}

		System.out.println("查询结果如下：");
		System.out.println("-------------------------------------------------");
		System.out.println("sn：" + employee.getSn());
		System.out.println("name：" + employee.getName());
		System.out.println("password：" + employee.getPassword());
		System.out.println("status：" + employee.getStatus());
		System.out.println("positionId：" + employee.getPositionId());
		System.out.println("departmentId：" + employee.getDepartmentId());

	}

	/**
	 * 保存员工
	 * 
	 * 
	 * 开发时间：2015-10-29 上午7:56:18
	 * 
	 * @author：moshco zhu
	 * @param emp
	 */
	public void saveEmployee() {

		// 创建员工对象
		Employee employee = new Employee();
		employee.setPassword("1234");
		employee.setName("周礼");
		employee.setDepartmentId(1);
		employee.setStatus("1");
		employee.setPositionId(1);

		// 保存
		employeeService.saveEmployee(employee);

		System.out.println("员工信息保存成功：sn=" + employee.getSn());

	}

}
