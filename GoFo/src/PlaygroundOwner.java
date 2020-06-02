import java.util.ArrayList;
import java.util.Scanner;

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

    // methods
    public  void createProfile(){
           this.location= new Address();
           location.createAddress();
           System.out.println("Enter your mobile number: ");
           Scanner scanner = new Scanner(System.in);
           this.mobile = scanner.nextInt();
           scanner.close();
    }
    public void addPlayground(){
           Playground playground = new Playground();
           playground.fill();
           playground.setApproved(false);
           this.playgrounds.add(playground);
           Administrator.pendingPlaygrounds.add(playground);

    }
    public void updatePlayground(){
           for (int i=0; i<playgrounds.size() ;i++){
               System.out.println(i+1+"- "+playgrounds.get(i));
           }
           System.out.println("=============================================");
           System.out.println("enter the number of the playground you want to edit ");
           Scanner scanner = new Scanner(System.in);
           String choice = scanner.nextLine();
           try {
               int index = Integer.parseInt(choice);
               if (index < 0 || index >= playgrounds.size() ){
                   throw  new NumberFormatException ();
               }
               else{
                   playgrounds.get(index).fill();
               }
           }
           catch (NumberFormatException e){
               System.out.println("Invalid choice press y to retry");
               choice= scanner.next();
               if (choice.equalsIgnoreCase("Y")){
                   updatePlayground();
               }
           }
           scanner.close();

    }
    public void viewBookings (){
           for (int i=0; i<playgrounds.size(); i++){
               ArrayList<Booking>bookings=playgrounds.get(i).getBookings();
               for (int j=0; j<bookings.size();j++ ){
                   System.out.print(bookings.get(j));
               }
           }
    }
    public void refreshPlayground( Playground updatedPlayground ){
           for (int i=0; i<playgrounds.size() ;i++){
               if (playgrounds.get(i).getName()== updatedPlayground.getName()){
                   playgrounds.set(i,updatedPlayground) ;
               }

           }

    }
    public void deletePlayground(String name ){
            for (int i=0; i<playgrounds.size(); i++){
                if (playgrounds.get(i).getName() == name){
                    playgrounds.remove(i);
                }
            }
    }
    public  void addNotification (String notification){
           notifications.add(notification);
    }
    public void mainMenu(){
           System.out.print("1-Create Profile ");
           System.out.print("2-Add playground");
           System.out.print("3-Update playground");
           System.out.print("4-View Bookings");
           System.out.print("5-check e wallet status.");

           Scanner scanner = new Scanner(System.in);
           String choice = scanner.next();
           if (choice.equalsIgnoreCase("1")){
               createProfile();
               mainMenu();
           }
           else if (choice.equalsIgnoreCase("2")){
               addPlayground();
               mainMenu();
           }
           else if (choice.equalsIgnoreCase("3")){
               updatePlayground();
               mainMenu();
           }
           else if (choice.equalsIgnoreCase("4")){
               viewBookings();
               mainMenu();
           }
           else if (choice.equalsIgnoreCase("5")){
               System.out.print("Your balance :" + getBalance());
               mainMenu();
           }
           scanner.close();

    }



}
