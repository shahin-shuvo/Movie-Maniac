
package signup_signin.database;

import IP.IPAdress;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import signup_signin.model.User;
//?useSSL=false or false
public class database_connector implements DC{
    private Connection connection;
     public static String ip= IPAdress.ip;
    @Override
    public boolean insert(User user) {
        try {
            String query = "INSERT INTO user values('"+user.getFirstname()+"','"+user.getLastname()+"','"+user.getUsername()+"','"+user.getMail()+"','"+user.getPassword()+"')";
            Statement statement = this.connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public User getUser(String username, String password) {
        try {
            String query = "SELECT * FROM user where username = '"+username+"'and password = '"+password+"'";
            PreparedStatement ps = this.connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            User user = null ;
            if(rs.next())
            {
                user = new User();
                user.setFirstname(rs.getString("firstname"));
                user.setLastname(rs.getString("lastname"));
                user.setUsername(rs.getString("username"));
                user.setMail(rs.getString("mail"));
                user.setPassword(rs.getString("password"));
            }
            ps.close();
            rs.close();
            return user;
            
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public void openConnection()
    {
        try
        {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://"+ip+"/database_1?autoReconnect=true&useSSL=false";
            connection = (Connection) DriverManager.getConnection(url,"root","$huvo91");
           // System.out.println("Connected to database");
        }
        catch(Exception e)
        {
            //JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println(e);
        }
    }  
}
