package org.launchcode.jobmatch.models;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
public class User extends AbstractEntity{

    @Email
    @NotNull
    private String email;

    @NotNull
    private String firstName;
    @NotNull
    private String lastName;

    @NotNull
    private String username;

    @NotNull
    private String pwHash;

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User(String email, String firstName, String lastName, String username, String password){
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.pwHash = encoder.encode(password);

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

    public String getUsername() {
        return username;
    }

    public boolean isMatchingPassword (String password) {
        return encoder.matches(password, pwHash);
    }
}
