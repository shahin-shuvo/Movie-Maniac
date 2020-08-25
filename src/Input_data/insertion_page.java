
package Input_data;

import IP.IPAdress;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class insertion_page extends javax.swing.JFrame  {
     String s;
      public static String ip= IPAdress.ip;
    public static String movie_type;
    public insertion_page(String movie_type) {
         initComponents();
         this.movie_type = movie_type;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar2 = new javax.swing.JScrollBar();
        add = new javax.swing.JButton();
        browse1 = new javax.swing.JButton();
        ID = new javax.swing.JTextField();
        Name = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        area = new javax.swing.JTextArea();
        image = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        add.setBackground(new java.awt.Color(102, 102, 102));
        add.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        add.setForeground(new java.awt.Color(255, 255, 255));
        add.setText("Submit");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        getContentPane().add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 430, -1, 40));

        browse1.setBackground(new java.awt.Color(102, 102, 102));
        browse1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        browse1.setForeground(new java.awt.Color(255, 255, 255));
        browse1.setText("Browse");
        browse1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        browse1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browse1ActionPerformed(evt);
            }
        });
        getContentPane().add(browse1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 430, -1, 40));

        ID.setText("ID");
        getContentPane().add(ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 430, 68, 38));

        Name.setText("Name");
        Name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameActionPerformed(evt);
            }
        });
        getContentPane().add(Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(556, 430, 130, 40));

        area.setColumns(20);
        area.setRows(5);
        area.setText("Description");
        jScrollPane1.setViewportView(area);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, 255, 370));

        image.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(image, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 230, 340));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 4, -1, -1));

        jButton1.setBackground(new java.awt.Color(102, 102, 102));
        jButton1.setFont(new java.awt.Font("Engravers MT", 3, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 500, 90, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Input_data/00.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-6, 4, 920, 580));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void NameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NameActionPerformed
    
    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        try{
               String url = "jdbc:mysql://"+ip+"/java?autoReconnect=true&useSSL=false";
               //String url = "jdbc:mysql://localhost/java?autoReconnect=true&useSSL=false";
               Connection con = DriverManager.getConnection(url,"root","$huvo91");
               //System.out.println("connected from insertion page");
               PreparedStatement ps = con.prepareStatement("insert into "+movie_type+"(ID,Name,Description,Rating,Image) values(?,?,?,?,?)");
               System.out.println("Hi");
               InputStream is = new FileInputStream(new File(s));
               ps.setString(1, ID.getText());
               ps.setString(2, Name.getText());
               ps.setString(3, area.getText());
               ps.setString(4,"0");
               ps.setBlob(5,is);
               ps.executeUpdate();
               JOptionPane.showMessageDialog(null, "Data submitted successfully!");
           }catch(Exception ex){
               System.out.println(ex);
               JOptionPane.showMessageDialog(null,"Sorry!! You didn't give data","",JOptionPane.ERROR_MESSAGE);
           }
        reSetallField();
    }//GEN-LAST:event_addActionPerformed

    private void browse1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browse1ActionPerformed
       JFileChooser fileChooser = new JFileChooser();
       //fileChooser.setLocation();
         fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
         FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg","gif","png");
         fileChooser.addChoosableFileFilter(filter);
         int result = fileChooser.showSaveDialog(null);
         if(result == JFileChooser.APPROVE_OPTION){
             File selectedFile = fileChooser.getSelectedFile();
             String path = selectedFile.getAbsolutePath();
             image.setIcon(ResizeImage(path));
             s = path;
              }
         else if(result == JFileChooser.CANCEL_OPTION){
             System.out.println("No Data");
         }
    }//GEN-LAST:event_browse1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed
    
     public ImageIcon ResizeImage(String imgPath){
        ImageIcon MyImage = new ImageIcon(imgPath);
        Image img = MyImage.getImage();
        Image newImage = img.getScaledInstance(image.getWidth(), image.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImage);
        return image;
    }
     
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new insertion_page(movie_type).setVisible(true);
            }
        });
    }
    private void reSetallField() {
        this.Name.setText(null);
        this.ID.setText(null);
        this.area.setText(null);
        this.image.removeAll();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ID;
    private javax.swing.JTextField Name;
    private javax.swing.JButton add;
    private javax.swing.JTextArea area;
    private javax.swing.JButton browse1;
    private javax.swing.JLabel image;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollBar jScrollBar2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
