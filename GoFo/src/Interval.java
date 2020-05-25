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
        startHour=-1;
        startMinute=-1;
        endHour=-1;
        endMinute=-1;
        day=-1;
        year=-1;
        month=-1;
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

    /*
    * Override function toString().
    *
    * */


}
