public class Booking {
	
	//attribute
	private int  playerIndex;// index of player in Database
	private Interval bookedSlot;
	private double price;
	private boolean freeCancellation;
	private int bookedPlaygroundIndex ;// index of the booked playground in database.
	
	//constructors
	public Booking() {
		this.playerIndex=-1;
		this.bookedSlot= new Interval();
		this.price=0;
		this.freeCancellation=false;
		this.bookedPlaygroundIndex=-1;
	}
	
	public Booking(int  playerIndex, Interval bookedSlot , double price ,
			boolean freeCancellation , int bookedPlaygroundIndex) {
		this.playerIndex=playerIndex;
		this.bookedSlot=bookedSlot;
		this.price=price;
		this.freeCancellation=freeCancellation;
		this.bookedPlaygroundIndex=bookedPlaygroundIndex
		;
	}
	
	//methods
	//setter
	public void setPlayerIndex(int playerIndex) {
		this.playerIndex = playerIndex;
	}
	public void setBookedSlot(Interval bookedSlot) {
		this.bookedSlot = bookedSlot;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	public void setBookedPlaygroundIndex(int bookedPlaygroundIndex) {
		this.bookedPlaygroundIndex = bookedPlaygroundIndex;
	}

	public void setFreeCancellation(boolean freeCancellation) {
		this.freeCancellation = freeCancellation;
	}

	//getter
	public int getPlayerIndex() {
		return playerIndex;
	}
	public Interval getBookedSlot() {
		return bookedSlot;
	}
	public double getPrice() {
		return price;
	}

	public int getBookedPlaygroundIndex() {
		return bookedPlaygroundIndex;
	}

	public boolean isFreeCancellation() {
		return freeCancellation;
	}
}
