package pattern.singleton;

public class SynchronizedSingleton {
	
	private volatile static SynchronizedSingleton synchronizedSingleton;
	
	private SynchronizedSingleton(){
		
	}
	
	public static SynchronizedSingleton getInstance(){
		if(synchronizedSingleton == null){
			synchronized (SynchronizedSingleton.class) {
				if(synchronizedSingleton == null){
					synchronizedSingleton = new SynchronizedSingleton();
				}
			}
		}
		
		return synchronizedSingleton;
	}
	
}
