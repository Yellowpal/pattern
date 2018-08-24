package pattern.singleton;

public class SimpleSingleton {
	
	//私有
	private static SimpleSingleton simpleSingleton;
	//私有
	private SimpleSingleton(){}
	
	public static SimpleSingleton getInstance(){
		if(simpleSingleton == null){
			simpleSingleton = new SimpleSingleton();
		}
		
		return simpleSingleton;
	}
}
