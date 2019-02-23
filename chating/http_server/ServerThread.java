package liao_tianV3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.LinkedList;

public class ServerThread extends Thread{
	//�ж��Ƿ��¼�ɹ�
	boolean yes;
	//���潨�����߳�
	LinkedList<ServerThread> list=null;
	private Socket s;
	Users u;
	public  ServerThread(Socket s,LinkedList<ServerThread> list) {
		this.s=s;
		this.list=list;
		Users u = new Users(s,yes);
		this.u=u;
		System.out.println("�û�������!");
	}
	@Override
	public void run() {
		System.out.println("������������!");
		
		try {
				OutputStream output = s.getOutputStream();
				InputStream input=s.getInputStream();
				BufferedReader bfr = new BufferedReader(new InputStreamReader(input));
				//��ȡ������ַ�
				String say=bfr.readLine();
				Message m = new Message();
				System.out.println("1");
				while(true)
				{System.out.println("2");
					
					System.out.println(say);
					//�жϵ�¼�Ƿ�ɹ�
					if(m.getType(say)==Message.TYPE_LOGIN)
					{
						String username=m.getReceiver(say);
						String userpsw=m.getSender(say);
						System.out.println(username+userpsw);
//						if(userpsw.equals(u.hash.get(username)))
//						{
							output.write("��ӭ����������\r\n".getBytes());
						output.flush();
							System.out.println("��¼�ɹ�!");
							list.add(this);
						//}
					}
					//�ж���Ⱥ����Ϣ
					else if(m.getType(say)==Message.TYPE_GROUP)
					{
						System.out.println(say);
						say=m.getSender(say)+":"+say+"\r\n";
						for(int i=0;i<list.size();i++)
						{
							//��ÿ���û��������
							list.get(i).sendout(say);
						}
					}
				}
//				while(!say.equals("bye"))
//				{
//					System.out.println("�ͻ���˵��"+say);
//	//				this.sendout(say);
//					//������
//					say=u.name+":"+say+"\r\n";
//					for(int i=0;i<list.size();i++)
//					{
//						//��ÿ���û��������
//						list.get(i).sendout(say);
//					}
//					say=readString(input);
//				}
//				output.write("ллʹ��".getBytes());
//				output.flush();
//				s.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}
	
	//�����Ϣ
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
	//��ȡ�û����������
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
