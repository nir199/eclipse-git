package name;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Name {
	public volatile int i = 0;
	public void increase() {
		i++;
	}
	public static void main(String args[]){
//		InetAddress myId=null;
//		try {
//			myId=InetAddress.getByName("www.baidu.com");
//		} catch (UnknownHostException e) {
//			// TODO: handle exception
//		}
//		System.out.println(myId);
		//Test1.printa(new String[]{"a"});
		final Name name = new Name();
		for(int i = 0; i < 10; i++) {
			new Thread(){
				@Override
				public void run() {
					for(int j = 0; j < 1000; j++) {
						name.increase();
					}
				}
			}.start();
		}
		while(Thread.activeCount() > 1) {
			Thread.yield();
		}
		System.out.println(name.i);
	}
	
}
