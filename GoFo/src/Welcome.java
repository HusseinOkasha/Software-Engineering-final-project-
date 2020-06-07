import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Welcome {
    
    //methods
    void chooseRole(){
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        System.out.println("1-For Registration.");
        System.out.println("2-For Login.");
        System.out.println("Enter your choice: ");
        try{
            String choice = reader.readLine();
            if(choice.equalsIgnoreCase("1")){
                Register register = new Register();
                register.chooseRole();
            }
            else if(choice.equalsIgnoreCase("2")){
                Login login = new Login();
                login.chooseRole();
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
class Main{
    public static void main(String args[]){
        Welcome welcome = new Welcome();
        welcome.chooseRole();
    }

}

