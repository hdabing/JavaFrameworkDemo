/**
 * 
 */
package cn.jbit.demo;

import java.io.Serializable;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.jbit.demo.dao.EmployeeDao;
import cn.jbit.demo.entity.Employee;

/**
 * @author moshco
 * 
 */
public class EmployeeTest implements Serializable {

	/**
	 * 查询所有员工
	 * 
	 * 
	 * 开发时间：2015-10-29 上午10:23:47
	 * 
	 * @author：moshco zhu
	 * @param template
	 */
	public static void queryEmployee(SqlSessionTemplate template) {

		// 获取Dao的代理对象
		EmployeeDao employeeDao = template.getMapper(EmployeeDao.class);

		// 查询所有员工
		List<Employee> listEmployee = employeeDao.queryEmployee();

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
	 * 开发时间：2015-10-29 上午10:26:18
	 * 
	 * @author：moshco zhu
	 * @param template
	 */
	public static void findEmployeeBySN(SqlSessionTemplate template) {

		// 获取Dao的代理对象
		EmployeeDao employeeDao = template.getMapper(EmployeeDao.class);

		// 找寻员工
		Employee employee = employeeDao.findEmployeeBySN("1");

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
	public static void saveEmployee(SqlSessionTemplate template) {

		// 获取Dao的代理对象
		EmployeeDao employeeDao = template.getMapper(EmployeeDao.class);

		// 创建员工对象
		Employee employee = new Employee();
		employee.setPassword("1234");
		employee.setName("周礼");
		employee.setDepartmentId(1);
		employee.setStatus("1");
		employee.setPositionId(1);

		// 保存
		employeeDao.saveEmployee(employee);

		System.out.println("员工信息保存成功：sn=" + employee.getSn());

	}

	/**
	 * 入口函数
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// 创建Spring容器
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		// 读取biz对象
		SqlSessionTemplate template = (SqlSessionTemplate) context
				.getBean("sqlSessionTemplate");

		// 查询所有员工
		// queryEmployee(template);

		// 找寻员工
		// findEmployeeBySN(template);

		// 保存员工
		saveEmployee(template);

	}

}
