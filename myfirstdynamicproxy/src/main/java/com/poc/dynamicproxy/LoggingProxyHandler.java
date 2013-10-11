package com.poc.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class LoggingProxyHandler implements InvocationHandler {

	protected Object delegate;

	public LoggingProxyHandler(Object delegate) {
		this.delegate = delegate;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		try {

			System.out.println(	"LoggingProxyHandler...Calling method " + method + " at " + System.currentTimeMillis());
			
			Object result = method.invoke(delegate, args);
			return result;
			
		} catch (InvocationTargetException e) {
			throw e.getTargetException();
		} finally {

			System.out.println("Called method(" + method + " at " + System.currentTimeMillis());
		}
	}

}
