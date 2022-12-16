package org.launchcode.jobmatch.controllers;

import org.launchcode.jobmatch.data.SearchPreferencesRepository;
import org.launchcode.jobmatch.data.UserRepository;
import org.launchcode.jobmatch.models.SearchPreferences;
import org.launchcode.jobmatch.models.User;
import org.launchcode.jobmatch.models.dto.LoginFormDTO;
import org.launchcode.jobmatch.models.dto.RegisterFormDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("profile")
public class ProfileController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationController authenticationController;

    @Autowired
    private SearchPreferencesRepository searchPreferencesRepository;

    @GetMapping
    public String displayProfile(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = authenticationController.getUserFromSession(session);
        List<SearchPreferences> searchPreferences = user.getSearchPreferences();

        String email = "Email: " + user.getEmail();
        String firstName = "First Name: " + user.getFirstName();
        String lastName = "Last Name: " + user.getLastName();
        String username = "Username: " + user.getUsername();

        model.addAttribute("email", email);
        model.addAttribute("firstName", firstName);
        model.addAttribute("lastName", lastName);
        model.addAttribute("username", username);

        model.addAttribute("searchPreferences", searchPreferences);

        return "profile";
    }

}
