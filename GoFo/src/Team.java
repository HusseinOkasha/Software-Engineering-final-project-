
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
	public void addPlayer(Player player) {
		players.add(player);
	}
	
	public void removePlayer(Player player) {
		players.remove(player);
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
	
}
