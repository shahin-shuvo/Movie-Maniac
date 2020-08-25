
package Rat_Cmnt;

import IP.IPAdress;
import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class client extends Thread {
    public static boolean bool1=false;
    Socket s;
    DataInputStream in;
    DataOutputStream out;
    JTextField j;
    public static String ipsocket = "172.16.13.221";
    public client(Socket s,DataInputStream in,DataOutputStream out) {
        this.s=s;
        this.in=in;
        this.out=out;
        this.j=j;
        start();
    }

    public client() {
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
            Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
           
            try {
                String check=in.readUTF();
                if(check.equals("Valid")) {
                    bool1=true;
                }
                in.close();
            } catch (IOException ex) {
                Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    void clientmethod()
{
      // b = "192.168.0.167";
        try {
            System.out.println(ipsocket);
            Socket s = new Socket(ipsocket, 5555);
            DataInputStream inclient = new DataInputStream(s.getInputStream());
            DataOutputStream outclient = new DataOutputStream(s.getOutputStream());
           
            outclient.writeUTF(ipsocket);
            client t1 = new client(s, inclient, outclient);//Calling Thread
            t1.join();
            if (client.bool1) {
                
                new RatCom(ipsocket);
               
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "This port is not available");
        } catch (InterruptedException e) {

        }
       
}
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new client();
                
            }
        });
    }

    
     
}



    



