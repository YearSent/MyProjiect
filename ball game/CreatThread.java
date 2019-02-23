package xiao_qiuV2;

import java.awt.Color;
import java.util.LinkedList;
import java.util.Random;

public class CreatThread extends Thread{
	
	Shape s;
	Random ran = new Random();
	LinkedList<Shape> list;
	LinkedList<Shape> list0;
	Shape s0,s1;
	Color c = new Color(0, 0, 0);
	public CreatThread(LinkedList<Shape> list,LinkedList<Shape> list0)
	{
		this.list=list;
		this.list0=list0;
	}
	
	public void run()
	{
		s0=list.getFirst();
		Thread td= new Thread()
		{
			public void run()
			{
				for(;;)
				{
					s1 = new Shape(s0.x1+20, s0.y1, 10, c);
					list0.add(s1);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};td.start();
		while(list.size()<10)
		{
			s = new Shape(ran.nextInt(360),10,ran.nextInt(30)+10,new Color
									(ran.nextInt(255),ran.nextInt(255),ran.nextInt(255)));
			list.add(s);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
		}
	}

}
