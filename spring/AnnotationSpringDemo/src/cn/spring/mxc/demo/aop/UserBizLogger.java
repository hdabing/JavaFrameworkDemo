package cn.spring.mxc.demo.aop;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Arrays;



import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
/**
 * 要增强的代码
 * TODO 
 * @author mxc  
 * @date 2016年6月10日 下午11:34:39    
 *
 */
@Aspect
public class UserBizLogger implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * TODO 前置增强代码
	 * 2016年6月10日下午11:42:03 
	 * @author mxc  
	 *  @param point 切入点
	 */
	@Before("execution(* cn.spring.mxc.demo.dao.*.*(..))")
	public void before(JoinPoint point){
		System.out.println("execute MethodBeforeAdvice");
		System.out.println("ClassName: "+point.getTarget()+";MethodName:"+point.getSignature().getName()+";arguments:"+Arrays.toString(point.getArgs()));
	}
	/**
	 * 后置增强代码
	 * TODO
	 * 2016年6月10日下午11:41:33 
	 * @author mxc  
	 *  @param point 切入点的对象
	 *  @param returnValue 返回值
	 *  @return
	 */
	@AfterReturning(value="execution(* cn.spring.mxc.demo.dao.*.*(..))",returning="returnValue")
	public void after(JoinPoint point ,Object returnValue){
		System.out.println("execute AfterReturning;");
		System.out.println("returnValue:"+returnValue);
		
	}
	/**
	 * 异常增强 
	 * TODO
	 * 2016年6月12日下午12:02:58 
	 * @author mxc  
	 *  @param jp
	 *  @param e 参数名 一致哦
	 */
	@AfterThrowing(value="execution(* cn.spring.mxc.demo.dao.*.*(..))",throwing="e")
	public void afterThrowing123(JoinPoint jp ,SQLException e ) {
		System.out.println("捕获 SQLException类型异常");
	}
	/**
	 * 异常增强 
	 * TODO
	 * 2016年6月12日下午12:02:58 
	 * @author mxc  
	 *  @param jp
	 *  @param e 参数名 一致哦
	 */
	@AfterThrowing(value="execution(* cn.spring.mxc.demo.dao.*.*(..))",throwing="e")
	public void afterThrowing(JoinPoint jp ,Exception e) {
		System.out.println("捕获 Exception类型异常：");
	}
	/**
	 * 环绕增强
	 * TODO 配置环绕增强之后，是先执行环绕增强代码，在执行 后置增强，在执行环绕增强代码
	 * 2016年6月12日下午12:05:01 
	 * @author mxc  
	 *  @param jp
	 * @throws Throwable 
	 */
	@Around(value="execution(* cn.spring.mxc.demo.dao.*.*(..))" )
	public Object aroundMethod(ProceedingJoinPoint jp ) throws Throwable {
		System.out.println("execute aroundMethod ");
		System.out.println("\t TargetObject："+jp.getTarget().getClass().getName());
		System.out.println("\t TargetMethod："+jp.getSignature().getName());
		System.out.println("\t TargetMethodArgs："+Arrays.toString(jp.getArgs()));
		
		//执行真实方法
		Integer result = (Integer) jp.proceed();
		
		System.out.println("\t TargetMethodResult："+result);
		return 2;
	}
	/**
	 * 最终增强，不论怎么样，都会执行的代码 类似如 finally块 
	 *  如果有后置增强，是先执行这个再执行后置增强
	 * TODO
	 * 2016年6月12日下午12:11:16 
	 * @author mxc  
	 *  @param jp
	 */
	@After("execution(* cn.spring.mxc.demo.dao.*.*(..))")
	public void afterFinally(JoinPoint jp ) {
		System.out.println("execute Finally");
	}
}
