package UDPV1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Receive {
	//此函数用来新建一个服务器
	public void receive()
	{
		try {
			DatagramSocket socket = new DatagramSocket(9999);//创建一个服务器，端口为8888
			//新建一个包，用来装接收的消息，括号内为此包的容量，即能装下的字节数
			DatagramPacket packet = new DatagramPacket(new  byte[1024],1024);
			//准备接收消息，并将消息存入包内，若接收不到消息服务器会一直开放，程序不会向下运行
			//若想接受收多条消息可将此代码放入循环中
			socket.receive(packet);
			//打印接收的数据
			String msg = new String(packet.getData()).trim();
			System.out.println(msg);
			System.out.println(new String(packet.getData()).trim());
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		Receive r = new Receive();
		r.receive();
	}

}
