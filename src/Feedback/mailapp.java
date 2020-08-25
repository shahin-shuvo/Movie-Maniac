
package Feedback;


public class mailapp extends javax.swing.JFrame {
  
    public mailapp() {
        initComponents();
        setLocationRelativeTo(null);
        shuvo.setFocusable(false);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        shuvo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        subject = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        msg = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        send = new javax.swing.JButton();
        userid = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        pas = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        jFormattedTextField1.setText("jFormattedTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        shuvo.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        shuvo.setText("shahinshuvo96@gmail.com");
        getContentPane().add(shuvo, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 130, 267, 43));

        jLabel1.setFont(new java.awt.Font("Engravers MT", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Server Adress");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 90, 185, 31));

        jLabel2.setFont(new java.awt.Font("Engravers MT", 1, 12)); // NOI18N
        jLabel2.setText("Send to:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 130, 90, -1));
        getContentPane().add(subject, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 210, 267, 45));

        jLabel3.setFont(new java.awt.Font("Engravers MT", 1, 12)); // NOI18N
        jLabel3.setText(" subject:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 210, 91, 34));

        msg.setColumns(20);
        msg.setRows(5);
        jScrollPane1.setViewportView(msg);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 270, 267, 184));

        jLabel4.setFont(new java.awt.Font("Engravers MT", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("message:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 270, 97, 25));

        send.setFont(new java.awt.Font("Engravers MT", 1, 14)); // NOI18N
        send.setText("send");
        send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendActionPerformed(evt);
            }
        });
        getContentPane().add(send, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 490, 92, 51));
        getContentPane().add(userid, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 265, 45));

        jLabel5.setFont(new java.awt.Font("Engravers MT", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("give your email adress");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, -1, 30));
        getContentPane().add(pas, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 320, 265, 40));

        jLabel6.setFont(new java.awt.Font("Engravers MT", 1, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("give your password");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, -1, 33));

        jLabel9.setFont(new java.awt.Font("Engravers MT", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("send feedback & request via email");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(264, 10, 440, 50));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Feedback/mail11.jpg"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 570));

        jButton1.setFont(new java.awt.Font("Engravers MT", 1, 14)); // NOI18N
        jButton1.setText("back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(623, 490, 100, 50));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Feedback/mail33.jpg"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 0, 770, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendActionPerformed
                String to = shuvo.getText();
                String subject = this.subject.getText();
                String message =  msg.getText();
                
                String user = userid.getText();
                String pass = pas.getText();

                sendmail.send(to,subject, message, user, pass);
    }//GEN-LAST:event_sendActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mailapp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea msg;
    private javax.swing.JPasswordField pas;
    private javax.swing.JButton send;
    private javax.swing.JTextField shuvo;
    private javax.swing.JTextField subject;
    private javax.swing.JTextField userid;
    // End of variables declaration//GEN-END:variables
}
