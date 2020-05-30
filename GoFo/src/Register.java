import java.util.ArrayList;
import java.util.Scanner;
public class Register {
    //attributes....
    public  Database static database;


    // methods...
    void registerAsPlayer(){
        Scanner Playr = new Scanner(System.in);
        Player player;
        System.out.println("enter the name");
        String name = Playr.nextLine();
        if(isCompleteString(name)==true){
            player.setName(name);
        }
        else{
            System.out.println("wrong input");
            registerAsPlayer();
        }
        System.out.println("enter the ID");
        int ID = Playr.nextINT;
        if(isCompleteINT(ID)==true){
            player.setID(ID);
        }
        else{
            System.out.println("wrong input");
            registerAsPlayer();
        }
        System.out.println("enter the password");
        String password = Playr.nextLine();
        if(isCompleteString(name)==true ) {
            player.setPassword(password);
        }
        else{
            System.out.println("wrong input");
            registerAsPlayer();
        }
        System.out.println("enter the e-mail");
        String email = Playr.nextLine();
        if(isCompleteString(name)==true){
            player.setEmail(email);
        }
        else{
            System.out.println("wrong input");
            registerAsPlayer();
        }
        database.AddPlayer(player);
    }
    void registerAsPlaygroundOwner(){
        Scanner Owner = new Scanner(System.in);
        PlaygroundOwner owner;
        System.out.println("enter the name");
        String name = Owner.nextLine();
        if(isCompleteString(name)==true){
            owner.setName(name);
        }
        else{
            System.out.println("wrong input");
            registerAsPlaygroundOwner();
        }
        System.out.println("enter the ID");
        int ID =  Owner.nextINT;
        if(isCompleteINT(ID)==true){
            owner.setID(ID);
        }
        else{
            System.out.println("wrong input");
            registerAsPlaygroundOwner();
        }
        System.out.println("enter the password");
        String password =  Owner.nextLine();
        if(isCompleteString(name)==true ) {
            owner.setPassword(password);
        }
        else{
            System.out.println("wrong input");
            registerAsPlaygroundOwner();
        }
        System.out.println("enter the e-mail");
        String email =  Owner.nextLine();
        if(isCompleteString(name)==true){
            owner.setEmail(email);
        }
        else{
            System.out.println("wrong input");
            registerAsPlaygroundOwner();
        }
        database.AddPlaygroundOwner(owner);
    }
    void registerAsAdminstartor(){
        Scanner Admin = new Scanner(System.in);
        Administrator admin;
        System.out.println("enter the name");
        String name = Admin.nextLine();
        if(isCompleteString(name)==true){
            admin.setName(name);
        }
        else{
            System.out.println("wrong input");
            registerAsAdminstartor();
        }
        System.out.println("enter the ID");
        int ID = Admin.nextINT;
        if(isCompleteINT(ID)==true){
            admin.setID(ID);
        }
        else{
            System.out.println("wrong input");
            registerAsAdminstartor();
        }
        System.out.println("enter the password");
        String password = Admin.nextLine();
        if(isCompleteString(name)==true ) {
            admin.setPassword(password);
        }
        else{
            System.out.println("wrong input");
            registerAsAdminstartor();
        }
        System.out.println("enter the e-mail");
        String email = Admin.nextLine();
        if(isCompleteString(name)==true){
            admin.setEmail(email);
        }
        else{
            System.out.println("wrong input");
            registerAsAdminstartor();
        }
        database.addAdministrator(admin);
    }
    boolean isCompleteString(String string){
        if(string.equals(null)){return false ;}
        else {return true;}
    }
    boolean isCompleteINT(int Int){
        if(Int.equals(null)){return false;}
        else {return true;}
    }
    void chooseRole(){
        Scanner Role = new Scanner(System.in);
        System.out.println("enter your role");
        int role = Role.nextINT;
        if(role==1){
            registerAsPlayer();
        }
        else if(role==2){
            registerAsPlaygroundOwner();
        }
        else if(role==3){
            registerAsAdminstartor();
        }
        else{
            System.out.println("invalid choice");
            chooseRole();
        }
    }

}
