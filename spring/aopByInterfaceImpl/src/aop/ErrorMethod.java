package aop;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.sql.SQLException;

import org.springframework.aop.ThrowsAdvice;
/**
 * 异常增强 实现 ThrowAdvice接口 只能捕获异常，不能拦截异常  
 * 只能有这三种方法签名，方法名称固定不变
 * TODO 
 * @author mxc  
 * @date 2016年6月12日 上午12:04:02    
 *
 */
public class ErrorMethod implements Serializable, ThrowsAdvice {

	/**
	 * 异常增强代码 捕获 exception类型的异常  多个方法哪个精准执行哪个方法
	 * TODO
	 * 2016年6月12日上午12:05:31 
	 * @author mxc  
	 *  @param method
	 *  @param args
	 *  @param target
	 *  @param exception
	 */
	public void afterThrowing(Method method,Object[] args ,Object target,Exception exception){
		System.out.println("exception");
	}
	/**
	 * 捕获 sqlexception类型的异常
	 * TODO
	 * 2016年6月12日上午12:06:14 
	 * @author mxc  
	 *  @param method
	 *  @param args
	 *  @param target
	 *  @param sqlException
	 */
	public void afterThrowing(Method method,Object[] args ,Object target,SQLException sqlException){
		System.out.println("sqlException");
	}
	/**
	 * 捕获 runTimeException类型的代码
	 * TODO
	 * 2016年6月12日上午12:06:55 
	 * @author mxc  
	 *  @param exception
	 */
	public void afterThrowing(RuntimeException  exception){
		System.out.println("runtimeException");
	}
	
}
