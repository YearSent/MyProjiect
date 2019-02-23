package wuziqi_PVE;

import java.awt.Dimension;
import java.awt.Font;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import wuziqi.Listener1;
import wuziqi.Myframe;
import wuziqi.UI;

public class PVE_UI {
	
	public void showUI()
	{
		//����һ������
		PVE_Myframe frame=new PVE_Myframe();
		frame.setSize(800,880);
		frame.setTitle("������");
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//�����������
		JPanel northP= new JPanel();
		northP.setPreferredSize(new Dimension(0, 50));

		//������ť
		JButton btn1=new JButton("����");
		JButton button=new JButton("��������");
		button.setPreferredSize(new Dimension(150, 40));
		btn1.setPreferredSize(new Dimension(150, 40));
		Font fon=new Font(null, 1, 25);
		btn1.setFont(fon);
		button.setFont(fon);
		northP.add(btn1);
		northP.add(button);
		frame.add(northP);
		
		PVE_Listener1 lsn1=new PVE_Listener1();
		frame.addMouseListener(lsn1);
		button.addActionListener(lsn1);
		btn1.addActionListener(lsn1);
		frame.setVisible(true);
		//��������
		lsn1.setG(frame.getGraphics());
		frame.lsn=lsn1;
		lsn1.f=frame;
	}
	public static void main(String[] args)
	{
		PVE_UI ui=new PVE_UI();
		ui.showUI();
		
	}

}
