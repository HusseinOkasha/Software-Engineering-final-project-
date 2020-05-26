import java.util.ArrayList;

public class PlaygroundOwner {
    // Attributes...
       private int ID;
       private String name ;
       private String password;
       private String email;
       private ArrayList<Playground> playgrounds;
       private double balance;
       private ArrayList<String>notifications;
       private Address location ;
       private int mobile;

     // constructors.
       PlaygroundOwner(int ID, String name , String password , String email , ArrayList<Playground>playgrounds,
                       double balance,ArrayList<String>notifications , Address location , int mobile){
           this.ID=ID;
           this.name= name;
           this.password= password;
           this.email= email;
           this.playgrounds= playgrounds;
           this.balance= balance;
           this.notifications= notifications;
           this.location=location;
           this.mobile= mobile;
       }
       PlaygroundOwner(){
           this.ID=0;
           this.name="";
           this.password="";
           this.email="";
           this.playgrounds= null;
           this.balance= 0;
           this.notifications= null;
           this.location=null;
           this.mobile= 0;

       }

       // setters
    public void setName(String name) {
        this.name = name;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLocation(Address location) {
        this.location = location;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    public void setNotifications(ArrayList<String> notifications) {
        this.notifications = notifications;
    }

    public void setPlaygrounds(ArrayList<Playground> playgrounds) {
        this.playgrounds = playgrounds;
    }

    // getters

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public Address getLocation() {
        return location;
    }

    public ArrayList<Playground> getPlaygrounds() {
        return playgrounds;
    }

    public ArrayList<String> getNotifications() {
        return notifications;
    }

    public int getID() {
        return ID;
    }

    public int getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

}
