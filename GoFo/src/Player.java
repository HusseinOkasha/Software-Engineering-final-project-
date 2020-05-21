import java.util.ArrayList;

public class Player {
    // Attributes....
    private String name;
    private int ID;
    private String Password;
    private String email;
    private ArrayList<String> notifications ;
    private Team team ;
    private ArrayList<Booking> bookings;
    private double balance;
    private Database database; // new attribute.....
    //methods..
    public Player (String name , int ID , String password , String email , ArrayList<String>notifications , Team team , ArrayList<Booking> bookings, double balance ){
            this.name=name;
            this.ID=ID;
            this.Password= password;
            this.email=email;
            this.notifications=notifications;
            this.team=team;
            this.bookings=bookings;
            this.balance= balance;
            database.AddPlayer(this);

    }
    //setters...

    public void setName(String name) {
        this.name = name;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setPassword(String password) {
        Password = password;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void addNotification(String notification){
        if (notification!=""){
            this.notifications.add(notification);
        }
    }
    public void createTeam(){
       //  this.team.addPlayer();
    }
    public void bookPlayground (){

    }
    public void setBalance(double balance){
        this.balance= balance;
    }
    public String getName(){
        return name;
    }
    public int getID(){
        return ID;
    }
    public String getPassword(){
        return this.Password;
    }
    public String getEmail(){
        return  this.email;
    }
    public ArrayList<String> getNotifications(){
        return this.notifications;
    }
    public Team getTeam(){
        return this.team;
    }

    public ArrayList<Booking> getBookings() {
        return bookings;
    }

    public double getBalance() {
        return balance;
    }
    public void cancelBooking (Booking booking ){

    }
    public void viewAvailablePlaygrounds(){

    }
    public void filterPlaygroundsByArea(){

    }
    public  void filterPlaygroundsByDataAndTime(){

    }
    public void filterPlaygroundsByPrice(){

    }
    public void payBooking(Booking booking){

    }
    public void sendInvitations(){
        
    }


}
class Main{
    public static void main(String args[]){
        Player player = new Player("Hussein Okasha" , 123 , "kk%lll" , "husseinokasha13@gmail.com",null, null,null,2000);
    }
}
