import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Address {
    // Attributes....
    private String governorate;
    private String city;


    // constructors
    public Address(String governorate , String city ){
        this.governorate=governorate;
        this.city=city;

    }
    public Address(){
        this.governorate="";
        this.city="";

    }

    // setters...
    public void setCity(String city) {
        this.city = city;
    }

    public void setGovernorate(String governorate) {
        this.governorate = governorate;
    }


    // getters...
    public String getCity() {
        return city;
    }

    public String getGovernorate() {
        return governorate;
    }

    // methods..
    @Override
    public String toString() {
        return "Address{" +
                "governorate:'" + governorate + '\'' +
                ", city:'" + city + '\'' +
                '}';
    }
    public void createAddress(){
           BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
           System.out.println("Enter governorate: ");
           try {
               String governorate =reader.readLine();
               System.out.println("Enter city: ");
               String city = reader.readLine();
               setGovernorate(governorate);
               setCity(city);
           }
           catch (IOException e){
               System.out.println("Invalid input ");
           }
    }
}
