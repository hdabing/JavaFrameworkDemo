package cn.jbit.demo.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.jbit.demo.biz.EmployeeBiz;
import cn.jbit.dome.entity.Employee;

/**
 * 测试类
 * @author mxc  
 * @date 2016年6月30日 下午10:16:58
 */
public class Test {

	public static void main(String[] args) {
		findEmployee();
	}
	
	/**
	 * 查询Employee
	 *  
	 * @author mxc  
	 * @Date 2016年6月30日下午10:17:26
	 */
	public static void findEmployee(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		EmployeeBiz biz = (EmployeeBiz) context.getBean("employeeBiz");
		
		Employee employee= biz.findEmployee(1);
		System.out.println("员工姓名："+employee.getTrueName());
	}

}
