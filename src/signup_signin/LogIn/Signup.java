
package signup_signin.LogIn;

import javax.swing.JOptionPane;
import signup_signin.model.User;
import signup_signin.model.UserInetraction;
public class Signup extends javax.swing.JDialog {

    private final UserInetraction listener;

   
    public Signup(java.awt.Frame parent, boolean modal,UserInetraction listener) {
        super(parent, modal);
        this.listener = listener;
        initComponents();
        setLocationRelativeTo(parent);
        setTitle("Signup From");
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        username = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        firstname = new javax.swing.JTextField();
        lastname = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        signup = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        mail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        username1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        username.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("First Name:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 76, 25));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Last Name:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 76, 25));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("User Name:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, 76, 25));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText(" Password:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 360, 76, 25));

        firstname.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(firstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, 206, 27));

        lastname.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(lastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 206, 27));

        password.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 360, 206, 28));

        signup.setBackground(new java.awt.Color(62, 55, 55));
        signup.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        signup.setForeground(new java.awt.Color(255, 255, 255));
        signup.setText("SUBMIT");
        signup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupActionPerformed(evt);
            }
        });
        getContentPane().add(signup, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 400, 90, 40));

        clear.setBackground(new java.awt.Color(255, 255, 255));
        clear.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        clear.setForeground(new java.awt.Color(255, 255, 255));
        clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/signup_signin/LogIn/58efda32b6e0e104053249.gif"))); // NOI18N
        clear.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        getContentPane().add(clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 70, 74));

        mail.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        mail.setText("example@gmail.com");
        mail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mailActionPerformed(evt);
            }
        });
        getContentPane().add(mail, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 310, 206, 27));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("       Email:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 310, 67, 27));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 330, -1));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, -1));

        username1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        username1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                username1ActionPerformed(evt);
            }
        });
        getContentPane().add(username1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, 206, 30));
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 104, -1, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/signup_signin/LogIn/33.gif"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 270, 150));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/signup_signin/LogIn/Resized-56EAY.jpg"))); // NOI18N
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, 150));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/signup_signin/LogIn/Resized-4DXJ3.jpg"))); // NOI18N
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mailActionPerformed

    private void signupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupActionPerformed
        if(signUpIsValid())
        {
            User user = new User();
            user.setFirstname(this.firstname.getText());
            user.setLastname(this.lastname.getText());
            user.setUsername(this.username1.getText());
            user.setMail(this.mail.getText());
            if(this.mail.getText().endsWith("@gmail.com")){
                
            user.setPassword(this.password.getText());
            
            if(this.listener.Signup(user))
            {
                JOptionPane.showMessageDialog(null, "SignUp successful!!!");
                dispose();
            }else{
                JOptionPane.showMessageDialog(null,"Sorry can't signup","Please check your form again!",JOptionPane.ERROR_MESSAGE);
            }
            }
            else {JOptionPane.showMessageDialog(null,"Invalid email adress","",JOptionPane.ERROR_MESSAGE);}
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Any field can't be empty.","Please check your form again!",JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_signupActionPerformed
    }
    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        dispose();
    }//GEN-LAST:event_clearActionPerformed

    private void username1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_username1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_username1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clear;
    private javax.swing.JTextField firstname;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField lastname;
    private javax.swing.JTextField mail;
    private javax.swing.JPasswordField password;
    private javax.swing.JButton signup;
    private javax.swing.JTextField username;
    private javax.swing.JTextField username1;
    // End of variables declaration//GEN-END:variables

    private void reSetallField() {
        this.firstname.setText(null);
        this.lastname.setText(null);
        this.username.setText(null);
        this.mail.setText(null);
        this.password.setText(null);
    }

    private boolean signUpIsValid() {
      return !this.firstname.getText().isEmpty();
    }
}
