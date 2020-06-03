import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Welcome {
    
    //methods
    void chooseRole(){
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        System.out.print("1-For Regestration \n");
        System.out.print("2-For Login\n");
        System.out.print("enter your choice ");
        try{
            String choice = reader.readLine();
            if(role.equalsIgnoreCase("1")){
                Register register = new Register();
                register.chooseRole();
            }
            else if(role.equalsIgnoreCase("2")){
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
        Login login = new Login();
        login.chooseRole();
    }

}

