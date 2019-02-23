package ke_hu_duanV1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class ChatUI extends JFrame {

	private static final long serialVersionUID = -497741081668611932L;
	private JTextArea jta_chatRecord, jta_chat;
	private String type = "group";
	private String user = "All";
	

	public static final ChatUI cUI = new ChatUI();

	private ChatUI() {
	};

	public void init() {
		this.setTitle("聊天室");
		this.setSize(600, 420);
		this.setDefaultCloseOperation(3);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(new BorderLayout());

		// 聊天框
		jta_chatRecord = new JTextArea();
		jta_chatRecord.setPreferredSize(new Dimension(430, 1000));
		jta_chatRecord.setEditable(false);
		System.out.println(jta_chatRecord+"sss");
		
		
		// 滚动条
		JScrollPane jsp = new JScrollPane(jta_chatRecord);
		jsp.setPreferredSize(new Dimension(450, 200));
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		this.add(jsp, BorderLayout.CENTER);

		// 聊天窗口底部JPanel
		JPanel jp_msgSend = new JPanel();
		jp_msgSend.setPreferredSize(new Dimension(580, 100));
		this.add(jp_msgSend, BorderLayout.SOUTH);
		// 发送文本框
		jta_chat = new JTextArea();
		jta_chat.setPreferredSize(new Dimension(580, 70));
		jp_msgSend.add(jta_chat);
		// 发送按钮
		JButton jbu_send = new JButton("发送");
		jbu_send.setPreferredSize(new Dimension(80, 20));
		jp_msgSend.add(jbu_send);
		// 关闭按钮
		JButton jbu_close = new JButton("关闭");
		jbu_close.setPreferredSize(new Dimension(80, 20));
		jp_msgSend.add(jbu_close);

		// 接收者列表Jpanel
		JPanel jp_receiver = new JPanel();
		jp_receiver.setPreferredSize(new Dimension(100, 300));
		this.add(jp_receiver, BorderLayout.EAST);

		// 创建用户动作监听器对象
		ActionListener userAction = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user = e.getActionCommand();
				System.out.println(user);
			}
		};
		// 群发消息按钮
		JButton jbu_allUser = new JButton("All");
		jbu_allUser.setPreferredSize(new Dimension(80, 20));
		jp_receiver.add(jbu_allUser);
		jbu_allUser.addActionListener(userAction);
		// 单发消息按钮
		for (int i = 1; i < 11; i++) {
			JButton jbu_user = new JButton("user" + i);
			jbu_user.setPreferredSize(new Dimension(80, 20));
			jp_receiver.add(jbu_user);
			jbu_user.addActionListener(userAction);
		}

		// 添加键盘监听器
		jta_chat.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if (KeyEvent.VK_SHIFT == e.getKeyCode()) {
					if (!user.equals("All")) {
						type = "single";
					}
					MessageProcess.msgPro.msgProcess(type, user, jta_chat);
				}
			} 
		});

		// 发送按钮添加监听器
		jbu_send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!user.equals("All")) {
					type = "single";
				}
				System.out.println("发送"+type);
				MessageProcess.msgPro.msgProcess(type, user, jta_chat);
			}
		});
		
		ImageIcon p1=new ImageIcon("P5.png");
		JLabel jl=new JLabel(p1);
		this.getLayeredPane().add(jl,new Integer(Integer.MIN_VALUE));
		jl.setBounds(0,0,p1.getIconWidth(),p1.getIconHeight());
		System.out.println("p1.getIconWidth()"+p1.getIconWidth());
		((JPanel)this.getContentPane()).setOpaque(false);
		this.setVisible(true);
	}
	// 获取jta_chatRecord
	public JTextArea getJta_chatRecord() {
		System.out.println(jta_chatRecord+"aaa");
		return jta_chatRecord;
	}
}
