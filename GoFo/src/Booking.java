public class Booking {
	
	//attribute
	private Player player;
	private Interval bookedSlot;
	private double price;
	private boolean freeCancellation;
	private Playground bookedPlayground ;
	
	//constractors
	public Booking() {
		this.player="";
		this.bookedSlot= "";
		this.price="";
		this.freeCancellation="";
		this.bookedPlayground="";
	}
	
	public Booking(Player player, Interval bookedSlot , double price ,
			boolean freeCancellation , Playground bookedPlayground) {
		this.player=player;
		this.bookedSlot=bookslot;
		this.price=price;
		this.freeCancellation=freeCancellation;
		this.bookedPlayground=bookedPlayground;
	}
	
	//methods
	//setter
	public void setPlayer(Player player) {
		this.player = player;
	}
	public void setBookedSlot(Interval bookedSlot) {
		this.bookedSlot = bookedSlot;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	//getter
	public Player getPlayer() {
		return player;
	}
	public Interval getBookedSlot() {
		return bookedSlot;
	}
	public double getPrice() {
		return price;
	}
	
	
}
