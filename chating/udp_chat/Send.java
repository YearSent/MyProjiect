package UDPV1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Send {
	//�˺�����������һ��������������Ϣ
	public void send()
	{
		try {
			//���ַ���ΪҪ���͵���Ϣ
			String msg = new String("Hello World!");
			//����һ��������
			DatagramSocket socket = new DatagramSocket(null);
			//����Ϣ������ڣ���ָ��Ŀ��IP�Ͷ˿�
			DatagramPacket packet = new DatagramPacket(msg.getBytes(), msg.length(), InetAddress.getByName("10.10.9.108"),8888);
			try {
				//�˺�������Ϣ���ͳ�ȥ
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
