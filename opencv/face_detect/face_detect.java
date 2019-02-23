package face_detect;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import org.bytedeco.javacpp.opencv_core.Mat;
import org.bytedeco.javacpp.opencv_core.Rect;
import org.bytedeco.javacpp.opencv_core.RectVector;
import org.bytedeco.javacpp.opencv_core.Scalar;
import org.bytedeco.javacv.CanvasFrame;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber.Exception;
import org.bytedeco.javacv.OpenCVFrameGrabber;
import org.opencv.imgproc.Imgproc;
import org.bytedeco.javacpp.opencv_objdetect.CascadeClassifier;
import static org.bytedeco.javacpp.opencv_imgproc.*;//包含方法cvtColor

import java.awt.Graphics;
import java.awt.Image;

import org.bytedeco.javacv.OpenCVFrameConverter;//包含converter

public class face_detect {

	/**
	 * OpenCVFrameConverter.ToIplImage可以用于将Frame转
	 * 换为Mat和IplImage，Mat和IplImage转为Frame
	 * Mat和IplImage之间的转换可以使用opeoCV库中提供的功能
	 */
	static OpenCVFrameConverter.ToIplImage converter = new OpenCVFrameConverter.ToIplImage();
	Frame videoframe=null;
	Mat src=null;
//	static JFrame frame1=new JFrame();
//	static Image im=null;
//	static Graphics  g=im.getGraphics();
//	static ImageIcon one=new ImageIcon("1.jpg");
	public static void main(String[] args) {

		face_detect f = new face_detect();
		f.startCamera();
	}
	
	//调用摄像头
	public void startCamera()
	{
//		frame1.setSize(500, 500);
//		frame1.setVisible(true);
//		im=frame1.createImage(frame1.getWidth(), frame1.getHeight());
		//初始化摄像头
		OpenCVFrameGrabber grabber = new OpenCVFrameGrabber(0);
		try {
			//开始获取摄像头数据
			grabber.start();
			//获取摄像头每一帧图像
			videoframe = grabber.grab();
			CanvasFrame canvas = new CanvasFrame("人脸检测");
			canvas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			canvas.setSize(600, 600);
			canvas.setLocationRelativeTo(null);
			canvas.showImage(videoframe);
			while(true)
			{
				if(!canvas.isEnabled())//窗口关闭
				{
					grabber.stop();//停止抓取
					System.exit(0);
				}
				videoframe=grabber.grab();
				src=converter.convertToMat(videoframe);
				detect(src);
				videoframe=converter.convert(src);
				canvas.showImage(videoframe);
				Thread.sleep(50);
			}
		} catch (Exception | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//检测人脸
	@SuppressWarnings("resource")
	public static Mat detect(Mat src)
	{
		CascadeClassifier cascade = new CascadeClassifier("D:\\java学习\\Opencv\\opencv.org\\opencv\\build\\etc\\haarcascades\\haarcascade_frontalface_alt.xml");;
//		Mat gray=new Mat();
//		cvtColor(src,gray,Imgproc.COLOR_BGRA2GRAY);
//		equalizeHist(gray, gray);//均衡化直方图
		RectVector faces = new RectVector();
		cascade.detectMultiScale(src, faces);
		Rect[] rects = faces.get();
	    if (rects != null && rects.length >= 1) {
	      for (Rect rect : rects) {
	        rectangle(src, rect,Scalar.GREEN);
	    	//g.drawImage(one.getImage(), rect.x(),rect.y(),rect.width(),rect.height(), null);
	      }
	      //frame1.getGraphics().drawImage(im, 0, 0, null);
	    }
	    cascade.close();
		return src;
	}

}
