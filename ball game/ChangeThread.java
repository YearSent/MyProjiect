package xiao_qiuV2;

import java.util.LinkedList;

public class ChangeThread extends Thread{
	
	LinkedList<Shape> list;
	public ChangeThread(LinkedList<Shape> list)
	{
		this.list=list;
	}
	
	public void run()
	{
		for(;;)
		{
			for(int i=1;i<list.size();i++)
			{
				Shape s=list.get(i);
				s.move();
				for(int j=0;j<list.size();j++)
				{
					s.crash(list.get(j));
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
