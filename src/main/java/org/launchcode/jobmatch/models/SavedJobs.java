package org.launchcode.jobmatch.models;

import org.launchcode.jobmatch.controllers.AuthenticationController;
import org.launchcode.jobmatch.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@Table(name="saved_jobs")
public class SavedJobs extends AbstractEntity{

    private String jobLink;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User user;

    @Transient
    @Autowired
    UserRepository userRepository;

    @Transient
    @Autowired
    AuthenticationController authenticationController;

    public SavedJobs(String jobLink, User user){
        this.jobLink = jobLink;
        this.user = user;
    }

    public SavedJobs(){}

    public String getJobLink() {
        return jobLink;
    }

    public void setJobLink(String jobLink) {
        this.jobLink = jobLink;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
