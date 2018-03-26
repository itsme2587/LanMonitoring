/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lanmonitoring;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author Ayush
 */
public class LanMonitoringClientGui extends javax.swing.JFrame {

    /**
     * Creates new form LanMonitoringClientGui
     */
    
    String name;
    PrintWriter pw;
    BufferedReader br;
    Socket s;
    
    public LanMonitoringClientGui() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        textField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Connect To Server");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        textField.setEditable(false);
        textField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(137, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textField)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(textField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(115, 115, 115))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        ChatHandler ch = new ChatHandler();
        ch.start();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void textFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LanMonitoringClientGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LanMonitoringClientGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LanMonitoringClientGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LanMonitoringClientGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LanMonitoringClientGui().setVisible(true);
            }
        });
    }
    
    class ChatHandler extends Thread {

        @Override
        public void run() {
            
            try {
                InetAddress ia = InetAddress.getLocalHost();
                s = new Socket(ia,9875);
                pw = new PrintWriter(s.getOutputStream(),true);
                br = new BufferedReader(new InputStreamReader(s.getInputStream()));
                name = JOptionPane.showInputDialog(null,"Enter A Unique Name","Name Required",JOptionPane.PLAIN_MESSAGE);
                pw.println(name);
                textField.setText("Connected To Server");
                
                while(true) {
                    String str = br.readLine();
                
                    if(str.equals("Message")) {
                        String message = br.readLine();
                        System.out.println(message);
                        JOptionPane.showMessageDialog(null,message,"Message From Server", JOptionPane.WARNING_MESSAGE);
                    }
                    if(str.equals("Screenshot")) {
                        screenShotCapture();
                    }
                    if(str.equals("Command")) {
                        executeCommand();
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
                
            } catch (IOException ex) {
                Logger.getLogger(LanMonitoringClientGui.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   
    }
    
    public void screenShotCapture() {
        try {
            Robot robot = new Robot();
            String format = "jpg";
            Rectangle fullscreen = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()); //Screen To be Captured
            BufferedImage screenshot = robot.createScreenCapture(fullscreen); // This method will return BufferedImage object
            ImageIO.write(screenshot, format, new File("screenshot.jpg"));
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    public void executeCommand() throws IOException {
        ProcessBuilder pb = new ProcessBuilder(br.readLine());
        Process p = pb.start();
        BufferedReader read = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String str;
        while((str = read.readLine()) != null) {
            pw.println(str);
        }
        pw.println("end");
        p.destroy();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JTextField textField;
    // End of variables declaration//GEN-END:variables
}