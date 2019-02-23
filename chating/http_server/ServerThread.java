package liao_tianV3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.LinkedList;

public class ServerThread extends Thread{
	//判断是否登录成功
	boolean yes;
	//储存建立的线程
	LinkedList<ServerThread> list=null;
	private Socket s;
	Users u;
	public  ServerThread(Socket s,LinkedList<ServerThread> list) {
		this.s=s;
		this.list=list;
		Users u = new Users(s,yes);
		this.u=u;
		System.out.println("用户进入了!");
	}
	@Override
	public void run() {
		System.out.println("服务器启动了!");
		
		try {
				OutputStream output = s.getOutputStream();
				InputStream input=s.getInputStream();
				BufferedReader bfr = new BufferedReader(new InputStreamReader(input));
				//读取输入的字符
				String say=bfr.readLine();
				Message m = new Message();
				System.out.println("1");
				while(true)
				{System.out.println("2");
					
					System.out.println(say);
					//判断登录是否成功
					if(m.getType(say)==Message.TYPE_LOGIN)
					{
						String username=m.getReceiver(say);
						String userpsw=m.getSender(say);
						System.out.println(username+userpsw);
//						if(userpsw.equals(u.hash.get(username)))
//						{
							output.write("欢迎来到服务器\r\n".getBytes());
						output.flush();
							System.out.println("登录成功!");
							list.add(this);
						//}
					}
					//判断是群聊消息
					else if(m.getType(say)==Message.TYPE_GROUP)
					{
						System.out.println(say);
						say=m.getSender(say)+":"+say+"\r\n";
						for(int i=0;i<list.size();i++)
						{
							//向每个用户发送语句
							list.get(i).sendout(say);
						}
					}
				}
//				while(!say.equals("bye"))
//				{
//					System.out.println("客户机说："+say);
//	//				this.sendout(say);
//					//输出语句
//					say=u.name+":"+say+"\r\n";
//					for(int i=0;i<list.size();i++)
//					{
//						//向每个用户发送语句
//						list.get(i).sendout(say);
//					}
//					say=readString(input);
//				}
//				output.write("谢谢使用".getBytes());
//				output.flush();
//				s.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}
	
	//输出信息
	public void sendout(String msg)
	{
		try {	
				OutputStream output = s.getOutputStream();
				
				output.write(msg.getBytes());
				output.flush();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	//获取用户输入的数据
	private String readString(InputStream input)
	{
		StringBuffer sb= new StringBuffer();
		char c=0;
		while(c!=13)
		{
			int i;
			try {
				i = input.read();
				c=(char)i;
				sb.append(c);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		String say=sb.toString().trim();
		return say;
	}

}
