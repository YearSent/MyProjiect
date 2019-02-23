//接收服务器信息
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

	// 构造方法传递client
	public ReadThread(Socket client) {
		super();
		this.client = client;
	}

	// 线程：获取服务器信息
	public void run() {
		while (true) {
			try {
				ins = client.getInputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(ins));
				msg_received = br.readLine();
				// 更新聊天文本域信息
				jta_chatRecord.append(msg_received + "\r\n");
				// 实现文本域更新信息时自动滚动到最后一行
				jta_chatRecord.setCaretPosition(jta_chatRecord.getText().length());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
