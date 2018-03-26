/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lanmonitoring;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author Ayush
 */
public class LanMonitoringClient {
    public static void main(String[] args) {
        try {
            InetAddress ia = InetAddress.getLocalHost();
            Socket s = new Socket(ia,9875);
            PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String name = JOptionPane.showInputDialog(null,"Enter A Unique Name","Name Required",JOptionPane.PLAIN_MESSAGE);
            pw.println(name);
                
            while(true) {
                int count = 1;
                String str = br.readLine();
                
                if(str.equals("Message")) {
                    pw.println("Message");
                    String message = br.readLine();
                    JOptionPane.showMessageDialog(null,message,"Message From Server", JOptionPane.WARNING_MESSAGE);
                }
                if(str.equals("Screenshot")) {
                    pw.println("Screenshot");
                    try {
                        Robot robot = new Robot();
                        String format = "jpg";
                        Rectangle fullscreen = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()); //Screen To be Captured
                        BufferedImage screenshot = robot.createScreenCapture(fullscreen); // This method will return BufferedImage object
                        File f = new File("screenshot.jpg");
                        ImageIO.write(screenshot, format, f);
                        int size = (int)f.length();
                        byte[] byteArray = new byte[size];
                        pw.println(size);
                        FileInputStream fileInputStream = new FileInputStream(f);
                        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
                        bufferedInputStream.read(byteArray,0,size);//copy file in byte array
                        OutputStream out = s.getOutputStream();
                        out.write(byteArray,0,size); // write data from byteArray in outputStream
                        out.flush();
                        bufferedInputStream.close();
                        fileInputStream.close();
                        f.delete();
                    }
                    catch (Exception ex) {
                        System.out.println(ex);
                    }   
                }
                
                if(str.equals("Command")) {
                    pw.println("Command");
                    ProcessBuilder pb = new ProcessBuilder(br.readLine());
                    Process p = pb.start();
                    BufferedReader read = new BufferedReader(new InputStreamReader(p.getInputStream()));
                    String com;
                    while((com = read.readLine()) != null) {
                        pw.println(com);
                    }
                    pw.println("end");
                    p.destroy();
                }
                
                if(str.equals("Restart")) {
//                    ProcessBuilder pb = new ProcessBuilder("cmd.exe","/C","shutdown -r");
//                    Process p = pb.start();
                    Runtime r = Runtime.getRuntime();
                    Process p = r.exec("shutdown -r -t 10");
                    System.exit(0);
                }
                
                if(str.equals("Shutdown")) {
//                    ProcessBuilder pb = new ProcessBuilder("cmd.exe","/C","shutdown -s");
//                    Process  p = pb.start();
                    Runtime r = Runtime.getRuntime();
                    Process p = r.exec("shutdown -s -t 10");
                    System.exit(0);
                }
            }
                
        }
        catch (IOException ex) {
                Logger.getLogger(LanMonitoringClientGui.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
}
 
