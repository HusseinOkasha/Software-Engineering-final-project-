import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Administrator {
    // Attributes
    private String name ;
    private int ID;
    private String password;
    private String email;
    public static ArrayList<String>notifications=new ArrayList<String>();
    public static ArrayList<Playground>pendingPlaygrounds=new ArrayList<Playground>();

    // constructors
    public Administrator() {
        name="";
        ID=0;
        password="";
        email="";
    }
    public Administrator(String name , int ID , String password , String email){
        this.name=name;
        this.ID=ID;
        this.email=email;
        this.password=password;
    }

    // setters...
    public void setName(String name) {
        this.name = name;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void addNotification(String notification){
        if (notification!=""){
            this.notifications.add(notification);
        }
    }

    // getters...
    public String getName(){
        return name;
    }
    public int getID(){
        return ID;
    }
    public String getPassword(){
        return this.password;
    }
    public String getEmail(){
        return  this.email;
    }
    public ArrayList<String> getNotifications(){
        return this.notifications;
    }

    // methods...
    public void approvePlayground(int index){
        if (!(pendingPlaygrounds.size() >0)){
            System.out.println("There is no pending playgrounds");
            return;
        }
        System.out.print(pendingPlaygrounds.get(index));
        System.out.print("===================");
        System.out.print("Is ok...? y / n");
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        try {
            String choice= reader.readLine();
            if (choice.equalsIgnoreCase("Y")){
                pendingPlaygrounds.get(index).setApproved(true);
                Database.playgrounds.add(pendingPlaygrounds.get(index));
                String ownerEmail=pendingPlaygrounds.get(pendingPlaygrounds.size()-1).getOwner().getEmail();
                int indexOfOwner =Database.findOwner(ownerEmail);
                Database.playgroundOwners.get(indexOfOwner).refreshPlayground(pendingPlaygrounds.get(index));
                pendingPlaygrounds.remove(index);
            }
            else {
                pendingPlaygrounds.get(index).setApproved(false);
            }

        }
        catch (IOException e){
            System.out.println("Invalid input ");
        }

    }
    public void suspendPlayground(int index ){
        Database.playgrounds.get(index).setSuspended(true);
        PlaygroundOwner owner =Database.playgrounds.get(index).getOwner();
        int indexOfOwner = Database.playgroundOwners.indexOf(owner);
        Database.playgroundOwners.get(indexOfOwner).refreshPlayground(Database.playgrounds.get(index));
    }
    public void activatePlayground(int index){

        Database.playgrounds.get(index).setSuspended(false);
        PlaygroundOwner owner =Database.playgrounds.get(index).getOwner();
        int indexOfOwner = Database.playgroundOwners.indexOf(owner);
        Database.playgroundOwners.get(indexOfOwner).refreshPlayground(Database.playgrounds.get(index));
    }
    public void deletePlayground(){
        for (int i=0; i<Database.playgrounds.size();i++){
            System.out.print(Database.playgrounds.get(i));
        }
        System.out.print("=============================================================");
        System.out.print("enter number of the playground you want to delete");
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        try {
            String choice = reader.readLine();
            try{
                int index = Integer.parseInt(choice);
                if (index<0 || index >= Database.playgrounds.size()){
                    throw  new NumberFormatException();
                }
                else {
                    PlaygroundOwner owner =Database.playgrounds.get(index).getOwner();
                    int indexOfOwner = Database.playgroundOwners.indexOf(owner);
                    Database.playgrounds.remove(index);
                    Database.playgroundOwners.get(indexOfOwner).deletePlayground(Database.playgrounds.get(index).getName());
                }
            }
            catch (NumberFormatException e){
                System.out.print("Invalid choice enter y to retry");
                choice=reader.readLine();
                if (choice.equalsIgnoreCase("Y")){
                    deletePlayground();
                }
            }

        }
        catch (IOException e){
            System.out.println("Invalid input ");
        }

    }
    public void mainMenu(){
        System.out.println("1-Approve playground.");
        System.out.println("2-Suspend playground.");
        System.out.println("3-Delete playground.");
        System.out.println("4-Activate playground.");
        System.out.println("5-Logout.");
        System.out.println("========================================================");

        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        try {
            String choice = reader.readLine();
            if (choice.equalsIgnoreCase("1")){
                System.out.print("pending playgrounds: ");
                for (int i=0; i<pendingPlaygrounds.size();i++){
                    System.out.print( i+1+ "- " +pendingPlaygrounds.get(i));
                }
                System.out.print("select one to approve");
                choice= reader.readLine();
                try{
                    int index = Integer.parseInt(choice);
                    if (index<0 || index>pendingPlaygrounds.size() ){
                        throw new NumberFormatException();
                    }
                    else {
                        approvePlayground(index-1);
                    }
                }
                catch (NumberFormatException e){
                    System.out.print("invalid choice...");
                }

                mainMenu();
            }
            else if(choice.equalsIgnoreCase("2")){
                System.out.print("Playgrounds:");
                for (int i=0; i<Database.playgrounds.size();i++){
                    System.out.print( i+1+" -"+ Database.playgrounds.get(i));
                }
                System.out.print("=============================");
                System.out.print("choose one: ");
                choice=reader.readLine();
                try{
                    int index = Integer.parseInt(choice);
                    if (index<0 || index>=Database.playgrounds.size() ){
                        throw new NumberFormatException();
                    }
                    else {
                        suspendPlayground(index-1);
                    }
                }
                catch (NumberFormatException e){
                    System.out.print("invalid choice...");
                }
            }
            else if(choice.equalsIgnoreCase("3")){
                deletePlayground();
            }
            else if(choice.equalsIgnoreCase("4")){
                System.out.print("Playgrounds:");
                for (int i=0; i<Database.playgrounds.size();i++){
                    System.out.print( i+1+" -"+ Database.playgrounds.get(i));
                }
                System.out.print("=============================");
                System.out.print("choose one: ");
                choice=reader.readLine();
                try{
                    int index = Integer.parseInt(choice);
                    if (index<0 || index>=Database.playgrounds.size() ){
                        throw new NumberFormatException();
                    }
                    else {
                        activatePlayground(index-1);
                    }
                }
                catch (NumberFormatException e){
                    System.out.print("invalid choice...");
                }
            }


        }
        catch (IOException e){
            System.out.println("Invalid input");
        }

    }

}
