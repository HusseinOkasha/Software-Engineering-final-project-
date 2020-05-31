
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
            Database.players.add(this);

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
         int numberOfPlayers ;
         Scanner scanner = new Scanner(System.in);
         System.out.print("Enter number of players: ");
         numberOfPlayers = scanner.nextInt();
         String email = scanner.next() ;
         int index ;
         for (int i=0; i< numberOfPlayers ; i++){
             System.out.print("enter player email: ");
             index = Database.findPlayer(scanner.next());
             team.addPlayer(Database.players.get(index));
         }

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
    public ArrayList<Integer> filterPlaygroundsByGovernorate(ArrayList<Integer>index){
        String governorate;
        System.out.println("Enter governorate name : ");
        Scanner scanner = new Scanner(System.in);
        governorate= scanner.nextLine();
        ArrayList<Integer>filterResult= new ArrayList<Integer>();
        for (int i=0; i< index.size();i++){
            if (Database.playgrounds.get(index.get(i)).getLocation().getGovernorate().equals(governorate)){
                filterResult.add(i);
            }
        }
        scanner.close();
        return filterResult;
    }

    public ArrayList<Integer> filterPlaygroundsByCity(ArrayList<Integer>index){
        String city;
        System.out.println("Enter city name : ");
        Scanner scanner = new Scanner(System.in);
        city= scanner.nextLine();
        ArrayList<Integer>filterResult= new ArrayList<Integer>();
        for (int i=0; i< index.size();i++){
            if (Database.playgrounds.get(index.get(i)).getLocation().getCity().equals(city)){
                filterResult.add(index.get(i));
            }
        }
        scanner.close();
        return filterResult;
    }
    /*
    public ArrayList<Playground> filterPlaygroundsByStreet(ArrayList<Playground>playgrounds){
        String street;
        System.out.println("Enter street name : ");
        Scanner scanner = new Scanner(System.in);
        street= scanner.nextLine();
        ArrayList<Playground>filterResult= new ArrayList<Playground>();
        for (int i=0; i< playgrounds.size();i++){
            if (playgrounds.get(i).getLocation().getStreet().equals(street)){
                filterResult.add(playgrounds.get(i));
            }
        }
        scanner.close();
        return filterResult;
    }
    */
    public  ArrayList<Integer> filterPlaygroundsByDataAndTime(ArrayList<Integer>index){
            int day, month ,year , startHour , startMinute , startSecond ;
            int endHour , endMinute , endSecond;
            ArrayList<Integer>filteredPlaygrounds = new ArrayList<Integer>();
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
            Interval searchInterval= new Interval(startHour,startMinute, endHour ,endMinute,day,month,year ,null);

            for (int i=0; i<index.size(); i++){
                if (Database.playgrounds.get(index.get(i)).getAvailableHours().contains(searchInterval)){
                    filteredPlaygrounds.add(index.get(i));
                }
            }
            scanner.close();
            return filteredPlaygrounds;

    }
    public ArrayList<Playground> filterPlaygroundsByPrice(ArrayList<Playground>playgrounds){
        double price;
        System.out.println("Enter filter price: ");
        Scanner scanner = new Scanner(System.in);
        price= scanner.nextDouble();
        ArrayList<Playground>filterResult= new ArrayList<Playground>();
        for (int i=0; i< playgrounds.size();i++){
            if (playgrounds.get(i).getPricePerHour() <= price){
                filterResult.add(playgrounds.get(i));
            }
        }
        scanner.close();
        return filterResult;
    }
    public boolean payBooking(Booking booking){
            if (balance >= booking.getPrice()){
                balance-= booking.getPrice();
                return true;
            }
            return false;

    }
    public void sendInvitations(){
        System.out.println("Email: ");
        Scanner scanner = new Scanner(System.in);
        String email = scanner.nextLine();
        int index = Database.findPlayer(email);
        if (index!=-1){
            Database.players.get(index).addNotification("Your friend "+this.name+ " send you an invitation" );
        }
    }
    public void bookPlayground (int index){

        double price ;
        String choice;
        Scanner scanner= new Scanner(System.in);
        if (index < Database.playgrounds.size() ){

            for (int i=0; i< Database.playgrounds.get(index).getAvailableHours().size(); i++){
                    System.out.println(i+1+" "+Database.playgrounds.get(index).getAvailableHours().size());
            }
            Interval bookedInterval= new Interval();
            bookedInterval.fill();
            price=Database.playgrounds.get(index).getPricePerHour();
            price*=bookedInterval.calculateTotalTime();
            System.out.print("Total price: "+price);
            System.out.print("Do you want to book y/n .");
            choice= scanner.next();
            if (choice.equalsIgnoreCase("Y")){
                Booking  booking= new Booking(this,bookedInterval,price);
                bookedInterval.setBooking(booking);
                if (payBooking(booking)){
                    Database.playgrounds.get(index).addBooking(booking);
                    Database.playgrounds.get(index).removeInterval(bookedInterval);
                    int indexOfOwner =Database.playgroundOwners.indexOf(Database.playgrounds.get(index).getOwner());
                    Database.playgroundOwners.get(indexOfOwner).addNotification("your playground "+
                            Database.playgrounds.get(index).getName()+ "has been booked");
                    this.bookings.add(booking);
                    System.out.print("Successful booking.");
                }
                else{
                    System.out.println("You don't have enough credit....");
                }
            }
        }
    }
    public void cancelBooking (Booking booking ){
          if (booking.getFreeCancellation()==true){
              balance+=booking.getPrice();
          }
          else{
              System.out.println("the free cancellation period has been passed so you can't take back your money");
          }
          for (int i=0;i<Database.playgrounds.size() ;i++){
              if (Database.playgrounds.get(i)== booking.getBookedPlayground()){
                  Database.playgrounds.get(i).addAvailableInterval(booking.getBookedInterval());
                  Database.playgrounds.get(i).removeBooking(booking);
              }
          }
          this.bookings.remove(booking);

    }
    public ArrayList<Integer> filterByPrice(ArrayList<Integer> indices){
        double maxPrice, minPrice;
        ArrayList<Integer>filterResult= new ArrayList<Integer>();
        System.out.print("Enter min price: ");
        Scanner scanner= new Scanner(System.in);
        minPrice=scanner.nextDouble();
        System.out.print("Enter Max price: ");
        maxPrice = scanner.nextDouble();
        for (int i=0; i<indices.size(); i++){
            if (Database.playgrounds.get(indices.get(i)).getPricePerHour()>= minPrice ){
                if (Database.playgrounds.get(indices.get(i)).getPricePerHour()<= maxPrice ){
                    filterResult.add(indices.get(i));
                }
            }
        }
        return filterResult;
    }

    public void mainMenu(){
        System.out.print("Hello "+ this.name+ ", please choose one of the following." );
        System.out.print("1-View all available playgrounds.");
        System.out.print("2-Filter playgrounds.");
        System.out.print("3-create team.");
        System.out.print("4-update team.");
        System.out.print("5-send invitation.");
        System.out.print("========================================");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next();
        if (choice.equalsIgnoreCase("1")){
            viewAvailablePlaygrounds();
            doYouWantToBook();
        }
        else if (choice.equalsIgnoreCase("2")){
            ArrayList<Integer>indices= new ArrayList<Integer>();
            for (int i=0; i<Database.playgrounds.size(); i++ ){
                indices.add(i);
            }
            indices=filter(indices);
            for (int i=0; i<indices.size();i++){
                System.out.print(indices.get(i)+1+" "+Database.playgrounds.get(indices.get(i)));
            }
            doYouWantToBook();

        }
        else if (choice.equalsIgnoreCase("3")){
                createTeam();
        }
        else if (choice.equalsIgnoreCase("4")){
            System.out.print("1-Add player.");
            System.out.print("2-Remove player.");
            choice=scanner.next();
            if (choice.equalsIgnoreCase("1")){
                System.out.print("Enter his email: ");
                String email = scanner.next();
                team.addPlayer(email);
            }
            else {
                System.out.print("Enter his email: ");
                String email = scanner.next();
                team.removePlayer(email);
            }

        }
        else if (choice.equalsIgnoreCase("5")){
            sendInvitations();
        }

    }

    public ArrayList<Integer> filter(ArrayList<Integer>indices){
        indices=filterPlaygroundsByGovernorate(indices);
        indices=filterPlaygroundsByCity(indices);
        indices=filterPlaygroundsByDataAndTime(indices);
        indices=filterByPrice(indices);
        return indices;
    }
    public void doYouWantToBook(){
        String choice;
        Scanner scanner= new Scanner(System.in);
        System.out.print("Do you want to book any ... ? y/n");
        choice= scanner.next();
        if (choice.equalsIgnoreCase("Y")){
            int index;
            System.out.print("Enter it's number: ");
            index= scanner.nextInt();
            bookPlayground(index-1);
        }
        scanner.close();
    }



}
class Main{


    public static void main(String args[]){


    }

}
