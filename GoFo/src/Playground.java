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
    Playground (String name , String location , String description , int bookingNumber , double pricePerHour , String link ,ArrayList<String>images , boolean approved , boolean suspended , ArrayList<Booking>bookings , ArrayList<Interval>availableHours , PlaygroundOwner owner){

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
        return true ;
    }
    boolean isAvailable(){
        return true ;
    }

    @Override
    public String toString() {
        return "Playground{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", bookingNumber=" + bookingNumber +
                ", pricePerHour=" + pricePerHour +
                ", link='" + link + '\'' +
                ", images=" + images +
                ", availableHours=" + availableHours +
                '}';
    }
}
