
package signup_signin.LogIn;

import Input_data.update_type;
import javax.swing.JOptionPane;
import Feedback.mailapp;
import signup_signin.helper.Controller;
import signup_signin.list.Movie_List;
import signup_signin.model.User;
import signup_signin.model.UserInetraction;
import signupsocket.loginclient;

public class Login extends javax.swing.JFrame implements UserInetraction{
    private final Controller controller;
    public static String name ;
   
    public Login() {
        initComponents();
        setLocationRelativeTo(null);
        this.controller = Controller.getController();
   
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox2 = new javax.swing.JComboBox<>();
        Jlabel1 = new javax.swing.JLabel();
        Jlabel2 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        login = new javax.swing.JButton();
        signup = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        exit = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 51, 51));
        setMinimumSize(new java.awt.Dimension(760, 530));
        getContentPane().setLayout(null);

        Jlabel1.setFont(new java.awt.Font("Engravers MT", 1, 14)); // NOI18N
        Jlabel1.setForeground(new java.awt.Color(255, 255, 255));
        Jlabel1.setText("User Name:");
        getContentPane().add(Jlabel1);
        Jlabel1.setBounds(161, 135, 130, 30);

        Jlabel2.setFont(new java.awt.Font("Engravers MT", 1, 14)); // NOI18N
        Jlabel2.setForeground(new java.awt.Color(255, 255, 255));
        Jlabel2.setText("Password:");
        getContentPane().add(Jlabel2);
        Jlabel2.setBounds(171, 204, 120, 30);
        getContentPane().add(username);
        username.setBounds(351, 136, 206, 31);
        getContentPane().add(password);
        password.setBounds(351, 205, 206, 31);

        login.setBackground(new java.awt.Color(62, 55, 55));
        login.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        login.setForeground(new java.awt.Color(255, 255, 255));
        login.setText("Login");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        getContentPane().add(login);
        login.setBounds(451, 347, 110, 40);

        signup.setBackground(new java.awt.Color(62, 55, 55));
        signup.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        signup.setForeground(new java.awt.Color(255, 255, 255));
        signup.setText("Signup");
        signup.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        signup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupActionPerformed(evt);
            }
        });
        getContentPane().add(signup);
        signup.setBounds(171, 347, 110, 40);

        jComboBox1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "User", "Admin" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(351, 269, 105, 30);

        jLabel1.setFont(new java.awt.Font("Engravers MT", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Login as :");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(180, 266, 120, 31);

        exit.setBackground(new java.awt.Color(62, 55, 55));
        exit.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        exit.setForeground(new java.awt.Color(255, 255, 255));
        exit.setText("EXIT");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        getContentPane().add(exit);
        exit.setBounds(301, 347, 120, 40);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("New User?");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(161, 407, 100, 30);
        getContentPane().add(jLabel5);
        jLabel5.setBounds(130, 20, 240, 0);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/signup_signin/LogIn/66.gif"))); // NOI18N
        getContentPane().add(jButton2);
        jButton2.setBounds(191, 0, 330, 110);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/signup_signin/LogIn/bb.jpg"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(4, 0, 740, 540);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        try{
            name = this.username.getText();
        User user = this.controller.login(this.username.getText(),this.password.getText());
        String val = (String)jComboBox1.getSelectedItem(); 
       
       if(user!= null && val == "User" )
       {
           Movie_List ml =new Movie_List();
           ml.setVisible(true);
           reSetallField();
           
           
       }
       else if(user.getUsername().equals("Shuvo") && user.getPassword().equals("shuvo91") && val.equals("Admin"))
       {
           update_type up = new update_type();
           up.setVisible(true);
       }
       else JOptionPane.showMessageDialog(null,"Please enter correct User name and Password");
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Please enter correct User name and Password");
        }
        this.hide();
    }//GEN-LAST:event_loginActionPerformed

    private void signupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupActionPerformed
//       Signup signup = new Signup(this,true,this);
//       signup.setVisible(true);
         loginclient c = new loginclient();
         c.start();
    }//GEN-LAST:event_signupActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        String val = (String)jComboBox1.getSelectedItem();
       // System.out.println(val);
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitActionPerformed

       

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Jlabel1;
    private javax.swing.JLabel Jlabel2;
    private javax.swing.JButton exit;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton login;
    private javax.swing.JPasswordField password;
    private javax.swing.JButton signup;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables

    @Override
    public boolean Signup(User user) {
        return this.controller.Signup(user);
    }

    private void reSetallField() {
        
        this.username.setText(null);
        this.password.setText(null);
    }
}
 
