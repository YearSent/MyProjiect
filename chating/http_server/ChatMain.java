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
		//储存建立的线程
		LinkedList<ServerThread> list=new LinkedList<>();
	try{
		//创建服务器
		ServerSocket server = new ServerSocket(port);
		System.out.println("服务器创建了!");
		//while(true)
		//{
			//启动服务器
			Socket s=server.accept();
			//有用户进入时开启一个新的线程
			ServerThread st = new ServerThread(s,list);
			st.start();
			System.out.println("已创建一个线程！");
		//}
	}catch(Exception e){
		e.printStackTrace();
	}
	}

}
