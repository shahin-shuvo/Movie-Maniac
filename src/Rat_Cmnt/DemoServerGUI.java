
package Rat_Cmnt;

import java.awt.HeadlessException;
import java.net.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import static signup_signin.Display.Rating.ip;


public class DemoServerGUI extends javax.swing.JFrame {

    static String str;
    Socket s2;
    ServerSocket ss;
    ServerSocket rat1;
    ServerSocket rat2;
    ServerSocket rat3;
    ServerSocket rat4;
    ServerSocket rat5;
    ServerSocket rat6;
    Socket rat1socket;
    Socket rat2socket;
    Socket rat3socket;
    Socket rat4socket;
    Socket rat5socket;
    Socket rat6socket;
    String rating;
    String comment;
    String name;
    String movie_name;
    String crnt_rat;
    String table;
    
    public DemoServerGUI() {
        try {
            ss = new ServerSocket(5555);
        } catch (IOException ex) {
            Logger.getLogger(DemoServerGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        initComponents();
        activateServer();
        setLocationRelativeTo(null);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Engravers MT", 3, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("click update to add");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 75, 303, 30));

        jButton2.setFont(new java.awt.Font("Engravers MT", 1, 14)); // NOI18N
        jButton2.setText("update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(257, 250, 120, 48));

        jLabel1.setFont(new java.awt.Font("Engravers MT", 3, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(" user review");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(193, 111, 250, 29));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rat_Cmnt/confirm1.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 135, 420));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rat_Cmnt/confirm2.jpg"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 380, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents
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
                    rat1=new ServerSocket(4000);
                    rat1socket=rat1.accept();
                    DataInputStream fromrat1=new DataInputStream(rat1socket.getInputStream());
                    rating=fromrat1.readUTF();
                    rat2=new ServerSocket(3000);
                    rat2socket=rat2.accept();
                    DataInputStream fromrat2=new DataInputStream(rat2socket.getInputStream());
                    comment=fromrat2.readUTF();
                    rat3=new ServerSocket(2500); 
                    rat3socket=rat3.accept();
                    DataInputStream fromrat3=new DataInputStream(rat3socket.getInputStream());
                    name=fromrat3.readUTF();
                    rat4=new ServerSocket(3500);
                    rat4socket=rat4.accept();
                    DataInputStream fromrat4=new DataInputStream(rat4socket.getInputStream());
                    movie_name=fromrat4.readUTF();
                    rat5=new ServerSocket(4500);
                    rat5socket=rat5.accept();
                    DataInputStream fromrat5=new DataInputStream(rat5socket.getInputStream());
                    crnt_rat=fromrat5.readUTF();
                    
                    rat6=new ServerSocket(5000);
                    rat6socket=rat6.accept();
                    DataInputStream fromrat6=new DataInputStream(rat6socket.getInputStream());
                    table=fromrat6.readUTF();
                    System.out.println(rating+" "+comment+" "+name+" "+movie_name+" "+crnt_rat+" "+table);
                    
                } catch (IOException ex) {
                    Logger.getLogger(DemoServerGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try{
               
               
               Double d1 = Double.parseDouble(rating);
               if(d1>0 && d1<=10) {
               Double d2 = Double.parseDouble(crnt_rat);
               Double d3 = (d1+d2)/2;
               Double final_rating = (double)Math.round(d3*10)/10;
               String r  = Double.toString(final_rating);
               
               String url = "jdbc:mysql://"+ip+"/java?autoReconnect=true&useSSL=false";
               //String url = "jdbc:mysql://localhost/java?autoReconnect=true&useSSL=false";
               Connection con = DriverManager.getConnection(url,"root","$huvo91");
               
              
               Statement st = con.createStatement();
              
              
               String sql = "UPDATE "+table+" SET Rating = ? WHERE Name=?"; 
               PreparedStatement ps = con.prepareStatement(sql);
               ps.setString(1, r);
               ps.setString(2,movie_name );
               ps.executeUpdate();
               
              try{          
               String string = movie_name.toLowerCase();
               String movie_nam = string.replaceAll("\\s+","");
               String url2 = "jdbc:mysql://"+ip+"/movie?autoReconnect=true&useSSL=false";
               //String url2 = "jdbc:mysql://localhost/movie?autoReconnect=true&useSSL=false";
               Connection con2 = DriverManager.getConnection(url2,"root","$huvo91");
               String q = "insert into "+movie_nam+"(name,rating,comment) values(?,?,?)";
               PreparedStatement ps2 = con2.prepareStatement(q);
               ps2.setString(1, name);
               ps2.setString(2, rating);
               ps2.setString(3, comment);
               ps2.executeUpdate();
               JOptionPane.showMessageDialog(null, "Data submitted successfully!");
           }   catch(HeadlessException | SQLException ex){
               System.out.println(ex);
               JOptionPane.showMessageDialog(null,ex,"",JOptionPane.WARNING_MESSAGE);
               
           }
               }
               else{
                   JOptionPane.showMessageDialog(null,"Your rating range should between 0 to 10","",JOptionPane.WARNING_MESSAGE);
                   // new Rating(movie_type).setVisible(true);
               }
           }catch(HeadlessException | NumberFormatException | SQLException ex){
               System.out.println(ex);
              JOptionPane.showMessageDialog(null,"Sorry!! You didn't give data or your data was wrong","",JOptionPane.ERROR_MESSAGE);
           }
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DemoServerGUI().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}


