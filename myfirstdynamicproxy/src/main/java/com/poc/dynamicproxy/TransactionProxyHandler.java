package com.poc.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TransactionProxyHandler implements InvocationHandler {
	
	protected Object delegate;

	public TransactionProxyHandler(Object delegate) {
		this.delegate = delegate;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("TransactionProxyHandler....invoke....inside the method");
		return null;
	}
	

}
