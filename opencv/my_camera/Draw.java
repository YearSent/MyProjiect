package camera01;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import org.bytedeco.javacpp.indexer.UByteIndexer;

public class Draw {

	JFrame frame;
	Graphics g;
	ImageIcon zero,one;
	public Draw()
	{
		frame=new JFrame();
		frame.setSize(600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		g=frame.getGraphics();
		zero=new ImageIcon("0.jpg");
		one=new ImageIcon("1.jpg");
	}
	public void draw()
	{
		Image im = frame.createImage(frame.getWidth(), frame.getHeight());
		g=im.getGraphics();
		int[][] picture=getImagePixel("black.jpg");
		for(int j=0;j<picture[0].length;j+=8)
		{
			for(int i=0;i<picture.length;i+=8)
			{
				if(picture[i][j]==-1)
				{
					g.drawImage(zero.getImage(), i*1, j*1, 8, 8,null);
				}
				if(picture[i][j]==-16777216)
				{
					g.drawImage(one.getImage(), i*1, j*1, 8, 8,null);
					//indexer.put(i, j, picturechannel, 255);
				}
				//改变颜色
				//indexer.put(i, j, picturechannel, 255);
			}
		}
		frame.getGraphics().drawImage(im, 0, 0, null);
	}
	
	/**
	 * 将一张图片转化成一个int型的二维数组
	 * @param image 图片文件名
	 * @return 转化后的二维数组
	 */
	public int[][]  getImagePixel(String image) {
		try{
	        File file = new File(image);  
	         BufferedImage bi= ImageIO.read(file);   
	        int w = bi.getWidth();  
	        int h = bi.getHeight(); 
	        int[][]  imIndex=new int[w][h];
	        //System.out.println("w=" + w + "  h=" + h ); 
	        for (int i = 0; i < w; i++) {  
	            for (int j = 0; j < h; j++) {  
	            	int pixel = bi.getRGB(i, j); //i,j位置的Color值
	            	imIndex[i][j]=pixel;//输出每一个像素点的color
	            }  
	        }  
	        return imIndex;
		}catch(Exception ef){
			return null;
		} 
	}
}
