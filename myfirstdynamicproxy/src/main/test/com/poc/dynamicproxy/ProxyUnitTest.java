package com.poc.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import org.junit.Test;

public class ProxyUnitTest {


	@Test
	public void testLoggingHandler() {
		try {

			// Create an instance of  TestImpl
			ProxyTest t = new ProxyTestImpl();

			// Create InvokeHandler
			InvocationHandler handler = new LoggingProxyHandler(t);

			// Create Proxy
			ProxyTest proxy = (ProxyTest) Proxy.newProxyInstance(
					//t.getClass().getClassLoader(),
					Thread.currentThread().getContextClassLoader(),
					t.getClass().getInterfaces(),
					handler);

			// Test real class
			//System.out.println("Testing the real class...");
			//t.ping();

			// Test Proxy class
			System.out.println("Testing the proxy class...");
			proxy.ping();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
    public void testDecoratedProxies() {
        try {
        	System.out.println("testDecoratedProxies....inside the method...");
            /// Create an instance of  TestImpl
        	ProxyTest t = new ProxyTestImpl();
            
            // Create Transaction Handler
            InvocationHandler txnHandler = new TransactionProxyHandler(t);
      
            // Create Txn Proxy 
            ProxyTest txnProxy =
                (ProxyTest) Proxy.newProxyInstance(
                    t.getClass().getClassLoader(),
                    t.getClass().getInterfaces(),
                    txnHandler);
                    
             // Create Log Handler and wrap around Transaction proxy
            InvocationHandler loggingHandler = new LoggingProxyHandler(txnProxy);
 
            // Create Proxy with 2 levels of indirection
            ProxyTest proxy =
                (ProxyTest) Proxy.newProxyInstance(
                    t.getClass().getClassLoader(),
                    t.getClass().getInterfaces(),
                    loggingHandler);
                    
            // Test Proxy class 
            proxy.ping();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
	
}
