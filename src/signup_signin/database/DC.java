
package signup_signin.database;

import signup_signin.model.User;

public interface DC {
    boolean insert(User user);
    User getUser(String UserName,String Password);
}
