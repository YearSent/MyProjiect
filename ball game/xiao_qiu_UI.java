package xiao_qiuV2;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

import javax.swing.JFrame;

public class xiao_qiu_UI {
	
	
	public static void main(String[] args)
	{
		xiao_qiu_UI ui = new xiao_qiu_UI();
		ui.show();
	}
	
	
	public void show()
	{
		//´æÐ¡Çò
		LinkedList<Shape> list= new LinkedList<Shape>();
		//´æ×Óµ¯
		LinkedList<Shape> list0= new LinkedList<>();
		JFrame frame = new JFrame();
		frame.setSize(400, 500);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(3);
		
		
		frame.setVisible(true);
		Graphics g=frame.getGraphics();
		Shape s = new Shape(180,480,40,new Color(255,0,0));
		list.add(s);
		Listener lis = new Listener(list.getFirst());
		frame.addKeyListener(lis);
		
		
		
		CreatThread creat = new CreatThread(list,list0);
		creat.start();
		
		ShootThread shoot = new ShootThread(list, list0, g,frame);
		shoot.start();

		ChangeThread change = new ChangeThread(list);
		change.start();
		
		DrawThread draw = new DrawThread(list,list0, g,frame);
		draw.start();
		
	}

}
