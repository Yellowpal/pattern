package pattern.proxy;

/**
 * 静态代理
 * @Time 2018年8月27日
 * @Version 1.0
 */
public class StaticProxy implements Out{
	
	private Out sysOut;
	
	public StaticProxy(Out sysOut){
		this.sysOut = sysOut;
	}
	
	@Override
	public void close(){
		sysOut.close();
	}
}
