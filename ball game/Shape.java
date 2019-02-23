package xiao_qiuV2;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Shape {

	int x1,y1,size;
	int speedx=2,speedy=1;
	Color c;
	boolean b;
	public Shape(int x1,int y1,int size,Color c)
	{
		this.x1=x1;
		this.y1=y1;
		this.size=size;
		this.c=c;
	}
	
	
	//移动方法
	public void move()
	{
		if(x1+size>=400)
		{
			speedx=-speedx;
		}
		if(x1<=0)
		{
			speedx=-speedx;
		}
		if(y1<=0)
		{
			speedy=-speedy;
		}
		if(y1+size>=500)
		{
			speedy=-speedy;
		}
		x1+=speedx;
		y1+=speedy;

	}
	
	//子弹移动方法
	public void move1()
	{
		y1-=5;
	}
	//绘图方法
	public void draw(Graphics g)
	{
		g.setColor(c);
		g.fillOval(x1, y1, size, size);
	}
	
	
	//碰撞方法
	public void crash(Shape s)
	{
		s.b=false;
		if(s!=this)
		{
			int l=((s.x1+s.size/2)-(x1+size/2))*((s.x1+s.size/2)-(x1+size/2))
					+((s.y1+s.size/2)-(y1+size/2))*((s.y1+s.size/2)-(y1+size/2));
			if(l<((s.size+size)/2)*((s.size+size)/2))
			{
				s.b=!s.b;
				speedx=-speedx;
				speedy=-speedy;
				s.speedx=-s.speedx;
				s.speedy=-s.speedy;
			}
		}
	}

}
