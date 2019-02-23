package camera01;

import org.bytedeco.javacpp.opencv_core.Mat;
import org.bytedeco.javacv.CanvasFrame;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.OpenCVFrameGrabber;
import org.opencv.imgproc.Imgproc;
import static org.bytedeco.javacpp.opencv_imgcodecs.*;
import static org.bytedeco.javacpp.opencv_imgproc.*;
import java.awt.EventQueue;
import static org.bytedeco.javacpp.opencv_imgcodecs.IMREAD_COLOR;
import javax.swing.JFrame;
 
import org.bytedeco.javacv.FrameGrabber.Exception;
import org.bytedeco.javacv.OpenCVFrameConverter;
 
public class Main {
	
	private CanvasFrame frame;
	Frame videoframe=null;
	Mat videomat=null;
	String path="D:\\java学习\\11.jpg";
	/**
	 * OpenCVFrameConverter.ToIplImage可以用于将Frame转
	 * 换为Mat和IplImage，Mat和IplImage转为Frame
	 * Mat和IplImage之间的转换可以使用opeoCV库中提供的功能
	 */
	static OpenCVFrameConverter.ToIplImage converter = new OpenCVFrameConverter.ToIplImage();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Main window = new Main();
		window.openCamera();
	}
 
 
	/**
	 * 摄像头输出到屏幕
	 */
	public void openCamera(){
		OpenCVFrameGrabber grabber = new OpenCVFrameGrabber(0);//创建OpenCV对象 OpenCVFrameGrabber    
		try {
			grabber.start();   //开始获取摄像头数据  
			frame =  new CanvasFrame("摄像头");//新建一个窗口 
			frame.setCanvasSize(800, 600);//设置大小
			frame.setLocationRelativeTo(null);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置关闭按钮起作用
			int index=1;
			Draw d=null;
			while(true){  
				videoframe=grabber.grab();
				videomat=converter.convertToMat(videoframe);
			    
				//图片二值化
				Mat image=videomat;
				Mat gray=new Mat();
		        // 灰度处理
				cvtColor(image,gray,Imgproc.COLOR_RGB2GRAY);
		        // 二值化
				Mat two=new Mat();
				threshold(gray,two,0,255,Imgproc.THRESH_BINARY | Imgproc.THRESH_OTSU); 
				imwrite("black.jpg", two);
				// (复杂版）保存图片到本地
//				BufferedImage bufferedImage = new BufferedImage(two.arrayWidth(),two.arrayHeight(), BufferedImage.TYPE_3BYTE_BGR);
//				WritableRaster raster = bufferedImage.getRaster();
//				DataBufferByte dataBuffer = (DataBufferByte) raster.getDataBuffer();
//				byte[] data = dataBuffer.getData();
//				((ByteBuffer) image.createBuffer()).get(data);
//				try {
//					ImageIO.write(bufferedImage, "jpg", new File(path));
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
				Mat newimage = imread("black.jpg", IMREAD_COLOR);
//				UByteIndexer indexer = newimage.createIndexer();
//				int picturechannel=newimage.channels();
//				int width=newimage.arrayWidth();
//				int height=newimage.arrayHeight();
				if(index==1)
				{
					d=new Draw();
					index++;
				}
				else
					index++;
				if(index%2==0)
					d.draw();
				videoframe=converter.convert(newimage);
				((CanvasFrame)frame).showImage(videoframe);//获取摄像头图像并放到窗口上显示， 这里的grabber.grab();是一帧视频图像  
				Thread.sleep(50);//50毫秒刷新一次图像  
			}
		} catch (Exception e) {
			System.out.println("摄像头初始化失败");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}  
	}
}

		
	    
	  
	

