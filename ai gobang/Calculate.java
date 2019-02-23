package wuziqi_PVE;

import java.awt.Color;
import java.util.HashMap;

public class Calculate {
	PVE_Listener1 lsn2;
	//����Ȩֵ��¼��,��СΪ��������
	int[][] data = new int[lsn2.row][lsn2.row];
	HashMap<String,Integer> map = new HashMap<String,Integer>();
	
	public void setData()
	{
		
		//����2������1���������º���
		map.put("21", 1);
		map.put("20", 2);
		map.put("221", 4);
		map.put("220", 8);
		map.put("2221", 16);
		map.put("2220", 32);
		map.put("22221", 64);
		map.put("22220", 128);	
		map.put("12", 1);
		map.put("10", 2);
		map.put("112", 4);
		map.put("110", 8);
		map.put("1112", 16);
		map.put("1110", 32);
		map.put("11112", 64);
	}
	//����Ȩֵ������
	public void ai()
	{
		int i0=0,j0=0,max=0;
		int i=0,j=0;
		for(i=0;i<lsn2.row;i++)
			for(j=0;j<lsn2.row;j++)
			{
				if(lsn2.qz[i][j]==0)
				{
					//�������
					int weight=left(i,j);
					data[i][j]+=weight;
				}
			}
		for(i=0;i<lsn2.row;i++)
			for(j=0;j<lsn2.row;j++)
			{
				if(data[i][j]>max)
				{
					max=data[i][j];
					i0=i;j0=j;
				}
			}
		lsn2.qz[i0][j0]=2;
		lsn2.click++;
		lsn2.g.setColor(Color.black);
		lsn2.g.fillOval(lsn2.x0+i*lsn2.p-lsn2.p/3, lsn2.y0+j*lsn2.p-lsn2.p/3, 2*lsn2.p/3, 2*lsn2.p/3);
	}
	
	//�������Ȩֵ
	public int left(int i,int j)
	{
		setData();
		int type=0;
		String qiju="";
		for(int k=i-1;k>=0;k--)
		{
			//��һ���ǿ�λ
			if(lsn2.qz[k][j]==0&&k==i-1)
				break;
			//��һ�����ӵ���ɫ
			if(type==0)
			{
				//��¼��ɫ
				type=lsn2.qz[k][j];
				qiju+=lsn2.qz[k][j];
			}
				
			//��һ��ͬɫ
			else if(lsn2.qz[k][j]==type)
			{
				qiju+=lsn2.qz[k][j];
			}
			//��һ����ͬ
			else if(lsn2.qz[k][j]!=type)
			{
				qiju+=lsn2.qz[k][j];
				break;
			}
		}
		Integer quanzhi=map.get(qiju);
		int qq=quanzhi;
		return qq;
	}
	

}
