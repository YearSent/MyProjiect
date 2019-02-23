package shou_xieV1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
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
		frame.setSize(600, 600);
		frame.setLocationRelativeTo(null);;
		frame.setDefaultCloseOperation(3);
		frame.setResizable(false);
		
		JPanel north = new JPanel();
		JButton btn1 = new JButton("ÑµÁ·");
		JButton btn2 = new JButton("Ê¶±ð");
		north.setBackground(Color.blue);
		north.add(btn1);
		north.add(btn2);
		Integer[] choice ={0,1,2,3,4,5,6,7,8,9};
		JComboBox<Integer> box = new JComboBox<Integer>(choice);
		north.add(box);
		frame.add(north, BorderLayout.NORTH);
		
		
		frame.setVisible(true);
		Graphics g=frame.getGraphics();
		//»­°å³ß´ç
		int width=600;
		int height=500;
		//µ¥Î»·½¿é³ß´ç
		int size=15;
		int[][] sz = new int[height/size][width/size];
		
		Listener lis = new Listener(g,sz);
		MotionListener mlis = new MotionListener(g,sz);
		frame.addMouseMotionListener(mlis);
		frame.addMouseListener(lis);
		AListener al = new AListener();
		lis.al=al;
		al.lis=lis;
		btn1.addActionListener(al);
		btn2.addActionListener(al);
		box.addActionListener(al);
		
	}

}
