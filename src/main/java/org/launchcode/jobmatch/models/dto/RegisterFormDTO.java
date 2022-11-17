package org.launchcode.jobmatch.models.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class RegisterFormDTO extends LoginFormDTO{

    @Email(message="Please enter a valid email address.")
    private String email;

    @NotBlank(message="This field cannot be left blank.")
    @Size(min=1, max=40)
    private String firstName;

    @NotBlank(message="This field cannot be left blank.")
    @Size(min=1, max=60)
    private String lastName;
    @NotBlank
    private String verifyPassword;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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
    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
    }
}
