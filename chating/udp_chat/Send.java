package UDPV1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Send {
	//此函数用来创建一个服务器发送消息
	public void send()
	{
		try {
			//此字符串为要发送的消息
			String msg = new String("Hello World!");
			//创建一个服务器
			DatagramSocket socket = new DatagramSocket(null);
			//将消息放入包内，并指定目标IP和端口
			DatagramPacket packet = new DatagramPacket(msg.getBytes(), msg.length(), InetAddress.getByName("10.10.9.108"),8888);
			try {
				//此函数将消息发送出去
				socket.send(packet);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SocketException | UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		Send s = new Send();
		s.send();
	}

}
