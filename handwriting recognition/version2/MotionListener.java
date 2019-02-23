package shou_xieV2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Arrays;

public class MotionListener extends MouseMotionAdapter{
	Graphics g;
	int x0=0,y0=100,x1,y1;
	static final int width=600;
	static final int height=500;
	static final int size=15;
	int[][] sz ;
	
	public MotionListener(Graphics g,int[][] sz )
	{
		this.g=g;
		this.sz=sz;
	}
	public void mouseDragged(MouseEvent e){
		x1=e.getX();
		y1=e.getY();
		g.setColor(Color.white);
		g.fillRect(x1, y1, size, size);
		if(x1>x0&&x1<x0+width&&y1>y0&&y1<y0+height&&x1<600&&y1<500)
		{
			sz[(y1-y0)/size][(x1-x0)/size]=1;
			sz[(y1-y0)/size+1][(x1-x0)/size+1]=1;
		}
		
	}

}
