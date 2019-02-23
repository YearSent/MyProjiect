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
import static org.bytedeco.javacpp.opencv_imgproc.*;//��������cvtColor

import java.awt.Graphics;
import java.awt.Image;

import org.bytedeco.javacv.OpenCVFrameConverter;//����converter

public class face_detect {

	/**
	 * OpenCVFrameConverter.ToIplImage�������ڽ�Frameת
	 * ��ΪMat��IplImage��Mat��IplImageתΪFrame
	 * Mat��IplImage֮���ת������ʹ��opeoCV�����ṩ�Ĺ���
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
	
	//��������ͷ
	public void startCamera()
	{
//		frame1.setSize(500, 500);
//		frame1.setVisible(true);
//		im=frame1.createImage(frame1.getWidth(), frame1.getHeight());
		//��ʼ������ͷ
		OpenCVFrameGrabber grabber = new OpenCVFrameGrabber(0);
		try {
			//��ʼ��ȡ����ͷ����
			grabber.start();
			//��ȡ����ͷÿһ֡ͼ��
			videoframe = grabber.grab();
			CanvasFrame canvas = new CanvasFrame("�������");
			canvas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			canvas.setSize(600, 600);
			canvas.setLocationRelativeTo(null);
			canvas.showImage(videoframe);
			while(true)
			{
				if(!canvas.isEnabled())//���ڹر�
				{
					grabber.stop();//ֹͣץȡ
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
	
	//�������
	@SuppressWarnings("resource")
	public static Mat detect(Mat src)
	{
		CascadeClassifier cascade = new CascadeClassifier("D:\\javaѧϰ\\Opencv\\opencv.org\\opencv\\build\\etc\\haarcascades\\haarcascade_frontalface_alt.xml");;
//		Mat gray=new Mat();
//		cvtColor(src,gray,Imgproc.COLOR_BGRA2GRAY);
//		equalizeHist(gray, gray);//���⻯ֱ��ͼ
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
