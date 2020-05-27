import java.util.ArrayList;
import java.util.Scanner;

public class Administrator {
    // Attributes
    private String name ;
    private int ID;
    private String password;
    private String email;
    private static ArrayList<String>notifications=null;
    private static ArrayList<Playground>pendingPlaygrounds=null;

    // constructors
    public Administrator() {
        name="";
        ID=0;
        password="";
        email="";
    }
    public Administrator(String name , int ID , String password , String email){
        this.name=name;
        this.ID=ID;
        this.email=email;
        this.password=password;
    }

    // setters...
    public void setName(String name) {
        this.name = name;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void addNotification(String notification){
        if (notification!=""){
            this.notifications.add(notification);
        }
    }

    // getters...
    public String getName(){
        return name;
    }
    public int getID(){
        return ID;
    }
    public String getPassword(){
        return this.password;
    }
    public String getEmail(){
        return  this.email;
    }
    public ArrayList<String> getNotifications(){
        return this.notifications;
    }

    // methods...
    void approvePlayground(Playground pendingPlayground ){
        System.out.print(pendingPlayground);
        System.out.print("===================");
        System.out.print("Is ok...? y / n");
        Scanner scanner = new Scanner(System.in);
        String choice= scanner.next();
        if (choice.equalsIgnoreCase("Y")){
            pendingPlayground.setApproved(true);
        }
        else {
            pendingPlayground.setApproved(false);
        }

    }
    void suspendPlayground(Playground playground ){
        playground.setSuspended(true);
    }
    void activatePlayground(Playground playground){
        playground.setSuspended(false);
    }





}
