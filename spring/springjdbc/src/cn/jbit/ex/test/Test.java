package cn.jbit.ex.test;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.SynchronousQueue;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.jbit.ex.biz.ExerciseBiz;
import cn.jbit.ex.entity.Employee;
/**
 * 测试类
 * @author mxc  
 * @date 2016年6月30日 下午4:26:15
 */
public class Test implements Serializable {

	public static void main(String[] args) {
		
		//查询员工
	//	findEmployee();
		
		//查询员工
		//queryEmployee();
		
		//查询员工通过存储过程
		//queryEmployeeByProcedure();
		
		//查询全部员工
		//findAll();
		
		//修改员工信息
		updateEmployee();
	}

	/**
	 * 修改员工信息
	 *  
	 * @author mxc  
	 * @Date 2016年7月2日下午5:14:15
	 */
	private static void updateEmployee() {
		ApplicationContext context = new  ClassPathXmlApplicationContext("applicationContext.xml");
		
		//获取Biz 对象
		ExerciseBiz exerciseBiz = (ExerciseBiz) context.getBean("exerciseBiz");
		
		Employee employee=  exerciseBiz.findEmployee(1);
		System.out.println("原来的年龄："+employee.getAge());
		employee.setAge(50);
		
	 boolean result =	exerciseBiz.updateEmployee(employee);
	 if (result) {
		System.out.println("update success");
	}else {
		System.out.println("update fail!");
	}
		employee= exerciseBiz.findEmployee(1);
		System.out.println("修改后的年龄："+employee.getAge());
	}

	/**
	 * 查询全部员工
	 *  
	 * @author mxc  
	 * @Date 2016年7月2日下午4:51:25
	 */
	private static void findAll() {
		
		ApplicationContext context = new  ClassPathXmlApplicationContext("applicationContext.xml");
		
		//获取Biz 对象
		ExerciseBiz exerciseBiz = (ExerciseBiz) context.getBean("exerciseBiz");
		
		List<Employee> employees = exerciseBiz.findAllEmployee();
		
		for (Employee employee : employees) {
			System.out.println(employee.getTrueName());
		}
	}

	/**
	 * 查询员工通过存储过程
	 *  
	 * @author mxc  
	 * @Date 2016年7月1日上午10:10:00
	 */
	private static void queryEmployeeByProcedure() {
		ApplicationContext context = new  ClassPathXmlApplicationContext("applicationContext.xml");
		
		//获取Biz 对象
		ExerciseBiz exerciseBiz = (ExerciseBiz) context.getBean("exerciseBiz");
		
		//查询员工  技术部的 年龄在 20-30之间
	 String employees=	exerciseBiz.findEmployeeByProcedure("技术部",20,30);
	 
	 System.out.print("员工姓名:");
	
		System.out.println(employees);
	 
	}

	/**
	 * 查询员工
	 *  
	 * @author mxc  
	 * @Date 2016年7月1日上午8:40:27
	 */
	private static void queryEmployee() {
		ApplicationContext context = new  ClassPathXmlApplicationContext("applicationContext.xml");
		
		//获取Biz 对象
		ExerciseBiz exerciseBiz = (ExerciseBiz) context.getBean("exerciseBiz");
		
		//查询员工  技术部的 年龄在 20-30之间
	 List<Employee> employees=	exerciseBiz.queryEmployee("技术部",20,30);
	 
	 System.out.println("员工姓名\t年龄\t部门");
	 for (Employee employee : employees) {
		System.out.println(employee.getTrueName()+"\t"+employee.getAge()+"\t"+employee.getDepartment());
	 }
		
	}

	/**
	 * 查询员工
	 *  
	 * @author mxc  
	 * @Date 2016年6月30日下午4:27:06
	 */
	private static void findEmployee() {
		//构建spring容器
		ApplicationContext context = new  ClassPathXmlApplicationContext("applicationContext.xml");
		
		//获取Biz 对象
		ExerciseBiz exerciseBiz = (ExerciseBiz) context.getBean("exerciseBiz");
		
		//查询员工
		Employee employee = exerciseBiz.findEmployee(1);
		
		System.out.println("员工姓名："+employee.getTrueName());
	}
	
	

}
