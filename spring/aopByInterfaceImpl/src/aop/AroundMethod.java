package aop;

import java.io.Serializable;
import java.util.Arrays;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
/**
 * 环绕增强 实现 MethodIntegerceptor
 * TODO 
 * @author mxc  
 * @date 2016年6月12日 上午8:26:51    
 *
 */
public class AroundMethod implements Serializable, MethodInterceptor {

	/**
	 * 如果配置后置增强或者前置增强 ，执行顺序：前置，环绕，后置
	 * @author mxc
	 * 2016年6月12日下午12:23:42   
	 * @param target
	 * @return
	 * @throws Throwable
	 */
	@Override
	public Object invoke(MethodInvocation target) throws Throwable {
		System.err.println("开始执行环绕增强代码");
		System.out.println("\t TargetObjectName:"+target.getClass().getName());
		System.out.println("\t TargetMethodName:"+target.getMethod().getName());
		System.out.println("\t TargetMethodArgs:"+Arrays.toString(target.getArguments()));
		
		//执行 真实对象的代码 并接受返回值
		Integer result= (Integer) target.proceed();
		System.out.println("\t TargetMethodReturnResult:"+result);
		System.err.println("环绕增强代码结束！");
		return result;
	}

}
