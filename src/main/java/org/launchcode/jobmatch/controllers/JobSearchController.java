package org.launchcode.jobmatch.controllers;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class JobSearchController {
    @GetMapping("jobsearch")
    public String index (Model model) {return "jobsearch";}


}




