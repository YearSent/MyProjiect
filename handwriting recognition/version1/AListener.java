package shou_xieV1;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.swing.JComboBox;

public class AListener  implements ActionListener{
	
	Listener lis;
	String text,lasttext;
	String c;
	public void actionPerformed(ActionEvent e) {
		text=e.getActionCommand();
		if("ѵ��".equals(text))
		{
			System.out.println("ѵ��");
			lasttext=text;
			
		}
		if("ʶ��".equals(text))
		{
			System.out.println("ʶ��");
			lasttext=text;
		}
	
		if(text.equals("comboBoxChanged"))
		{
			JComboBox<Integer> box =(JComboBox<Integer>) e.getSource();
			c=box.getSelectedItem().toString();
			System.out.println(c);
			lis.countout=0;
				
		}	
	}

}
