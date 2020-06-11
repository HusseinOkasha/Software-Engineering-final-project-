import java.util.ArrayList;

public class Team {
	
	//attributtes
	private ArrayList<Integer> players; // index of players in the Database
	private int  teamCreator; // index of team creator in the Database
	
	//constractors
	public Team() {
		this.players= new ArrayList<Integer>();
		this.teamCreator = -1 ;
	}
	
	public Team(ArrayList<Integer> players , int teamCreator) {
		this.players = players;
		this.teamCreator = teamCreator;
	}
	
	//methods
	public void addPlayer(String playerEmail) {
		int index = Database.findPlayer(playerEmail);

		players.add(index);
	}
	
	public void removePlayer(String playerEmail) {
		int index = Database.findPlayer(playerEmail);
		players.remove(index);
	}
	
	public void sendInvitations(){
	        int index ; // index of this player in the database.
	        for (int i=0; i< players.size() ;i++ ){
	        	Database.players.get(players.get(i)).addNotification("you have recieved inviatation");
			}
	    }
}
