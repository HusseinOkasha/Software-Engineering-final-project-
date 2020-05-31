import java.util.ArrayList;

public class Database {
    // attributes....
    public static  ArrayList<Player> players;
    public static  ArrayList<Playground>playgrounds;
    public static  ArrayList<PlaygroundOwner>playgroundOwners;
    public static  ArrayList<Administrator>administrators;
    // methods...
    public Database (){
        players= new ArrayList<Player>();
        playgrounds= new ArrayList<Playground>();
        playgroundOwners = new ArrayList<PlaygroundOwner>();
        administrators = new ArrayList<Administrator>();
    }
    void addPlayer(Player player) {
        players.add(player);
    }
    void addPlaygroundOwner(PlaygroundOwner playgroundOwner){
        playgroundOwners.add(playgroundOwner);
    }
    void addPlayground(Playground playground){
        playgrounds.add(playground);
    }
    void addAdministrator(Administrator administrator){
        administrators.add(administrator);
    }
    // add functions to remove also ....
    void removePlaygroundOwner(PlaygroundOwner playgroundOwner){
        playgroundOwners.remove(playgroundOwner);
     }
    void removePlayer(Player player ){
        players.remove(player);
    }

    void removePlayground(Playground playground){
        playgrounds.remove(playground);
    }

    void removeAdministrator(Administrator administrator){
        administrators.remove(administrator);
    }
    static Player findPlayer(String email){
        for(int i=0 ; i<players.size() ; i++){
            if(players.get(i).getEmail().equalsIgnoreCase(email)){
                return players.get(i);
            }
        }
     return null;   
    }

}


    


