import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;
public class Register {


    // methods...
    void registerAsPlayer(){
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        Player player= new Player();
        System.out.print("enter the name:");
        String name = null;
        try {
            name = reader.readLine();
            if(isCompleteString(name)==true){
                player.setName(name);
            }
            else{
                System.out.println("wrong input");
                registerAsPlayer();
            }
            System.out.print("enter the ID: ");
            int ID = reader.read();
            reader.readLine();

            if(isCompleteINT(ID)==true){
                player.setID(ID);
            }
            else{
                System.out.println("wrong input");
                registerAsPlayer();
            }
            System.out.print("enter the password:");
            String password = reader.readLine();
            if(isCompleteString(name) && isStrongPass(password)) {
                player.setPassword(password);
            }
            else{
                System.out.println("wrong input");
                registerAsPlayer();
            }
            System.out.print("enter the e-mail;");
            String email = reader.readLine();
            if(isCompleteString(name)==true && isValid(email)==true){
                player.setEmail(email);
            }
            else{
                System.out.println("wrong input");
                registerAsPlayer();
            }
            Database.players.add(player);

            Login login = new Login();
            login.loginAsPlayer();

        }
        catch (IOException e){
            System.out.println("Invalid Input...");
            registerAsPlayer();
        }


    }
    void registerAsPlaygroundOwner(){
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        PlaygroundOwner owner = new PlaygroundOwner() ;
        System.out.print("Enter the name: ");
        try{
            String name = reader.readLine();
            if(isCompleteString(name)){
                owner.setName(name);
            }
            else{
                System.out.println("wrong input");
                registerAsPlaygroundOwner();
            }
            System.out.print("Enter the ID: ");
            int ID =  reader.read();
            reader.readLine(); // without it , it will take the newline character as input for the next time you try to read
            if(isCompleteINT(ID)){
                owner.setID(ID);
            }
            else{
                System.out.println("wrong input");
                registerAsPlaygroundOwner();
            }
            System.out.print("Enter the password: ");
            String password =  reader.readLine();
            if(isCompleteString(name) &&isStrongPass(password)) {
                owner.setPassword(password);
            }
            else{
                System.out.println("wrong input");
                registerAsPlaygroundOwner();
            }
            System.out.print("Enter the e-mail: ");
            String email =  reader.readLine();
            if(isCompleteString(name)&&isValid(email)){
                owner.setEmail(email);
            }
            else{
                System.out.println("wrong input");
                registerAsPlaygroundOwner();
            }
            Database.playgroundOwners.add(owner);

            Login login = new Login();
            login.loginAsPlaygroundOwner();
        }
        catch (IOException e){
            System.out.println("Invalid input");
            System.out.println("===============================================");
            registerAsPlaygroundOwner();
        }
    }
    void registerAsAdministrator(){
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        Administrator admin = new Administrator();
        System.out.println("enter the name");
        try {
            String name = reader.readLine();
            if(isCompleteString(name)==true){
                admin.setName(name);
            }
            else{
                System.out.println("wrong input");
                registerAsAdministrator();
            }
            System.out.println("enter the ID");
            int ID = reader.read();
            reader.readLine();
            if(isCompleteINT(ID)==true){
                admin.setID(ID);
            }
            else{
                System.out.println("wrong input");
                registerAsAdministrator();
            }
            System.out.println("enter the password");
            String password = reader.readLine();
            if(isCompleteString(password) && isStrongPass(password)) {
                admin.setPassword(password);
            }
            else{
                System.out.println("wrong input");
                registerAsAdministrator();
            }
            System.out.println("enter the e-mail");
            String email = reader.readLine();
            if(isCompleteString(name)&&isValid(email)==true){
                admin.setEmail(email);
            }
            else{
                System.out.println("wrong input");
                registerAsAdministrator();
            }
            Database.administrators.add(admin);

            Login login = new Login();
            login.loginAsAdminstartor();

        }
        catch (IOException e){
            System.out.println("Invalid input");
            System.out.println("=======================================");
            registerAsAdministrator();
        }

    }
    boolean isCompleteString(String input){
        if(input.equalsIgnoreCase("")){return false ;}
        else {return true;}
    }
    boolean isCompleteINT(int input){
        if(input == -1){return false;}
        else {return true;}
    }
    boolean isStrongPass(String pass){
        boolean isUpper=false;
        boolean isLower= false;
        boolean isDigit=false;
        if(pass.length()>=8) {
            for (int i = 0; i < pass.length(); i++) {
                if (Character.isLetter(pass.charAt(i))){
                    if (Character.isUpperCase(pass.charAt(i))){
                        isUpper=true;
                    }
                    else {
                        isLower=true;
                    }
                }
                else if(Character.isDigit(pass.charAt(i))){
                    isDigit=true;
                }
            }
        }
        if (isDigit && isUpper && isLower){
            return true;
        }
        return false;

    }
    public static boolean isValid(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }

    void chooseRole(){
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        System.out.print("1-As player\n");
        System.out.print("2-As playgroundOwner\n");
        System.out.print("3-As Administrator\n");
        System.out.print("enter your role: ");
        try{
            String role = reader.readLine();
            if(role.equalsIgnoreCase("1")){
                registerAsPlayer();
            }
            else if(role.equalsIgnoreCase("2")){
                registerAsPlaygroundOwner();
            }
            else if(role.equalsIgnoreCase("3")){
                registerAsAdministrator();
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
