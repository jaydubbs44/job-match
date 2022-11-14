package org.launchcode.jobmatch.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/createAccount")
public class CreateAccountController {

    @ModelAttribute
    public userDto userDto{
    return new userDto();
    }

    @GetMapping
    public String showCreateAccountForm(){
        return "createAccount";
    }

    @PostMapping
    public String submitAccountCreationForm(){

    }

}
