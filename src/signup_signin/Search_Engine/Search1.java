
package signup_signin.Search_Engine;

import IP.IPAdress;
import java.awt.HeadlessException;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Search1 extends javax.swing.JFrame {
    public static String table;
     public static String ip= IPAdress.ip;
    public Search1(String table) {
        initComponents();
        this.table = table;
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        area = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        rating = new javax.swing.JLabel();
        ratingbar = new javax.swing.JProgressBar();
        search_text = new javax.swing.JTextField();
        search = new javax.swing.JButton();
        back = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(960, 614));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 230, 340));

        area.setColumns(20);
        area.setRows(5);
        jScrollPane1.setViewportView(area);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 90, 315, 340));

        jLabel2.setFont(new java.awt.Font("Engravers MT", 0, 12)); // NOI18N
        jLabel2.setText("RATING");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 470, 73, 34));

        rating.setFont(new java.awt.Font("Engravers MT", 1, 18)); // NOI18N
        getContentPane().add(rating, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 440, 146, 34));
        getContentPane().add(ratingbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 500, -1, 25));
        getContentPane().add(search_text, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 28, 253, 34));

        search.setBackground(new java.awt.Color(62, 55, 55));
        search.setFont(new java.awt.Font("Engravers MT", 1, 10)); // NOI18N
        search.setForeground(new java.awt.Color(255, 255, 255));
        search.setText("SEarch");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        getContentPane().add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 22, -1, 50));

        back.setBackground(new java.awt.Color(62, 55, 55));
        back.setFont(new java.awt.Font("Engravers MT", 1, 14)); // NOI18N
        back.setForeground(new java.awt.Color(255, 255, 255));
        back.setText("BACK");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(781, 520, 110, 42));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/signup_signin/Search_Engine/99.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 4, 960, 620));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        try{
            String url = "jdbc:mysql://"+ip+"/java?useSSL=false";
          //  String url = "jdbc:mysql://localhost/java?useSSL=false";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection(url,"root","$huvo91");
            System.out.println("yes");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from "+table+" where Name = '"+search_text.getText()+"'");
            if(rs.next()){
                byte[] img = rs.getBytes("Image");

                //Resize The ImageIcon
                ImageIcon image = new ImageIcon(img);
                Image im = image.getImage();
                Image myImg = im.getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(),Image.SCALE_SMOOTH);
                ImageIcon newImage = new ImageIcon(myImg);
                jLabel1.setIcon(newImage);
                area.setText(rs.getString("Description"));
                Double r = Double.parseDouble(rs.getString("Rating"));
                int value = r.intValue();
        
                ratingbar.setValue(value*10);
  
      
                rating.setText(rs.getString("Rating")+"/10");
            }

            else{
                JOptionPane.showMessageDialog(null, "No Movie Found!!");
            }
        }catch(HeadlessException | ClassNotFoundException | IllegalAccessException | InstantiationException | NumberFormatException | SQLException ex){
        }
    }//GEN-LAST:event_searchActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        dispose();
    }//GEN-LAST:event_backActionPerformed

    public static void main(String args[]) {       
        java.awt.EventQueue.invokeLater(() -> {
            new Search1(table).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea area;
    private javax.swing.JButton back;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel rating;
    private javax.swing.JProgressBar ratingbar;
    private javax.swing.JButton search;
    private javax.swing.JTextField search_text;
    // End of variables declaration//GEN-END:variables
}
