package cn.jbit.ex.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.jbit.ex.biz.ExerciseBiz;

/**     
 * @author mxc  
 * @date 2016年7月1日 下午3:36:22          
*/
public class Test {

	/**   
	 *  
	 * @author mxc  
	 * @Date 2016年7月1日下午3:36:22
	 *  @param args        
	*/
	public static void main(String[] args) {

		//构建spring容器
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//获取业务类
		ExerciseBiz exerciseBiz = (ExerciseBiz) context.getBean("exerciseBiz");
		
		//查询报销单
		//exerciseBiz.queryClaimVoucher();
		
		//增加报销单
		//exerciseBiz.addClaimVoucher();
		
		//查询一个报销单
		 exerciseBiz.findClaimVoucher();
		
	}

}
