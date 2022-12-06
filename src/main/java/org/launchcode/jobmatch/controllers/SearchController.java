package org.launchcode.jobmatch.controllers;
import org.launchcode.jobmatch.data.SearchPreferencesRepository;
import org.launchcode.jobmatch.data.UserRepository;
import org.launchcode.jobmatch.models.SearchPreferences;
import org.launchcode.jobmatch.models.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;


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

        HttpSession session = request.getSession();
        Integer user_id = (Integer) session.getAttribute("user");
        Optional<User> user = userRepository.findById(user_id);
        searchPreferences.setUser(user.get());
        user.get().setSearchPreferences(searchPreferences);
        searchPreferencesRepository.save(searchPreferences);
        userRepository.save(user.get());

        return "/homepage";

    }


}
