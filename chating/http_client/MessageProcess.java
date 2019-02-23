package ke_hu_duanV1;

import java.io.IOException;
import java.io.OutputStream;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MessageProcess {
	public static final MessageProcess msgPro = new MessageProcess();
	private Boolean flag = true;
	private String sender;

	private MessageProcess() {
	}

	// 登录信息处理
	public Boolean loginProcess(JTextField jta_name, JTextField jta_pwd) {
		sender=jta_name.getText();
		String msg = "Type_login".concat("*").concat(sender).concat("@").concat(jta_pwd.getText()).concat("$").concat("/r/n");
		sendMsg(msg);
		System.out.println("loginmsg:"+msg);
		return flag;
	}

	// 发送信息处理  
	public void msgProcess(String type,String user, JTextArea jta2) {
		if (type.equals("single")) {
			String msg_send = "Type_single".concat("*").concat(user).concat("@").concat(sender).concat("$").concat(jta2.getText())
					.concat("/r/n");
			jta2.setText("");
			jta2.requestFocus();
			sendMsg(msg_send);
		}
		if (type.equals("All")) {
			String msg_send = "Type_group".concat("*").concat(user).concat("@").concat(sender).concat("$").concat(jta2.getText())
					.concat("/r/n");
			jta2.setText("");
			jta2.requestFocus();
			sendMsg(msg_send);
		}
	}

	// 发送消息
	public void sendMsg(String msg) {
		try {
			 OutputStream out=ChatClient.conn.getClient().getOutputStream();
			out.write(msg.getBytes());
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
