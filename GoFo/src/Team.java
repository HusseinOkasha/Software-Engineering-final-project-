
import java.util.ArrayList;

public class Team {
	
	//attributtes
	private ArrayList<Player> players;
	private Player teamCreator;
	
	//constractors
	public Team() {
		this.players= new ArrayList<Player>();
		this.teamCreator = null ;
	}
	
	public Team(ArrayList<player> players , Player teamCreator) {
		this.players = players;
		this.teamCreator = teamCreator;
	}
	
	//methods
	public void addPlayer() {
		ArrayList<Player> player = new Player();
		
	}
	
	public void removePlayer() {
		
	}
	
	public void sendInvitation(){
		
	}
	
}
