package pattern.proxy;

public class Test {
	public static void main(String[] args) {
		
		Out sysOut = new SysOut();
		
		StaticProxy staticProxy = new StaticProxy(sysOut);
		
		staticProxy.close();
		
		DynamicProxy dynamicProxy = new DynamicProxy(sysOut);
//		Out sysOutProxy = (Out) Proxy.newProxyInstance(dynamicProxy.getClass().getClassLoader(),sysOut.getClass().getInterfaces(),dynamicProxy);
		Out sysOutProxy = (Out) dynamicProxy.getProxy();
		
		sysOutProxy.close();
	}
}
