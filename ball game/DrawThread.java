package xiao_qiuV2;

import java.awt.Graphics;
import java.awt.Image;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class DrawThread extends Thread{
	LinkedList<Shape> list;
	LinkedList<Shape> list0;
	Shape s,s1;
	Graphics g;
	JFrame f;
	public DrawThread(LinkedList<Shape> list,LinkedList<Shape> list0,Graphics g,JFrame f)
	{
		this.list=list;
		this.g=g;
		this.f=f;
		this.list0=list0;
	}
	
	public void run()
	{
		for(;;)
		{
			//这三句防闪
			Image im=f.createImage(f.getWidth(), f.getHeight());
			g=im.getGraphics();
			for(int i=0;i<list.size();i++)
			{
				s=list.get(i);
				s.draw(g);
				if(s.b==true)
				{
					ImageIcon image=new ImageIcon("D:\\java_study\\小球游戏\\src\\baozha.gif");
					g.drawImage(image.getImage(), s.x1, s.y1, 50, 50, null);
				}
			}
			for(int i=0;i<list0.size();i++)
			{
				s1=list0.get(i);
				s1.move1();
				s1.draw(g);
			}
			try {
					Thread.sleep(10);
				} catch (InterruptedException e) {}	
			f.getGraphics().drawImage(im, 0, 0, null);
		}
	}

}
