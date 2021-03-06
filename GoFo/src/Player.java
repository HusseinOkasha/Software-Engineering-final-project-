import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        notifications= new ArrayList<String>();
        team= null;
        bookings= new ArrayList<Booking>();
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

         for (int i=0; i< numberOfPlayers ; i++){
             System.out.print("enter player email: ");
             team.addPlayer(email);
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
        for (int i=0; i< Database.playgrounds.size();i++){
            if (Database.playgrounds.get(i).isAvailable()){
                    System.out.println( i+1 +" "+Database.playgrounds.get(i));
            }
        }
    }
    public ArrayList<Integer> filterPlaygroundsByGovernorate(ArrayList<Integer>index){
        System.out.println("Enter governorate name : ");

        String governorate;
        ArrayList<Integer>filterResult= new ArrayList<Integer>();

        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        try{
            governorate= reader.readLine();

            for (int i=0; i< index.size();i++){
                if (Database.playgrounds.get(index.get(i)).getLocation().getGovernorate().equalsIgnoreCase(governorate)){

                    filterResult.add(index.get(i));
                }
            }
        }
        catch (IOException e){
            System.out.println("Invalid input");
            return null;
        }
        return filterResult;
    }

    public ArrayList<Integer> filterPlaygroundsByCity(ArrayList<Integer>index){
        System.out.println("Enter city name : ");
        String city;
        ArrayList<Integer>filterResult= new ArrayList<Integer>();

        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));

        try {
            city = reader.readLine();
            for (int i = 0; i < index.size(); i++) {
                if (Database.playgrounds.get(index.get(i)).getLocation().getCity().equalsIgnoreCase(city)) {
                    filterResult.add(index.get(i));
                }
            }
        }
        catch (IOException e){
            System.out.println("Invalid input");
            return null;
        }

        return filterResult;
    }

    public ArrayList<Integer> filterPlaygroundsByDataAndTime(ArrayList<Integer>index){

            ArrayList<Integer>filteredPlaygrounds = new ArrayList<Integer>();

            Interval searchInterval= new Interval();
            searchInterval.fill();
            for (int i=0; i<index.size(); i++){
                ArrayList<Interval> availableHours= Database.playgrounds.get(index.get(i)).getAvailableHours();
                if (searchInterval.getDay()==availableHours.get(i).getDay() && searchInterval.getMonth()==availableHours.get(i).getMonth()
                && searchInterval.getYear()==availableHours.get(i).getYear()){
                    for (int j=0 ; j<availableHours.size() ;j++){
                        if (availableHours.get(j).getStartHour() < searchInterval.getStartHour()  &&
                                availableHours.get(j).getEndHour() > searchInterval.getEndHour() ){
                            filteredPlaygrounds.add(index.get(i));

                        }
                        else if (availableHours.get(j).getStartHour() == searchInterval.getStartHour() &&
                                availableHours.get(j).getEndHour() == searchInterval.getEndHour() ){
                            if (availableHours.get(j).getStartMinute()<= searchInterval.getStartMinute() &&
                                    availableHours.get(j).getEndMinute()>= searchInterval.getEndMinute()){
                                filteredPlaygrounds.add(index.get(i));

                            }
                        }
                        else if (availableHours.get(j).getStartHour() <= searchInterval.getStartHour() &&
                                availableHours.get(j).getEndHour() > searchInterval.getEndHour()){
                            if (availableHours.get(i).getStartMinute()<= searchInterval.getStartMinute()){
                                filteredPlaygrounds.add(index.get(i));
                            }
                        }
                        else if (availableHours.get(j).getStartHour() < searchInterval.getStartHour() &&
                                availableHours.get(j).getEndHour() >= searchInterval.getEndHour()){
                            if (availableHours.get(i).getEndMinute()>= searchInterval.getEndMinute()){
                                filteredPlaygrounds.add(index.get(i));
                            }
                        }

                    }
                }

            }



            return filteredPlaygrounds;

    }

    public boolean payBooking(Booking booking){
            if (balance >= booking.getPrice()){
                balance-= booking.getPrice();
                int bookedPlaygroundIndex= booking.getBookedPlaygroundIndex();
                String ownerEmail = Database.playgrounds.get(bookedPlaygroundIndex).getOwner().getEmail();
                int ownerIndex= Database.findOwner(ownerEmail);
                double currentBalance = Database.playgroundOwners.get(ownerIndex).getBalance();
                Database.playgroundOwners.get(ownerIndex).setBalance(currentBalance+booking.getPrice());
                return true;
            }
            return false;

    }
    public void sendInvitations(){
        System.out.println("Email: ");
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        String email ;
        try {
            email= reader.readLine();
            int index = Database.findPlayer(email);
            if (index!=-1){
                Database.players.get(index).addNotification("Your friend "+this.name+ " send you an invitation" );
            }
        }
        catch (IOException e){
            System.out.println("invalid Input");
        }

    }
    public void bookPlayground (int index){

       double price ;
        String choice;
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        try {
            if (index < Database.playgrounds.size() ){

                for (int i=0; i< Database.playgrounds.get(index).getAvailableHours().size(); i++){
                    System.out.println(i+1+" "+Database.playgrounds.get(index).getAvailableHours().size());
                }
                Interval bookedInterval= new Interval();
                bookedInterval.fill();
                price=Database.playgrounds.get(index).getPricePerHour();
                price*=bookedInterval.calculateTotalTime()/60;
                System.out.print("Total price: "+price);
                System.out.print("Do you want to book y/n .");
                choice= reader.readLine();
                if (choice.equalsIgnoreCase("Y")){
                    int PlayerIndex = Database.findPlayer(this.email);
                    Booking  booking= new Booking(PlayerIndex , bookedInterval , price ,true , index );
                    bookedInterval.setBooking(booking);
                    if (payBooking(booking)){
                        Database.playgrounds.get(index).addBooking(booking);
                        Database.playgrounds.get(index).removeInterval(bookedInterval);
                        int indexOfOwner =Database.playgroundOwners.indexOf(Database.playgrounds.get(index).getOwner());
                        Database.playgroundOwners.get(indexOfOwner).addNotification("your playground "+
                                Database.playgrounds.get(index).getName()+ "has been booked");
                        Database.playgroundOwners.get(indexOfOwner).refreshPlayground(Database.playgrounds.get(index));
                        this.bookings.add(booking);
                        System.out.print("Successful booking.");
                    }
                    else{
                        System.out.println("You don't have enough credit....");
                    }
                }
            }
        }
        catch (IOException e){
            System.out.println("Invalid input");
        }

    }
    public void cancelBooking (Booking booking ){
          if (booking.isFreeCancellation()){
              balance+=booking.getPrice();
          }
          else{
              System.out.println("the free cancellation period has been passed so you can't take back your money");
          }

          Database.playgrounds.get(booking.getBookedPlaygroundIndex()).addAvailableInterval(booking.getBookedSlot());
          Database.playgrounds.get(booking.getBookedPlaygroundIndex()).removeBooking(booking);
          int ownerIndex=Database.findOwner(Database.playgrounds.get(booking.getBookedPlaygroundIndex()).getOwner().getEmail());
          Database.playgroundOwners.get(ownerIndex).refreshPlayground(Database.playgrounds.get(booking.getBookedPlaygroundIndex()));
          this.bookings.remove(booking);
    }
    public ArrayList<Integer> filterByPrice(ArrayList<Integer> indices){
        double maxPrice, minPrice;
        ArrayList<Integer>filterResult= new ArrayList<Integer>();
        System.out.print("Enter min price: ");
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        try {
            String number = reader.readLine();
            minPrice=Double.parseDouble(number);
            System.out.print("Enter Max price: ");
            number=reader.readLine();
            maxPrice = Double.parseDouble(number);
            for (int i=0; i<indices.size(); i++){
                if (Database.playgrounds.get(indices.get(i)).getPricePerHour()>= minPrice ){
                    if (Database.playgrounds.get(indices.get(i)).getPricePerHour()<= maxPrice ){
                        filterResult.add(indices.get(i));
                    }
                }
            }

        }
        catch (IOException e){
            System.out.println("Invalid input");
            return null;
        }
        return filterResult;
    }

    public void mainMenu(){
        System.out.println("Hello "+ this.name+ ", please choose one of the following." );
        System.out.println("1-View all available playgrounds.");
        System.out.println("2-Filter playgrounds.");
        System.out.println("3-create team.");
        System.out.println("4-update team.");
        System.out.println("5-send invitation.");
        System.out.println("6-deposit credit");
        System.out.println("7-Cancel booking ");
        System.out.println("8-check e wallet status");
        System.out.println("9-Logout.");
        System.out.println("========================================================");

        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        try {
            String choice = reader.readLine();
            if (choice.equalsIgnoreCase("1")){
                viewAvailablePlaygrounds();
                doYouWantToBook();
                mainMenu();
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
                mainMenu();

            }
            else if (choice.equalsIgnoreCase("3")){
                createTeam();
                mainMenu();
            }
            else if (choice.equalsIgnoreCase("4")){
                System.out.print("1-Add player.");
                System.out.print("2-Remove player.");
                choice=reader.readLine();
                if (choice.equalsIgnoreCase("1")){
                    System.out.print("Enter his email: ");
                    String email = reader.readLine();
                    team.addPlayer(email);
                }
                else {
                    System.out.print("Enter his email: ");
                    String email = reader.readLine();
                    team.removePlayer(email);
                }
                mainMenu();
            }
            else if (choice.equalsIgnoreCase("5")){
                sendInvitations();
                mainMenu();
            }
            else if(choice.equalsIgnoreCase("6")){
                System.out.print("deposit amount: ");
                double amount = Double.parseDouble(reader.readLine());
                setBalance(this.balance+amount);
                mainMenu();
            }
            else if (choice.equalsIgnoreCase("7")){
                   if (!(bookings.size()>0)){
                       System.out.println("You dan't have any bookings...");
                   }
                   else {
                       for(int i=0; i< bookings.size(); i++){
                           System.out.println(i+1+"- "+bookings.get(i));
                       }
                       System.out.print("select one to cancel: ");
                       int index = Integer.parseInt(reader.readLine());
                       if (index > bookings.size()  || index < 0){
                           System.out.println("invalid choice ");

                       }
                       else {
                           cancelBooking(bookings.get(index-1));
                       }

                   }
                   mainMenu();
            }
            else if (choice.equalsIgnoreCase("8")){
                   System.out.println("Your balance: "+ getBalance());
                   mainMenu();
            }
            
        }
        catch (IOException e){
            System.out.println("Invalid input");
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
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Do you want to book any ... ? y/n");
        try {
            choice= reader.readLine();
            if (choice.equalsIgnoreCase("Y")){

                System.out.print("Enter it's number: ");
                int index= Integer.parseInt(reader.readLine());
                bookPlayground(index-1);
            }

        }
        catch (IOException e){
            System.out.println("invalid input");
        }

    }

}
class Test {
    public static  void main (String[] args ){
        Playground playground_1 = new Playground();
        Playground playground_2 = new Playground();
        playground_1.fill();
        playground_2.fill();
        Database.playgrounds.add(playground_1);
        Database.playgrounds.add(playground_2);
        Player player = new Player();
        player.setBalance(1000);
        player.viewAvailablePlaygrounds();
        ArrayList<Integer>indcies= new ArrayList<Integer>();
        for (int i=0; i< Database.playgrounds.size();i++){
            indcies.add(i);
        }
        player.filterPlaygroundsByDataAndTime(indcies);

    }
}
