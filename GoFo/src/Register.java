import java.util.Scanner;
public class Register {


    // methods...
    void registerAsPlayer(){
        Scanner scanner = new Scanner(System.in);
        Player player= new Player();
        System.out.println("enter the name");
        String name = scanner.next();
        if(isCompleteString(name)==true){
            player.setName(name);
        }
        else{
            System.out.println("wrong input");
            registerAsPlayer();
        }
        System.out.print("enter the ID");
        int ID = scanner.nextInt();
        if(isCompleteINT(ID)==true){
            player.setID(ID);
        }
        else{
            System.out.println("wrong input");
            registerAsPlayer();
        }
        System.out.print("enter the password");
        String password = scanner.next();
        if(isCompleteString(name)==true ) {
            player.setPassword(password);
        }
        else{
            System.out.println("wrong input");
            registerAsPlayer();
        }
        System.out.print("enter the e-mail");
        String email = scanner.next();
        if(isCompleteString(name)==true){
            player.setEmail(email);
        }
        else{
            System.out.println("wrong input");
            registerAsPlayer();
        }
        Database.players.add(player);

        Login login = new Login();
        login.loginAsPlayer(scanner);
        scanner.close();
    }
    void registerAsPlaygroundOwner(){
        Scanner scanner = new Scanner(System.in);
        PlaygroundOwner owner = new PlaygroundOwner() ;
        System.out.println("enter the name");
        String name = scanner.nextLine();
        if(isCompleteString(name)==true){
            owner.setName(name);
        }
        else{
            System.out.println("wrong input");
            registerAsPlaygroundOwner();
        }
        System.out.println("enter the ID");
        int ID =  scanner.nextInt();
        if(isCompleteINT(ID)==true){
            owner.setID(ID);
        }
        else{
            System.out.println("wrong input");
            registerAsPlaygroundOwner();
        }
        System.out.println("enter the password");
        String password =  scanner.nextLine();
        if(isCompleteString(name)==true ) {
            owner.setPassword(password);
        }
        else{
            System.out.println("wrong input");
            registerAsPlaygroundOwner();
        }
        System.out.println("enter the e-mail");
        String email =  scanner.nextLine();
        if(isCompleteString(name)==true){
            owner.setEmail(email);
        }
        else{
            System.out.println("wrong input");
            registerAsPlaygroundOwner();
        }
        Database.playgroundOwners.add(owner);
        scanner.close();
        Login login = new Login();
        login.loginAsPlaygroundOwner();
    }
    void registerAsAdministrator(){
        Scanner scanner = new Scanner(System.in);
        Administrator admin = new Administrator();
        System.out.println("enter the name");
        String name = scanner.nextLine();
        if(isCompleteString(name)==true){
            admin.setName(name);
        }
        else{
            System.out.println("wrong input");
            registerAsAdministrator();
        }
        System.out.println("enter the ID");
        int ID = scanner.nextInt();
        scanner.nextLine();
        if(isCompleteINT(ID)==true){
            admin.setID(ID);
        }
        else{
            System.out.println("wrong input");
            registerAsAdministrator();
        }
        System.out.println("enter the password");
        String password = scanner.next();
        if(isCompleteString(name)==true ) {
            admin.setPassword(password);
        }
        else{
            System.out.println("wrong input");
            registerAsAdministrator();
        }
        System.out.println("enter the e-mail");
        String email = scanner.next();
        if(isCompleteString(name)==true){
            admin.setEmail(email);
        }
        else{
            System.out.println("wrong input");
            registerAsAdministrator();
        }
        Database.administrators.add(admin);

        Login login = new Login();
        login.loginAsAdminstartor();
        scanner.close();
    }
    boolean isCompleteString(String input){
        if(input.equalsIgnoreCase("")){return false ;}
        else {return true;}
    }
    boolean isCompleteINT(int input){
        if(input == -1){return false;}
        else {return true;}
    }
    void chooseRole(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("1-As player\n");
        System.out.print("2-As playgroundOwner\n");
        System.out.print("3-As Administrator\n");
        System.out.print("enter your role: ");
        String role = scanner.next();
        if(role.equalsIgnoreCase("1")){
            registerAsPlayer();
        }
        else if(role.equalsIgnoreCase("1")){
            registerAsPlaygroundOwner();
        }
        else if(role.equalsIgnoreCase("1")){
            registerAsAdministrator();
        }
        else{
            System.out.println("invalid choice");
            chooseRole();
        }
        //scanner.close();
    }

}

class Main{


    public static void main(String args[]){
        Register register = new Register();
        register.chooseRole();
    }

}
