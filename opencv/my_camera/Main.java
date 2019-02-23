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
	String path="D:\\javaѧϰ\\11.jpg";
	/**
	 * OpenCVFrameConverter.ToIplImage�������ڽ�Frameת
	 * ��ΪMat��IplImage��Mat��IplImageתΪFrame
	 * Mat��IplImage֮���ת������ʹ��opeoCV�����ṩ�Ĺ���
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
	 * ����ͷ�������Ļ
	 */
	public void openCamera(){
		OpenCVFrameGrabber grabber = new OpenCVFrameGrabber(0);//����OpenCV���� OpenCVFrameGrabber    
		try {
			grabber.start();   //��ʼ��ȡ����ͷ����  
			frame =  new CanvasFrame("����ͷ");//�½�һ������ 
			frame.setCanvasSize(800, 600);//���ô�С
			frame.setLocationRelativeTo(null);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���ùرհ�ť������
			int index=1;
			Draw d=null;
			while(true){  
				videoframe=grabber.grab();
				videomat=converter.convertToMat(videoframe);
			    
				//ͼƬ��ֵ��
				Mat image=videomat;
				Mat gray=new Mat();
		        // �Ҷȴ���
				cvtColor(image,gray,Imgproc.COLOR_RGB2GRAY);
		        // ��ֵ��
				Mat two=new Mat();
				threshold(gray,two,0,255,Imgproc.THRESH_BINARY | Imgproc.THRESH_OTSU); 
				imwrite("black.jpg", two);
				// (���Ӱ棩����ͼƬ������
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
				((CanvasFrame)frame).showImage(videoframe);//��ȡ����ͷͼ�񲢷ŵ���������ʾ�� �����grabber.grab();��һ֡��Ƶͼ��  
				Thread.sleep(50);//50����ˢ��һ��ͼ��  
			}
		} catch (Exception e) {
			System.out.println("����ͷ��ʼ��ʧ��");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}  
	}
}

		
	    
	  
	

