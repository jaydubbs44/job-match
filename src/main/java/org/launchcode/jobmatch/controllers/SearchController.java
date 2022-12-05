package org.launchcode.jobmatch.controllers;
import org.launchcode.jobmatch.data.SearchPreferencesRepository;
import org.launchcode.jobmatch.data.UserRepository;
import org.launchcode.jobmatch.models.SearchPreferences;
import org.launchcode.jobmatch.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.ObjectFactory;


@Controller
@RequestMapping("/search")
public class SearchController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SearchPreferencesRepository searchPreferencesRepository;

    @GetMapping()
    public String showSearchPreferencesForm(Model model){
        model.addAttribute("title", "Search Form");
        model.addAttribute(new SearchPreferences());
        return "/search";
    }





    @PostMapping()
    public String submitJobPreferencesForm(@ModelAttribute @Valid SearchPreferences searchPreferences, Errors errors, Model model, HttpServletRequest request){


        if(errors.hasErrors()){
            return "/search";
        }


        String username = request.getUserPrincipal().getName();
        User user = userRepository.findByUsername(username);
        searchPreferences.setUser(user);
        searchPreferencesRepository.save(searchPreferences);

        return "/homepage";

    }


}
