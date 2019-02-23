package wuziqi_PVE;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import wuziqi.Listener1;

public class PVE_Myframe extends JFrame{
	
	PVE_Listener1 lsn;
	//÷ÿ–¥paint∑Ω∑®
	public void paint(Graphics g)
	{
		super.paint(g);
		ImageIcon tp=new ImageIcon("±≥æ∞Õº∆¨Œª÷√");
		Image beijing=tp.getImage();
		g.drawImage(beijing, 0, 0, null);
		for(int i=0;i<lsn.row;i++)
		{
			g.setColor(Color.black);
			g.drawLine(lsn.x0+i*lsn.p, lsn.y0, lsn.x0+i*lsn.p, lsn.y0+(lsn.row-1)*lsn.p);
			g.drawLine(lsn.x0, lsn.y0+i*lsn.p, lsn.x0+(lsn.row-1)*lsn.p, lsn.y0+i*lsn.p);
			
		}
		//ª≠œ» ÷∆Â◊”
		if(lsn.click==0)
		{
			lsn.qz[9][9]=2;
			ImageIcon tph=new ImageIcon("∫⁄∆Â◊”Õº∆¨Œª÷√");
			Image qizihei=tph.getImage();
			g.drawImage(qizihei, lsn.x0+9*lsn.p-lsn.p/3, lsn.y0+9*lsn.p-lsn.p/3, lsn.p*2/3,lsn.p*2/3, null);
			g.setColor(Color.black);
			g.fillOval(lsn.x0+9*lsn.p-lsn.p/3, lsn.y0+9*lsn.p-lsn.p/3, lsn.p*2/3,lsn.p*2/3);
		}
		for(int i=0;i<lsn.row;i++)
		{
			for(int j=0;j<lsn.row;j++)
			{
				if(lsn.qz[i][j]==1)
				{
					ImageIcon tpb=new ImageIcon("∞◊∆Â◊”Õº∆¨Œª÷√");
					Image qizibai=tpb.getImage();
					g.drawImage(qizibai, lsn.x0+i*lsn.p-lsn.p/3, lsn.y0+j*lsn.p-lsn.p/3, lsn.p*2/3,lsn.p*2/3, null);			
				}
				if(lsn.qz[i][j]==2)
				{
					
					ImageIcon tph=new ImageIcon("∫⁄∆Â◊”Õº∆¨Œª÷√");
					Image qizihei=tph.getImage();
					g.drawImage(qizihei, lsn.x0+i*lsn.p-lsn.p/3, lsn.y0+j*lsn.p-lsn.p/3, lsn.p*2/3,lsn.p*2/3, null);
				}
			}
		}
		
		
	}

}
