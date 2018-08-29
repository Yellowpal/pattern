package pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理一般处理多个相同的操作
 * @Time 2018年8月27日
 * @Version 1.0
 */
public class DynamicProxy implements InvocationHandler{
	
	private Object obj;
	
	public DynamicProxy(Object obj) {
		this.obj = obj;
	}
	
	public void before(){
		System.out.println("before");
	}
	
	public void after(){
		System.out.println("after");
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if(method.getName().equals("close")){
			before();
		}
		
		Object object = method.invoke(obj, args);
		
		if(method.getName().equals("close")){
			after();
		}
		
		return object;
	}
	
	public Object getProxy(){
		return Proxy.newProxyInstance(this.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
	}
	
}
