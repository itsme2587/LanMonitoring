/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lanmonitoring;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Ayush
 */
public class LanMonitoringServerGui extends javax.swing.JFrame {

    ProcessBuilder pb;
    int listIndex;
    DefaultListModel<String> model = new DefaultListModel<String>();
    ArrayList<PrintWriter> printwriters = new ArrayList<PrintWriter>();
    /**
     * Creates new form LanMonitoringServerGui
     */
    public LanMonitoringServerGui() {
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

        jPanel1 = new javax.swing.JPanel();
        usernameTF = new javax.swing.JTextField();
        passwordTF = new javax.swing.JTextField();
        loginBTN = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        clientTF = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        screenshotBTN = new javax.swing.JButton();
        processBTN = new javax.swing.JButton();
        messageBTN = new javax.swing.JButton();
        restartBTN = new javax.swing.JButton();
        shutdownBTN = new javax.swing.JButton();
        livestreamBTN = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        runBTN = new javax.swing.JButton();
        runTF = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        clientLIST = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        outputTA = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LAN MONITORING SERVER");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Login"));

        usernameTF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        usernameTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameTFActionPerformed(evt);
            }
        });

        passwordTF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        passwordTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordTFActionPerformed(evt);
            }
        });

        loginBTN.setText("Login");
        loginBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(passwordTF)
            .addComponent(usernameTF)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 117, Short.MAX_VALUE)
                .addComponent(loginBTN))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(usernameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordTF, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(loginBTN))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Client"));

        clientTF.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(clientTF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(clientTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Actions"));

        screenshotBTN.setText("Take ScreenShot");
        screenshotBTN.setEnabled(false);
        screenshotBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                screenshotBTNActionPerformed(evt);
            }
        });

        processBTN.setText("Process Manager");
        processBTN.setEnabled(false);

        messageBTN.setText("Send Messages");
        messageBTN.setEnabled(false);
        messageBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                messageBTNActionPerformed(evt);
            }
        });

        restartBTN.setText("Restart");
        restartBTN.setEnabled(false);
        restartBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restartBTNActionPerformed(evt);
            }
        });

        shutdownBTN.setText("Shut Down");
        shutdownBTN.setEnabled(false);
        shutdownBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shutdownBTNActionPerformed(evt);
            }
        });

        livestreamBTN.setText("Live Stream");
        livestreamBTN.setEnabled(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(screenshotBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(restartBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(shutdownBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(processBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(messageBTN, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                    .addComponent(livestreamBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(screenshotBTN)
                    .addComponent(processBTN)
                    .addComponent(messageBTN))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(restartBTN)
                    .addComponent(shutdownBTN)
                    .addComponent(livestreamBTN)))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Run Command"));

        runBTN.setText("Run");
        runBTN.setEnabled(false);
        runBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runBTNActionPerformed(evt);
            }
        });

        runTF.setEditable(false);
        runTF.setEnabled(false);
        runTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runTFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(runBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(runTF)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(runTF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(runBTN))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Clients"));

        clientLIST.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clientLISTMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(clientLIST);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        jScrollPane3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Command Output"));

        outputTA.setEditable(false);
        outputTA.setColumns(20);
        outputTA.setRows(5);
        jScrollPane3.setViewportView(outputTA);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usernameTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameTFActionPerformed

    private void messageBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_messageBTNActionPerformed
        String message = JOptionPane.showInputDialog(null,"Enter A Message,JOptionPane",JOptionPane.PLAIN_MESSAGE);
        printwriters.get(listIndex).println("Message");
        printwriters.get(listIndex).println(message);
    }//GEN-LAST:event_messageBTNActionPerformed

    private void screenshotBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_screenshotBTNActionPerformed
        // TODO add your handling code here:
        printwriters.get(listIndex).println("Screenshot");
    }//GEN-LAST:event_screenshotBTNActionPerformed

    private void loginBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBTNActionPerformed
        if(usernameTF.getText().equals("admin") && passwordTF.getText().equals("admin")) {
            clientLIST.setModel(model);
            WaitClient wc = new WaitClient();
            wc.start();
            usernameTF.setText("");
            passwordTF.setText("");
            JOptionPane.showMessageDialog(null,"Server Started Succesfully","Login Succesful", JOptionPane.PLAIN_MESSAGE);
        }
        else {   
            JOptionPane.showMessageDialog(null, "Invalid Combination Of Username And Password","   Invalid Credentials", JOptionPane.WARNING_MESSAGE);
            usernameTF.setText("");
            passwordTF.setText("");
        }
    }//GEN-LAST:event_loginBTNActionPerformed

    private void shutdownBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shutdownBTNActionPerformed
        printwriters.get(listIndex).println("Shutdown");
        printwriters.get(listIndex).println("shutdown -s");
        
    }//GEN-LAST:event_shutdownBTNActionPerformed


    private void clientLISTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clientLISTMouseClicked
        listIndex = (clientLIST.getSelectedIndex());
        panelEnabled(jPanel4);
        panelEnabled(jPanel3);
        runTF.setEditable(true);
        clientTF.setText(model.elementAt(listIndex));
    }//GEN-LAST:event_clientLISTMouseClicked

    private void runTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runTFActionPerformed
        printwriters.get(listIndex).println("Command");
        printwriters.get(listIndex).println(runTF.getText());
        
        
    }//GEN-LAST:event_runTFActionPerformed

    private void restartBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restartBTNActionPerformed
        printwriters.get(listIndex).println("Restart");
        printwriters.get(listIndex).println("shutdown -r");
    }//GEN-LAST:event_restartBTNActionPerformed

    private void passwordTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordTFActionPerformed
        if(usernameTF.getText().equals("admin") && passwordTF.getText().equals("admin")) {
            clientLIST.setModel(model);
            WaitClient wc = new WaitClient();
            wc.start();
            usernameTF.setText("");
            passwordTF.setText("");
            JOptionPane.showMessageDialog(null,"Server Started Succesfully","Login Succesful", JOptionPane.PLAIN_MESSAGE);
        }
        else {   
            JOptionPane.showMessageDialog(null, "Invalid Combination Of Username And Password","   Invalid Credentials", JOptionPane.WARNING_MESSAGE);
            usernameTF.setText("");
            passwordTF.setText("");
        }

    }//GEN-LAST:event_passwordTFActionPerformed

    private void runBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runBTNActionPerformed
        printwriters.get(listIndex).println("Command");
        printwriters.get(listIndex).println(runTF.getText());
    }//GEN-LAST:event_runBTNActionPerformed

    public void panelEnabled(JPanel panel) {
        Component[] array = panel.getComponents();
        for(Component c : array) {
            c.setEnabled(true);
        }
    }
   
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
            java.util.logging.Logger.getLogger(LanMonitoringServerGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LanMonitoringServerGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LanMonitoringServerGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LanMonitoringServerGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LanMonitoringServerGui().setVisible(true);
            }
        });
    }
    
    class WaitClient extends Thread {

        @Override
        public void run() {
            try {
                ServerSocket ss = new ServerSocket(9875);
                while(true) {
                    Socket s = ss.accept();
                    ClientHandler ch = new ClientHandler(s);
                    ch.start();
                }
            }
            catch (IOException ex) {
                Logger.getLogger(LanMonitoringServerGui.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }
    
    class ClientHandler extends Thread {
        
        Socket s;
        
        public ClientHandler(Socket s) {
            this.s = s;
        }

        @Override
        public void run() {
            try {
                PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
                BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
                String name = br.readLine();
                model.addElement(name);
                printwriters.add(pw);
                while(true) {
                    
                    String action = br.readLine();
                    
                    if(action.equals("Command")) {
                        String str = br.readLine();
                        while(!str.equals("end")) {
                            outputTA.append(str + "\n");
                            str = br.readLine();
                        }
                    }
                    
                    if(action.equals("Screenshot")) {
                        int size = Integer.parseInt(br.readLine());
                        byte[] byteArray = new byte[size];
                        int bytesRead = 0;
                        int current = 0;
                        InputStream is = s.getInputStream();
                        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd-HHmmss");
                        Date date = new Date();
                        FileOutputStream fos = new FileOutputStream("C:\\Users\\Ayush\\Screenshot\\" + dateFormat.format(date) + ".jpg");
                        BufferedOutputStream bos = new BufferedOutputStream(fos);
                        bytesRead = is.read(byteArray,0,size);
                        current = bytesRead;
                        System.out.println(bytesRead);
                        while(current < size) {
                            bytesRead = is.read(byteArray,current,(size - current));
                            current = current + bytesRead; 
                            System.out.println(current);
                        }
                        bos.write(byteArray,0,current);//writing byteArray to file
                        bos.flush();
                        System.out.println("File downloaded(size: " + current +" bytes read)");
                        bos.close();
                        fos.close();
                        
                    }
                    
                }
            } catch (IOException ex) {
                Logger.getLogger(LanMonitoringServerGui.class.getName()).log(Level.SEVERE, null, ex);
            }
                
//                BufferedImage screenshot = ImageIO.read(ImageIO.createImageInputStream(s.getInputStream()));
//                FileOutputStream ssfile = new FileOutputStream("image.jpg");
//                ImageIO.write(screenshot,"jpg",ssfile);
                
        }
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList clientLIST;
    private javax.swing.JTextField clientTF;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton livestreamBTN;
    private javax.swing.JButton loginBTN;
    private javax.swing.JButton messageBTN;
    private javax.swing.JTextArea outputTA;
    private javax.swing.JTextField passwordTF;
    private javax.swing.JButton processBTN;
    private javax.swing.JButton restartBTN;
    private javax.swing.JButton runBTN;
    private javax.swing.JTextField runTF;
    private javax.swing.JButton screenshotBTN;
    private javax.swing.JButton shutdownBTN;
    private javax.swing.JTextField usernameTF;
    // End of variables declaration//GEN-END:variables
}
