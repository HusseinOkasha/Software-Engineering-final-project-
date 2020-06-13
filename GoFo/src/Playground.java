import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Playground {

    // Attributes....
    private String name ;
    private Address location;
    private String description;
    private int bookingNumber;
    private double pricePerHour;
    private String link;
    private ArrayList<String>images;
    private boolean approved;
    private boolean suspended;
    private ArrayList<Booking>bookings;
    private ArrayList<Interval>availableHours;
    private PlaygroundOwner owner;

    // methods...
    Playground (String name , Address location , String description , int bookingNumber , double pricePerHour , String link ,ArrayList<String>images , boolean approved , boolean suspended , ArrayList<Booking>bookings , ArrayList<Interval>availableHours , PlaygroundOwner owner) {
            this.name =name;
            this.location=location;
            this.description=description;
            this.bookingNumber=bookingNumber;
            this.pricePerHour=pricePerHour;
            this.link=link;
            this.images=images;
            this.approved=approved;
            this.suspended=suspended;
            this.bookings=bookings;
            this.availableHours=availableHours;
            this.owner=owner;
    }
    Playground(){
        this.name ="";
        this.location=null;
        this.description=null;
        this.bookingNumber=0;
        this.pricePerHour=0;
        this.link="";
        this.images=new ArrayList<String>();
        this.approved=false;
        this.suspended=true;
        this.bookings=new ArrayList<Booking>();
        this.availableHours=new ArrayList<Interval>();
        this.owner=null;
    }

    //setters...
    public void setName(String name) {
        this.name = name;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public void setAvailableHours(ArrayList<Interval> availableHours) {
        this.availableHours = availableHours;
    }

    public void setBookingNumber(int bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    public void setBookings(ArrayList<Booking> bookings) {
        this.bookings = bookings;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImages(ArrayList<String> images) {
        this.images = images;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setLocation(Address location) {
        this.location = location;
    }

    public void setOwner(PlaygroundOwner owner) {
        this.owner = owner;
    }

    public void setPricePerHour(double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public void setSuspended(boolean suspended) {
        this.suspended = suspended;
    }

    //getters...

    public String getName() {
        return name;
    }

    public ArrayList<Booking> getBookings() {
        return bookings;
    }

    public ArrayList<Interval> getAvailableHours() {
        return availableHours;
    }

    public ArrayList<String> getImages() {
        return images;
    }

    public boolean isApproved() {
        return approved;
    }

    public boolean isSuspended() {
        return suspended;
    }

    public double getPricePerHour() {
        return pricePerHour;
    }

    public int getBookingNumber() {
        return bookingNumber;
    }

    public PlaygroundOwner getOwner() {
        return owner;
    }

    public String getDescription() {
        return description;
    }

    public String getLink() {
        return link;
    }

    public Address getLocation() {
        return location;
    }

    boolean isCompleteData(){
        if (name!="" && location!=null && description!="" && bookingNumber>0 && pricePerHour>=0   ){
            return  true;
        }
        return false;
    }
    boolean isAvailable(){
        if (availableHours.size()>0){
            return true;
        }
        return true;
    }
    void addBooking(Booking booking){
        bookings.add(booking);
    }
    void removeInterval(Interval interval){
        for (int i=0; i<availableHours.size();i++){
            if (interval.getYear()== availableHours.get(i).getYear()){
                if (interval.getMonth() ==  availableHours.get(i).getMonth() ){
                    if(interval.getDay() ==  availableHours.get(i).getDay() ){
                         if(interval.getStartHour() > availableHours.get(i).getStartHour() ){
                             if (interval.getEndHour() < availableHours.get(i).getEndHour()){
                                    int endHour=availableHours.get(i).getEndHour();
                                    int endMinute= availableHours.get(i).getEndMinute();
                                    availableHours.get(i).setEndHour(interval.getEndHour());
                                    availableHours.get(i).setEndMinute(interval.getEndMinute());
                                    Interval newInterval= new Interval (interval.getStartHour(), interval.getStartMinute() , interval.getEndHour() , interval.getEndMinute(),
                                    interval.getDay(), interval.getMonth() , interval.getYear(), null);
                                    availableHours.add(newInterval);
                             }
                             else if (interval.getEndHour() == availableHours.get(i).getEndHour()){
                                     availableHours.get(i).setEndHour(interval.getStartHour());
                                     availableHours.get(i).setEndMinute(interval.getEndMinute());
                             }

                         }
                         else if (interval.getStartHour() == availableHours.get(i).getStartHour() ){
                                  if (interval.getEndHour() < availableHours.get(i).getEndHour() ){
                                      Interval newInterval = new Interval(interval.getEndHour() , interval.getEndMinute(),
                                              availableHours.get(i).getEndHour(), availableHours.get(i).getEndMinute(),interval.getDay(),
                                              interval.getMonth(), interval.getMonth(), null);
                                      availableHours.add(newInterval);
                                  }
                                  else if (interval.getEndHour()==availableHours.get(i).getEndHour()){
                                      availableHours.remove(i);
                                  }

                         }
                    }
                }
            }
        }
    }
    public  void addAvailableInterval(Interval interval){
           availableHours.add(interval);
    }
    public void  removeBooking(Booking booking){
        for (int i=0; i<bookings.size();i++){
            if (booking==bookings.get(i)){
                bookings.remove(booking);
            }
        }
    }

    public  void fill (){
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Name: ");
            this.name=reader.readLine();
            this.location= new Address();
            this.location.createAddress();
            System.out.print("Description: ");
            this.description=reader.readLine();
            System.out.print("Booking Number: ");
            this.bookingNumber= reader.read();
            reader.readLine();
            System.out.print("Price per hour: ");

            this.pricePerHour= Double.parseDouble(reader.readLine());
            System.out.print("website Link: ");
            this.link= reader.readLine();
            System.out.print("Number of images: ");
            try {
                int numberOfImages = Integer.parseInt(reader.readLine());

                for (int i=0; i<numberOfImages ;i++){
                    System.out.print("Image path: ");
                    this.images.add(reader.readLine());
                }
                int numberOfIntervals=0;
                System.out.print("Number of interval you want to add");
                numberOfIntervals= Integer.parseInt(reader.readLine());
                for (int i=0; i<numberOfIntervals ;i++){
                    System.out.println("interval "+ i +1 + ": ");
                    Interval newInterval = new Interval();
                    newInterval.fill();
                    availableHours.add(newInterval);
                }
            }
            catch (NumberFormatException e){
                System.out.println("Invalid input");
            }


        }
        catch (IOException e){
            System.out.println("Invalid input");
        }

    }
    @Override
    public String toString() {
        return
                "name='" + name + '\n' +
                "location='" + location + '\n' +
                "description='" + description + '\n' +
                "bookingNumber=" + bookingNumber +'\n'+
                "pricePerHour=" + pricePerHour +'\n'+
                "link='" + link + '\'' + '\n'+
                "images=" + images + '\n' +
                "availableHours=" + availableHours + '\n'+
                "============================================================\n";
    }
}
