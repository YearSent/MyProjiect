package liao_tianV3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.LinkedList;

public class Users {
	 String name;
	private String password;
	private Socket s;
	boolean yes;
	static HashMap<String, String> hash = new HashMap<>();
	public Users(Socket s,boolean yes)
	{
		this.s=s;
		this.yes=yes;
	}
	static{
		
		String key,value;
		for(int i=1;i<11;i++)
		{
			key="user"+Integer.toString(i);
			value="psw"+Integer.toString(i);
			hash.put(key, value);
		}
	}
//	public void setUsers()
//	{
//		try {
//			OutputStream output = s.getOutputStream();
//			InputStream input=s.getInputStream();
//			output.write("�������û���:".getBytes());
//			output.flush();
//			name =readString(input);
////			System.out.println("�ͻ���˵��"+say);
//			output.write("\r\n����������:".getBytes());
//			output.flush();
//			password=readString(input);
//			if(password.equals(hash.get(name)))
//			{
//				output.write("\r\n��¼�ɹ�!\r\n".getBytes());
//				output.flush();
//				yes=true;
//			}
//			else
//			{
//				output.write("\r\n��¼ʧ�ܣ������û���������!\r\n".getBytes());
//				output.flush();
//				yes=false;
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
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
