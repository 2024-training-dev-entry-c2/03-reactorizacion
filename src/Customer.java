import java.time.LocalDate;

public class Customer {
    private String firstName;
    private String lastName;
    private String email;
    private String nationality;
    private String phone;
    private LocalDate birthDate;

    public Customer(String firstName, String lastName, String email, String nationality, String phone, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.nationality = nationality;
        this.phone = phone;
        this.birthDate = birthDate;
    }

    public Boolean validateCustomer(String email, LocalDate birthDate){
        return email.equals(this.email) && birthDate.equals(this.birthDate);
    }
}
