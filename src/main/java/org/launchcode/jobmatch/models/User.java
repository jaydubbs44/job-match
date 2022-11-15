package org.launchcode.jobmatch.models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
@Entity
public class User {

    @Id
    @GeneratedValue
    private int id;

    @NotBlank(message="This field cannot be left blank.")
    @Size(min=3, max=40)
    private String firstName;
    @NotBlank(message="This field cannot be left blank.")
    @Size(min=3, max=60)
    private String lastName;

    @Email(message="Please enter a valid email address.")
    private String email;

    public User(String firstName, String lastName, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public User(){}
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
