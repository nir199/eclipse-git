package integerCache;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
	
	public static void main(String[] args) throws IOException {
		DatagramSocket ds = new DatagramSocket(5678);
		byte[] buf = new byte[1024];
		DatagramPacket dp = new DatagramPacket(buf, buf.length);
		try {
			while (true) {
				ds.receive(dp);
				ByteArrayInputStream bis = new ByteArrayInputStream(dp.getData());
				DataInputStream dis = new DataInputStream(bis);
				System.out.println(dis.readLong());
			}
		}catch (Exception e) {
			e.printStackTrace();
			ds.close();
		}
	}

}
