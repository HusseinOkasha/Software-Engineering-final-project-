import java.util.Scanner;

public class Address {
    // Attributes....
    private String governorate;
    private String city;
    private String street;

    // constructors
    public Address(String governorate , String city , String street){
        this.governorate=governorate;
        this.city=city;
        this.street= street;
    }

    // setters...
    public void setCity(String city) {
        this.city = city;
    }

    public void setGovernorate(String governorate) {
        this.governorate = governorate;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    // getters...
    public String getCity() {
        return city;
    }

    public String getGovernorate() {
        return governorate;
    }

    public String getStreet() {
        return street;
    }

    // methods..
    @Override
    public String toString() {
        return "Address{" +
                "governorate:'" + governorate + '\'' +
                ", city:'" + city + '\'' +
                ", street:'" + street + '\'' +
                '}';
    }
    public void createAddress(){
           System.out.println("Enter governorate: ");
           Scanner scanner = new Scanner(System.in);
           String governorate =scanner.nextLine();
           String city = scanner.nextLine();
           String street = scanner.nextLine();
           setGovernorate(governorate);
           setCity(city);
           setStreet(street);
    }
}
