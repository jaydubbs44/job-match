package org.launchcode.jobmatch.models;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToMany
    @JoinColumn(name = "search_preferences_id")
    private List<SearchPreferences> searchPreferences;

    @ManyToMany
    @JoinColumn(name="saved_jobs_id")
    private List<SavedJobs> savedJobs;

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

    public List<SearchPreferences> getSearchPreferences() {
        return searchPreferences;
    }

    public void setSearchPreferences(SearchPreferences searchPreferences) {
        this.searchPreferences.add(searchPreferences);
    }

    public List<SavedJobs> getSavedJobs() {
        return savedJobs;
    }

    public void setSavedJobs(SavedJobs savedJobs) {
        this.savedJobs.add(savedJobs);
    }
}
