package UDPV1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Receive {
	//�˺��������½�һ��������
	public void receive()
	{
		try {
			DatagramSocket socket = new DatagramSocket(9999);//����һ�����������˿�Ϊ8888
			//�½�һ����������װ���յ���Ϣ��������Ϊ�˰�������������װ�µ��ֽ���
			DatagramPacket packet = new DatagramPacket(new  byte[1024],1024);
			//׼��������Ϣ��������Ϣ������ڣ������ղ�����Ϣ��������һֱ���ţ����򲻻���������
			//��������ն�����Ϣ�ɽ��˴������ѭ����
			socket.receive(packet);
			//��ӡ���յ�����
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
