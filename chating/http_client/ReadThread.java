//���շ�������Ϣ
package ke_hu_duanV1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import javax.swing.JTextArea;

public class ReadThread implements Runnable {

	private InputStream ins;
	private Socket client;
	private String msg_received;
	private JTextArea jta_chatRecord = ChatUI.cUI.getJta_chatRecord();

	// ���췽������client
	public ReadThread(Socket client) {
		super();
		this.client = client;
	}

	// �̣߳���ȡ��������Ϣ
	public void run() {
		while (true) {
			try {
				ins = client.getInputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(ins));
				msg_received = br.readLine();
				// ���������ı�����Ϣ
				jta_chatRecord.append(msg_received + "\r\n");
				// ʵ���ı��������Ϣʱ�Զ����������һ��
				jta_chatRecord.setCaretPosition(jta_chatRecord.getText().length());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
