package xiao_qiuV2;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

public class Listener extends KeyAdapter{

	Shape s;
	
	public Listener(Shape s)
	{
		this.s=s;
	}
	


	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode())
		{
		case 37:
			s.x1-=10;
			break;
		case 38:
			s.y1-=10;
			break;
		case 39:
			s.x1+=10;
			break;
		case 40:
			s.y1+=10;
			break;
		default:
			break;
			
		
		}	
	}

	public void keyTyped(KeyEvent e) {
		
	}
	public void keyReleased(KeyEvent e) {}

}
