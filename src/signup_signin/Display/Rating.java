
package signup_signin.Display;

import IP.IPAdress;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import signup_signin.LogIn.Login;

public class Rating extends javax.swing.JFrame {
    String s;
    
    
    public static String ip= IPAdress.ip;
    public static String movie_type;
    public Rating(String movie_type) {
        initComponents();
        this.movie_type = movie_type;
        setLocationRelativeTo(null); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        rat = new javax.swing.JTextField();
        submit = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        comment = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Engravers MT", 1, 14)); // NOI18N
        jLabel1.setText("Rating :");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 210, 99, 32));

        rat.setFont(new java.awt.Font("Engravers MT", 0, 14)); // NOI18N
        getContentPane().add(rat, new org.netbeans.lib.awtextra.AbsoluteConstraints(177, 210, 87, 32));

        submit.setBackground(new java.awt.Color(62, 55, 55));
        submit.setFont(new java.awt.Font("Engravers MT", 0, 14)); // NOI18N
        submit.setForeground(new java.awt.Color(255, 255, 255));
        submit.setText("SUBMIT");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });
        getContentPane().add(submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(331, 384, -1, 39));

        jLabel2.setFont(new java.awt.Font("Engravers MT", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("rating should between 0 to 10");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 360, 34));

        jLabel3.setFont(new java.awt.Font("Engravers MT", 1, 12)); // NOI18N
        jLabel3.setText("Comment:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 290, 99, 35));

        comment.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(comment, new org.netbeans.lib.awtextra.AbsoluteConstraints(177, 290, 259, 35));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/signup_signin/Display/ezgif.com-resize.gif"))); // NOI18N
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 305, 133));

        jButton2.setBackground(new java.awt.Color(62, 55, 55));
        jButton2.setFont(new java.awt.Font("Engravers MT", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("BACK");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(221, 384, -1, 39));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/signup_signin/Display/rat2.jpg"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 440));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        try{
               
             //  DisplayFrame df = new DisplayFrame();
               
               Double d1 = Double.parseDouble(rat.getText());
               if(d1>0 && d1<=10) {
               Double d2 = Double.parseDouble(DisplayFrame.crnt_rating);
               Double d3 = (d1+d2)/2;
               Double final_rating = (double)Math.round(d3*10)/10;
               String r  = Double.toString(final_rating);
               
               String url = "jdbc:mysql://"+ip+"/java?autoReconnect=true&useSSL=false";
                //String url = "jdbc:mysql://localhost/java?autoReconnect=true&useSSL=false";
               Connection con = DriverManager.getConnection(url,"root","$huvo91");
               
              // System.out.println("connected from rating page");
               Statement st = con.createStatement();
              
              
               String sql = "UPDATE "+movie_type+" SET Rating = ? WHERE Name=?"; 
               PreparedStatement ps = con.prepareStatement(sql);
               ps.setString(1, r);
               ps.setString(2,DisplayFrame.this_movie );
               ps.executeUpdate();
               
               try{          
               String string = DisplayFrame.this_movie.toLowerCase();
               String movie_name = string.replaceAll("\\s+","");
               String url2 = "jdbc:mysql://"+ip+"/movie?autoReconnect=true&useSSL=false";
               Connection con2 = DriverManager.getConnection(url2,"root","$huvo91");
               String q = "insert into "+movie_name+"(name,rating,comment) values(?,?,?)";
               PreparedStatement ps2 = con2.prepareStatement(q);
               ps2.setString(1, Login.name);
               ps2.setString(2, rat.getText());
               ps2.setString(3, comment.getText());
               ps2.executeUpdate();
               JOptionPane.showMessageDialog(null, "Data submitted successfully!");
           }   catch(HeadlessException | SQLException ex){
               System.out.println(ex);
               JOptionPane.showMessageDialog(null,ex,"",JOptionPane.WARNING_MESSAGE);
               
           }
               }
               else{
                   JOptionPane.showMessageDialog(null,"Your rating range should between 0 to 10","",JOptionPane.WARNING_MESSAGE);
                    new Rating(movie_type).setVisible(true);
               }
           }catch(HeadlessException | NumberFormatException | SQLException ex){
               System.out.println(ex);
              JOptionPane.showMessageDialog(null,"Sorry!! You didn't give data or your data was wrong","",JOptionPane.ERROR_MESSAGE);
           }
        dispose();
    }//GEN-LAST:event_submitActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Rating(movie_type).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField comment;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField rat;
    private javax.swing.JButton submit;
    // End of variables declaration//GEN-END:variables
}
