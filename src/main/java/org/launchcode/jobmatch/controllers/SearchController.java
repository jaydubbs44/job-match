package org.launchcode.jobmatch.controllers;

import org.launchcode.jobmatch.data.SearchPreferencesRepository;
import org.launchcode.jobmatch.data.UserRepository;
import org.launchcode.jobmatch.models.SearchPreferences;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Optional;

@Controller
public class SearchController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SearchPreferencesRepository searchPreferencesRepository;

    @GetMapping("/search")
    public String showSearchPreferencesForm(Model model){
        ArrayList<String> allJobTypes = new ArrayList<>();
        allJobTypes.add("fulltime");
        allJobTypes.add("parttime");
        allJobTypes.add("contract");
        allJobTypes.add("internship");
        allJobTypes.add("temporary");
        model.addAttribute("allJobTypes", allJobTypes);
        model.addAttribute(new SearchPreferences());
        return "search";
    }


    @PostMapping
    public String submitJobPreferencesForm(@ModelAttribute SearchPreferences SearchPreferences, Errors errors, Model model){
        if(errors.hasErrors()){
            return "/search";
        }
        searchPreferencesRepository.save(SearchPreferences);
        model.addAttribute("searchPreferences", SearchPreferences.getSearchTerm());
        return "";

    }


}
