package com.poc.dynamicproxy;

public class ProxyTestImpl implements ProxyTest {
	public void ping() throws ApplicationException {
		System.out.println("TestImpl...ping()");

	}
}
