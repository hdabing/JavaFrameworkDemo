package aop;

import java.io.Serializable;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;

public class MethodBeforeAdvice implements Serializable, org.springframework.aop.MethodBeforeAdvice {

	protected static final Logger logger  = Logger.getLogger(MethodBeforeAdvice.class);
	/**
	 * 前置 织入代码 
	 * @author mxc
	 * 2016年6月11日下午11:55:33   
	 * @param method 目标方法
	 * @param arguments 目标方法参数
	 * @param target 目标对象
	 * @throws Throwable 异常
	 */
	@Override
	public void before(Method method, Object[] arguments, Object target) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("execute MethodBeforeAddvice :");
	}

}
