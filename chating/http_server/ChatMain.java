package liao_tianV3;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;


public class ChatMain {
	
	public static void main(String[] args)
	{
		ChatMain chat = new ChatMain();
		chat.setup(8888);
	}
	
	public void setup(int port){
		//���潨�����߳�
		LinkedList<ServerThread> list=new LinkedList<>();
	try{
		//����������
		ServerSocket server = new ServerSocket(port);
		System.out.println("������������!");
		//while(true)
		//{
			//����������
			Socket s=server.accept();
			//���û�����ʱ����һ���µ��߳�
			ServerThread st = new ServerThread(s,list);
			st.start();
			System.out.println("�Ѵ���һ���̣߳�");
		//}
	}catch(Exception e){
		e.printStackTrace();
	}
	}

}
