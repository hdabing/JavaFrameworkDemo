package aop;

import java.io.Serializable;
import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

/**
 * 后置增强代码 实现 AfterReturningAdvice接口
 * TODO 
 * @author mxc  
 * @date 2016年6月11日 下午11:57:38    
 *
 */
public class AfterReturn implements Serializable, AfterReturningAdvice {

	/**
	 * 后置增强代码
	 * @author mxc
	 * 2016年6月11日下午11:57:26   
	 * @param returnValue
	 * @param method
	 * @param args
	 * @param target
	 * @throws Throwable
	 */
	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("execute AfterReturningMethod ,returnValue:"+returnValue);
	}

}
