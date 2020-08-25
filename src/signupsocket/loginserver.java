
package signupsocket;

import IP.IPAdress;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class loginserver extends javax.swing.JFrame {
    public static String ip = IPAdress.ip;
    static String str;
    Socket s2;
    ServerSocket ss;
    ServerSocket rat1;
    ServerSocket rat2;
    ServerSocket rat3;
    ServerSocket rat4;
    ServerSocket rat5;
    
    Socket rat1socket;
    Socket rat2socket;
    Socket rat3socket;
    Socket rat4socket;
    Socket rat5socket;
    
    String firstname;
    String lastname;
    String username;
    String mail;
    String pass;
    
    
    public loginserver() {
        try {
            ss = new ServerSocket(4444);
        } catch (IOException ex) {
            Logger.getLogger(loginserver.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        initComponents();
        activateServer();
        setLocationRelativeTo(null);
        
    }

             
    public void activateServer()
    {
         boolean bool=false;
        try {
            
            s2 = ss.accept();
            DataInputStream inserver = new DataInputStream(s2.getInputStream());
            DataOutputStream outserver=new DataOutputStream(s2.getOutputStream());;
            str = Inet4Address.getLocalHost().getHostAddress();
            System.out.println(str);
            String k = inserver.readUTF();
            //String a=k;

            if (k.equals(str)) {
                //JOptionPane.showMessageDialog(null, "Received IP address is:" + k);
                bool=true;
                outserver.writeUTF("Valid");
            }
            else {
                outserver.writeUTF("Not Valid");
           }
        } catch (Exception e) {
            System.out.println(e);
        }
        finally {
            if(bool==true) {
                try {
                    rat1=new ServerSocket(7000);
                    rat1socket=rat1.accept();
                    DataInputStream fromrat1=new DataInputStream(rat1socket.getInputStream());
                    firstname=fromrat1.readUTF();
                    
                    rat2=new ServerSocket(8000);
                    rat2socket=rat2.accept();
                    DataInputStream fromrat2=new DataInputStream(rat2socket.getInputStream());
                    lastname=fromrat2.readUTF();
                    
                    rat3=new ServerSocket(8500); 
                    rat3socket=rat3.accept();
                    DataInputStream fromrat3=new DataInputStream(rat3socket.getInputStream());
                    username=fromrat3.readUTF();
                    
                    rat4=new ServerSocket(9000);
                    rat4socket=rat4.accept();
                    DataInputStream fromrat4=new DataInputStream(rat4socket.getInputStream());
                    mail=fromrat4.readUTF();
                    
                    rat5=new ServerSocket(9500);
                    rat5socket=rat5.accept();
                    DataInputStream fromrat5=new DataInputStream(rat5socket.getInputStream());
                    pass=fromrat5.readUTF();
                    
                    
                    System.out.println(firstname+" "+lastname+" "+username+" "+mail+" "+pass);
                    
                } catch (IOException ex) {
                    Logger.getLogger(loginserver.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        
    }
   
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 400));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("Engravers MT", 1, 14)); // NOI18N
        jButton1.setText("update");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 210, 120, 50));

        jLabel1.setFont(new java.awt.Font("Engravers MT", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("update new user profile");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 300, 40));

        jButton2.setFont(new java.awt.Font("Engravers MT", 1, 14)); // NOI18N
        jButton2.setText("back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 340, 110, 50));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/signupsocket/s1.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 0, 510, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/signupsocket/s2.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        try {
            String url = "jdbc:mysql://"+ip+"/database_1?autoReconnect=true&useSSL=false";
            //String url = "jdbc:mysql://localhost/java?autoReconnect=true&useSSL=false";
            Connection con = DriverManager.getConnection(url,"root","$huvo91");
            String q = "insert into user (firstname,lastname,username,mail,password) values(?,?,?,?,?)";
               PreparedStatement ps2 = con.prepareStatement(q);
               ps2.setString(1, firstname);
               ps2.setString(2, lastname);
               ps2.setString(3, username);
               ps2.setString(4, mail);
               ps2.setString(5, pass);
               ps2.executeUpdate();
               JOptionPane.showMessageDialog(null, "Data submitted successfully!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Something error!");
            Logger.getLogger(loginserver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new loginserver().setVisible(true);

            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
