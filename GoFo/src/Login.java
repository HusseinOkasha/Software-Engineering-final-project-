import java.util.Scanner;

public class Login {


    // methods
    boolean loginAsPlayer(Scanner scanner) {
        System.out.print("====================================\n");
        System.out.println("login:");
        System.out.print("enter the email: " );
        //Scanner scanner = new Scanner(System.in);
        String email = scanner.next() ;

        System.out.print("enter the password");
        String password = scanner.next();
        for (int i = 0; i< Database.players.size(); i++) {
            if (Database.players.get(i).getEmail().equalsIgnoreCase(email) && Database.players.get(i).getPassword().equals(password) ){
                  Database.players.get(i).mainMenu();
            }

        }
        System.out.println("there isnot an account with this info pls make a registeration");
        scanner.close();
        return false;
    }
    boolean loginAsPlaygroundOwner() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter the email");
        String email = scanner.next();
        System.out.println("enter the password");
        String password = scanner.next();
        for (int i = 0; i< Database.playgroundOwners.size(); i++) {
            if (Database.playgroundOwners.get(i).getEmail().equalsIgnoreCase(email) && Database.playgroundOwners.get(i).getPassword().equals(password)){
                Database.playgroundOwners.get(i).mainMenu();
            }

        }
        System.out.println("there isnot an account with this info pls make a registeration");
        return false;
    }
    boolean loginAsAdminstartor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter the email");
        String email = scanner.next();
        System.out.println("enter the password");
        String password = scanner.next();
        for (int i = 0; i<Database.administrators.size() ; i++) {
            if (Database.administrators.get(i).getEmail().equalsIgnoreCase(email) && Database.administrators.get(i).getPassword().equals(password)){
                Database.administrators.get(i).mainMenu();
            }

        }
        System.out.println("there isnot an account with this info pls make a registeration");
        return false;
    }
    void chooseRole(){
        Scanner Role = new Scanner(System.in);
        System.out.println("enter your role");
        int role = Role.nextInt();
        if(role==1){
            //loginAsPlayer();
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