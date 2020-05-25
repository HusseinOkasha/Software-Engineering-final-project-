import com.sun.source.tree.LambdaExpressionTree;

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

    public void viewAvailablePlaygrounds(){
        for (int i=0; i< database.playgrounds.size();i++){
            if (Database.playgrounds.get(i).isAvailable()){
                    System.out.println( i+1 +" "+Database.playgrounds.get(i));
            }
        }
    }
    public ArrayList<Playground> filterPlaygroundsByGovernorate(){
        String governorate;
        System.out.println("Enter governorate name : ");
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
        System.out.println("Enter city name : ");
        Scanner scanner = new Scanner(System.in);
        city= scanner.nextLine();
        ArrayList<Playground>filterResult= new ArrayList<Playground>();
        for (int i=0; i< database.playgrounds.size();i++){
            if (Database.playgrounds.get(i).getLocation().getCity().equals(city)){
                filterResult.add(Database.playgrounds.get(i));
            }
        }
        scanner.close();
        return filterResult;
    }

    public ArrayList<Playground> filterPlaygroundsByStreet(){
        String street;
        System.out.println("Enter street name : ");
        Scanner scanner = new Scanner(System.in);
        street= scanner.nextLine();
        ArrayList<Playground>filterResult= new ArrayList<Playground>();
        for (int i=0; i< database.playgrounds.size();i++){
            if (Database.playgrounds.get(i).getLocation().getStreet().equals(street)){
                filterResult.add(Database.playgrounds.get(i));
            }
        }
        scanner.close();
        return filterResult;
    }

    public  ArrayList<Playground> filterPlaygroundsByDataAndTime(){
            int day, month ,year , startHour , startMinute , startSecond ;
            int endHour , endMinute , endSecond;
            ArrayList<Playground>filteredPlaygrounds = new ArrayList<Playground>();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter day: ");
            day =scanner.nextInt();
            System.out.println("Enter month: ");
            month =scanner.nextInt();
            System.out.println("Enter year: ");
            year =scanner.nextInt();
            System.out.println("Enter start hour: ");
            startHour=scanner.nextInt();
            System.out.println("Enter start minute: ");
            startMinute= scanner.nextInt();
            System.out.println("Enter end hour: ");
            endHour=scanner.nextInt();
            System.out.println("Enter end minute: ");
            endMinute= scanner.nextInt();
            Interval searchInterval= new Interval(startHour,startMinute endHour ,endMinute,day,month,year ,null);

            for (int i=0; i<Database.playgrounds.size(); i++){
                if (Database.playgrounds.get(i).getAvailableHours().contains(searchInterval)){
                    filteredPlaygrounds.add(Database.playgrounds.get(i));
                }
            }
            scanner.close();
    }
    public ArrayList<Playground> filterPlaygroundsByPrice(){
        double price;
        System.out.println("Enter filter price: ");
        Scanner scanner = new Scanner(System.in);
        price= scanner.nextDouble();
        ArrayList<Playground>filterResult= new ArrayList<Playground>();
        for (int i=0; i< database.playgrounds.size();i++){
            if (Database.playgrounds.get(i).getPricePerHour() <= price){
                filterResult.add(Database.playgrounds.get(i));
            }
        }
        scanner.close();
        return filterResult;
    }
    public void payBooking(Booking booking){

    }
    public void sendInvitations(){
        System.out.println("Email: ");
        Scanner scanner = new Scanner(System.in);
        String email = scanner.nextLine();
        Player player= Database.findPlayer(email);
        if (player!=null){
            player.addNotification("Your friend "+this.name+ " send you an invitation" );
        }
    }
    public void bookPlayground (){

        System.out.println("Choose a playground to book: ");
        viewAvailablePlaygrounds();
        System.out.print("Enter the number of the playground you want to book: ");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        double price ;
        try {
            int index= Integer.parseInt(choice);
            if (index < Database.playgrounds.size() ){
                ArrayList<Interval>availableHours=Database.playgrounds.get(index).getAvailableHours();
                for (int i=0; i< availableHours.size(); i++){
                    System.out.println("1- "+availableHours.get(i));
                }
                Interval bookedInterval= new Interval();
                bookedInterval.fill();
                price=Database.playgrounds.get(index).getPricePerHour();
                price*=bookedInterval.calculateTotalTime();
                Booking  booking= new Booking(this,bookedInterval,price);
                bookedInterval.setBooking(booking);
                Database.playgrounds.get(index).addBooking(booking);
                Database.playgrounds.get(index).removeInterval(bookedInterval);

            }
            else {
                throw  new NumberFormatException ();
            }
        }
        catch (NumberFormatException e){
            System.out.println("Invalid choice if you want to retry press y ");
            System.out.println("================================================");
            choice= scanner.nextLine();
            if (choice.equalsIgnoreCase("y")){
                bookPlayground();
            }
        }

    }
    public void cancelBooking (Booking booking ){

    }
    public int isValidIndex(String index , int size ){
        if
    }



}
class Main{
    public static void main(String args[]){
        Player player = new Player("Hussein Okasha" , 123 , "kk%lll" , "husseinokasha13@gmail.com",null, null,null,2000);
    }
}
