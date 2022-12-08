package org.launchcode.jobmatch.controllers;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobSearchController {

    @GetMapping("jobsearch")
    public String index (Model model) {return "jobsearch";}

       public HttpResponse<String> response = Unirest.post("https://indeed11.p.rapidapi.com/")
                .header("content-type", "application/json")
                .header("X-RapidAPI-Key", "c1d1d45673mshb872bacdff5241dp1373fdjsn45adf7f84af6")
                .header("X-RapidAPI-Host", "indeed11.p.rapidapi.com")
                .body("{\r\n    \"search_terms\": \"Developer\",\r\n    \"location\": \"United States\",\r\n    \"page\": \"1\"\r\n}")
                .asString();
    }



