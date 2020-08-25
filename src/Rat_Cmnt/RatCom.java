
package Rat_Cmnt;
import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import signup_signin.Display.DisplayFrame;
import signup_signin.LogIn.Login;



class RatThread1 extends Thread {
    Socket s1;
    DataOutputStream toserver1;
    String data,ip;
    public RatThread1(String ip,String data) {
        this.data=data;
        this.ip=ip;
        start();
        
    }
    
    @Override
    public void run() {
        try {
            s1=new Socket(ip,4000);
            toserver1=new DataOutputStream(s1.getOutputStream());
            toserver1.writeUTF(data);
        } catch (IOException ex) {
            Logger.getLogger(RatThread1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

class RatThread2 extends Thread {
    Socket s2;
    DataOutputStream toserver2;
    String ip;
    String data;
    public RatThread2(String ip,String data) {
        this.data=data;
        this.ip=ip;
        start();
    }
    
    @Override
    public void run() {
         try {
            s2=new Socket(ip,3000);
            toserver2=new DataOutputStream(s2.getOutputStream());
            toserver2.writeUTF(data);
        } catch (IOException ex) {
            Logger.getLogger(RatThread1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

class RatThread3 extends Thread {
    Socket s3;
    DataOutputStream toserver3;
    String ip;
    String name;
    public RatThread3(String ip,String name) {
        this.name=name;
        this.ip=ip;
        start();
    }
    
    @Override
    public void run() {
         try {
            s3=new Socket(ip,2500);
            toserver3=new DataOutputStream(s3.getOutputStream());
            toserver3.writeUTF(name);
        } catch (IOException ex) {
            Logger.getLogger(RatThread1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
class RatThread4 extends Thread {
    Socket s4;
    DataOutputStream toserver4;
    String ip;
    String name;
    public RatThread4(String ip,String name) {
        this.name=name;
        this.ip=ip;
        start();
    }
    
    @Override
    public void run() {
         try {
            s4=new Socket(ip,3500);
            toserver4=new DataOutputStream(s4.getOutputStream());
            toserver4.writeUTF(name);
        } catch (IOException ex) {
            Logger.getLogger(RatThread1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
class RatThread5 extends Thread {
    Socket s5;
    DataOutputStream toserver5;
    String ip;
    String name;
    public RatThread5(String ip,String name) {
        this.name=name;
        this.ip=ip;
        start();
    }
    
    @Override
    public void run() {
         try {
            s5=new Socket(ip,4500);
            toserver5=new DataOutputStream(s5.getOutputStream());
            toserver5.writeUTF(name);
        } catch (IOException ex) {
            Logger.getLogger(RatThread1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
class RatThread6 extends Thread {
    Socket s6;
    DataOutputStream toserver6;
    String ip;
    String name;
    public RatThread6(String ip,String name) {
        this.name=name;
        this.ip=ip;
        start();
    }
    
    @Override
    public void run() {
         try {
            s6=new Socket(ip,5000);
            toserver6=new DataOutputStream(s6.getOutputStream());
            toserver6.writeUTF(name);
        } catch (IOException ex) {
            Logger.getLogger(RatThread1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
public class RatCom extends javax.swing.JFrame {
    public static String a,b,c,d,e,f;
    
    
    public String as;

    public RatCom(String s) {
        initComponents();
        this.setVisible(true);
        setLocationRelativeTo(null);
        as=s;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        rr = new javax.swing.JSlider();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Engravers MT", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 255, 255));
        jLabel1.setText("Rating :");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 138, 100, 42));

        jLabel2.setFont(new java.awt.Font("Engravers MT", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 255, 255));
        jLabel2.setText("Comment: ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 242, -1, 36));
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(243, 238, 238, 46));

        jButton1.setBackground(new java.awt.Color(153, 153, 255));
        jButton1.setFont(new java.awt.Font("Engravers MT", 1, 14)); // NOI18N
        jButton1.setText("submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(352, 373, 129, 50));

        jLabel3.setFont(new java.awt.Font("Engravers MT", 3, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("give your review");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 67, 422, 37));

        rr.setBackground(new java.awt.Color(0, 102, 102));
        rr.setForeground(new java.awt.Color(255, 255, 255));
        rr.setMajorTickSpacing(1);
        rr.setMaximum(10);
        rr.setPaintLabels(true);
        rr.setPaintTicks(true);
        rr.setValue(5);
        rr.setDoubleBuffered(true);
        rr.setFocusCycleRoot(true);
        getContentPane().add(rr, new org.netbeans.lib.awtextra.AbsoluteConstraints(243, 138, 238, 50));

        jButton2.setFont(new java.awt.Font("Engravers MT", 1, 14)); // NOI18N
        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 100, 50));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rat_Cmnt/rating.jpg"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int ddd = rr.getValue();
        a= Integer.toString(ddd);
        b=jTextField2.getText();
        c = Login.name;
        d = DisplayFrame.this_movie;
        e = DisplayFrame.crnt_rating;
        f= DisplayFrame.table;
        
        Double dd = Double.parseDouble(a);
        if(dd>=0 && dd<=10)
        {
        RatThread1 r1=new RatThread1(as,a);
        RatThread2 r2=new RatThread2(as,b);
        RatThread3 r3=new RatThread3(as,c);
        RatThread4 r4=new RatThread4(as,d);
        RatThread5 r5=new RatThread5(as,e);
        RatThread6 r6=new RatThread6(as,f);
        
        }
        else 
        {
            JOptionPane.showMessageDialog(null,"Your rating range should between 0 to 10","",JOptionPane.WARNING_MESSAGE);
            new RatCom(client.ipsocket);
            this.hide();
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.hide();
    }//GEN-LAST:event_jButton2ActionPerformed

    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JSlider rr;
    // End of variables declaration//GEN-END:variables
}
