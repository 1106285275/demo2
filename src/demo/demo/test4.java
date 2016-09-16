package demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.junit.Test;

public class test4 {
	
	private Opreation opreation = new Opreation();
	Map map = new HashMap<Thread,Integer>();
	Integer data;
	
	@Test
	public void test(){
		for(int i=0;i<2;i++){
			new Thread(new Runnable() {
				@Override
				public void run() {
					data = new Random().nextInt();
					opreation.put(map,data);
					opreation.get(map);
				}
			}).start();
			
			
		}
		
	}

	
}
class Opreation{
	public  void put(Map map,Integer data){
		map.put(Thread.currentThread(), data);
		System.out.println(Thread.currentThread().getName()+"....has put..."+data);
	}
	public  void get(Map map){
		Integer data = (Integer) map.get(Thread.currentThread());
		System.out.println(Thread.currentThread().getName()+"....has get..."+data);
		System.out.println(Thread.currentThread().getName()+"....has mmmm get..."+data);
	}
}
