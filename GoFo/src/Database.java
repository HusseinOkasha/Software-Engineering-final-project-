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
    void AddPlayer(Player player) {
        players.add(player);
    }
    void AddPlaygroundOwner(PlaygroundOwner playgroundOwner){
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
        for(int i=0; i<playgroundOwners.size() ; i++){
            if(playgroundOwners.get(i)==playgroundOwner){
                playgroundOwners.remove(i);
                
                
            }
        }
    }
    void removePlayer(Player player ){
        for(int i=0; i<players.size() ; i++){
            if(players.get(i)==player){
                palyers.remove(i);
            }
        }
    }
    void removePlaygroud(Playground playground){
        for(int i=0; i<playgrounds.size() ; i++){
            if(playgrounds.get(i)==playground){
               playgrounds.remove(i);} 
        }
    }
    void removeAdministrator(Administrator administrator){
        for(int i=0; i<administrators.size() ; i++){
            if(administrators.get(i)==administrator){
                administrators.remove(i);}
        }
    }
    player findPlayer(String email){
        for(int i=0 ; i<players.size() ; i++){
            if(players.get(i).email==email){
                System.out.println(players.get(i));
            }
        }
        
    }
    }
    


