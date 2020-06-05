import java.util.ArrayList;

public class Database {
    // attributes....
    public static  ArrayList<Player> players= new ArrayList<Player>();
    public static  ArrayList<Playground>playgrounds= new ArrayList<Playground>();
    public static  ArrayList<PlaygroundOwner>playgroundOwners = new ArrayList<PlaygroundOwner>();
    public static  ArrayList<Administrator>administrators = new ArrayList<Administrator>();
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
    static int  findPlayer(String email){
        for(int i=0 ; i<players.size() ; i++){
            if(players.get(i).getEmail().equalsIgnoreCase(email)){
                return i;
            }
        }
     return -1;
    }
    static int  findOwner(String email) {
        for (int i = 0; i < playgroundOwners.size(); i++) {
            if (playgroundOwners.get(i).getEmail().equalsIgnoreCase(email)) {
                return i;
            }
        }
        return -1;
    }



    }


    


