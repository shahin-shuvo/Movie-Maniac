
package signup_signin.helper;

import signup_signin.database.database_connector;
import signup_signin.model.User;
import signup_signin.model.UserInetraction;

public class Controller implements UserInetraction{
    private static Controller controller;
    private final database_connector dc;
    private Controller()
    {
          this.dc = new database_connector() ;
          this.dc.openConnection();
    }
    public static Controller getController()
    {
        if(controller == null)
        {
            controller = new Controller();
        }
        return controller;
    }

    @Override
    public boolean Signup(User user) {
       return this.dc.insert(user);
    }

    public User login(String username, String password) {
        return this.dc.getUser(username,password);
    }

    
}
