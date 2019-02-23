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

	// 私有化构造方法
	private ChatClient() {
	}

	// 获取client方法
	public Socket getClient() {
		return client;
	}

	// 主函数
	public static void main(String[] args) throws IOException {
		// 设置并获取服务器地址
		address = InetAddress.getByName("192.168.31.17");
		// 客户端连接服务器
		conn2Server(address, port);
	}

	// 连接服务器
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

	// 判断是否展示登录界面
	private static void showUI(Boolean conn2Server) {
		if (conn2Server) {
			// 打开登录界面
			LoginUI.lUI.init();
		} else {
			JOptionPane.showMessageDialog(new JOptionPane(), "连接服务器失败");
		}
	}
}
