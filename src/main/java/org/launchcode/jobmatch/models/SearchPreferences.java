package org.launchcode.jobmatch.models;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.lang.reflect.Array;
import java.util.*;


@Entity
@Table(name="search_preferences")
public class SearchPreferences extends AbstractEntity{

    private String country;


    private String city;


    private Integer radius;

    //Job type. Allowed values: "fulltime", "parttime", "contract", "internship", "temporary".
    private String jobType;

    private String searchTerm;

    // Site type. To show only jobs from job boards use 'jobsite'. For jobs from direct employer websites use 'employer
    @NotBlank(message="Type either 'jobsite' or 'employer' to get results from job boards or direct employer websites")
    private String siteType;
    
    private String savedSearchName;

    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User user;

    public SearchPreferences(String country, String city, Integer radius, HashMap<Integer,String> jobType, String searchTerm, String siteType, String savedSearchName, User user) {
        this.country = country;
        this.city = city;
        this.radius = radius;
        for (Map.Entry<Integer, String> entry : jobType.entrySet()){
         this.jobType += " " + entry.getValue();
         this.jobType.trim();
        }
        this.searchTerm = searchTerm;
        this.siteType = siteType;
        this.savedSearchName = savedSearchName;
        this.user = user;

    }

    public SearchPreferences(){}

    public String getSavedSearchName() {
        return savedSearchName;
    }

    public void setSavedSearchName(String savedSearchName) {
        this.savedSearchName = savedSearchName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getRadius() {
        return radius;
    }

    public void setRadius(Integer radius) {
        this.radius = radius;
    }

    public String getSearchTerm() {
        return searchTerm;
    }


    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getSiteType() {
        return siteType;
    }

    public void setSiteType(String siteType) {
        this.siteType = siteType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
