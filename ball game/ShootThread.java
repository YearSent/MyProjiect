package xiao_qiuV2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class ShootThread extends Thread{
	
	
	LinkedList<Shape> list;
	LinkedList<Shape> list0;
	Shape s,s1;
	Color c = new Color(0,0,0);
	Graphics g;
	JFrame f;
	public ShootThread(LinkedList<Shape> list,LinkedList<Shape> list0,Graphics g,JFrame f)
	{
		this.list=list;
		this.list0=list0;
		this.g=g;
		this.f=f;
	}
	
	public void run()
	{
		for(;;)
		{
			for(int i=0;i<list0.size();i++)
			{
				s1=list0.get(i);
				for(int j=1;j<list.size();j++)
				{
					s=list.get(j);
					s1.crash(s);
					if(s.b==true)
					{
						list.remove(s);
						list0.remove(s1);
						if(s.b==true)
						{
							ImageIcon image=new ImageIcon("D:\\java_study\\Ð¡ÇòÓÎÏ·\\src\\baozha.gif");
							g.drawImage(image.getImage(), s.x1, s.y1, 50, 50, null);
						}
						
					}
				}
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
