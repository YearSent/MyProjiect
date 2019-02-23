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
		// 添加背景图片
		ImageIcon icon = new ImageIcon(this.getClass().getResource("0.jpg"));
		// 添加标签
		JLabel jla = new JLabel(icon);
		jf.add(jla);

		// 添加帐号文本框
		jta_name = new JTextField();
		jta_name.setPreferredSize(new Dimension(200, 30));
		jf.add(jta_name);
		// 创建按钮
		JButton bu_register = new JButton("注册帐号");
		bu_register.setPreferredSize(new Dimension(100, 30));
		jf.add(bu_register);

		// 添加密码文本框
		jta_pwd = new JTextField();
		jta_pwd.setPreferredSize(new Dimension(200, 30));
		jf.add(jta_pwd);

		// 创建按钮
		JButton bu_sec = new JButton("找回密码");
		bu_sec.setPreferredSize(new Dimension(100, 30));
		jf.add(bu_sec);

		// 记住密码复选框
		JCheckBox jcb1 = new JCheckBox("记住密码");
		jf.add(jcb1);

		// 找回密码复选框
		JCheckBox jcb2 = new JCheckBox("找回密码");
		jf.add(jcb2);

		// 创建登录按钮
		JButton bu_login = new JButton("登录");
		bu_login.setPreferredSize(new Dimension(300, 30));
		jf.add(bu_login);
		bu_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conn2Server = MessageProcess.msgPro.loginProcess(jta_name, jta_pwd);
				// 登录成功
				if (conn2Server) {
					// 关闭登录界面
					jf.setVisible(!conn2Server);
					// 打开聊天界面
					ChatUI.cUI.init();
					//启动线程接收服务器信息
					new Thread(new ReadThread(ChatClient.conn.getClient())).start();
				} else {
					JOptionPane.showMessageDialog(jf, "帐号密码输入错误！");
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
		// 设置窗体显示出来
		jf.setVisible(true);
	}

}
