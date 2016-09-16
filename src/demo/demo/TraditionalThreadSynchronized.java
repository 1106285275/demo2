package demo;

public class TraditionalThreadSynchronized {

	public static void main(String[] args){
		final Outputer outputer = new Outputer();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				outputer.out("lmloo");
			}
		}).start();
		
		outputer.out("hjj");
	}
	
}

class Outputer{
	public synchronized void out(String name){
		for(int i=0;i<name.length();i++){
			System.out.print(name.charAt(i));
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}