package org.launchcode.jobmatch;

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

public class AuthenticationFilter extends HandlerInterceptorAdapter {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationController authenticationController;

    private static final List<String> whitelist = Arrays.asList("/landing", "/login", "/createAccount", "/logout");

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws IOException {

        //checks whether request is whitelisted; is so, page is rendered.
        if (isWhitelisted(request.getRequestURI())) {
            return true;
        }

        HttpSession session = request.getSession();
        User user = authenticationController.getUserFromSession(session);
        //the user is logged in
        if (user != null) {
            return true;
        }
        //the user is NOT logged in
        response.sendRedirect("/login");
        return false;
    }

    //check whether request is whitelisted
    private static boolean isWhitelisted(String path) {
        for (String pathRoot : whitelist) {
            if (path.startsWith(pathRoot)) {
                return true;
            }
        }
        return false;
    }

}
