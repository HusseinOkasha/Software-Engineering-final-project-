import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Interval {

    // Attributes....
    private int startHour;
    private int startMinute;
    private int endHour;
    private int endMinute;
    private int day;
    private int year;
    private int month;
    private Booking booking;

    public Interval (int startHour , int startMinute , int endHour , int endMinute , int day , int month , int year  , Booking booking)
    {
       this.startHour= startHour;
       this.startMinute= startMinute;
       this.endHour = endHour;
       this.endMinute = endMinute;
       this.day= day;
       this.year = year;
       this.month= month;
       booking=booking;

    }
    public Interval(){
        startHour=0;
        startMinute=0;
        endHour=0;
        endMinute=0;
        day=0;
        year=0;
        month=0;
        booking= null;
    }

    // setters.....
    public void setStartHour(int startHour) {
        this.startHour = startHour;
    }

    public void setStartMinute(int startMinute) {
        this.startMinute = startMinute;
    }

    public void setEndHour(int endHour) {
        this.endHour = endHour;
    }

    public void setEndMinute(int endMinute) {
        this.endMinute = endMinute;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    // getters

    public int getStartHour() {
        return startHour;
    }

    public int getStartMinute() {
        return startMinute;
    }

    public int getEndHour() {
        return endHour;
    }

    public int getEndMinute() {
        return endMinute;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public Booking getBooking() {
        return booking;
    }
     public double calculateTotalTime(){
    	double totalTimeOfMinute = (endHour*60+endMinute) - (startHour*60+startMinute);
        return totalTimeOfMinute;
    }
     
     public void fill() {
         BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
         try{
             System.out.print("Enter start hour: ");
             startHour= Integer.parseInt(reader.readLine());

             System.out.print("Enter end hour: ");
             endHour = Integer.parseInt(reader.readLine());

             System.out.print("Enter start minute: ");
             startMinute = Integer.parseInt(reader.readLine());

             System.out.print("Enter end minute: ");
             endMinute = Integer.parseInt(reader.readLine());

             System.out.print("Enter day: ");
             day = Integer.parseInt(reader.readLine());

             System.out.print("Enter month: ");
             month = Integer.parseInt(reader.readLine());

             System.out.print("Enter year: ");
             year = Integer.parseInt(reader.readLine());
         }
         catch (IOException e){
             System.out.println("Invalid input.");
         }

     }
     public String toString() {
    	return ("Start hour " + startHour +"\n"
    			+ "start minute " + startMinute +"\n"
    			+ "end Hour " + endHour +"\n"
    			+ "end minute " + endMinute +"\n"
    			+ "day " + day +"\n"
    			+ "year " + year +"\n"
    			+ "month " + month +"\n" )	;
    }


}
