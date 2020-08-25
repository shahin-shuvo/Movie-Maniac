
package signup_signin.Display;

public class User_data {
    
    private String name;
    private String rating;
    private String comment;
    
    
    public User_data(String name,String rating,String comment)
    {
        this.name = name;
        this.rating = rating;
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public String getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    
    
}
