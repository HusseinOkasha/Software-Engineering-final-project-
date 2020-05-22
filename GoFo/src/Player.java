import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Scanner;

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
    public Player(){
        name= null;
        ID=-1;
        Password=null;
        email=null;
        notifications= null;
        team= null;
        bookings= null;
        balance=0.0;
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
         team = new Team();
         //team.addPlayers();
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
        for (int i=0; i< database.playgrounds.size();i++){
            if (Database.playgrounds.get(i).isAvailable()){
                    System.out.println(Database.playgrounds.get(i));
            }
        }
    }
    public ArrayList<Playground> filterPlaygroundsByGovernorate(){
        String governorate;
        Scanner scanner = new Scanner(System.in);
        governorate= scanner.nextLine();
        ArrayList<Playground>filterResult= new ArrayList<Playground>();
        for (int i=0; i< database.playgrounds.size();i++){
            if (Database.playgrounds.get(i).getLocation().getGovernorate().equals(governorate)){
                filterResult.add(Database.playgrounds.get(i));
            }
        }
        scanner.close();
        return filterResult;
    }

    public ArrayList<Playground> filterPlaygroundsByCity(){
        String city;
        Scanner scanner = new Scanner(System.in);
        city= scanner.nextLine();
        ArrayList<Playground>filterResult= new ArrayList<Playground>();
        for (int i=0; i< database.playgrounds.size();i++){
            if (Database.playgrounds.get(i).getLocation().getGovernorate().equals(city)){
                filterResult.add(Database.playgrounds.get(i));
            }
        }
        scanner.close();
        return filterResult;
    }

    public ArrayList<Playground> filterPlaygroundsByStreet(){
        String street;
        Scanner scanner = new Scanner(System.in);
        street= scanner.nextLine();
        ArrayList<Playground>filterResult= new ArrayList<Playground>();
        for (int i=0; i< database.playgrounds.size();i++){
            if (Database.playgrounds.get(i).getLocation().getGovernorate().equals(street)){
                filterResult.add(Database.playgrounds.get(i));
            }
        }
        scanner.close();
        return filterResult;
    }

    public  ArrayList<Playground> filterPlaygroundsByDataAndTime(){

    }
    public ArrayList<Playground> filterPlaygroundsByPrice(){

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
