package demo;

import org.junit.Test;

//子线程循环10次，主线程一百次，然后子线程循环10次，主线程一百次..反复操作，总共50次
public class test3 {
	
	@Test
	public void threadDemo(){
		final Business business = new Business();
		new Thread(new Runnable() {
			
			public void run() {
				for(int i=0;i<50;i++)
					business.sub(i);
			}
		}).start();
		
		for(int i=0;i<50;i++)
			business.main(i);
	}

}
class Business{
	
	boolean flag = true;//子线程运行锁
	
	public synchronized void sub(int i){
		if(!flag){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for(int j=0;j<10;j++){
			System.out.println("....sub thread..."+j+"....of times..."+i);
		}
		flag = false;
		this.notify();
	}
	public synchronized void main(int i){
		if(flag){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for(int j=0;j<100;j++){
			System.out.println("....main thread..."+j+"....of times..."+i);
		}
		flag = true;
		this.notify();
	}
}