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
	
	public Team(ArrayList<Player> players , Player teamCreator) {
		this.players = players;
		this.teamCreator = teamCreator;
	}
	
	//methods
	public void addPlayer(Player player) {
		players.add(player);
	}
	
	public void removePlayer(Player player) {
		players.remove(player);
	}
	
	public void sendInvitations(){
	        int index ; // index of this player in the database.
	        for (int i=0; i< players.size() ;i++ ){
	        	index = Database.findPlayer(players.get(i).getEmail());
	        	Database.players.get(i).addNotification("Hey "+ players.get(i).getName()+" I am"+teamCreator.getName()+ " inviting you" );
			}
	    }
}
