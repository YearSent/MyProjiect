package RMI;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
public class SetService {
    public static void main(String[] args) {
    	System.setProperty("java.rmi.server.hostname","192.168.31.17");
        try {
            StudentService studentService=new StudentServiceImpl();
            LocateRegistry.createRegistry(9999);//����˿ں�
            Naming.rebind("rmi://127.0.0.1:9999/StudentService", studentService);
            System.out.println("����������");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("����������123214325");
        }
    }
}
