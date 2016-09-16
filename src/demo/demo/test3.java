package demo;

import org.junit.Test;

//���߳�ѭ��10�Σ����߳�һ�ٴΣ�Ȼ�����߳�ѭ��10�Σ����߳�һ�ٴ�..�����������ܹ�50��
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
	
	boolean flag = true;//���߳�������
	
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