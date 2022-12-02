package org.launchcode.jobmatch.models;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;


@Entity
public class SearchPreferences extends AbstractEntity{

  
    private String country;


    private String city;


    private Number radius;

    //Job type. Allowed values: "fulltime", "parttime", "contract", "internship", "temporary".
    @NotEmpty(message="This field cannot be left empty")
    private ArrayList<String> jobType;

    private String searchTerm;

    // Site type. To show only jobs from job boards use 'jobsite'. For jobs from direct employer websites use 'employer
    private String siteType;
    
    private String savedSearchName;



    public SearchPreferences(String country, String city, Number radius, ArrayList<String> jobType, String searchTerm, String siteType, String savedSearchName) {
        this.country = country;
        this.city = city;
        this.radius = radius;
        this.jobType = jobType;
        this.searchTerm = searchTerm;
        this.siteType = siteType;
        this.savedSearchName = savedSearchName;
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

    public Number getRadius() {
        return radius;
    }

    public void setRadius(Number radius) {
        this.radius = radius;
    }

    public String getSearchTerm() {
        return searchTerm;
    }


    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    public ArrayList<String> getJobType() {
        return jobType;
    }

    public void setJobType(ArrayList<String> jobType) {
        this.jobType = jobType;
    }


}
