
package signupsocket;

import IP.IPAdress;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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
            s1=new Socket(ip,7000);
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
            s2=new Socket(ip,8000);
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
            s3=new Socket(ip,8500);
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
            s4=new Socket(ip,9000);
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
            s5=new Socket(ip,9500);
            toserver5=new DataOutputStream(s5.getOutputStream());
            toserver5.writeUTF(name);
        } catch (IOException ex) {
            Logger.getLogger(RatThread1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

public class signupform extends javax.swing.JFrame {

    public static String a,b,c,d,e,f;
    
    
    public String as;

    public signupform(String s) {
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        fn = new javax.swing.JTextField();
        ln = new javax.swing.JTextField();
        un = new javax.swing.JTextField();
        pass = new javax.swing.JPasswordField();
        mail = new javax.swing.JTextField();
        submit = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Engravers MT", 1, 14)); // NOI18N
        jLabel1.setText("first name");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, 134, 30));

        jLabel2.setFont(new java.awt.Font("Engravers MT", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("last name");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, 128, 29));

        jLabel3.setFont(new java.awt.Font("Engravers MT", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("email");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 360, 119, 28));

        jLabel4.setFont(new java.awt.Font("Engravers MT", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("password");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 420, -1, 36));

        jLabel5.setFont(new java.awt.Font("Engravers MT", 1, 14)); // NOI18N
        jLabel5.setText(" username");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 290, 128, 31));

        fn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fnActionPerformed(evt);
            }
        });
        getContentPane().add(fn, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 150, 200, 38));
        getContentPane().add(ln, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 230, 200, 39));
        getContentPane().add(un, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 290, 200, 38));

        pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passActionPerformed(evt);
            }
        });
        getContentPane().add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 420, 200, 39));
        getContentPane().add(mail, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 350, 200, 37));

        submit.setFont(new java.awt.Font("Engravers MT", 1, 14)); // NOI18N
        submit.setText("submit");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });
        getContentPane().add(submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 480, -1, 47));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/signupsocket/58efda32b6e0e104053249.gif"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, -1, 96));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/signupsocket/sf1.gif"))); // NOI18N
        jButton2.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/signupsocket/sf1.gif"))); // NOI18N
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 0, 200, 180));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/signupsocket/sf2.gif"))); // NOI18N
        jButton3.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/signupsocket/sf2.gif"))); // NOI18N
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 480, 130));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/signupsocket/sf3.jpg"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 124, 480, 430));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/signupsocket/sf4.jpg"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 200, 360));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fnActionPerformed

    private void passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passActionPerformed

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        a = fn.getText();
        b = ln.getText();
        c = un.getText();
        d = mail.getText();
        e = pass.getText();
        if(c!=null && d.endsWith("@gmail.com"))
        {
        RatThread1 r1=new RatThread1(as,a);
        RatThread2 r2=new RatThread2(as,b);
        RatThread3 r3=new RatThread3(as,c);
        RatThread4 r4=new RatThread4(as,d);
        RatThread5 r5=new RatThread5(as,e);
        
        
        }
        else 
        {
            JOptionPane.showMessageDialog(null,"Invalid email or empty username","",JOptionPane.WARNING_MESSAGE);
            new signupform(loginclient.ipsocket);
            this.hide();
        }

    }//GEN-LAST:event_submitActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField fn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField ln;
    private javax.swing.JTextField mail;
    private javax.swing.JPasswordField pass;
    private javax.swing.JButton submit;
    private javax.swing.JTextField un;
    // End of variables declaration//GEN-END:variables
}
