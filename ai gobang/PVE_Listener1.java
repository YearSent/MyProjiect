//权值法
package wuziqi_PVE;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PVE_Listener1 implements MouseListener,ActionListener{
	Calculate cal;
	PVE_Myframe f;
	//记录坐标
	int x0=38,x2=0,y0=98,y2=0,x1=0,y1=0;
	//棋盘行数
	public static final int row=19;
	Graphics g;
	//棋子间距
	public static final int p=40;
	//点击次数，棋子数
	int click=0,qzb=0,qzh=1;
	//判断输赢
	int win=0;
	
	//棋盘交点棋子
	int[][] qz= new int[row][row];
	//储存棋子的x，y坐标
	int[] qzx=new int[row*row];
	int[] qzy=new int[row*row];
	

	
	//获取画布
	public void setG(Graphics g)
	{
		this.g=g;
	}

	
	
	
	public void mousePressed(MouseEvent e)
	{
	}
	

	public void mouseReleased(MouseEvent e)
	{
		x1=e.getX();
		y1=e.getY();
		draw();
		if(win==0)
			win();
		ai();
		if(win==0)
			win();
		
	}
	
	
	
	
	public void actionPerformed(ActionEvent e)
	{
		String btnText=e.getActionCommand();
		if(btnText.equals("重新下棋"))
		{
			win=0;
			for(int i=0;i<row;i++)
				for(int j=0;j<row;j++)
				{
					qz[i][j]=0;
					data[i][j]=0;
				}
			click=0;
			g.setColor(Color.black);
			g.clearRect(0, 85, 1000, 1000);
			ImageIcon tp=new ImageIcon("背景图片位置");
			Image beijing=tp.getImage();
			g.drawImage(beijing, 0, 0, null);
			g.setColor(Color.black);
			for(int i=0;i<row;i++)
			{
				g.drawLine(x0+i*p, y0, x0+i*p, y0+(row-1)*p);
				g.drawLine(x0, y0+i*p, x0+(row-1)*p, y0+i*p);
			}
			qz[9][9]=2;
			g.setColor(Color.black);
			g.fillOval(x0+9*p-p/3, y0+9*p-p/3, p*2/3,p*2/3);
		}
		if(btnText.equals("悔棋"))
		{
			huiqi();
		}
	}
	
	
	
	
	//求绝对值
	public int abs(int a)
	{ 
	 	return a>0?a:-a;
	}
	
	
	
	
	
	
	
	
	
	//画棋子
	public void draw()
	{
		int i,j;
		for( i=0;i<row;i++)
		{
			
			if(Math.abs(x1-(x0+i*p))<p/2)
			{
				x1=x0+i*p;
				for( j=0;j<row;j++)
				{
					if(abs(y1-(y0+j*p))<p/2)
					{
						y1=y0+j*p;
						if(qz[i][j]==0)
						{
							click++;
							qzx[click]=x1;
							qzy[click]=y1;
							if(click%2==1)
							{
								qz[i][j]=1;
								ImageIcon tpb=new ImageIcon("D:\\java_study\\五子棋\\src\\wuziqi\\qizibai.png");
								Image qizibai=tpb.getImage();
								g.drawImage(qizibai, x1-p/3, y1-p/3, 2*p/3, 2*p/3, f);
								qzb++;
							}
						}
					}
				}
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	//判断输赢
	public void win()
	{
		int whi=0,bla=0;
		//判断水平方向
		for(int i=0;i<row;i++)
			for(int j=0;j<row;j++)
			{
				//判断水平方向
				for(int z=0;z<5;z++)
				{
					if(i-z>=0)
					{
						if(qz[i-z][j]==1)
							whi++;
						if(qz[i-z][j]==2)
							bla++;
					}						
				}
				if(whi==5)
				{
					System.out.println("白子胜!");
					whi=0;
					win++;
					i=row;
					showwhite();
					break;
				}
				else
					whi=0;
				if(bla==5)
				{
					System.out.println("黑子胜!");
					bla=0;
					win++;
					i=row;
					showblack();
					break;
				}
				else
					bla=0;
			}
		for(int i=0;i<row;i++)
			for(int j=0;j<row;j++)
			{
				for(int z=0;z<5;z++)
				{
					if(j-z>=0)
					{
						if(qz[i][j-z]==1)
							whi++;
						if(qz[i][j-z]==2)
							bla++;
					}						
				}
				if(whi==5)
				{
					System.out.println("白子胜!");
					whi=0;win++;
					i=row;
					showwhite();
					break;
				}
				else
					whi=0;
				if(bla==5)
				{
					System.out.println("黑子胜!");
					bla=0;win++;
					i=row;
					showblack();
					break;
				}
				else
					bla=0;
			}
		//判断对角线方向
		for(int i=0;i<row;i++)
			for(int j=0;j<row;j++)
			{
				for(int z=0;z<5;z++)
				{
					if(i-z>=0&&j-z>=0)
					{
						if(qz[i-z][j-z]==1)
							whi++;
						if(qz[i-z][j-z]==2)
							bla++;
					}						
				}
				if(whi==5)
				{
					System.out.println("白子胜!");
					whi=0;win++;
					i=row;
					showwhite();
					break;
				}
				else
					whi=0;
				if(bla==5)
				{
					System.out.println("黑子胜!");
					bla=0;win++;
					i=row;
					showblack();
					break;
				}
				else
					bla=0;
			}
		for(int i=0;i<row;i++)
			for(int j=0;j<row;j++)
			{
				for(int z=0;z<5;z++)
				{
					if(i+z<row&&j-z>=0)
					{
						if(qz[i+z][j-z]==1)
							whi++;
						if(qz[i+z][j-z]==2)
							bla++;
					}						
				}
				if(whi==5)
				{
					System.out.println("白子胜!");
					whi=0;win++;
					i=row;
					showwhite();
					break;
				}
				else
					whi=0;
				if(bla==5)
				{
					System.out.println("黑子胜!");
					bla=0;win++;
					i=row;
					showblack();
					break;
				}
				else
					bla=0;
			}
		
		
	}
	
	
	
	
	//悔棋方法
	public void huiqi()
	{
		if(click>0)
		{
			qz[(qzx[click]-x0)/p][(qzy[click]-y0)/p]=0;
			click--;
			qz[((qzx[click]-x0)/p)][((qzy[click]-y0)/p)]=0;
			click--;
			f.paint(g);
		}
		if(click==0)
		{
			JFrame f=new JFrame();
			f.setSize(250, 110);
			f.setLocationRelativeTo(null);
			f.setLayout(new FlowLayout());
			JLabel l1=new JLabel("请下棋!");
			Font font=new Font(null, 0, 40);
			l1.setFont(font);
					
			
			f.add(l1);
			f.setVisible(true);
		}
		
	}
	
	
	
	
	
	//创建提示窗
	public void showwhite()
	{
		JFrame f=new JFrame();
		f.setSize(400, 320);
		f.setLocationRelativeTo(null);
		f.setLayout(new FlowLayout());
		f.setBackground(Color.pink);
		f.setResizable(false);
		JLabel l1=new JLabel();
		ImageIcon tp1=new ImageIcon("图片位置");
		l1.setIcon(tp1);
		f.add(l1);
		JLabel l2=new JLabel("白子胜!");
		Font font=new Font(null, 0, 40);
		l2.setFont(font);
				
		
		f.add(l2);
		f.setVisible(true);
				
	}
	

	public void showblack()
	{
		JFrame f=new JFrame();
		f.setSize(400, 320);
		f.setLocationRelativeTo(null);
		f.setLayout(new FlowLayout());
		f.setResizable(false);
		JLabel l1=new JLabel();
		ImageIcon tp1=new ImageIcon("图片位置");
		l1.setIcon(tp1);
		f.add(l1);
		JLabel l2=new JLabel("黑子胜!");
		Font font=new Font(null, 0, 40);
		l2.setFont(font);
				
		
		f.add(l2);
		f.setVisible(true);
				
	}
	
	
	
	
	
	
	
	//创建权值记录表,大小为棋盘行数
		int[][] data = new int[row][row];
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		
		public void setData()
		{
			
			//黑子2，白子1，电脑先下黑子
			map.put("21", 1);
			map.put("20", 2);
			map.put("221", 20);
			map.put("220", 30);
			map.put("2221", 60);
			map.put("2220", 600);
			map.put("22221", 1200);
			map.put("22220", 1300);
			map.put("22020", 2000);
			map.put("220220", 2000);
			map.put("12", 1);
			map.put("10", 2);
			map.put("112", 20);
			map.put("110", 20);
			map.put("1112", 80);
			map.put("1110", 500);
			map.put("11112", 2000);
			map.put("11110", 1000);
			map.put("11010", 2000);
			map.put("110110", 2000);
		}
		
		
		
		
		
		
		
		
		
		
		
		//计算权值并下棋
		public void ai()
		{
			int i0=0,j0=0,max=0;
			int i=0,j=0;
			for(i=0;i<row;i++)
				for(j=0;j<row;j++)
				{
					if(qz[i][j]==0)
					{
						//计算权值
						//i，j交换，我也不知带为什么，存出来的数组是反过来的
						data[j][i]=west(i,j)+east(i,j)+south(i,j)+north(i,j)+northwest(i,j)+northeast(i,j)+southwest(i,j)+southeast(i,j);
					}
				}
			for(i=0;i<row;i++)
				for(j=0;j<row;j++)
				{
					if(data[i][j]>max&&qz[i][j]==0)
					{
						max=data[i][j];
						i0=j;j0=i;
					}
				}
			if(qzh==qzb&&qz[i0][j0]==0)
			{
				qz[i0][j0]=2;
				click++;
				qzx[click]=x0+i0*p;
				qzy[click]=y0+j0*p;
				ImageIcon tph=new ImageIcon("D:\\java_study\\五子棋\\src\\wuziqi\\qizihei.png");
				Image qizihei=tph.getImage();
				g.drawImage(qizihei, x0+i0*p-p/3, y0+j0*p-p/3, 2*p/3, 2*p/3,null);
				qzh++;
			}
			for(i=0;i<data.length;i++)
				System.out.println(Arrays.toString(data[i]));
			System.out.println(click);
			for(i=0;i<row;i++)
				for(j=0;j<row;j++)
				{
					data[i][j]=0;
				}
		}
		
		
		
		
		
		
		
		
		
		
		//计算左边权值
		public int west(int i,int j)
		{
			setData();
			int type=0;
			String qiju="";
			for(int k=i-1;k>=0;k--)
			{
				//第一个是空位
				if(k==i-1&&qz[k][j]==0)
					break;
				//第一个棋子的颜色
				if(type==0)
				{
					//记录颜色
					type=qz[k][j];
					qiju+=qz[k][j];					
				}
					
				//下一个同色
				else if(qz[k][j]==type)
				{
					qiju+=qz[k][j];
					
				}
				//下一个不同
				else if(qz[k][j]!=type)
				{
					qiju+=qz[k][j];
					break;
				}
			}
			Integer quanzhi=0;
			quanzhi=map.get(qiju);
			if(quanzhi==null)
				return 0;
			else
				
				return quanzhi;
		}
		
		
		
		
		
		
		
		
		
		
		//计算右边权值
		public int east(int i,int j)
		{
			setData();
			int type=0;
			String qiju="";
			for(int k=i+1;k<row;k++)
			{
				//第一个是空位
				if(qz[k][j]==0&&k==i+1)
					break;
				//第一个棋子的颜色
				if(type==0)
				{
					//记录颜色
					type=qz[k][j];
					qiju+=qz[k][j];
				}
					
				//下一个同色
				else if(qz[k][j]==type)
				{
					qiju+=qz[k][j];
				}
				//下一个不同
				else if(qz[k][j]!=type)
				{
					qiju+=qz[k][j];
					break;
				}
			}
			Integer quanzhi=0;
			quanzhi=map.get(qiju);
			if(quanzhi==null)
				return 0;
			else
				return quanzhi;
		}
		
		
		
		
		
		
		
		
		//计算上边权值
		public int north(int i,int j)
		{
			setData();
			int type=0;
			String qiju="";
			for(int k=j-1;k>=0;k--)
			{
				//第一个是空位
				if(qz[i][k]==0&&k==j-1)
					break;
				//第一个棋子的颜色
				if(type==0)
				{
					//记录颜色
					type=qz[i][k];
					qiju+=qz[i][k];
				}
					
				//下一个同色
				else if(qz[i][k]==type)
				{
					qiju+=qz[i][k];
				}
				//下一个不同
				else if(qz[i][k]!=type)
				{
					qiju+=qz[i][k];
					break;
				}
			}
			Integer quanzhi=0;
			quanzhi=map.get(qiju);
			if(quanzhi==null)
				return 0;
			else
				return quanzhi;
		}

		
		
		
		
		
		
		
		//计算下边权值
		public int south(int i,int j)
		{
			setData();
			int type=0;
			String qiju="";
			for(int k=j+1;k<row;k++)
			{
				//第一个是空位
				if(qz[i][k]==0&&k==j+1)
					break;
				//第一个棋子的颜色
				if(type==0)
				{
					//记录颜色
					type=qz[i][k];
					qiju+=qz[i][k];
				}
					
				//下一个同色
				else if(qz[i][k]==type)
				{
					qiju+=qz[i][k];
				}
				//下一个不同
				else if(qz[i][k]!=type)
				{
					qiju+=qz[i][k];
					break;
				}
			}
			Integer quanzhi=0;
			quanzhi=map.get(qiju);
			if(quanzhi==null)
				return 0;
			else
				return quanzhi;
		}
	
		
		
		
		
		//计算左上角权值
		public int northwest(int i,int j)
		{
			setData();
			int type=0;
			String qiju="";
			for(int k=1;k<6;k++)
			{
				//第一个是空位
				if(i-1<0||j-1<0)
					break;
				else if(i-1>=0&&j-1>=0&&qz[i-1][j-1]==0)
					break;
				//第一个棋子的颜色
				else if(type==0&&i-1>=0&&j-1>=0)
				{
					//记录颜色
					type=qz[i-1][j-1];
					qiju+=qz[i-1][j-1];
				}
					
				//下一个同色
				else if(i-k>=0&&j-k>=0&&qz[i-k][j-k]==type)
				{
					qiju+=qz[i-k][j-k];
				}
				//下一个不同
				
				else if(i-k>=0&&j-k>=0&&qz[i-k][j-k]!=type)
				{
					qiju+=qz[i-k][j-k];
					break;
				}
			}	
			Integer quanzhi=0;
			quanzhi=map.get(qiju);
			if(quanzhi==null)
				return 0;
			else
				return quanzhi;
		}
		
		
		
		
		
		
		
		//计算左下角权值
		public int southwest(int i,int j)
		{
			setData();
			int type=0;
			String qiju="";
			for(int k=1;k<6;k++)
			{
				if(i-1<0||j+1==row)
					break;
				//第一个是空位
				else if(i-1>=0&&j+1<row&&qz[i-1][j+1]==0)
					break;
				//第一个棋子的颜色
				else if(type==0&&i-1>=0&&j+1<row)
				{
					//记录颜色
					type=qz[i-1][j+1];
					qiju+=qz[i-1][j+1];
				}
					
				//下一个同色
				else if(i-k>=0&&j+k<row&&qz[i-k][j+k]==type)
				{
					qiju+=qz[i-k][j+k];
				}
				//下一个不同
				else if(i-k>=0&&j+k<row&&qz[i-k][j+k]!=type)
				{
					qiju+=qz[i-k][j+k];
					break;
				}
			}	
			Integer quanzhi=0;
			quanzhi=map.get(qiju);
			if(quanzhi==null)
				return 0;
			else
				return quanzhi;
		}
		
		
		
		
		//计算右上角权值
		public int northeast(int i,int j)
		{
			setData();
			int type=0;
			String qiju="";
			for(int k=1;k<6;k++)
			{
				//第一个是空位
				if(i+1<row&&j-1>=0&&qz[i+1][j-1]==0)
					break;
				//第一个棋子的颜色
				else if(i+1<row&&j-1>=0&&type==0)
				{
					//记录颜色
					type=qz[i+1][j-1];
					qiju+=qz[i+1][j-1];
				}
					
				//下一个同色
				else if(i+k<row&&j-k>=0&&qz[i+k][j-k]==type)
				{
					qiju+=qz[i+k][j-k];
				}
				//下一个不同
				else if(i+k<row&&j-k>=0&&qz[i+k][j-k]!=type)
				{
					qiju+=qz[i+k][j-k];
					break;
				}
			}	
			Integer quanzhi=0;
			quanzhi=map.get(qiju);
			if(quanzhi==null)
				return 0;
			else
				return quanzhi;
			}
		
		
		
		
		//计算右下角权值
		public int southeast(int i,int j)
		{
			setData();
			int type=0;
			String qiju="";
			for(int k=1;k<6;k++)
			{
				if(i+1==row||j+1==row)
					break;
				//第一个是空位
				else if(i+1<row&&j+1<row&&qz[i+1][j+1]==0)
					break;
				//第一个棋子的颜色
				else if(type==0&&i+1<row&&j+1<row)
				{
					//记录颜色
					type=qz[i+1][j+1];
					qiju+=qz[i+1][j+1];
				}
					
				//下一个同色
				else if(i+k>=0&&j+k>=0&&qz[i+k][j+k]==type)
				{
					qiju+=qz[i+k][j+k];
				}
				//下一个不同
				else if(i+k>=0&&j+k>=0&&qz[i+k][j+k]!=type)
				{
					qiju+=qz[i+k][j+k];
					break;
				}
			}	
			Integer quanzhi=0;
			quanzhi=map.get(qiju);
			if(quanzhi==null)
				return 0;
			else
				return quanzhi;
			}

		
		
	
		
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	public void mouseClicked(MouseEvent e)
	{
		
	}

}
