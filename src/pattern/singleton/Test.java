package pattern.singleton;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
	
	
	public static void main(String[] args) throws InterruptedException {
//		simpleTest();
		syncTest();
		
	}
	
	public static void simpleTest(){
		final Set<String> instanceSet = Collections.synchronizedSet(new HashSet<String>());
		int total = 1000;
		ExecutorService executorService = Executors.newCachedThreadPool();
		
		for(int i=0;i<total;i++){
			executorService.execute(new Runnable() {
				
				@Override
				public void run() {
						
					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					instanceSet.add(SimpleSingleton.getInstance().toString());
							
				}
			});
		}
		
		executorService.shutdown();
		for(String s : instanceSet){
			System.out.println(s);
		}
		
	}
	
	public static void syncTest(){
		final Set<String> instanceSet = Collections.synchronizedSet(new HashSet<String>());
		int total = 1000;
		ExecutorService executorService = Executors.newCachedThreadPool();
		
		for(int i=0;i<total;i++){
			executorService.execute(new Runnable() {
				
				@Override
				public void run() {
						
					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					instanceSet.add(SynchronizedSingleton.getInstance().toString());
							
				}
			});
		}
		
		executorService.shutdown();
		for(String s : instanceSet){
			System.out.println(s);
		}
		
	}
}
