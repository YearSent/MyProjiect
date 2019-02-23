package shou_xieV2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.LayoutQueue;

public class UI {
	
	public static void main(String[] args)
	{
		UI ui= new UI();
		ui.show();	
	}
	
	public void show()
	{
		JFrame frame = new JFrame();
		frame.setSize(730, 600);
		frame.setLocationRelativeTo(null);;
		frame.setDefaultCloseOperation(3);
		frame.setResizable(false);
		//±±±ßÃæ°å
		JPanel north = new JPanel();
		//ÏÔÊ¾¿ò
		JTextField calShow=new JTextField();
		calShow.setPreferredSize(new Dimension(360,60));
		calShow.setEditable(false);
		calShow.setFont(new Font(null,0, 40));
		north.add(calShow);
		frame.add(north, BorderLayout.NORTH);
		
		//¶«±ßÃæ°å
		JPanel east = new JPanel();
		east.setPreferredSize(new Dimension(100,100));
		Font size1=new Font(null, 0, 40);
		Dimension btnsize=new Dimension(90, 65);
		String[] str={"AC","+","-","*","/",".","="};
		AListener al = new AListener();
		for(int i=0;i<str.length;i++)
		{
			JButton button=new JButton(str[i]);
			east.add(button);
			button.addActionListener(al);
			button.setPreferredSize(btnsize);
			button.setFont(size1);
		}
		frame.add(east, BorderLayout.EAST);
		frame.setVisible(true);
		Graphics g=frame.getGraphics();
		//»­°å³ß´ç
		int width=600;
		int height=500;
		//µ¥Î»·½¿é³ß´ç
		int size=15;
		int[][] sz = new int[height/size][width/size];
		
		Listener lis = new Listener(g,sz,al);
		MotionListener mlis = new MotionListener(g,sz);
		frame.addMouseMotionListener(mlis);
		frame.addMouseListener(lis);
		
		al.setCalShow(calShow);
		lis.setCalShow(calShow);
		al.lis=lis;
		
	}

}
