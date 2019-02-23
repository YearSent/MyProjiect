package ke_hu_duanV1;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginUI {

	private JTextField jta_name, jta_pwd;
	private Boolean conn2Server;
	private JFrame jf;
	public static final LoginUI lUI = new LoginUI();

	private LoginUI() {
	};

	public void init() {
		jf = new JFrame("qq");
		jf.setSize(360, 450);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(3);
		jf.setLayout(new FlowLayout());
		// ��ӱ���ͼƬ
		ImageIcon icon = new ImageIcon(this.getClass().getResource("0.jpg"));
		// ��ӱ�ǩ
		JLabel jla = new JLabel(icon);
		jf.add(jla);

		// ����ʺ��ı���
		jta_name = new JTextField();
		jta_name.setPreferredSize(new Dimension(200, 30));
		jf.add(jta_name);
		// ������ť
		JButton bu_register = new JButton("ע���ʺ�");
		bu_register.setPreferredSize(new Dimension(100, 30));
		jf.add(bu_register);

		// ��������ı���
		jta_pwd = new JTextField();
		jta_pwd.setPreferredSize(new Dimension(200, 30));
		jf.add(jta_pwd);

		// ������ť
		JButton bu_sec = new JButton("�һ�����");
		bu_sec.setPreferredSize(new Dimension(100, 30));
		jf.add(bu_sec);

		// ��ס���븴ѡ��
		JCheckBox jcb1 = new JCheckBox("��ס����");
		jf.add(jcb1);

		// �һ����븴ѡ��
		JCheckBox jcb2 = new JCheckBox("�һ�����");
		jf.add(jcb2);

		// ������¼��ť
		JButton bu_login = new JButton("��¼");
		bu_login.setPreferredSize(new Dimension(300, 30));
		jf.add(bu_login);
		bu_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conn2Server = MessageProcess.msgPro.loginProcess(jta_name, jta_pwd);
				// ��¼�ɹ�
				if (conn2Server) {
					// �رյ�¼����
					jf.setVisible(!conn2Server);
					// ���������
					ChatUI.cUI.init();
					//�����߳̽��շ�������Ϣ
					new Thread(new ReadThread(ChatClient.conn.getClient())).start();
				} else {
					JOptionPane.showMessageDialog(jf, "�ʺ������������");
					jta_name.setText("");
					jta_pwd.setText("");
				}
			}
		});
		ImageIcon p1=new ImageIcon("P5.png");
		JLabel jl=new JLabel(p1);
		jf.getLayeredPane().add(jl,new Integer(Integer.MIN_VALUE));
		jl.setBounds(0,0,p1.getIconWidth(),p1.getIconHeight());
		System.out.println("p1.getIconWidth()"+p1.getIconWidth());
		((JPanel)jf.getContentPane()).setOpaque(false);
		jf.setVisible(true);
		// ���ô�����ʾ����
		jf.setVisible(true);
	}

}
