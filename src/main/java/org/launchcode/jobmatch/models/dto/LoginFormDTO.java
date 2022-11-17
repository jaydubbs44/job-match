package org.launchcode.jobmatch.models.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginFormDTO {


    @NotNull
    @NotBlank
    @Size(min=3, max=15, message="Username invalid. Please choose a username between 3 and 15 characters long.")
    private String username;

    @NotNull
    @NotBlank
    @Size(min=8, max=35, message="Password invalid. Please choose a username between 8 and 35 characters long.")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
