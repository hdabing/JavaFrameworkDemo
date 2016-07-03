/**
 * 
 */
package cn.jbit.demo;

import java.io.Serializable;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.jbit.demo.biz.EmployeeBiz;

/**
 * @author moshco
 * 
 */
public class EmployeeTest implements Serializable {

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
		EmployeeBiz biz = (EmployeeBiz) context.getBean("employeeBiz");

		// 查询
		biz.queryEmployee();

		// 找寻
		biz.findEmployeeBySN();

		// 添加
		biz.saveEmployee();

	}
}
