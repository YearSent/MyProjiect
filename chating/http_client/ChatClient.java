package ke_hu_duanV1;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import javax.swing.JOptionPane;

public class ChatClient {
	private static int port = 8888;
	private static InetAddress address;
	private static Socket client;
	private static Boolean conn2Server;
	public static final ChatClient conn = new ChatClient();

	// ˽�л����췽��
	private ChatClient() {
	}

	// ��ȡclient����
	public Socket getClient() {
		return client;
	}

	// ������
	public static void main(String[] args) throws IOException {
		// ���ò���ȡ��������ַ
		address = InetAddress.getByName("192.168.31.17");
		// �ͻ������ӷ�����
		conn2Server(address, port);
	}

	// ���ӷ�����
	private static void conn2Server(InetAddress address, int port) {
		try {
			client = new Socket(address, port);
			conn2Server = true;
			showUI(conn2Server);
			return;
		} catch (Exception e) {
		}
		conn2Server = false;
		showUI(conn2Server);
		return;
	}

	// �ж��Ƿ�չʾ��¼����
	private static void showUI(Boolean conn2Server) {
		if (conn2Server) {
			// �򿪵�¼����
			LoginUI.lUI.init();
		} else {
			JOptionPane.showMessageDialog(new JOptionPane(), "���ӷ�����ʧ��");
		}
	}
}
