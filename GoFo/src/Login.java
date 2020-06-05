import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Login {


    // methods
    void loginAsPlayer() {
        System.out.println("Player login:");
        System.out.println("========================================================");
        System.out.print("Enter the email: " );
        boolean found=false;
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        try {
            String email = reader.readLine();
            System.out.print("Enter the password: ");
            String password = reader.readLine();
            for (int i = 0; i< Database.players.size(); i++) {
                if (Database.players.get(i).getEmail().equalsIgnoreCase(email) && Database.players.get(i).getPassword().equals(password) ){
                    Database.players.get(i).mainMenu();
                    found=true;
                }

            }
            if(!found){
                System.out.println("Invalid username or password.");
            }
        }
        catch (IOException e){
             System.out.println("Invalid input");
             loginAsPlayer();
        }

        Welcome welcome = new Welcome();
        welcome.chooseRole();

    }

    public void  loginAsPlaygroundOwner() {
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Owner login: " ) ;
        System.out.println("========================================================");
        try {
            System.out.print("enter the email: ");
            String email = null;
            email = reader.readLine();
            System.out.print("enter the password:");
            String password = null;
            password = reader.readLine();
            for (int i = 0; i < Database.playgroundOwners.size(); i++) {
                if (Database.playgroundOwners.get(i).getEmail().equalsIgnoreCase(email) && Database.playgroundOwners.get(i).getPassword().equals(password)) {
                    Database.playgroundOwners.get(i).mainMenu();
                }

            }

        }

        catch(IOException e){
            System.out.println("there isnot an account with this info pls make a registeration");
            Welcome welcome = new Welcome();
            welcome.chooseRole();
        }
        Welcome welcome = new Welcome();
        welcome.chooseRole();


    }
    void  loginAsAdminstartor() {
        System.out.println("Admin login:");
        System.out.println("========================================================");
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.print("enter the email: ");
            String email = null;
            email = reader.readLine();
            System.out.print("enter the password:");
            String password = null;
            password = reader.readLine();
            for (int i = 0; i < Database.administrators.size(); i++) {
                if (Database.administrators.get(i).getEmail().equalsIgnoreCase(email) && Database.administrators.get(i).getPassword().equalsIgnoreCase(password)) {
                    Database.administrators.get(i).mainMenu();
                }
            }
        }
        catch(IOException e){
            System.out.println("there isnot an account with this info pls make a registeration");
            Welcome welcome = new Welcome();
            welcome.chooseRole();
        }
        Welcome welcome = new Welcome();
        welcome.chooseRole();
    }
    void chooseRole(){
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        System.out.println("1-Login As player.");
        System.out.println("2-Login As playgroundOwner.");
        System.out.println("3-Login As Administrator.");
        System.out.println("========================================================");
        System.out.print("enter your role: ");

        try{
            String role = reader.readLine();
            if(role.equalsIgnoreCase("1")){
                loginAsPlayer();
            }
            else if(role.equalsIgnoreCase("2")){
                loginAsPlaygroundOwner();
            }
            else if(role.equalsIgnoreCase("3")){
                loginAsAdminstartor();
            }
            else{
                System.out.println("invalid choice");
                chooseRole();
            }
        }
        catch (IOException e){
            System.out.println("invalid Input");
            chooseRole();
        }
    }
}
