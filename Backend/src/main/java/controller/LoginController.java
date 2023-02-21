package controller;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import service.CustomUserDetailsService;
//details of user getMapping method(read)
//use constructor for testing
@Controller
public class LoginController {
    @Autowired
    private CustomUserDetailsService userService;

    //global object of modelAndView
    ModelAndView modelAndView = new ModelAndView();
    //login method for login of user
    public ModelAndView login() {
        modelAndView.setViewName("login");
        return modelAndView;
    }
    //dashboard method for view of admin
    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public ModelAndView dashboard() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        modelAndView.addObject("currentUser", user);
        modelAndView.addObject("fullName", "Welcome " + user.getFullname());
        modelAndView.setViewName("dashboard");
        return modelAndView;
    }

    //home page for user other than admin
    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public ModelAndView home() {
        modelAndView.setViewName("home");
        return modelAndView;
    }

}
