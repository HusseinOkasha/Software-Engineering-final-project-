import java.util.ArrayList;
import java.util.Scanner;

public class Login {
    //atrributes
    public Database static database;

    // methods
    boolean loginAsPlayer() {
        Scanner Player = new Scanner(System.in);
        System.out.println("enter the name");
        String name = Player.nextLine();
        System.out.println("enter the password");
        String password = Player.nextLine();
        for (int i = 0; database.players.size()) {
            if (database.players.get(i).name equals(name) && database.players.get(i).Password equals(password)){
                return true;
                break;
            }
            else{
                i++;
            }

        }
        System.out.println("there isnot an account with this info pls make a registeration");
        return false;
    }
    boolean loginAsPlaygroundOwner() {
        Scanner Owner = new Scanner(System.in);
        System.out.println("enter the name");
        String name = Owner.nextLine();
        System.out.println("enter the password");
        String password = Owner.nextLine();
        for (int i = 0; database.playgroundOwners.size()) {
            if (database.playgroundOwners.get(i).name equals(name) && database.playgroundOwners.get(i).Password equals(password)){
                return true;
                break;
            }
            else{
                i++;
            }

        }
        System.out.println("there isnot an account with this info pls make a registeration");
        return false;
    }
    boolean loginAsAdminstartor() {
        Scanner Admin = new Scanner(System.in);
        System.out.println("enter the name");
        String name = Admin.nextLine();
        System.out.println("enter the password");
        String password = Admin.nextLine();
        for (int i = 0; database.administrators.size()) {
            if (database.administrators.get(i).name equals(name) && database.administrators.get(i).Password equals(password)){
                return true;
                break;
            }
            else{
                i++;
            }

        }
        System.out.println("there isnot an account with this info pls make a registeration");
        return false;
    }
    void chooseRole(){
        Scanner Role = new Scanner(System.in);
        System.out.println("enter your role");
        int role = Role.nextINT;
        if(role==1){
            loginAsPlayer();
        }
        else if(role==2){
            loginAsPlaygroundOwner();
        }
        else if(role==3){
            loginAsAdminstartor();
        }
        else{
            System.out.println("invalid choice");
            chooseRole();
        }
    }




}