package org.launchcode.jobmatch.controllers;

import org.launchcode.jobmatch.data.UserRepository;
import org.launchcode.jobmatch.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/createAccount")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String showCreateAccountForm(Model model){
        model.addAttribute(new User());
        return "/createAccount";
    }

    @PostMapping
    public String submitAccountCreationForm(@ModelAttribute @Valid User newUser, Errors errors, Model model){
        if(errors.hasErrors()){
            return "/createAccount";
        }
        userRepository.save(newUser);
        model.addAttribute("firstName", newUser.getFirstName());
        return "";
    }

}
