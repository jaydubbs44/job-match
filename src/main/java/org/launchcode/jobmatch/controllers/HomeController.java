package org.launchcode.jobmatch.controllers;

import org.launchcode.jobmatch.data.UserRepository;
import org.launchcode.jobmatch.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import org.launchcode.jobmatch.controllers.AuthenticationController;
import org.launchcode.jobmatch.data.UserRepository;
import org.launchcode.jobmatch.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    AuthenticationController authenticationController;
    @GetMapping("homepage")
    public String index (Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        String userFirstName = authenticationController.getUserFromSession(session).getFirstName();
        String welcomeMessage = "Welcome " + userFirstName + "!";
        model.addAttribute("welcomeMessage", welcomeMessage);
        return "homepage";
    }

}
