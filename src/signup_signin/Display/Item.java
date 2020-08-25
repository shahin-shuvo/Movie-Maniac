
package signup_signin.Display;

public class Item {
    private String ID;
    private String Name;
    private String Description;
    private String Rating;
    private byte[] Image;
    
    public Item(String ID, String Name, String Description,String Rating,  byte[] Image)
    {
        this.ID = ID;
        this.Name = Name;
        this.Description = Description;
        this.Rating = Rating;
        this.Image = Image;
    }

    
    public String getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public String getDescription() {
        return Description;
    }
    public String getRating()
    {
        return Rating;
    }

    public byte[] getImage() {
        return Image;
    }
    
}
