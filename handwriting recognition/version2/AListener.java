package shou_xieV2;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.swing.JComboBox;
import javax.swing.JTextField;

public class AListener  implements ActionListener{
	//计算器用
JTextField LcalShow;
	
	//创建一个设置输入框的方法
	public void setCalShow(JTextField text)
	{
		LcalShow=text;
	}
	String num="";
	String num1="";
	String num2="";
	String fuhao="";
	float j=0;
	int f=0,d=0;
	//设一个值，判断前一个按下的是不是运算符
	int pd=0;
	//识别用
	Listener lis;
	String text;
	String c;
	public void actionPerformed(ActionEvent e) {
		text=e.getActionCommand();
		for(;;)
		{
			LcalShow.setText(num+text);
			if(text.equals("."))
			{
				num=LcalShow.getText();
				break;
			}
			
			if(text.equals("="))
			{
				num2=num;
				float num11=Float.parseFloat(num1);		
				float num22=Float.parseFloat(num2);
				if(fuhao.equals("+"))  j=num11+num22;
				if(fuhao.equals("-"))  j=num11-num22;
				if(fuhao.equals("*"))  j=num11*num22;
				if(fuhao.equals("/"))  j=num11/num22;
				String jj=j+"";
				LcalShow.setText(jj);
				break;
				
			}
			if(text.equals("+")||text.equals("-")||text.equals("*")||text.equals("/"))
			{
				pd++;
				if(pd==1)
				{
					f++;
					if(f>1)
					{
						num2=num;
						float num11=Float.parseFloat(num1);		
						float num22=Float.parseFloat(num2);
						if(fuhao.equals("+"))  j=num11+num22;
						if(fuhao.equals("-"))  j=num11-num22;
						if(fuhao.equals("*"))  j=num11*num22;
						if(fuhao.equals("/"))  j=num11/num22;
						String jj=j+"";
						num=jj;
						LcalShow.setText(jj);
						
					}
					num1=num;
					num="";
					
					fuhao=text;
					break;
				}
				else if(pd>1) 
				{
					fuhao=e.getActionCommand();
					break;
				}
				
				
			}
			if(text.equals("AC"))
			{
				pd=0;
				num="";
				num1="";
				num2="";
				LcalShow.setText(num);
				break;
			}
		}
	}

}
