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
		this.setTitle("������");
		this.setSize(600, 420);
		this.setDefaultCloseOperation(3);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(new BorderLayout());

		// �����
		jta_chatRecord = new JTextArea();
		jta_chatRecord.setPreferredSize(new Dimension(430, 1000));
		jta_chatRecord.setEditable(false);
		System.out.println(jta_chatRecord+"sss");
		
		
		// ������
		JScrollPane jsp = new JScrollPane(jta_chatRecord);
		jsp.setPreferredSize(new Dimension(450, 200));
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		this.add(jsp, BorderLayout.CENTER);

		// ���촰�ڵײ�JPanel
		JPanel jp_msgSend = new JPanel();
		jp_msgSend.setPreferredSize(new Dimension(580, 100));
		this.add(jp_msgSend, BorderLayout.SOUTH);
		// �����ı���
		jta_chat = new JTextArea();
		jta_chat.setPreferredSize(new Dimension(580, 70));
		jp_msgSend.add(jta_chat);
		// ���Ͱ�ť
		JButton jbu_send = new JButton("����");
		jbu_send.setPreferredSize(new Dimension(80, 20));
		jp_msgSend.add(jbu_send);
		// �رհ�ť
		JButton jbu_close = new JButton("�ر�");
		jbu_close.setPreferredSize(new Dimension(80, 20));
		jp_msgSend.add(jbu_close);

		// �������б�Jpanel
		JPanel jp_receiver = new JPanel();
		jp_receiver.setPreferredSize(new Dimension(100, 300));
		this.add(jp_receiver, BorderLayout.EAST);

		// �����û���������������
		ActionListener userAction = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user = e.getActionCommand();
				System.out.println(user);
			}
		};
		// Ⱥ����Ϣ��ť
		JButton jbu_allUser = new JButton("All");
		jbu_allUser.setPreferredSize(new Dimension(80, 20));
		jp_receiver.add(jbu_allUser);
		jbu_allUser.addActionListener(userAction);
		// ������Ϣ��ť
		for (int i = 1; i < 11; i++) {
			JButton jbu_user = new JButton("user" + i);
			jbu_user.setPreferredSize(new Dimension(80, 20));
			jp_receiver.add(jbu_user);
			jbu_user.addActionListener(userAction);
		}

		// ��Ӽ��̼�����
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

		// ���Ͱ�ť��Ӽ�����
		jbu_send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!user.equals("All")) {
					type = "single";
				}
				System.out.println("����"+type);
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
	// ��ȡjta_chatRecord
	public JTextArea getJta_chatRecord() {
		System.out.println(jta_chatRecord+"aaa");
		return jta_chatRecord;
	}
}
