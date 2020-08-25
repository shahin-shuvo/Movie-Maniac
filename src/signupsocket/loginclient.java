
package signupsocket;


import IP.IPAdress;
import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class loginclient extends Thread {
    public static boolean bool1=false;
    Socket s;
    DataInputStream in;
    DataOutputStream out;
    JTextField j;
    public static String ipsocket = "172.16.13.221";
    public loginclient(Socket s,DataInputStream in,DataOutputStream out) {
        this.s=s;
        this.in=in;
        this.out=out;
        this.j=j;
        start();
    }

    public loginclient() {
          clientmethod();
    }
    
    @Override
    public void run()
    {
          
        try {
            in = new DataInputStream(s.getInputStream());
            out=new DataOutputStream(s.getOutputStream());
           
            out.writeUTF(ipsocket);  
        } catch (IOException ex) {
            Logger.getLogger(loginclient.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
           
            try {
                String check=in.readUTF();
                if(check.equals("Valid")) {
                    bool1=true;
                }
                in.close();
            } catch (IOException ex) {
                Logger.getLogger(loginclient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    void clientmethod()
{
        try {
            System.out.println(ipsocket);
            Socket s = new Socket(ipsocket, 4444);
            DataInputStream inclient = new DataInputStream(s.getInputStream());
            DataOutputStream outclient = new DataOutputStream(s.getOutputStream());
           
            outclient.writeUTF(ipsocket);
            loginclient t1 = new loginclient(s, inclient, outclient);//Calling Thread
            t1.join();
            if (loginclient.bool1) {
                
                new signupform(ipsocket);
               
            }
            else {JOptionPane.showMessageDialog(null,loginclient.bool1 );}
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "This port is not available");
        } catch (InterruptedException e) {

        }
       
}
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new loginclient();
                
            }
        });
    }

    
     
}



    



