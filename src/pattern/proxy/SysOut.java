package pattern.proxy;

public class SysOut implements Out{
	
	public SysOut(){
		
	}
	
	@Override
	public void close(){
		System.out.println("close");
	}
}
