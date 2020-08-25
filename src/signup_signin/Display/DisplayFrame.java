
package signup_signin.Display;

import IP.IPAdress;
import Rat_Cmnt.RatCom;
import Rat_Cmnt.client;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.management.Query;
import javax.swing.ImageIcon;
import signup_signin.Trailer_Show.trailer;
import speech.saytext;

public final class DisplayFrame extends javax.swing.JFrame {
    public static String table;
     public static String ip= IPAdress.ip;
    saytext st = new saytext();
     
    public DisplayFrame(String table) {
        initComponents();
        this.table= table;
        setLocationRelativeTo(null); 
        showItem(pos);
        area.setFocusable(false);
    }
    int pos = 0;
    public static String this_movie;
    public static String crnt_rating;

    public Connection getConnection(){
        Connection conn = null;
        try {
            String url = "jdbc:mysql://"+ip+"/java?useSSL=false";
             //String url = "jdbc:mysql://localhost/java?useSSL=false";
            conn = DriverManager.getConnection(url, "root","$huvo91");
        } catch (SQLException e) {
           Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, e);
        }
        return conn;
    }
    
    public ArrayList<Item> getItemsList()
    {
        try {
            Connection connection = getConnection();
           
            Statement st = connection.createStatement();
            String cmd = "SELECT * FROM "+table;
            ResultSet rs = st.executeQuery(cmd);

            ArrayList<Item> list = new ArrayList<Item>();

            Item item;

            while(rs.next())
            {
               item = new Item(rs.getString("ID"),rs.getString("Name"),
                      rs.getString("Description"),rs.getString("Rating"),rs.getBytes("Image"));
               
               list.add(item);
            }
            return list;

        } catch (SQLException e) {
            return null;
        }
    }
    
    public String getMovie()
    {
        String movie_name = movie.getText();
        return movie_name;
    }
    public void showItem(int index)
    {

        movie.setText(getItemsList().get(index).getName());

        area.setText(getItemsList().get(index).getDescription());
        Double r = Double.parseDouble(getItemsList().get(index).getRating());
        int value = r.intValue();
       
        rating.setValue(value*10);
  
      
        rating2.setText(getItemsList().get(index).getRating()+"/10");
        
        
        
       ImageIcon icon = new ImageIcon(getItemsList().get(index).getImage());

        Image image = icon.getImage().getScaledInstance(img_label.getWidth(), 
                                 img_label.getHeight(), Image.SCALE_SMOOTH);

        img_label.setIcon(new ImageIcon(image));
        crnt_rating = getItemsList().get(index).getRating();
       
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        img_label = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        area = new javax.swing.JTextArea();
        Prev = new javax.swing.JButton();
        First = new javax.swing.JButton();
        Next1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        rating = new javax.swing.JProgressBar();
        rating2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        yes = new javax.swing.JButton();
        review = new javax.swing.JButton();
        back = new javax.swing.JButton();
        trailer = new javax.swing.JButton();
        movie = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        img_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(img_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 20, 230, 340));

        area.setColumns(20);
        area.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        area.setRows(5);
        jScrollPane1.setViewportView(area);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(354, 63, 294, 417));

        Prev.setBackground(new java.awt.Color(62, 55, 55));
        Prev.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Prev.setForeground(new java.awt.Color(255, 255, 255));
        Prev.setText("Prev");
        Prev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrevActionPerformed(evt);
            }
        });
        jPanel1.add(Prev, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 472, 82, 39));

        First.setBackground(new java.awt.Color(62, 55, 55));
        First.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        First.setForeground(new java.awt.Color(255, 255, 255));
        First.setText("First");
        First.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FirstActionPerformed(evt);
            }
        });
        jPanel1.add(First, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 472, 82, 39));

        Next1.setBackground(new java.awt.Color(62, 55, 55));
        Next1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Next1.setForeground(new java.awt.Color(255, 255, 255));
        Next1.setText("Next");
        Next1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Next1ActionPerformed(evt);
            }
        });
        jPanel1.add(Next1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 472, 82, 39));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 530));

        jLabel2.setFont(new java.awt.Font("Algerian", 1, 12)); // NOI18N
        jLabel2.setText("   Rating:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 392, 76, 30));

        rating.setBackground(new java.awt.Color(255, 255, 255));
        rating.setForeground(new java.awt.Color(0, 153, 0));
        rating.setMinimum(1);
        jPanel1.add(rating, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 378, -1, 22));

        rating2.setBackground(new java.awt.Color(0, 153, 153));
        rating2.setFont(new java.awt.Font("Engravers MT", 1, 18)); // NOI18N
        jPanel1.add(rating2, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 406, 146, 33));

        jLabel3.setFont(new java.awt.Font("Engravers MT", 1, 14)); // NOI18N
        jLabel3.setText("Want to give your Rating ?");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 510, -1, -1));

        yes.setBackground(new java.awt.Color(62, 55, 55));
        yes.setFont(new java.awt.Font("Engravers MT", 0, 14)); // NOI18N
        yes.setForeground(new java.awt.Color(255, 255, 255));
        yes.setText("YES");
        yes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yesActionPerformed(evt);
            }
        });
        jPanel1.add(yes, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 500, 85, 40));

        review.setBackground(new java.awt.Color(62, 55, 55));
        review.setFont(new java.awt.Font("Engravers MT", 1, 12)); // NOI18N
        review.setForeground(new java.awt.Color(255, 255, 255));
        review.setText("User Review");
        review.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reviewActionPerformed(evt);
            }
        });
        jPanel1.add(review, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 80, -1, 42));

        back.setBackground(new java.awt.Color(62, 55, 55));
        back.setFont(new java.awt.Font("Engravers MT", 1, 12)); // NOI18N
        back.setForeground(new java.awt.Color(255, 255, 255));
        back.setText("back");
        back.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        back.setMaximumSize(new java.awt.Dimension(69, 27));
        back.setMinimumSize(new java.awt.Dimension(69, 27));
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        jPanel1.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 500, 85, 41));

        trailer.setBackground(new java.awt.Color(62, 55, 55));
        trailer.setFont(new java.awt.Font("Engravers MT", 1, 12)); // NOI18N
        trailer.setForeground(new java.awt.Color(255, 255, 255));
        trailer.setText("Trailer");
        trailer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trailerActionPerformed(evt);
            }
        });
        jPanel1.add(trailer, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 210, -1, 42));

        movie.setFont(new java.awt.Font("Engravers MT", 3, 18)); // NOI18N
        movie.setForeground(new java.awt.Color(255, 255, 255));
        movie.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(movie, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 11, 256, 42));

        jLabel4.setFont(new java.awt.Font("Engravers MT", 1, 10)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Click below to see public review");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 20, 290, 40));

        jLabel5.setFont(new java.awt.Font("Engravers MT", 1, 10)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Click below to see trailer");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 150, 240, 40));
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 560, 980, 50));

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setFont(new java.awt.Font("Engravers MT", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("trivia");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(781, 343, 110, 50));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/signup_signin/Display/11.jpg"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 2, 980, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Next1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Next1ActionPerformed
        pos++;
        if(pos >= getItemsList().size())
        {
            pos = getItemsList().size()-1;
        }
        showItem(pos);
       
    }//GEN-LAST:event_Next1ActionPerformed

    private void FirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FirstActionPerformed
        pos =0;
        showItem(pos);
    }//GEN-LAST:event_FirstActionPerformed

    private void PrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrevActionPerformed
        pos--;
        if(pos < 0)
        {
            pos = 0;
        }
        showItem(pos);
       
    }//GEN-LAST:event_PrevActionPerformed

    private void yesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yesActionPerformed
        this_movie = getMovie();
        //Rating rating = new Rating(table);
        //rating.setVisible(true);
       // DemoClientGUI dg = new DemoClientGUI();
       // dg.setVisible(true);
       client c = new client();
       c.run();
    }//GEN-LAST:event_yesActionPerformed

    private void reviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reviewActionPerformed
       this_movie = getMovie();
       Cmnt_Rating cr = new Cmnt_Rating();
       cr.setVisible(true);
       
    }//GEN-LAST:event_reviewActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        dispose();
    }//GEN-LAST:event_backActionPerformed

    private void trailerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trailerActionPerformed
         String link = null ;
        String nam = movie.getText();
        Connection connection = getConnection();

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM video where name = '"+movie.getText()+"'");
            if(rs.next())
            {
               link = rs.getString("video");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DisplayFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        trailer t = new trailer();
        String[] args = null;
        t.main(args,link);
    }//GEN-LAST:event_trailerActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String text = trivia();
        st.speak(text);
    }//GEN-LAST:event_jButton1ActionPerformed

    String trivia()
    {
        String trivia = null ;
        String nam = movie.getText();
        Connection connection = getConnection();

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM video where name = '"+movie.getText()+"'");
            if(rs.next())
            {
               trivia = rs.getString("trivia");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DisplayFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return trivia;
    }
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DisplayFrame(table).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton First;
    private javax.swing.JButton Next1;
    private javax.swing.JButton Prev;
    private javax.swing.JTextArea area;
    private javax.swing.JButton back;
    private javax.swing.JLabel img_label;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel movie;
    private javax.swing.JProgressBar rating;
    private javax.swing.JLabel rating2;
    private javax.swing.JButton review;
    private javax.swing.JButton trailer;
    private javax.swing.JButton yes;
    // End of variables declaration//GEN-END:variables
}
