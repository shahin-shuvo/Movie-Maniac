
package signup_signin.Display;

import IP.IPAdress;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.table.AbstractTableModel;


public class Cmnt_Rating extends javax.swing.JFrame {
     public static String ip= IPAdress.ip;
    public Cmnt_Rating() {
        initComponents();
        setLocationRelativeTo(null);
        populateJTable();
    }
    public String searchQuery;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        table_name = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 65, 500, 402));

        table_name.setFont(new java.awt.Font("Engravers MT", 1, 14)); // NOI18N
        table_name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(table_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 21, 450, 38));

        back.setBackground(new java.awt.Color(62, 55, 55));
        back.setFont(new java.awt.Font("Engravers MT", 0, 12)); // NOI18N
        back.setForeground(new java.awt.Color(255, 255, 255));
        back.setText("BACK");
        back.setActionCommand("");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        jPanel1.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(516, 454, -1, 38));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/signup_signin/Display/rating_cmnt.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        dispose();
    }//GEN-LAST:event_backActionPerformed

   
    public static void main(String args[]) {
     
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cmnt_Rating().setVisible(true);
            }
        });
    }
    
    public Connection openConnection()
    {
        Connection connection = null;
        try
        {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://"+ip+"/movie?autoReconnect=true&useSSL=false";
           // String url = "jdbc:mysql://localhost/movie?autoReconnect=true&useSSL=false";
            connection = (Connection) DriverManager.getConnection(url,"root","$huvo91");
            //System.out.println("Connected to database");
        }
        catch(Exception e)
        {
        }
        
        return connection;
    }  
    
     public ArrayList<User_data> ListUsers()
    {
        ArrayList<User_data> usersList = new ArrayList<User_data>();
        
        Statement st;
        ResultSet rs;
        String string = DisplayFrame.this_movie.toLowerCase();
        String movie = string.replaceAll("\\s+","");
        
        try{
            Connection con = openConnection();
            st = con.createStatement();
            searchQuery = "SELECT * FROM "+movie;
            rs = st.executeQuery(searchQuery);
            
            User_data ud; 
            
            while(rs.next())
            {
                ud = new User_data(
                                 rs.getString("name"),
                                 rs.getString("rating"),
                                 rs.getString("comment")
                                );
                usersList.add(ud);
            }
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        return usersList;
    }
     
     
    public class TheModel extends AbstractTableModel {

    private String[] columns;
    private Object[][] rows;
    
    public TheModel(){}
    
    public TheModel(Object[][] data, String[] columnName){
    
        this.rows = data;
        this.columns = columnName;
    }

    
    public Class getColumnClass(int column){
            return getValueAt(0,column).getClass();

    }
    
    
    public int getRowCount() {
     return this.rows.length;
    }

    public int getColumnCount() {
     return this.columns.length;
    }

    
    public Object getValueAt(int rowIndex, int columnIndex) {
    
    return this.rows[rowIndex][columnIndex];
    }
    public String getColumnName(int col){
        return this.columns[col];
    }


}
    
    public void populateJTable(){
        table_name.setText("''"+DisplayFrame.this_movie+"''"+"  Public Review");
        ArrayList<User_data> list = ListUsers();
        String[] columnName = {"User Name","Rating","Comment"};
        Object[][] rows = new Object[list.size()][3];
        for(int i = 0; i < list.size(); i++){
            rows[i][0] = list.get(i).getName();
            rows[i][1] = list.get(i).getRating();
            rows[i][2] = list.get(i).getComment();
        }
       
        TheModel model = new TheModel(rows, columnName);
        jTable1.setModel(model);
        jTable1.setRowHeight(80);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(80);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(60);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(360);
        }
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel table_name;
    // End of variables declaration//GEN-END:variables
}
