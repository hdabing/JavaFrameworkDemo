package aop;

import java.io.Serializable;
import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
/**
 * 业务增强代码 Advice
 * TODO 
 * @author mxc  
 * @date 2016年6月12日 上午8:53:42    
 *
 */
public class BizLogger implements Serializable {

	/**
	 * 前置代码 参数 JoinPoint 可有可无，需要时加入即可
	 * TODO
	 * 2016年6月12日上午9:17:30 
	 * @author mxc
	 */
	public void before() {
		System.out.println("execute before！");
	}
	/**
	 * 后置代码  
	 * 
	 * TODO
	 * 2016年6月12日上午10:05:47 
	 * @author mxc  
	 *  @param jp
	 *  @param returnValue 这里名称必须和配置文件中的一致 must
	 *  @return
	 */
	public void afterReturning(JoinPoint jp, Object returnValue){
		System.out.println("execute AfterReturning method  returnValue:"+returnValue);
	}
	/**
	 *  异常增强 哪一个跟精准就执行哪一个方法
	 *  TODO
	 *  2016年6月12日上午10:33:44 
	 *  @author mxc  
	 *  @param jPoint
	 *  @param e  这里的名称必须和配置文件的一致 must
	 */
	public void afterThrowing(JoinPoint jPoint ,RuntimeException e  ) {
		System.out.println("catch runTimeException:"+e.getMessage());
	}
	/**
	 *  异常增强 哪一个跟精准就执行哪一个方法
	 *  TODO
	 *  2016年6月12日上午10:33:44 
	 *  @author mxc  
	 *  @param jPoint
	 *  @param e 这里的名称必须和配置文件的一致 must
	 */
	public void afterThrow(JoinPoint jPoint ,Exception e  ) {
		System.out.println("catch Exception:"+e.getMessage());
	}
	/**
	 * 环绕增强
	 * ProceedingJoinPoint 是 JoinPoint的子接口
	 * TODO
	 * 2016年6月12日上午10:42:26 
	 * @author mxc  
	 *  @param jp
	 * @throws Throwable 
	 */
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
	 * 最终增强 finally 无论前面发生了什么这个都会执行的
	 * 参数 JoinPoint 可有可无，需要时加入即可
	 * TODO
	 * 2016年6月12日上午10:50:08 
	 * @author mxc
	 */
	public void afterMethod() {
		System.out.println("execute afterMethod //finally");
	}
}
