package org.launchcode.jobmatch.controllers;

import org.launchcode.jobmatch.data.SavedJobsRepository;
import org.launchcode.jobmatch.data.UserRepository;
import org.launchcode.jobmatch.models.SavedJobs;
import org.launchcode.jobmatch.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

@Controller
@RequestMapping("/saveJob")
public class SavedJobsController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    SavedJobsRepository savedJobsRepository;

    @GetMapping()
    public String saveJobToProfile(@ModelAttribute SavedJobs savedJobs, Model model, HttpServletRequest request){

        model.addAttribute(new SavedJobs());
        HttpSession session = request.getSession();
        Integer user_id = (Integer) session.getAttribute("user");
        Optional<User> user = userRepository.findById(user_id);
        savedJobs.setUser(user.get());

        user.get().setSavedJobs(savedJobs);
        savedJobsRepository.save(savedJobs);
        userRepository.save(user.get());

        return "/jobsearch";

    }
}
